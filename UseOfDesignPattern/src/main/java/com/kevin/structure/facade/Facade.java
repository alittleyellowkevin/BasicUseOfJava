package com.kevin.structure.facade;

import com.kevin.structure.facade.entity.SubSystem1;
import com.kevin.structure.facade.entity.SubSystem2;
import com.kevin.structure.facade.entity.SubSystem3;

public class Facade {
    private SubSystem1 subSystem1;
    private SubSystem2 subSystem2;
    private SubSystem3 subSystem3;

    public Facade() {
        this.subSystem1 = new SubSystem1();
        this.subSystem2 = new SubSystem2();
        this.subSystem3 = new SubSystem3();
    }

    public void methodA() {
        subSystem1.method1();
        subSystem2.method2();
    }

    public void methodB() {
        subSystem2.method2();
        subSystem3.method3();
    }
}
