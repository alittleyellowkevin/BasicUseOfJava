package com.kevin.creation.builder.entity;

// 具体生成器
public class ConcretePizzaBuilder implements PizzaBuilder {
    private Pizza pizza;

    public ConcretePizzaBuilder() {
        this.pizza = new Pizza();
    }

    @Override
    public void setSize(String size) {
        pizza.setSize(size);
    }

    @Override
    public void addCheese() {
        pizza.setCheese(true);
    }

    @Override
    public void addPepperoni() {
        pizza.setPepperoni(true);
    }

    @Override
    public void addMushrooms() {
        pizza.setMushrooms(true);
    }

    @Override
    public Pizza getPizza() {
        return this.pizza;
    }
}
