package com.pharmaking.order.web;

import com.pharmaking.order.service.MethodLogService;
import com.sun.org.apache.xpath.internal.operations.String;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/monitor")
@Slf4j
public class MonitorController {

    @Autowired
    private MethodLogService methodLogService;

    @Autowired
    private KafkaTemplate kafkaTemplate;

    @GetMapping("/getList")
    public List getList() {
        return new ArrayList(){{
            add(1);
            add(2);
        }};
    }


    @GetMapping("/put")
    public void put() {
        kafkaTemplate.send("test","monitorDateTime", "12321");
        log.info("producer send ok");
    }
}
