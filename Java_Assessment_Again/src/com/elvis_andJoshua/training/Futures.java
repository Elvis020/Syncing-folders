package com.elvis_andJoshua.training;

public class Futures extends Product{
    protected String futuresExchange;
    protected String contractCode;
    protected int month;
    protected int year;


    public Futures(String uniqueID, String futuresExchange, String contractCode, int month, int year,ProductPricingService productPricingService) {
        super(uniqueID);
        this.futuresExchange = futuresExchange;
        this.contractCode = contractCode;
        this.month = month;
        this.year = year;
        currentPrice = productPricingService.price(this.futuresExchange,this.contractCode,month,year);
    }
}
