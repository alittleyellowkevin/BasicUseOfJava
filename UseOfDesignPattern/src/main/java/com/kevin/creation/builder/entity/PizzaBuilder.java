package com.kevin.creation.builder.entity;


// 生成器接口
public interface PizzaBuilder {
    void setSize(String size);

    void addCheese();

    void addPepperoni();

    void addMushrooms();

    Pizza getPizza();
}
