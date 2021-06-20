package com.example.cart.democart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartServiceImp implements CartService{

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Cart> getAllCartItems() {
        return mongoTemplate.findAll(Cart.class);
    }

    @Override
    public Cart getCartById(String cartid) {
        Query query = new Query();
        System.out.println("Cart Item is "+cartid);
        return mongoTemplate.findOne(
                Query.query(Criteria.where("cartId").is(Long.parseLong(cartid))),
                Cart.class);

    }

    @Override
    public Cart addCartItem(Cart cart) {
        mongoTemplate.save(cart);
        return cart;
    }

    @Override
    public Cart saveOrUpdateCart(Cart manuf) {
        mongoTemplate.save(manuf);
        return manuf;
    }

    @Override
    public Cart deleteCartItem(Cart manuf) {
        mongoTemplate.remove(manuf);
        return manuf;
    }

    @Override
    public Long deleteCartItem(Long cartId) {

        Query mquerry= Query.query(Criteria.where("cartId").is(cartId));
        mongoTemplate.remove(mquerry,Cart.class);

        return 1L;
    }

    @Override
    public Long findTopByOrderByIdDesc() {
        final Query query = new Query()
                .limit(1)
                .with(Sort.by(Sort.Direction.DESC, "cartId"));
        System.out.println("findTopByOrderByIdDesc");
        Long sayi=1L;
        if(mongoTemplate.findOne(query, Cart.class)!=null)
         sayi=mongoTemplate.findOne(query, Cart.class).getCartId();


        return sayi;

    }
}
