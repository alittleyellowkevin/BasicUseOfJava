package com.kevin.structure.proxy;

import com.kevin.structure.proxy.entity.BuyHouse;


// 静态代理
public class StaticProxy implements BuyHouse{
    private BuyHouse buyHouse;
    public StaticProxy(final BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }
    @Override
    public void buyHosue() {
        System.out.println("买房前准备");
        buyHouse.buyHosue();
        System.out.println("买房后装修");
    }
}
