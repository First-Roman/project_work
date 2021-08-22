package com.firstroman.botconstructor;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication
@EnableMongoRepositories
@EnableMongock
public class BotConstructorApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotConstructorApplication.class, args);
    }

}
