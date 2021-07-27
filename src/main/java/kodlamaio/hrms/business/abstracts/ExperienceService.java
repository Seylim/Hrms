package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Experience;

import java.util.List;

public interface ExperienceService {
    DataResult<List<Experience>> getAll();
    Result add(Experience experience);
    Result delete(int id);
}
