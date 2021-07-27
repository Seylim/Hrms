package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeManager implements ResumeService {

    private ResumeDao resumeDao;

    @Autowired
    public ResumeManager(ResumeDao resumeDao) {
        this.resumeDao = resumeDao;
    }

    @Override
    public Result addResume(Resume resume) {
        this.resumeDao.save(resume);
        return new SuccessResult();
    }

    @Override
    public Result delete(int id) {
        this.resumeDao.deleteById(id);
        return new SuccessResult("Başarıyla silindi");
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return new SuccessDataResult<List<Resume>>(this.resumeDao.findAll(),"Başarıyla listelendi");
    }

    @Override
    public DataResult<Resume> getByCandidateId(int id) {
        return new SuccessDataResult<Resume>(this.resumeDao.getById(id), "Öz geçmiş listelendi.");
    }
}
