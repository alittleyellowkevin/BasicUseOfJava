package com.kevin.structure.adapter.entity;

public class Projector<T> {
       public void projection(T t) {
              if (t instanceof VGA) {
                     System.out.println("开始投影");
                     VGA v = new VGAImpl();
                     v = (VGA) t;
                     v.projection();
              } else {
                     System.out.println("接口不匹配，无法投影");
              }
       }
}