package com.kevin.structure.adapter;

import com.kevin.structure.adapter.entity.Projector;
import com.kevin.structure.adapter.entity.USBImpl;
import com.kevin.structure.adapter.entity.VGA;

//类适配器， 当希望一个类转换成满足另一个新接口的类时，可以使用类适配器模式
public class ClassAdapter extends USBImpl implements VGA {
    @Override
    public void projection() {
        super.showPPT();
    }

    public static void main(String[] args) {
        // 创建适配器
        VGA VGA = new ClassAdapter();
        // 投影
        Projector<VGA> projector = new Projector<>();
        // VGA接口投影
        projector.projection(VGA);
    }
}
