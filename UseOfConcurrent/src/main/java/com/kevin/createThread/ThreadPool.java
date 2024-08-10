package com.kevin.createThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool implements Runnable{
    @Override
    public void run() {
        System.out.println("myThread is running");
    }

     public static void main(String[] args) {
        //创建线程池对象
        ExecutorService tp = Executors.newFixedThreadPool(3);
        tp.submit(new ThreadPool());
        //关闭线程池
        tp.shutdown();
    }
}
