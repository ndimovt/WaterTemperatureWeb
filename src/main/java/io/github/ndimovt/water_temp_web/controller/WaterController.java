package io.github.ndimovt.water_temp_web.controller;

import io.github.ndimovt.water_temp_web.service.WaterService;
import io.github.ndimovt.water_temp_web.water_info.Water;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class WaterController {
    @Autowired
    private WaterService service;
    @GetMapping("byTownDate/{town}/{date}")
    public ArrayList<Water> findByDateTown(@PathVariable String town, @PathVariable String date){
        return service.searchByTownAndDay(town,date);
    }
    @GetMapping("year/{town}/{date}")
    public double findByYear(@PathVariable String town, @PathVariable String date) {
        return service.searchByYear(town, date);
    }
    @GetMapping("byTown/{town}")
    public ArrayList<Water> findByTown(@PathVariable String town){
        return service.searchByTown(town);
    }
    @PostMapping("insert")
    public boolean insert (@RequestBody Water water){
        return service.insertSingleRecord(water);
    }
    @PostMapping("table")
    public int insertExcelData(@RequestParam("file") MultipartFile file) {
        boolean success = service.readExcelTable(file);
        if (success) {
            return HttpServletResponse.SC_CREATED;
        } else {
            return HttpServletResponse.SC_CONFLICT;
        }
    }
}
