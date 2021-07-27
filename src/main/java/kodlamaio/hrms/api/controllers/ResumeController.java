package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.core.utilities.SuccessResult;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resume")
public class ResumeController {

    private ResumeService resumeService;

    @Autowired
    public ResumeController(ResumeService resumeService){
        this.resumeService = resumeService;
    }

    @PostMapping("/add-resume")
    public Result addResume(@RequestBody Resume resume){
        return this.resumeService.addResume(resume);
    }

    @DeleteMapping("/delete_resume")
    public Result delete(@RequestParam int id){
        this.resumeService.delete(id);
        return new SuccessResult();
    }

    @PostMapping("/getall")
    DataResult<List<Resume>> getAll(){
        return this.resumeService.getAll();
    }

}
