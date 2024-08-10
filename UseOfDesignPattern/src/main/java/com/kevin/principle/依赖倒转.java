package com.kevin.principle;

public class 依赖倒转 {
    public static void main(String[] args) {
        Bus bus = new Bus();
        Air air = new Air();
        yundong(air);
    }
    interface Inter{
        public void run();
    }
    static public class Bus implements Inter{

        @Override
        public void run() {
            System.out.println("我在地上跑");
        }
    }
    static public class Air implements Inter{

        @Override
        public void run() {
            System.out.println("我在天上飞");
        }
    }
    static public void yundong(Inter inter){
        inter.run();
    }

}
