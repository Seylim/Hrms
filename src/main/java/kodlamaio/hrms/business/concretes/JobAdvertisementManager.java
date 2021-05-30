package kodlamaio.hrms.business.concretes;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.*;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {
    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao){
        this.jobAdvertisementDao=jobAdvertisementDao;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(), "İş ilanları listelendi");
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatus(boolean status) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByStatus(status));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusSorted(Boolean status) {
        Sort sort = Sort.by(Sort.Direction.DESC);
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByStatusAndEmployer_Id(Boolean status, int id) {
        return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByStatusAndEmployer_Id(status, id));
    }


}
