package com.kevin;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;

public class curatorWatch的使用 {
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

        //1、创建NodeCache的对象 监听某个节点
        NodeCache nodeCache = new NodeCache(client, "/app1");
        //2、注册监听
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("节点变化了~");
                //获取修改节点后数据
                byte[] data = nodeCache.getCurrentData().getData();
                System.out.println(new String(data));
            }
        });
        //3.开启的监听，如果设置为true，则开启监听，加载缓存数据
        nodeCache.start(true);


        //1.创建PathChildrenCache 监听某个节点的所有子节点
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client, "/app2", true);

        //2.绑定监听器
        pathChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent event) throws Exception {
                System.out.println("子节点变化了..");
                System.out.println(event);
                //监听子节点数据变更，并且拿到变更后的数据
                //1.获取类型
                PathChildrenCacheEvent.Type type = event.getType();
                //2.判断类型是否是update
                if(type.equals(PathChildrenCacheEvent.Type.CHILD_UPDATED)){
                    byte[] data = event.getData().getData();
                    System.out.println(new String(data));
                }
            }
        });
        pathChildrenCache.start();
    }
}
