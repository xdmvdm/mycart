package com.example.cart.democart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class DemocartApplication {

    public static void main(String[] args) throws Exception {

        SpringApplication.run(DemocartApplication.class, args);
    }

}
