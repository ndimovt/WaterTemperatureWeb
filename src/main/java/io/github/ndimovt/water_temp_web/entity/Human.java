package io.github.ndimovt.water_temp_web.entity;

import java.util.Objects;

public class Human {
    private String username;
    private String password;
    private String name;
    private String surname;

    public Human() {
    }

    public Human(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Human(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;
        return Objects.equals(username, human.username) && Objects.equals(password, human.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
