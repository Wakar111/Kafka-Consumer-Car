FROM adoptopenjdk:11-jre-hotspot
ADD target/kafka_consumer_cars-0.0.1-SNAPSHOT.jar app-consumer.jar
ENTRYPOINT ["java", "-jar", "app-consumer.jar"]