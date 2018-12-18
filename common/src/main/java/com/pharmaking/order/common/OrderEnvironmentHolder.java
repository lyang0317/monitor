package com.pharmaking.order.common;

import com.pharmaking.groundhog.passport.web.security.EnvironmentHolder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderEnvironmentHolder implements EnvironmentHolder {


    @Value("${domain:default}")
    private String domain;

    @Value("${env:default}")
    private String environment;

    @Override
    public String getCurrentDomain() {
        return domain;
    }

    @Override
    public Environment getEnvironment() {
        return Environment.of(this.environment);
    }

}
