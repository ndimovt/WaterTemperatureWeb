package io.github.ndimovt.water_temp_web.service;

import io.github.ndimovt.water_temp_web.repository.ScientistRepository;
import io.github.ndimovt.water_temp_web.entity.Scientist;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;

@Service
public class ScientistService{
    @Autowired
    private ScientistRepository repo;

    public JSONObject logIn(String username, String pass){
        JSONObject obj = new JSONObject();
        ArrayList<Scientist> information = (ArrayList<Scientist>) repo.findAll();
        for(Scientist check : information){
            if(check.getUsername().equals(username) && check.getPassword().equals(pass)){
                obj.put("username",check.getUsername());
                obj.put("password",check.getPassword());
                obj.put("name", check.getName());
                obj.put("surname", check.getSurname());
            }
        }
        return obj;
    }
}
