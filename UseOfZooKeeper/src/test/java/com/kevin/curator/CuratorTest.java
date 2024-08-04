package com.kevin.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CuratorTest {
    CuratorFramework client;
    @Before
    public void testConnect(){

        //第一种方式
        /*
            String connectString,    zkserver的地址和端口
            int sessionTimeoutMs,    会话超时时间
            int connectionTimeoutMs, 连接超时时间
            RetryPolicy retryPolicy  重连策略
        */
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000, 10);
        client = CuratorFrameworkFactory.newClient("localhost:2181", retryPolicy);
        client.start();
    }
    @After
    public void close(){
        if(client != null){
            client.close();
        }
    }
    /*
     * 创建节点：create 持久 临时 顺序 数据
     * */
    @Test
    public void testCreate() throws Exception {
        //创建临时的节点，如果父节点不存在则创建父节点，并带有数据
        String path = client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath("/app2", "hello".getBytes());
        System.out.println(path);
    }
    /*
    * 查询节点
    * */
    @Test
    public void testGet() throws Exception {
        //查询节点数据
        byte[] data = client.getData().forPath("/app1");
        System.out.println(new String(data));
        //查询子节点
        List<String> paths = client.getChildren().forPath("/");
        System.out.println(paths);
        //查询状态信息
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/app1");
        System.out.println(stat);
    }
    /*
     * 修改节点
     * */
    @Test
    public void testSet() throws Exception {
        //修改节点数据
        client.setData().forPath("/app1", "itcast".getBytes());
        //修改节点带版本
        Stat stat = new Stat();
        client.getData().storingStatIn(stat).forPath("/app1");
        client.setData().withVersion(stat.getVersion()).forPath("/app1");
    }
    /*
     * 删除节点
     * */
    @Test
    public void testDelete() throws Exception {
        //修改节点数据
        client.delete().forPath("/app1");
        //删除带子节点
        client.delete().deletingChildrenIfNeeded().forPath("/app1");
        //必须删除
        client.delete().guaranteed().forPath("/app1");
        //回调
        client.delete().inBackground(new BackgroundCallback() {
            @Override
            public void processResult(CuratorFramework curatorFramework, CuratorEvent curatorEvent) throws Exception {
                System.out.println("我被删除了");
                System.out.println(curatorEvent);
            }
        });
    }
    /*
     * Watch事件监听
     * */
    @Test
    public void testWatch() throws Exception {
        /* NodeCache给单一节点注册监听器 */
        //1.创建NodeCache对象
        NodeCache nodeCache = new NodeCache(client, "/app1");
        //2.注册监听
        nodeCache.getListenable().addListener(new NodeCacheListener() {
            @Override
            public void nodeChanged() throws Exception {
                System.out.println("当前节点数据变化成:"+new String(nodeCache.getCurrentData().getData()));
            }
        });
        //3.开启监听，如果设置为true
        nodeCache.start(true);
//        while (true);



        /* PathcChildrenCache:监听某个节点的所有子节点 */
        PathChildrenCache ChildrenCache = new PathChildrenCache(client, "/app1", true);
        ChildrenCache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, PathChildrenCacheEvent pathChildrenCacheEvent) throws Exception {
                System.out.println("节点发生变化");
                System.out.println(pathChildrenCacheEvent);
                //判断类型
                if(pathChildrenCacheEvent.getType().equals(PathChildrenCacheEvent.Type.CHILD_ADDED)){

                }
            }
        });
//        while (true);

        /* PathcChildrenCache:监听某个节点的所有子节点 */
        TreeCache treeCache = new TreeCache(client, "/app1");
        treeCache.getListenable().addListener(new TreeCacheListener() {
            @Override
            public void childEvent(CuratorFramework curatorFramework, TreeCacheEvent treeCacheEvent) throws Exception {

            }
        });
    }

    /*
     * 分布式锁
     * */
    @Test
    public void testLock() throws Exception {

    }
}
