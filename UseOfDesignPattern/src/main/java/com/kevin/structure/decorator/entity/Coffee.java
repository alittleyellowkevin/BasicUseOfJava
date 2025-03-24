package com.kevin.structure.decorator.entity;

// 被装饰的对象
public  class Coffee extends Drink {
       @Override
       public float cost() {
              // TODO Auto-generated method stub
              return super.getPrice();
       }
}