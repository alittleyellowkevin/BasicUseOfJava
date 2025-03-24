package com.kevin.creation.prototype;

import com.kevin.creation.prototype.entity.ConcretePrototype;

// 客户端
public class Prototype {
    public static void main(String[] args) {
        ConcretePrototype original = new ConcretePrototype("Original Value");
        System.out.println("Original: " + original);

        // 克隆对象
        ConcretePrototype cloned = (ConcretePrototype) original.clone();
        System.out.println("Cloned: " + cloned);

        // 修改克隆对象
        cloned.setField("Modified Value");
        System.out.println("Original after modification: " + original);
        System.out.println("Cloned after modification: " + cloned);
    }
}
