package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.ExperienceService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
public class ExperienceController {

    private ExperienceService experienceService;

    @Autowired
    public ExperienceController(ExperienceService experienceService){
        this.experienceService = experienceService;
    }

    @GetMapping("/getall")
    DataResult<List<Experience>> getAll(){
        return this.experienceService.getAll();
    }

    @PostMapping("/add-experience")
    Result add(@RequestBody Experience experience){
        return this.experienceService.add(experience);
    }

    @DeleteMapping("/delete-experience")
    Result delete(@RequestParam int id){
        return this.experienceService.delete(id);
    }

    @GetMapping("/getByLeaveDateSorted")
    DataResult<List<Experience>> getByLeaveDateSorted(){
        return this.experienceService.getByLeaveDateSorted();
    }

}
