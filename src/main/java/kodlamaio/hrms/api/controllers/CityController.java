package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService){
        this.cityService = cityService;
    }

    @GetMapping("/getall")
    DataResult<List<City>> getAll(){
        return this.cityService.getAll();
    }

    @PostMapping("/add-city")
    Result add(@RequestBody City city){
        return this.cityService.add(city);
    }

    @DeleteMapping("delete-city")
    Result delete(@RequestParam int id){
        return this.cityService.delete(id);
    }
}
