package com.example.cart.democart;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AppConfig {
    @Value("${spring.data.mongodb.uri}")
    private String mongoDB;
    public MongoClient mongoClient() {
        return MongoClients.create(mongoDB);
    }

    public @Bean
    MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "MyCart");

    }
}