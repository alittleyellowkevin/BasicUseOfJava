package com.kevin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Listener {
//    @RabbitListener(queues = "q1")
//    public void listen(String msg){
//        log.info("Spring 消费者1收到消息【"+msg+"】");
//    }
    @RabbitListener(queues = "q2")
    public void listen2(String msg){
        log.info("Spring 消费者1收到消息【"+msg+"】");
    }
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "q1", durable = "true"),
            exchange =  @Exchange(value = "direct.exchange", type = ExchangeTypes.DIRECT),
            key = {"red", "yellow"}
    ))
    public void listen3(String msg){
        log.info("Spring 消费者2收到消息【"+msg+"】");
    }
    @RabbitListener(queues = "direct.q1")
    public void listen4(String msg){
        log.info("blue 收到消息 【"+msg+"】");
    }
    @RabbitListener(queues = "direct.q2")
    public void listen5(String msg){
        log.info("yellow 收到消息【"+msg+"】");
    }
    @RabbitListener(queues = "topic.q1")
    public void listen6(String msg){
        log.info("消费者1收到消息【"+msg+"】");
    }
    @RabbitListener(queues = "topic.q2")
    public void listen7(String msg){
        log.info("消费者2收到消息【"+msg+"】");
    }
    @RabbitListener(queues = "topic.q3")
    public void listen8(String msg){
        log.info("消费者3收到消息【"+msg+"】");
    }

}
