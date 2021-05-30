package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<JobAdvertisement>> getAll();
    DataResult<List<JobAdvertisement>> getByStatus(boolean status);
    DataResult<List<JobAdvertisement>> getByStatusSorted(Boolean status);
    DataResult<List<JobAdvertisement>> getByStatusAndEmployer_Id(Boolean status, int id);
}
