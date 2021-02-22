package com.elvis_andJoshua.training;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StocksTest {

    @Mock
    ProductPricingService mockingProductPricingService = mock(ProductPricingService.class);
    double requiredStocksValue = 2000.00;



    @Test
    public void testStockValuation(){
        when(mockingProductPricingService.price("S2311","T542")).thenReturn(requiredStocksValue);
        Product Stocks1 = new Stocks("Stocky1","T542","S2311",mockingProductPricingService);
        assertEquals(requiredStocksValue,Stocks1.getCurrentPrice(),0.01);
        System.out.println(Stocks1.getCurrentPrice());
    }
}