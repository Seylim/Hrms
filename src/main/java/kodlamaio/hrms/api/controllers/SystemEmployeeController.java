package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.SystemEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/system_employee")
public class SystemEmployeeController {

    private SystemEmployeeService systemEmployeeService;

    @Autowired
    public SystemEmployeeController(SystemEmployeeService systemEmployeeService){
        this.systemEmployeeService = systemEmployeeService;
    }

    @GetMapping("/getall")
    DataResult<List<SystemEmployee>> getAll(){
        return this.systemEmployeeService.getAll();
    }

    @PostMapping("/add-system_employee")
    Result add(@RequestBody SystemEmployee systemEmployee){
        return this.systemEmployeeService.add(systemEmployee);
    }

    @DeleteMapping("/delete-system_employee")
    Result delete(@RequestParam int id){
        return this.systemEmployeeService.delete(id);
    }

}
