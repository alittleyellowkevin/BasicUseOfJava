package com.kevin.curator;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.junit.Test;

public class CuratorTest {
    @Test
    public void testConnect(){

        //第一种方式
        /*
            String connectString,    zkserver的地址和端口
            int sessionTimeoutMs,    会话超时时间
            int connectionTimeoutMs, 连接超时时间
            RetryPolicy retryPolicy  重连策略
        */
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(3000, 10);
        CuratorFrameworkFactory.newClient("localhost:2181", retryPolicy);
    }
}
