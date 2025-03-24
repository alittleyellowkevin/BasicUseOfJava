package com.kevin.creation.builder.entity;


// 指挥者
public class PizzaDirector {
    private PizzaBuilder pizzaBuilder;

    public PizzaDirector(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public void makePizza() {
        pizzaBuilder.setSize("Large");
        pizzaBuilder.addCheese();
        pizzaBuilder.addPepperoni();
        pizzaBuilder.addMushrooms();
    }
}
