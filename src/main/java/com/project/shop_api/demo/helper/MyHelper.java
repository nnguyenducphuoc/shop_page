package com.project.shop_api.demo.helper;

public class MyHelper {
    public static Double handlePrice(Double originalPrice, Double value) {
        if (value != null)
            return originalPrice - Math.round((originalPrice * value/100)*100.0)/100.0;
        else return Math.round(originalPrice*100.0)/100.0;
    }
}
