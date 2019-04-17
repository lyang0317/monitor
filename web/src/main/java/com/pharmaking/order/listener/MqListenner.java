package com.pharmaking.order.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MqListenner {

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?, ?> record) {

        log.info("kafka的key: " + record.key());
        log.info("kafka的value: " + record.value().toString());
    }
}
