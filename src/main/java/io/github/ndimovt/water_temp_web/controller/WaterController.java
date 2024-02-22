package io.github.ndimovt.water_temp_web.controller;

import io.github.ndimovt.water_temp_web.service.WaterService;
import io.github.ndimovt.water_temp_web.water_info.Water;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@RequestMapping("/")
//@CrossOrigin("*")
public class WaterController {
    @Autowired
    private WaterService service;
    @GetMapping("/byTownDate/{town},{date}")
    public ArrayList<Water> byDateTown(@PathVariable String town, @PathVariable String date){
        return service.byTownAndDay(town,date);
    }
    @PostMapping("/insert")
    public Water insert (@RequestBody Water water){
        return service.insert(water);
    }
    @GetMapping("/byTown/{town}")
    public ArrayList<Water> byTown(@PathVariable String town){
        return service.byTown(town);
    }
}
