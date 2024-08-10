package com.kevin.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ImplementsCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("MyThread is running");
        return "MyThread is running";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ImplementsCallable implementsCallable = new ImplementsCallable();
        //创建futuretask
        FutureTask<String> ft = new FutureTask<>(implementsCallable);
        Thread thread = new Thread(ft);
        thread.start();
        System.out.println(ft.get());
    }
}
