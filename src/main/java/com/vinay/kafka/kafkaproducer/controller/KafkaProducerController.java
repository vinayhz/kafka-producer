package com.vinay.kafka.kafkaproducer.controller;

import com.vinay.kafka.kafkaproducer.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, Person> kafkaTemplate;

    private static final String KAFKA_EXAMPLE = "kafka_example";

    @GetMapping("/{message}")
    public String getPublish(@PathVariable String message) {

        Person person = new Person();
        person.setId(1001L);
        person.setName(message);

        kafkaTemplate.send(KAFKA_EXAMPLE, person);

        return "Published successfully...!!!";
    }
}
