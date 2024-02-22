package io.github.ndimovt.water_temp_web.water_info;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "temperature")
public class Water {

    private String town;
    private double temperature;
    private String date;

    public Water() {
    }

    public Water(String date, double temperature) {
        this.date = date;
        this.temperature = temperature;
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

}
