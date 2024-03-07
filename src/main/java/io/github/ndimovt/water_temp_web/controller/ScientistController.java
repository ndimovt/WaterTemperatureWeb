package io.github.ndimovt.water_temp_web.controller;

import io.github.ndimovt.water_temp_web.service.ScientistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/info")
@CrossOrigin("*")
public class ScientistController {
    @Autowired
    private ScientistService service;

    @GetMapping("/get/{username}/{password}")
    public String user(@PathVariable String username, @PathVariable String password){
        return service.logIn(username, password);
    }
}
