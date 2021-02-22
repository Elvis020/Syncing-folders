package com.elvis_andJoshua.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MontrealTrading implements MontrealTradedProducts{
    List<Product> productsForTrading  = new ArrayList<>();
    Map<Product,Integer> tradedProducts = new HashMap<>();

    public MontrealTrading() {
    }

    @Override
    public void addNewProduct(Product product) throws ProductAlreadyRegisteredException {
        if(productsForTrading.contains(product)){
            throw new ProductAlreadyRegisteredException("Product "+ product + "is already registered.");
        }else{
            productsForTrading.add(product);
        }

    }

    @Override
    public void trade(Product product, int quantity) {
        if(productsForTrading.contains(product)){
            tradedProducts.put(product,quantity);
        }else{
            tradedProducts.put(product,0);
        }

    }

    @Override
    public int totalTradeQuantityForDay() {
        return tradedProducts.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .reduce(0, Integer::sum);
    }

    @Override
    public double totalValueOfDaysTradedProducts() {
        double totalValue = 0.0;
        for (Map.Entry<Product,Integer> trade : tradedProducts.entrySet()) {
            totalValue = totalValue + (trade.getKey().getCurrentPrice() * trade.getValue());
        }
        return totalValue;
    }
}
