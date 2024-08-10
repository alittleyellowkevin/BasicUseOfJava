package com.kevin;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class Ticket implements Runnable{
    private InterProcessMutex lock;
    public Ticket(){
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000, 10);
        CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181",60*1000, 15*1000, retryPolicy);
        //开启连接
        client.start();

        lock = new InterProcessMutex(client, "/lock");
    }
    private int tickets = 10;
    @Override
    public void run() {
        while (true){
            try{
                if(tickets>0){
                    System.out.println(Thread.currentThread().getName()+":"+tickets);
                    tickets--;
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try {
                    lock.release();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
}
