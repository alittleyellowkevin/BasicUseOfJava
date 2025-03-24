package com.kevin.creation.facotory.entity;

import com.kevin.creation.facotory.FactoryMethod;

public class NYOrderPizza extends FactoryMethod {
    @Override
    public Pizza createPizza() {
        return new Pizza("NY");
    }
}
