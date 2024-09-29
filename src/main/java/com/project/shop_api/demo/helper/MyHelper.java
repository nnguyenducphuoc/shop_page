package com.project.shop_api.demo.helper;

public class MyHelper {
    public static Double handlePrice(Double originalPrice, Double value) {
        return Math.round((originalPrice - (originalPrice * value/100))*100.0)/100.0;
    }
}
