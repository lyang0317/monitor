package com.pharmaking.order.common.model;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MonitorConfig {

    private String projectCode;
    private String moduleCode;
    private boolean switchFlag;

}
