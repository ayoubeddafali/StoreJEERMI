package com.project.model;

import java.io.Serializable;

public class Product implements Serializable{
    private int id = 0 ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name = "";
    private String price = "";
    private String buyer = "";
    private String seller = "";

    public Product(int id, String name, String price, String buyer, String seller) {
        this.id  = id ;
        this.name = name;
        this.price = price;
        this.buyer = buyer;
        this.seller = seller;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
