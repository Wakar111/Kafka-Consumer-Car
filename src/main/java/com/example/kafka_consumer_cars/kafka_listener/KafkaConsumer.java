package com.example.kafka_consumer_cars.kafka_listener;

import com.example.kafka_consumer_cars.model.Car;
import com.google.gson.Gson;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    private static final Gson g = new Gson();

    @KafkaListener(topics = "java-example-json", groupId = "group_json")
    public void carConsume(String car) {
        if (!car.equals("")) {

            Car carObj = g.fromJson(car, Car.class);
            System.out.println("Name: " + carObj.getName() + "\n" +
                    "Dealer: " + carObj.getDealer() + "\n" +
                    "Wert: " + carObj.getPrice() + "\n" +
                    "Preis: " + carObj.getPrice() + "\n" +
                    "Jahr: " + carObj.getYear());

        } else {
            System.out.println("Keine Daten!!!");
        }

    }

//    @KafkaListener(topics = "java-example-json", groupId = "group_string", containerFactory = "msgkafkaListenerContainerFactory")
//    public void msgConsume(String msg) {
//        if (!msg.equals("")) {
//            System.out.println("Ihre Eingabe: " + msg.toString());
//        } else {
//            System.out.println("Keine Daten!!!");
//        }
//    }

}
