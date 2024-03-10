package io.github.ndimovt.water_temp_web.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
public class Scientist extends Human{

    public Scientist() {
    }
    public Scientist(String username, String password, String name, String surname) {
        super(username, password, name, surname);
    }
    public Scientist(String name, String surname) {
        super(name, surname);
    }

}
