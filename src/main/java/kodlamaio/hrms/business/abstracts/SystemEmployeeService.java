package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.SystemEmployee;

import java.util.List;

public interface SystemEmployeeService {
    DataResult<List<SystemEmployee>> getAll();
    Result add(SystemEmployee systemEmployee);
    Result delete(int id);
}
