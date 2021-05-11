package com.example.kafka_consumer_cars.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Car {
    private Long id;
    private String name;
    private String dealer;
    private String modelNummer;
    private Integer year;
    private Integer ps;
    private Long price;
}
