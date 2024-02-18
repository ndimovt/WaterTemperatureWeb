package io.github.ndimovt.water_temp_web.repository;

import io.github.ndimovt.water_temp_web.scientist.Scientist;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;
import java.util.List;

public interface ScientistRepository extends MongoRepository<Scientist, String> {

}
