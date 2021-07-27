package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.CandidateWithEducationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {
    private CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService){
        this.candidateService = candidateService;
    }

    @PostMapping("/register")
    public Result register(@RequestBody Candidate candidate) throws Exception{
        return this.candidateService.register(candidate);
    }

    @DeleteMapping("/delete_candidate")
    Result delete(@RequestParam int id){
        return  this.candidateService.delete(id);
    }

    @GetMapping("/getall")
    public DataResult<List<Candidate>> getAll(){
        return this.candidateService.getAll();
    }

    @GetMapping("/getbyid")
    public DataResult<Candidate> getById(@RequestParam int id){
        return this.candidateService.getById(id);
    }

    @GetMapping("/getCandidateByGraduationDate")
    DataResult<List<CandidateWithEducationDto>> getCandidateByGraduationDate(){
        return this.candidateService.getCandidateByGraduationDate();
    }
}
