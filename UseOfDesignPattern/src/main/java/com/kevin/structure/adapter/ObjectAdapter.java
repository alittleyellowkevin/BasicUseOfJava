package com.kevin.structure.adapter;

import com.kevin.structure.adapter.entity.Projector;
import com.kevin.structure.adapter.entity.USB;
import com.kevin.structure.adapter.entity.USBImpl;
import com.kevin.structure.adapter.entity.VGA;

//对象适配器， 当希望一个对象转换成满足另一个新接口的对象时，可以使用对象适配器模式
public class ObjectAdapter implements VGA {
    private static USB usb;

    public ObjectAdapter(USB usb) {
        ObjectAdapter.usb = usb;
    }

    @Override
    public void projection() {
        usb.showPPT();
    }

    public static void main(String[] args) {
        USB usb1 = new USBImpl();
        ObjectAdapter objectAdapter = new ObjectAdapter(usb1);
        Projector<VGA> projector = new Projector<>();
        projector.projection(objectAdapter);
    }
}
