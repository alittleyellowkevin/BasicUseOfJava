package com.kevin.creation.facotory;

import com.kevin.creation.facotory.entity.Pizza;

//抽象工厂模式
public interface AbstractFacotry {
    Pizza CreatePizza(String ordertype) ;
}
