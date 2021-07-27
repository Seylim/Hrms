package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
public class EducationController {

    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService){
        this.educationService = educationService;
    }

    @GetMapping("/getall")
    DataResult<List<Education>> getAll(){
        return this.educationService.getAll();
    }

    @PostMapping("/add-education")
    Result add(@RequestBody Education education){
        return this.educationService.add(education);
    }

    @DeleteMapping("/delete-education")
    Result delete(@RequestParam int id){
        return this.educationService.delete(id);
    }

}
