package com.kevin.creation.facotory.entity;

import com.kevin.creation.facotory.FactoryMethod;

public class LDOrderPizza extends FactoryMethod {
    @Override
    public Pizza createPizza() {
        return new Pizza("LD");
    }
}
