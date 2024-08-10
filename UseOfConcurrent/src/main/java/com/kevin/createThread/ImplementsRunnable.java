package com.kevin.createThread;

public class ImplementsRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("myThread is running");
    }

    public static void main(String[] args) {
        ImplementsRunnable implementsRunnable = new ImplementsRunnable();
        Thread thread = new Thread(implementsRunnable);
        thread.start();
    }
}
