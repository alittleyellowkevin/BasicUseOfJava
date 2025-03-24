package com.kevin.creation.builder;

import com.kevin.creation.builder.entity.ConcretePizzaBuilder;
import com.kevin.creation.builder.entity.Pizza;
import com.kevin.creation.builder.entity.PizzaBuilder;
import com.kevin.creation.builder.entity.PizzaDirector;

//生成器模式
public class Builder {
    public static void main(String[] args) {
        //创建一个具体的pizza生产者
        PizzaBuilder builder = new ConcretePizzaBuilder();
        //交给指挥者
        PizzaDirector director = new PizzaDirector(builder);
        //指挥者指挥工厂制造披萨
        director.makePizza();
        //通过生产者获取披萨
        Pizza pizza = builder.getPizza();
        System.out.println(pizza);
    }
}
