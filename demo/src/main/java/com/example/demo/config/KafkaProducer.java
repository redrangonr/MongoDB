//package com.example.demo.config;
//
//import com.example.demo.model.User;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//public class KafkaProducer {
//
//    @Bean
//    public Map<String, Object> producerConfigs(){
//        Map<String, Object> props = new HashMap<>();
//        props.put("bootstrap.servers", "10.0.223.140:9092");
//        props.put("acks", "all");
//        props.put("retries", 3);
//        props.put("batch.size", 16384);
//        props.put("linger.ms", 1);
//        props.put("buffer.memory", 33554432);
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        return props;
//    }
//    @Bean
//    public ProducerFactory<String, User> producerFactory() {
//        return new DefaultKafkaProducerFactory<>(producerConfigs());
//    }
//    @Bean
//    public KafkaTemplate<String, User> kafkaTemplate() {
//        return new KafkaTemplate<>(producerFactory());
//    }
//}
