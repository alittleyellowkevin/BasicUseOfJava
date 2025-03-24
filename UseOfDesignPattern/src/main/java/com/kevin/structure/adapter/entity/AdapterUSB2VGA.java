package com.kevin.structure.adapter.entity;

import com.kevin.structure.adapter.ObjectAdapter;

public abstract class AdapterUSB2VGA implements VGA {
    private static USB usb;

    public AdapterUSB2VGA(USB usb) {
        AdapterUSB2VGA.usb = usb;
    }

    @Override
    public void projection() {
        usb.showPPT();
    }
}
