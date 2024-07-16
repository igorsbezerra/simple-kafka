package dev.igor.salesservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sales")
public class SalesController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public SalesController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public ResponseEntity<Void> makeSale(@RequestBody String productId) {
        kafkaTemplate.send("stock-topic", productId);
        return ResponseEntity.ok().build();
    }
}
