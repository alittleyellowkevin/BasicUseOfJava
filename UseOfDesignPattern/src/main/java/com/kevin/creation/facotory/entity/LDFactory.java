package com.kevin.creation.facotory.entity;

import com.kevin.creation.facotory.AbstractFacotry;

public class LDFactory implements AbstractFacotry {
       @Override
       public Pizza CreatePizza(String ordertype) {
              Pizza pizza = null;
              if ("cheese".equals(ordertype)) {
                     pizza = new LDCheesePizza("LD Cheese Pizza");
              } else if ("pepper".equals(ordertype)) {
                     pizza = new LDPepperPizza("LD Pepper Pizza");
              }
              return pizza;
       }
}