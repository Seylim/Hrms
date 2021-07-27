package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface EmployerService {
    Result register(Employer employer) throws Exception;
    DataResult<List<Employer>> getAll();
    DataResult<Employer> getById(int id);
}
