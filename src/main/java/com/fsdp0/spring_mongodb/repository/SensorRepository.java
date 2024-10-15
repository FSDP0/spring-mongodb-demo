package com.fsdp0.spring_mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.fsdp0.spring_mongodb.domain.Sensor;

public interface SensorRepository extends MongoRepository<Sensor, String>{
}
