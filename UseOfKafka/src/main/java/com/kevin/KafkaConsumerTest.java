package com.kevin;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KafkaConsumerTest {
    public static void main(String[] args) {
        //创建配置对象
        Map<String, Object> configMap =  new HashMap<>();
        configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        //对生产的数据K，V 进行序列化
        configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        // 消费者组
        configMap.put(ConsumerConfig.GROUP_ID_CONFIG, "kevin");

        // 创建消费者对象
        // 消费者需要设定泛型
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(configMap);

        // 订阅主题
        consumer.subscribe(Arrays.asList("test"));

        // 拉取数据
        ConsumerRecords<String, String> records = consumer.poll(100);

        // 遍历数据
        while ( true) {
            final ConsumerRecords<String, String> consumerRecords = consumer.poll(100);
            for(ConsumerRecord<String, String> record : consumerRecords) {
                System.out.println(record.key() + " : " + record.value());
            }
        }

//        // 关闭消费者
//        consumer.close();
    }
}
