package io.github.ndimovt.water_temp_web.controller;

import io.github.ndimovt.water_temp_web.scientist.Scientist;
import io.github.ndimovt.water_temp_web.service.ScientistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/info")
//@CrossOrigin("*")
public class ScientistController {
    @Autowired
    private ScientistService service;

    @GetMapping("/get/{username},{password}")
    public String personalData(@PathVariable String username, @PathVariable String password){
        return service.enter(username, password);
    }
    @GetMapping("/getAll")
    public ArrayList<Scientist> all(){
        return service.getAll();
    }
}
