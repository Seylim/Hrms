package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.EmployerValidService;
import kodlamaio.hrms.core.services.EmailService;
import kodlamaio.hrms.core.utilities.*;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private final EmployerDao employerDao;
    private final EmployerValidService employerValidService;
    private final EmailService emailService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, EmployerValidService employerValidService, EmailService emailService,
                           JobAdvertisementDao jobAdvertisementDao){
        this.employerDao = employerDao;
        this.employerValidService = employerValidService;
        this.emailService = emailService;
    }

    @Override
    public Result register(Employer employer) throws Exception {
        List<Employer> employers = this.employerDao.findAll();
        if (checkIfExistEmployer(employers, employer).isSuccess()){
            if (this.emailService.sendMail()){
                if (this.employerValidService.validate(employer).isSuccess()){
                    this.employerDao.save(employer);
                    return new SuccessResult("Kayıt Başarılı");
                }
                return this.employerValidService.validate(employer);
            }
            return new ErrorResult("Lütfen epostanıza gelen aktivasyon kodunu aktive ediniz.");
        }
        return checkIfExistEmployer(employers, employer);
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi.");
    }

    @Override
    public DataResult<Employer> getById(int id) {
        return new SuccessDataResult<Employer>(this.employerDao.findById(id).orElse(null));
    }

    private Result checkIfExistEmployer(List<Employer> employers, Employer checkEmpployer){
        for (Employer employer : employers){
            if (employer.getEmail().equals(employer.getEmail())){
                return new ErrorResult("Bu email kayıtlı.");
            }
        }
        return new SuccessResult();
    }
}
