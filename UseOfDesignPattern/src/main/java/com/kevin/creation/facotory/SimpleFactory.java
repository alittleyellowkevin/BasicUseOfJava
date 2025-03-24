package com.kevin.creation.facotory;

import com.kevin.creation.facotory.entity.Pizza;

// 简单工厂模式
public class SimpleFactory {
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("greek")) {
            pizza = new Pizza("Greek");
        } else if (orderType.equals("cheese")) {
            pizza = new Pizza("Cheese");
        }
        return pizza;
    }
}
