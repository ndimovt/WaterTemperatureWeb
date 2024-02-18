package io.github.ndimovt.water_temp_web.scientist;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
public class Scientist {
    private String username;
    private String password;
    private String name;
    private String surname;

    public Scientist() {
    }

    public Scientist(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }


    public Scientist(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof Scientist) & ((((Scientist) obj).getUsername() == this.username) && (((Scientist) obj).getPassword() == this.password))) {
            return true;
        }
        return false;
    }

}
