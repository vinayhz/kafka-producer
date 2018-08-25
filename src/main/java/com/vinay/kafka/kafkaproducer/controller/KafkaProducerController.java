package com.vinay.kafka.kafkaproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaProducerController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String KAFKA_EXAMPLE = "kafka_example";

    @GetMapping("/{message}")
    public String getPublish(@PathVariable String message) {

        kafkaTemplate.send(KAFKA_EXAMPLE, message);

        return "Published successfully...!!!";
    }
}
