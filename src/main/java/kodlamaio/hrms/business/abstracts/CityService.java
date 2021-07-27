package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.City;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CityService {
    DataResult<List<City>> getAll();
    Result add(City city);
    Result delete(int id);
}
