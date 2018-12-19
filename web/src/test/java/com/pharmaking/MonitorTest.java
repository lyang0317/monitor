package com.pharmaking;

import com.pharmaking.order.service.MethodLogService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class MonitorTest extends BaseTest {

    @Autowired
    private MethodLogService methodLogService;

    @Test
    public void testService(){
        methodLogService.selectList();
        try {
            Thread.sleep(65000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
