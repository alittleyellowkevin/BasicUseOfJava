package com.kevin;

import com.sun.corba.se.pept.protocol.MessageMediator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@ExtendWith(SpringExtension.class) //
@SpringBootTest
public class sendMessage {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Test
    void Send() {
        String queueName = "q1";
        Map<String, String> map = new HashMap<>();
        map.put("name", "jack");
        rabbitTemplate.convertAndSend(queueName, map);
    }
    @Test
    void Send1() {
        for (int i = 0; i < 50; i++) {
            String queueName = "q1";
            String message = "hello_" + i;
            rabbitTemplate.convertAndSend(queueName, message);
        }
    }
    @Test
    void Send2() {
        String queueName = "fanout.exchange";
        Map<String, String> map = new HashMap<>();
        map.put("name", "jack");
        //发送到交换机
        rabbitTemplate.convertAndSend(queueName,"",map);
    }
    @Test
    void Send3() {
        String queueName = "direct.exchange";
        String message = "hello";
        //发送到交换机
        rabbitTemplate.convertAndSend(queueName,"yellow",message);
    }
    @Test
    void Send4() {
        String queueName = "topic.exchange";
        String message = "hello";
        //发送到交换机
        rabbitTemplate.convertAndSend(queueName,"Math.#",message);
    }
    @Test
    void testPublicsherConfirm() {
        // 1.创建CorrelationData
        CorrelationData cd = new CorrelationData(UUID.randomUUID().toString());
        // 2.给Future添加ConfirmCallback
        cd.getFuture().addCallback(new ListenableFutureCallback<CorrelationData.Confirm>() {
            @Override
            public void onFailure(Throwable ex) {
                //2.1future发生异常时的处理逻辑，基本不会触发
                log.error("fail");
            }

            @Override
            public void onSuccess(CorrelationData.Confirm result) {
                //2.2 future 接收到回执的处理逻辑
                if(result.isAck()){
                    log.debug("消息发送成功");
                }else {
                    log.error("消息发送失败：{}", result.getReason());
                }
            }
        });
        //发送到交换机
        rabbitTemplate.convertAndSend("direct.exchange","blue","hello", cd);
    }
    @Test
    void testPageOut(){
        Message message = MessageBuilder
                .withBody("hello".getBytes())
                .setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
        rabbitTemplate.convertAndSend("q1", message);

    }
    @Test
    void testTTl(){
        Message message = MessageBuilder
                .withBody("hello".getBytes())
                .setExpiration("30000").build();
        rabbitTemplate.convertAndSend("simple.exchange", "yeah", message);

    }
}