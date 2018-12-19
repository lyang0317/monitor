package com.pharmaking.order.common.model;

import lombok.Data;

@Data
public class LogContext {

    private String methodName;
    private Integer callTime;

}
