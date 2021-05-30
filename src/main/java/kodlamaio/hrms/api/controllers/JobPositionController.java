package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/job_positions")
public class JobPositionController {
    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionController(JobPositionService jobPositionService){
        this.jobPositionService = jobPositionService;
    }

    @GetMapping("/getall")
    public DataResult<List<JobPosition>> getAll(){
        return this.jobPositionService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<JobPosition> getById(@RequestParam int id){
        return this.jobPositionService.getById(id);
    }

    @PostMapping("/add")
    public DataResult<JobPosition> add(@RequestParam JobPosition jobPosition){
        return this.jobPositionService.add(jobPosition);
    }
}
