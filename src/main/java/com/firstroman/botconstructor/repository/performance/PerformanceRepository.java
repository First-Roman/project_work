package com.firstroman.botconstructor.repository.performance;

import com.firstroman.botconstructor.model.Performance;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PerformanceRepository extends MongoRepository<Performance, String> {

    Performance findByCommand(String command);

    List<Performance> findAllByUserToken(String userToken);
}
