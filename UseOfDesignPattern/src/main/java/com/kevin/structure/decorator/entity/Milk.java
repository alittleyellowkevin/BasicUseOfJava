package com.kevin.structure.decorator.entity;

import com.kevin.structure.decorator.Decorator;

public class Milk extends Decorator {
       public Milk(Drink Obj) {          
              super(Obj);
              // TODO Auto-generated constructor stub
              super.setDescription("Milk");
              super.setPrice(2.0f);
       }
}
