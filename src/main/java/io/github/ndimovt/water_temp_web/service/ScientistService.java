package io.github.ndimovt.water_temp_web.service;

import io.github.ndimovt.water_temp_web.repository.ScientistRepository;
import io.github.ndimovt.water_temp_web.scientist.Scientist;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Service
public class ScientistService{
    @Autowired
    private ScientistRepository repo;

    public String logIn(String username, String pass){
        StringBuilder sb = new StringBuilder();
        ArrayList<Scientist> information = (ArrayList<Scientist>) repo.findAll();
        for(Scientist check : information){
            if(check.getUsername().equals(username) && check.getPassword().equals(pass)){
                return sb.append(check.getName()).append(" ").append(check.getSurname()).toString();
            }
        }
        return null;
    }
}
