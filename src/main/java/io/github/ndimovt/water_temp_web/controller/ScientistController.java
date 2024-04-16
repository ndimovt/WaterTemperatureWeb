package io.github.ndimovt.water_temp_web.controller;

import io.github.ndimovt.water_temp_web.service.ScientistService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ScientistController {
    @Autowired
    private ScientistService service;

    @GetMapping("/scientist/{username}/{password}")
    public JSONObject user(@PathVariable String username, @PathVariable String password){
        return service.logIn(username, password);
    }
}
