package com.pharmaking.order.service;

import com.pharmaking.order.common.model.MonitorConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingDeque;

@Component
public class WorkingPool implements InitializingBean {

    @Autowired
    private WorkingExecutor workingExecutor;

    private static LinkedBlockingDeque workingQueue = new LinkedBlockingDeque();

    public static LinkedBlockingDeque getWorkingQueue() {
        return workingQueue;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        workingExecutor.doWork();
    }

}
