package kodlamaio.hrms.api.controllers;

import kodlamaio.hrms.business.abstracts.SocialMediaService;
import kodlamaio.hrms.core.utilities.DataResult;
import kodlamaio.hrms.core.utilities.Result;
import kodlamaio.hrms.entities.concretes.SocialMedia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/socialmedia")
public class SocialMediaController {

    private SocialMediaService socialMediaService;

    @Autowired
    public SocialMediaController(SocialMediaService socialMediaService){
        this.socialMediaService = socialMediaService;
    }

    @GetMapping("/getall")
    DataResult<List<SocialMedia>> getAll(){
        return this.socialMediaService.getAll();
    }

    @PostMapping("/add-socialmedia")
    Result add(@RequestBody SocialMedia socialMedia){
        return this.socialMediaService.add(socialMedia);
    }

    @DeleteMapping("/delete-socialmedia")
    Result delete(@RequestParam int id){
        return this.socialMediaService.delete(id);
    }

}
