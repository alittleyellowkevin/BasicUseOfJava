package com.kevin.structure.decorator;

import com.kevin.structure.decorator.entity.Decaf;
import com.kevin.structure.decorator.entity.Drink;
import com.kevin.structure.decorator.entity.Milk;

public class Decorator extends Drink {
       private Drink Obj;
       public Decorator(Drink Obj) {
              this.Obj = Obj;
       };
       @Override
       public float cost() {
              // TODO Auto-generated method stub
              return super.getPrice() + Obj.cost();
       }
       @Override
       public String getDescription() {
              return super.description + "-" + super.getPrice() + "&&" + Obj.getDescription();
       }

       public static void main(String[] args) {
              Drink order;
              order = new Decaf();
              System.out.println("order1 price:" + order.cost());
              System.out.println("order1 desc:" + order.getDescription());
              System.out.println("****************");
              order = new Milk(order);
              System.out.println("order2 price:" + order.cost());
              System.out.println("order2 desc:" + order.getDescription());
              order = new Milk(order);
              System.out.println("order3 price:" + order.cost());
              System.out.println("order3 desc:" + order.getDescription());
       }
}