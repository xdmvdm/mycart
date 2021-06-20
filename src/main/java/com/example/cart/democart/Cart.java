package com.example.cart.democart;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "cart")
public class Cart {


    private Long cartId;
    private Long productId;

    private int quantity;
    private double price;

    private int customerId;

    private String productName;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Cart(Long cartId, Long productId, int quantity, double price, int customerId, String productName) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.customerId = customerId;
        this.productName = productName;
    }

    public Cart() {
    }


    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", price=" + price +
                ", customerId=" + customerId +
                ", productName='" + productName + '\'' +
                '}';
    }
}
