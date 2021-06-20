package com.example.cart.democart;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping(value = "/cart")
public class AppController {
    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private CartService cartService;

    @Autowired
    RabbitMQProducer rabbitMQProducer;

    @RequestMapping(value = "/addCart", method = RequestMethod.POST)
    public Cart addNewCart(@RequestBody Cart cart) {
        LOG.info("Saving cart.");
        return cartService.saveOrUpdateCart(cart);
    }

    @RequestMapping(value = "/testQue", method = RequestMethod.GET)
    public String addMessageQue() {
        LOG.info("Saving Que.");

        Cart mycard = new Cart(100L, 1L, 1, 10, 1, "testdata"+UUID.randomUUID());
        rabbitMQProducer.send(mycard);
        cartService.addCartItem(mycard);

         System.out.println("Cart Item Added & Message is sent to que");
        return "Items are saved";
    }


    @RequestMapping(value = "/initCart", method = RequestMethod.GET)
    public List<Cart> initCart() {
        LOG.info("Getting all cart items.");
        Cart mycard = new Cart(1L, 1L, 1, 10, 1, "testdata");
        cartService.addCartItem(mycard);

        return cartService.getAllCartItems();
    }




    @GetMapping("/addCartItem")
    public ResponseEntity<Void> addship(
            @RequestParam("productId") String productId,
            @RequestParam("quantity") String quantity,
            @RequestParam("price") String price,
            @RequestParam("customerId") String customerId,
            @RequestParam("productName") String productName

    ) {

        Long cartid = cartService.findTopByOrderByIdDesc() + 1;
        System.out.println("Cart id spring add card method is :" + cartid);
        Cart card = new Cart();
        card.setCartId(cartid);
        card.setProductId(Long.parseLong(productId));
        card.setQuantity(Integer.parseInt(quantity));
        card.setPrice(Double.parseDouble(price));
        card.setCustomerId(Integer.parseInt(customerId));
        card.setProductName(productName);
 System.out.println("Cart Item Saved!");
        rabbitMQProducer.send(card);
        cartService.addCartItem(card);
        System.out.println("Cart Item Added & Message is sent to que");

        return ResponseEntity.noContent().build();
    }


    @RequestMapping(value = "/getCart", method = RequestMethod.GET)
    public List<Cart> getAllCart() {
        LOG.info("Getting all cart items.");

        return cartService.getAllCartItems();
    }

    @RequestMapping(value = "/getCart/{cartid}", method = RequestMethod.GET)
    public Cart getCart(@PathVariable String cartid) {
        LOG.info("Getting cart items with ID: {}.", cartid);
        return cartService.getCartById(cartid);
    }


    @RequestMapping(value = "/deleteCart/{cartid}", method = RequestMethod.GET)
    public String deleteCart(@PathVariable String cartid) {
        LOG.info("Deleting  cart." + cartid);
        cartService.deleteCartItem(Long.parseLong(cartid));
        return "Deleted";
    }


}
