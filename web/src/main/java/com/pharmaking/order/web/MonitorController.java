package com.pharmaking.order.web;

import com.pharmaking.order.service.MethodLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/monitor")
public class MonitorController {

    @Autowired
    private MethodLogService methodLogService;

    public List getList() {
        return null;
    }

}
