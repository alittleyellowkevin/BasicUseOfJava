package com.kevin;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import java.util.List;

public class curator的使用 {
    public static void main(String[] args) throws Exception {
        /*
        依赖
         `<!-- Curator framework -->
        <dependency>
            <groupId>org.apache.curator</groupId>
            <artifactId>curator-framework</artifactId>
            <version>5.2.0</version> <!-- Use the latest 5.x version -->
        </dependency>
        <!-- Curator recipes -->
        <dependency>
            <groupId>org.apache.curator</groupId>
            <artifactId>curator-recipes</artifactId>
            <version>5.2.0</version> <!-- Use the latest 5.x version -->
        </dependency>
         */
        //第一种方式
        /*
          1.连接字符串
          2.会话超时时间
          3.连接超时时间
          4.重试策略
         */

        //重试策略
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000, 10);
        CuratorFramework client = CuratorFrameworkFactory.newClient("localhost:2181",60*1000, 15*1000, retryPolicy);
        //开启连接
        client.start();

        //创建节点
        // 若创建节点，没制定数据，则默认将当前客户端ip作为数据存储的
        // withMode 设置节点模式
        // creatingParentsIfNeeded()：如果父节点不存在则父节点一起创建
        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/app1","toString".getBytes());

        //查询节点数据
        byte[] data = client.getData().forPath("/app1");

        //查询节点的子孙
        List<String> path = client.getChildren().forPath("/app1");

        //查询节点状态数据保存于stat中
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/app1");

        //修改节点
        client.setData().forPath("/app1","itcast".getBytes());

        //删除节点
        // deletingChildrenIfNeeded() 删除带有子节点的节点
        // guaranteed()必须成功删除
        //inBackground() 回调函数删除成功之后做什么
        client.delete().guaranteed().deletingChildrenIfNeeded().inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                System.out.println("我被删除了~");
            }
        }).forPath("/app1");


        //关闭连接
        client.close();
    }
}
