package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.School;

import java.util.List;

public interface SchoolService {
    DataResult<List<School>> getAll();
    Result add(School school);
    Result delete(int id);
}
