package com.example.shoplist.model;

public class Product {

    private int id;
    private String name;
    private boolean isBought;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
        isBought = false;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }


}
