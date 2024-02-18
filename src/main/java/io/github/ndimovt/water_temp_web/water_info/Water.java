package io.github.ndimovt.water_temp_web.water_info;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "temperature")
public class Water {
    @Id
    private int id;
    private String town;
    private double temperature;
    private LocalDateTime time;
}
