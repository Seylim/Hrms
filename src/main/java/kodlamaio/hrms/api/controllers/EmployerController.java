package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
    private EmployerService employerService;

    @Autowired
    public EmployerController(EmployerService employerService){
        this.employerService = employerService;
    }

    @PostMapping("/register")
    public Result register(@RequestBody Employer employer) throws Exception{
        return this.employerService.register(employer);
    }

    @PostMapping("/job_advertisement_add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement){
        return this.employerService.add(jobAdvertisement);
    }

    @DeleteMapping("/delete_job_advertisement")
    public Result deleteJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement){
        return this.employerService.deleteJobAdvertisement(jobAdvertisement);
    }

    @GetMapping("/getall")
    public DataResult<List<Employer>> getAll(){
        return this.employerService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Employer> getById(@RequestParam int id){
        return this.employerService.getById(id);
    }
}
