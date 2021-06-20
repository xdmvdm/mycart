package com.example.cart.democart;
/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.mongodb.client.result.UpdateResult;
import com.mongodb.client.result.DeleteResult;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Component
public class AppRunner implements CommandLineRunner {
    @Autowired
    private MongoTemplate mongoTemplate;

    public AppRunner() {

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("APPRunner Cart has started for initial values");

        if (!mongoTemplate.collectionExists("cart")) {
            doInsert();
        }

    }

    private void doInsert() {


        Cart mycard = new Cart(1L, 1L, 1, 10, 1, "testdata");
        mongoTemplate.insert(mycard);
        System.out.println("Cart item inserted successfully");

    }

    private void myQuery() {
        Criteria criteria = Criteria.where("productName").is("testdata");
        Query query = Query.query(criteria);
        Cart mcard = mongoTemplate.findOne(query, Cart.class);
        System.out.println(mcard);

        // Query all card
        List<Cart> cards = mongoTemplate.findAll(Cart.class);
        cards.forEach(System.out::println);

        // Query multiple card
        BasicQuery queryByName = new BasicQuery("{ productName: 'testdata' }");
        List<Cart> cardByName = mongoTemplate.find(queryByName, Cart.class);
        cardByName.forEach(System.out::println);
    }

    private void myUpdate() {
        // Update one card
        Query query = new Query(Criteria.where("cartId").is("1"));
        Update update = new Update().set("price", 3.9);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Cart.class);
        System.out.println("Modified data: " + result.getModifiedCount());
        // Update multiple card
        Query queryCard = query(where("customerId").is("55"));
        Update updateCard = new Update().set("quantity", "5");
        UpdateResult resultAuthor = mongoTemplate.updateMulti(queryCard, updateCard, Cart.class);
        System.out.println("Modified data: " + resultAuthor.getModifiedCount());
    }

    private void myDelete() {
        Query query = query(where("cartId").is("3"));
        DeleteResult result = mongoTemplate.remove(query, Cart.class);
        System.out.println("Deleted data: " + result.getDeletedCount());
    }
}

 */