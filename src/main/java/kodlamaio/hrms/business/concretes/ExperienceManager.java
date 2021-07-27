package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ExperienceDao;
import kodlamaio.hrms.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceManager implements ExperienceService {

    private ExperienceDao experienceDao;

    @Autowired
    public ExperienceManager(ExperienceDao experienceDao){
        this.experienceDao = experienceDao;
    }

    @Override
    public DataResult<List<Experience>> getAll() {
        return new SuccessDataResult<List<Experience>>(this.experienceDao.findAll(), "Başarıyla listelendi.");
    }

    @Override
    public Result add(Experience experience) {
        this.experienceDao.save(experience);
        return new SuccessResult("Kayıt başarılı.");
    }

    @Override
    public Result delete(int id) {
        this.experienceDao.deleteById(id);
        return new SuccessResult("Kayıt silindi.");
    }
}
