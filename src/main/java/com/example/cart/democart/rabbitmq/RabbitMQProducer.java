package com.example.cart.democart.rabbitmq;

import com.example.cart.democart.entity.Cart;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMQProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;


    public void send(Cart cart) {
        amqpTemplate.convertAndSend(exchange, routingkey, cart);
        System.out.println("Sending msg to rabbitmq!! = " + cart);

    }
}