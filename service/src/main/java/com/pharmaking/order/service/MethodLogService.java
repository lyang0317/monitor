package com.pharmaking.order.service;

import com.pharmaking.order.common.annotation.MethodMonitor;
import com.pharmaking.order.common.model.MethodLogDTO;
import com.pharmaking.order.dao.mapper.MethodLogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
//@Transactional
public class MethodLogService {

    //@Autowired
    private MethodLogMapper methodLogMapper;

    public void insert(MethodLogDTO methodLogDTO) {
        //methodLogMapper.insert(methodLogDTO.toDO());
    }

    @MethodMonitor
    public List selectList() {
        return null;
    }

}
