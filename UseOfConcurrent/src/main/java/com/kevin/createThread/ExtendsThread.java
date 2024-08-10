package com.kevin.createThread;

public class ExtendsThread extends Thread{
    @Override
    public void run(){
        System.out.println("MyThread is running");
    }

    public static void main(String[] args) {
        ExtendsThread thread = new ExtendsThread();
        Thread thread1 = new Thread(()->{
            System.out.println("log");
        });

        thread.start();
    }
}
