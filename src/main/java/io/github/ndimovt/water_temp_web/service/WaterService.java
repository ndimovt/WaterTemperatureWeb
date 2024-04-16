package io.github.ndimovt.water_temp_web.service;

import io.github.ndimovt.water_temp_web.repository.WaterRepository;
import io.github.ndimovt.water_temp_web.water_info.Water;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class WaterService{
    @Autowired
    private WaterRepository repository;

    public ArrayList<Water> searchByTownAndDay(String town, String date){
        List<Water> database = records();
        ArrayList<Water> result = new ArrayList<>();
        for(Water water : database){
            if(water.getTown().contains(town) && water.getDate().contains(date)){
                result.add(new Water(water.getTemperature(), water.getDate()));
            }
        }
        return result;
    }
    public ArrayList<Water> searchByTown(String town){
        return repository.findByTown(town);
    }
    public double searchByYear(String town, String date){
        List<Water> database = records();
        for(Water water : database){
            if(water.getTown().contains(town) && water.getDate().contains(date)){
                return water.getTemperature();
            }
        }
        return 0.0;
    }
    public boolean readExcelTable(MultipartFile file){
        List<Water> database = records();
        int count = 0;
        try(InputStream fis = file.getInputStream();
            Workbook workbook = WorkbookFactory.create(fis)){
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            while(rowIterator.hasNext()){
                Row row = rowIterator.next();
                Water water = new Water();
                water.setTown(String.valueOf(row.getCell(0)));
                water.setTemperature(Double.parseDouble(String.valueOf(row.getCell(1))));
                water.setDate(String.valueOf(row.getCell(2)));
                if(!database.contains(water)){
                    repository.save(water);
                    count++;
                }
            }
            if(count > 0){
                return true;
            }
        }catch (FileNotFoundException fnf){
            fnf.printStackTrace();
        }catch (IOException ie){
            ie.printStackTrace();
        }
        return false;
    }

    public boolean insertSingleRecord(Water water){
        List<Water> database = records();
        if(!database.contains(water)){
            repository.save(water);
            return true;
        }
        return false;
    }
    private ArrayList<Water> records(){
        ArrayList<Water> allRecords = (ArrayList<Water>) repository.findAll();
        return allRecords;
    }
}
