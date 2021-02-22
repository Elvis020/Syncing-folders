package com.elvis_andJoshua.training;

public class Stocks extends Product {
    protected String stockTicker;
    protected String stockExchange;
    ProductPricingService productPricingService;


    public Stocks(String uniqueID,  String stockExchange,String stockTicker,ProductPricingService productPricingService) {
        super(uniqueID);
        this.stockTicker = stockTicker;
        this.stockExchange = stockExchange;
        this.currentPrice = productPricingService.price(stockTicker,stockExchange);
    }
}
