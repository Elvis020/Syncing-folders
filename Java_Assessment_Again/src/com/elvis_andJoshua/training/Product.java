package com.elvis_andJoshua.training;

public class Product {
    protected String UniqueID;
    protected double currentPrice;

    public Product(String uniqueID) {
        UniqueID = uniqueID;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }
}
