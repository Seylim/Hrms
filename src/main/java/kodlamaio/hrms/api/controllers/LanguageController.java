package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/language")
public class LanguageController {

    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService){
        this.languageService = languageService;
    }

    @GetMapping("/getall")
    DataResult<List<Language>> getAll(){
        return this.languageService.getAll();
    }

    @PostMapping("/add-language")
    Result add(@RequestBody Language language){
        return this.languageService.add(language);
    }

    @DeleteMapping("/delete-language")
    Result delete(@RequestParam int id){
        return this.languageService.delete(id);
    }

}
