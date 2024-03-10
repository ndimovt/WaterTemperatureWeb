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
        return repository.findByTownAndDate(town,date);
    }
    public ArrayList<Water> searchByTown(String town){
        return repository.findByTown(town);
    }
    public ArrayList<Water> searchByYear(String year){
        ArrayList<Water> full = (ArrayList<Water>) repository.findAll();
        ArrayList<Water> byYear = new ArrayList<>();
        for(Water water : full){
            if(water.getDate().contains(year)){
                byYear.add(water);
            }
        }
        return byYear;
    }
    public boolean readExcelTable(MultipartFile file){
        ArrayList<Water> allRecords = (ArrayList<Water>) repository.findAll();
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
                if(!allRecords.contains(water)){
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

    public Water insertSingleRecord(Water water){
        return repository.save(water);
    }
    public List<Water> addToMongoDB(ArrayList<Water> list){
        return repository.saveAll(list);
    }
}
