package io.github.ndimovt.water_temp_web.water_info;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Document(collection = "temperature")
public class Water {

    private String town;
    private double temperature;
    private String date;

    public Water() {
    }

    public Water(double temperature, String date) {
        this.temperature = temperature;
        this.date = date;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Water water)) return false;
        return Objects.equals(town, water.town) && Objects.equals(date, water.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(town, date);
    }
}
