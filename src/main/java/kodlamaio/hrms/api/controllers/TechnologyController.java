package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/technology")
public class TechnologyController {

    private TechnologyService technologyService;

    @Autowired
    public TechnologyController(TechnologyService technologyService){
        this.technologyService = technologyService;
    }

    @GetMapping("/getall")
    DataResult<List<Technology>> getAll(){
        return this.technologyService.getAll();
    }

    @PostMapping("/add-technology")
    Result add(@RequestBody Technology technology){
        return this.technologyService.add(technology);
    }

    @DeleteMapping("/delete-technology")
    Result delete(@RequestParam int id){
        return this.technologyService.delete(id);
    }

}
