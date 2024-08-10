package com.kevin;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class consumerConfiguration {
    //配置消息转换器
    @Bean
    public MessageConverter messageConverter(){
        return new Jackson2JsonMessageConverter();
    }

    //创建exchange
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanout.exchange");
    }
    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("direct.exchange1");
    }
    //创建 queue
    @Bean
    public Queue fanoutQ1(){
        return new Queue("fanout.q1");
    }

    @Bean
    public Queue lazyQueue(){
        return QueueBuilder.durable("q1").lazy() //开启lazy模式
                .build();
    }
    //绑定
    @Bean
    public Binding binding1(){
        return BindingBuilder.bind(fanoutQ1()).to(fanoutExchange());
    }
    //绑定
    @Bean
    public Binding binding2(){
        return BindingBuilder.bind(fanoutQ1()).to(directExchange()).with("white");
    }
}
