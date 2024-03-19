package io.github.ndimovt.water_temp_web.repository;

import io.github.ndimovt.water_temp_web.water_info.Water;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.ArrayList;

public interface WaterRepository extends MongoRepository<Water, String> {
    public ArrayList<Water> findByTown(String town);

}
