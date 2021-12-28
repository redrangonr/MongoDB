package com.example.demo.config;

import java.util.Arrays;
import java.util.Properties;

public class KafkaConsumer {


//    public class Consumer {
//        public static void main(String[] args) {
//            Properties props = new Properties();
//            props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "10.0.223.140:9092");
//            props.put(ConsumerConfig.GROUP_ID_CONFIG,"Quocanh1");
//            props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
//            props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
//            props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
//                    "org.apache.kafka.common.serialization.StringDeserializer");
//            props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
//                    "org.apache.kafka.common.serialization.StringDeserializer");
//            props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
//            KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
//            consumer.subscribe(Arrays.asList("foo","bar"));
//            while (true) {
//                ConsumerRecords<String, String> records = consumer.poll(100);
//                for (ConsumerRecord<String, String> record : records)
//                    System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//            }
//        }
//    }

}
