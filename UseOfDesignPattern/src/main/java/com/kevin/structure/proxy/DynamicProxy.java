package com.kevin.structure.proxy;

import com.kevin.structure.proxy.entity.BuyHouse;
import com.kevin.structure.proxy.entity.BuyHouseImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//动态代理
public class DynamicProxy implements InvocationHandler {
    private Object object;
    public DynamicProxy(final Object object) {
        this.object = object;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("买房前准备");
        Object result = method.invoke(object, args);
        System.out.println("买房后装修");
        return result;
    }
    public static void main(String[] args) {
        BuyHouse buyHouse = new BuyHouseImpl();
        BuyHouse proxyBuyHouse = (BuyHouse) Proxy.newProxyInstance(BuyHouse.class.getClassLoader(), new
                Class[]{BuyHouse.class}, new DynamicProxy(buyHouse));
        proxyBuyHouse.buyHosue();
    }
}
