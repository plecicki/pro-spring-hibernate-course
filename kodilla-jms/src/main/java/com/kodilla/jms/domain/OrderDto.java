package com.kodilla.jms.domain;

import java.util.List;

public class OrderDto {

    private String receiver;
    private String sender;
    private List<Products> productsList;

    public OrderDto() {
    }

    public OrderDto(String receiver, String sender, List<Products> productsList) {
        this.receiver = receiver;
        this.sender = sender;
        this.productsList = productsList;
    }

    public OrderDto(String receiver, String sender) {
        this.receiver = receiver;
        this.sender = sender;
    }

    public void addProductToList(Products product) {
        productsList.add(product);
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public List<Products> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<Products> productsList) {
        this.productsList = productsList;
    }
}
