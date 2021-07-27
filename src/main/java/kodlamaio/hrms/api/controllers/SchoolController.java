package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SchoolService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/school")
public class SchoolController {

    private SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService){
        this.schoolService = schoolService;
    }

    @GetMapping("/getall")
    DataResult<List<School>> getAll(){
        return this.schoolService.getAll();
    }

    @PostMapping("/add-school")
    Result add(@RequestBody School school){
        return this.schoolService.add(school);
    }

    @DeleteMapping("/delete-school")
    Result delete(@RequestParam int id){
        return this.schoolService.delete(id);
    }

}
