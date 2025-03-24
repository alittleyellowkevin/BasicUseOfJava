package com.kevin.creation.singleton;



public class PreloadSingleton {
    private static PreloadSingleton instance = new PreloadSingleton();

    private PreloadSingleton() {
    }

    public static PreloadSingleton getInstance() {
        return instance;
    }
}
