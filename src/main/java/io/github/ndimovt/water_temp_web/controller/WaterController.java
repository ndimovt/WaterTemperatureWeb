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
    public ArrayList<Water> findByDateTown(@PathVariable String town, @PathVariable String date){
        return service.byTownAndDay(town,date);
    }
    @GetMapping("/year/{date}")
    public ArrayList<Water> findByYear(@PathVariable String date){
        return service.byYear(date);
    }
    @GetMapping("/byTown/{town}")
    public ArrayList<Water> findByTown(@PathVariable String town){
        return service.byTown(town);
    }
    @PostMapping("/insert")
    public Water insert (@RequestBody Water water){
        return service.insert(water);
    }

}
