package com.pharmaking.order.common.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class MonitorConfig {

    @Value("${order.monitor.project.code}")
    private String projectCode;
    @Value("${order.monitor.module.code}")
    private String moduleCode;
    @Value("${order.monitor.switch.flag}")
    private boolean switchFlag;

}
