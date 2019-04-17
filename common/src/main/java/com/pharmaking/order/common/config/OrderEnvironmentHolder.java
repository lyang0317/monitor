package com.pharmaking.order.common.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderEnvironmentHolder {


    @Value("${model:default}")
    private String domain;

    @Value("${env:default}")
    private String environment;


}
