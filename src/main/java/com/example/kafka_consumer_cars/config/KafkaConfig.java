package com.example.kafka_consumer_cars.config;

import com.example.kafka_consumer_cars.model.Car;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfig {
    @Bean
    public ConsumerFactory<String, String> carConsumerFactory() {
        Map<String, Object> config = new HashMap<>();

        try {
            config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "kafka:9092");
            config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_json");
            config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
            config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

            return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new StringDeserializer());
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(carConsumerFactory());
        return factory;
    }


////    ***** CONFIG for String message ******
//@Bean
//public ConsumerFactory<String, String> msgConsumerFactory() {
//    Map<String, Object> config = new HashMap<>();
//
//
//    try {
//        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
//        config.put(ConsumerConfig.GROUP_ID_CONFIG, "group_id");
//        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//        config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "none");
//
//        return new DefaultKafkaConsumerFactory<>(config);
//    } catch (IllegalStateException e) {
//        e.printStackTrace();
//    }
//
//    return null;
//}
//
//    @Bean
//    public ConcurrentKafkaListenerContainerFactory<String, String> msgkafkaListenerContainerFactory() {
//        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(msgConsumerFactory());
//        return factory;
//    }

}
