package io.github.ndimovt.water_temp_web.repository;

import io.github.ndimovt.water_temp_web.entity.Scientist;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScientistRepository extends MongoRepository<Scientist, String> {

}
