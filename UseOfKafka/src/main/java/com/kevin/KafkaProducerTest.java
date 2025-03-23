package com.kevin;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;

public class KafkaProducerTest {
    public static void main(String[] args) {
        //创建配置对象
        Map<String, Object> configMap =  new HashMap<>();
        configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");

        //对生产的数据K，V 进行序列化
        configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // 创建生产对象
        // 生产者需要设定泛型
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(configMap);

        // 创建数据
        //创建数据时，需要传递三个参数，第一个参数是topic，第二个参数是key，第三个参数是value
        ProducerRecord<String, String> record = new ProducerRecord<String, String>("test", "key", "value");

        // 发送数据
        producer.send(record);

        // 关闭生产者
        producer.close();

    }
}
