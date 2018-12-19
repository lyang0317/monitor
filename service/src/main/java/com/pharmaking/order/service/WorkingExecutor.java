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
@Service
public class WorkingExecutor {

    @Autowired
    private MethodLogService methodLogService;

    @Autowired
    private MonitorConfig monitorConfig;

    @Async
    public void doWork() {
        while (true) {
            Object work = null;
            try {
                work = WorkingPool.getWorkingQueue().take();
            } catch (InterruptedException e) {
                log.error("阻塞队列获取中断异常");
            }
            try {
                if(work != null) {
                    LogContext logContext = (LogContext) work;
                    if(monitorConfig.isSwitchFlag()) {
                        MethodLogDTO methodLogDTO = new MethodLogDTO(logContext, monitorConfig);
                        methodLogService.insert(methodLogDTO);
                    }
                }
            } catch (Exception e) {
                log.error("记录异常", e);
            }
        }
    }

}
