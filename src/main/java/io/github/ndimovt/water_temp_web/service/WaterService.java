package io.github.ndimovt.water_temp_web.service;

import io.github.ndimovt.water_temp_web.repository.WaterRepository;
import io.github.ndimovt.water_temp_web.water_info.Water;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;

@Service
public class WaterService {
    @Autowired
    private WaterRepository repository;

    public ArrayList<Water> byTownAndDay(String town, String date){
        return repository.findByTownAndDate(town,date);
    }
    public ArrayList<Water> byTown(String town){
        return repository.findByTown(town);
    }
    public ArrayList<Water> byYear(String year){
        ArrayList<Water> full = (ArrayList<Water>) repository.findAll();
        ArrayList<Water> byYear = new ArrayList<>();
        for(Water water : full){
            if(water.getDate().contains(year)){
                byYear.add(water);
            }
        }
        return byYear;
    }
    public Water insert(Water water){
        return repository.save(water);
    }
}
