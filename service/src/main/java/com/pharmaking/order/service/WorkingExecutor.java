package com.pharmaking.order.service;

import com.pharmaking.order.common.model.LogContext;
import com.pharmaking.order.common.model.MethodLogDTO;
import com.pharmaking.order.common.model.MonitorConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
public class WorkingExecutor implements InitializingBean {

    @Autowired
    private MethodLogService methodLogService;

    @Autowired
    private MonitorConfig monitorConfig;

    @Override
    public void afterPropertiesSet() throws Exception {
        new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
            }
        }).start();
    }

    public void doWork() {
        while (true) {
            Object work = null;
            try {
                work = WorkingPool.getWorkingQueue().take();
            } catch (InterruptedException e) {
                log.error("阻塞队列获取中断异常");
            }
            if(work != null) {
                LogContext logContext = (LogContext) work;
                MethodLogDTO methodLogDTO = new MethodLogDTO(logContext, monitorConfig);
                methodLogService.insert(methodLogDTO);
            }
        }
    }

}
