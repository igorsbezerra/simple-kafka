package dev.igor.stockservice.service;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class StockListener {
    @KafkaListener(topics = "stock-topic", groupId = "stock-group")
    public void processSale(String message) {
        log.info("Sale received {}", message);
    }
}
