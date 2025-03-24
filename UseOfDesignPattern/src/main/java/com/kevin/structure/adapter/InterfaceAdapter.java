package com.kevin.structure.adapter;

import com.kevin.structure.adapter.entity.AdapterUSB2VGA;
import com.kevin.structure.adapter.entity.USB;

// 接口适配器，当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，我们写别的类的时候，继承抽象类即可。
public class InterfaceAdapter extends AdapterUSB2VGA {
    public InterfaceAdapter(USB usb) {
        super(usb);
    }

    @Override
    public void projection() {
        super.projection();
    }
}
