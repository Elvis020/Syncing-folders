package com.elvis_andJoshua.training;

import org.junit.Test;
import org.mockito.Mock;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MontrealTradingTest {
    @Mock
    ProductPricingService mockingProductPricingService = mock(ProductPricingService.class);
    MontrealTradedProducts montTPro = mock(MontrealTradedProducts.class);
    double requiredFuturesValue = 4000.00;
    double requiredStocksValue = 2000.00;

    @Test(expected = ProductAlreadyRegisteredException.class)
    public void addNewProduct() throws ProductAlreadyRegisteredException {
        when(mockingProductPricingService.price("T542","S2311")).thenReturn(requiredStocksValue);
        when(mockingProductPricingService.price("ELSE","F432",4,2021)).thenReturn(requiredFuturesValue);
        Stocks StocksAB = new Stocks("Stocky1","T542","S2311",mockingProductPricingService);
        Futures FuturesAB = new Futures("F112","ELSE","F432",4,2021,mockingProductPricingService);
        MontrealTrading mT = new MontrealTrading();
        mT.addNewProduct(StocksAB);
        mT.addNewProduct(FuturesAB);
        try{
            mT.addNewProduct(StocksAB);
        }catch (ProductAlreadyRegisteredException e){}
        mT.addNewProduct(StocksAB);
    }

    @Test
    public void trade(){
        when(mockingProductPricingService.price("T542","S2311")).thenReturn(requiredStocksValue);
        when(mockingProductPricingService.price("ELSE","F432",4,2021)).thenReturn(requiredFuturesValue);
        Stocks StocksAB = new Stocks("Stocky1","T542","S2311",mockingProductPricingService);
        Stocks StocksDD = new Stocks("Stocky2","TR32","S1199",mockingProductPricingService);
        Futures FuturesAB = new Futures("F112","ELSE","F432",4,2021,mockingProductPricingService);
        MontrealTrading mT = new MontrealTrading();
        try{
            mT.addNewProduct(StocksAB);
            mT.addNewProduct(FuturesAB);
        }catch (ProductAlreadyRegisteredException e){}
        mT.trade(StocksAB,23);
        mT.trade(FuturesAB,21);
        mT.trade(StocksDD,9);
        mT.tradedProducts.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + ":" + entry.getValue());
        });

    }

    @Test
    public void totalTradeQuantityForDay() {
        when(mockingProductPricingService.price("T542","S2311")).thenReturn(requiredStocksValue);
        when(mockingProductPricingService.price("T542","S2311")).thenReturn(requiredStocksValue);
        when(mockingProductPricingService.price("ELSE","F432",4,2021)).thenReturn(requiredFuturesValue);
        Stocks StocksAB = new Stocks("Stocky1","T542","S2311",mockingProductPricingService);
        Stocks StocksDD = new Stocks("Stocky2","TR32","S1199",mockingProductPricingService);
        Futures FuturesAB = new Futures("F112","ELSE","F432",4,2021,mockingProductPricingService);
        MontrealTrading mT = new MontrealTrading();
        try{
            mT.addNewProduct(StocksAB);
            mT.addNewProduct(FuturesAB);
        }catch (ProductAlreadyRegisteredException e){}
        mT.trade(StocksAB,23);
        mT.trade(FuturesAB,21);
        mT.trade(StocksDD,9);
        assertEquals(44,mT.totalTradeQuantityForDay());

    }

    @Test
    public void totalValueOfDaysTradedProducts() {
        when(mockingProductPricingService.price("T542","S2311")).thenReturn(requiredStocksValue);
        when(mockingProductPricingService.price("TR32","S1199")).thenReturn(requiredStocksValue);
        when(mockingProductPricingService.price("ELSE","F432",4,2021)).thenReturn(requiredFuturesValue);
        Stocks StocksAB = new Stocks("Stocky1","T542","S2311",mockingProductPricingService);
        Stocks StocksDD = new Stocks("Stocky2","TR32","S1199",mockingProductPricingService);
        Futures FuturesAB = new Futures("F112","ELSE","F432",4,2021,mockingProductPricingService);
//        Futures FuturesDD = new Futures("F12212sdfsaf12","ELedasfSE","F43df2",2,2020,mockingProductPricingService);
        MontrealTrading mT = new MontrealTrading();
        try{
//            mT.addNewProduct(StocksAB);
            mT.addNewProduct(FuturesAB);
//            mT.addNewProduct(StocksDD);
        }catch (ProductAlreadyRegisteredException e){}
//        mT.trade(StocksAB,23);
        mT.trade(StocksDD,9);
        mT.trade(FuturesAB,21);

        System.out.println(mT.tradedProducts);
        System.out.println(mT.totalValueOfDaysTradedProducts());;
    }
}