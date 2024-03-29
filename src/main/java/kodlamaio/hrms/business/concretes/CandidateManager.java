package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CandidateValidService;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.services.EmailService;
import kodlamaio.hrms.core.services.MernisService;
import kodlamaio.hrms.core.utilities.*;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.CandidateWithEducationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private final CandidateDao candidateDao;
    private final CandidateValidService candidateValidService;
    private final MernisService mernisService;
    private final EmailService emailService;
    private ResumeService resumeService;

    @Autowired
    public CandidateManager(CandidateDao candidateDao, CandidateValidService candidateValidService,
                            MernisService mernisService, EmailService emailService, ResumeService resumeService){
        this.candidateDao=candidateDao;
        this.candidateValidService = candidateValidService;
        this.mernisService = mernisService;
        this.emailService = emailService;
        this.resumeService = resumeService;
    }
    @Override
    public Result register(Candidate candidate) throws Exception {
        List<Candidate> candidates = this.candidateDao.findAll();
        if (mernisService.IfRealPerson(candidate)){
            if (checkIfUserExist(candidates,candidate).isSuccess()){
                if (emailService.sendMail()){
                    if (candidateValidService.validate(candidate).isSuccess()){
                        this.candidateDao.save(candidate);
                        return new SuccessResult("Kayıt Başarılı");
                    }
                    return candidateValidService.validate(candidate);
                }
                return new ErrorResult("Lütfen epostanıza gelen aktivasyon kodunu aktive ediniz.");
            }
        }
        return new ErrorResult("Lütfen bilgilerinizi doğru giriniz.");
    }

    @Override
    public Result delete(int id) {
        this.resumeService.delete(id);
        this.candidateDao.deleteById(id);
        return new SuccessResult("Başarıyla silindi");
    }

    @Override
    public DataResult<List<Candidate>> getAll() {
        return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Adaylar Listelendi");
    }

    @Override
    public DataResult<Candidate> getById(int id) {
        return new SuccessDataResult<Candidate>(this.candidateDao.findById(id).orElse(null));
    }

    @Override
    public DataResult<List<CandidateWithEducationDto>> getCandidateByGraduationDate() {
        return new SuccessDataResult<List<CandidateWithEducationDto>>(this.candidateDao.getCandidateByGraduationDate());
    }

    private Result checkIfUserExist(List<Candidate> candidates, Candidate checkCandidate){
        for (Candidate candidate : candidates){
            if (candidate.getEmail().equals(checkCandidate.getEmail())){
                return new ErrorResult("Bu mail kayıtlı.");
            }
            if (candidate.getNationalIdNumber().equals(checkCandidate.getNationalIdNumber())){
                return new ErrorResult("Bu kimlik numarası kayıtlı.");
            }
        }
        return new SuccessResult();
    }
}
