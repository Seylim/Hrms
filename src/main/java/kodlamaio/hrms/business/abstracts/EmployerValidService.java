package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerValidService {
    Result validate(Employer employer) throws Exception;
}
