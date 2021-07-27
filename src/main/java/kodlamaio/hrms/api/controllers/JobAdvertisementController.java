package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessDataResult;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobadvertisement")
public class JobAdvertisementController {

    private final JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(JobAdvertisementService jobAdvertisementService){
        this.jobAdvertisementService = jobAdvertisementService;
    }

    @PostMapping("/job_advertisement_add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.add(jobAdvertisement);
    }

    @DeleteMapping("/delete_job_advertisement")
    public Result deleteJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement){
        return this.jobAdvertisementService.deleteJobAdvertisement(jobAdvertisement);
    }

    @GetMapping("/getall")
    public DataResult<List<JobAdvertisement>> getAll(){
        return this.jobAdvertisementService.getAll();
    }

    @GetMapping("/gedbystatus")
    public DataResult<List<JobAdvertisement>> getByStatus(@RequestParam boolean status){
        return this.jobAdvertisementService.getByStatus(status);
    }

    @GetMapping("/getByStatusSorted")
    public DataResult<List<JobAdvertisement>> getByStatusSorted(@RequestParam Boolean status){
        return this.jobAdvertisementService.getByStatusSorted(status);
    }

    @GetMapping("/getByStatusAndEmployer_Id")
    public DataResult<List<JobAdvertisement>> getByStatusAndEmployer_Id(@RequestParam Boolean status,@RequestParam int id){
        return this.jobAdvertisementService.getByStatusAndEmployer_Id(status,id);
    }

}
