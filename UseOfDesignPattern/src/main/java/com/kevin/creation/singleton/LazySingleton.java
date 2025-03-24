package com.kevin.creation.singleton;


public class LazySingleton {
    // volatile关键字保证了instance在所有线程中同步
    private static volatile LazySingleton instance = null;
    private LazySingleton() {
    };
    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            // 保证线程安全
            synchronized (instance) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
