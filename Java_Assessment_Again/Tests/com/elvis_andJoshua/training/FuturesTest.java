package com.elvis_andJoshua.training;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FuturesTest {
    @Mock
    ProductPricingService mockingProductPricingService = mock(ProductPricingService.class);
    double requiredFuturesValue = 4000.00;

    @Test
    public void testFuturesValuation(){
        when(mockingProductPricingService.price("ELSE","F432",4,2021)).thenReturn(requiredFuturesValue);
        Product Futures1 = new Futures("F112","ELSE","F432",4,2021,mockingProductPricingService);
        assertEquals(requiredFuturesValue,Futures1.getCurrentPrice(),0.01);
    }




}