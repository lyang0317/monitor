package com.pharmaking.order.common.model;

import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class MethodLogDTO {

    private String projectCode;
    private String moduleCode;
    private String name;
    private Integer callTime;

    public MethodLogDTO() {}

    public MethodLogDTO(LogContext logContext, MonitorConfig monitorConfig) {
        this.projectCode = monitorConfig.getProjectCode();
        this.moduleCode = monitorConfig.getModuleCode();
        this.name = logContext.getMethodName();
        this.callTime = logContext.getCallTime();
    }

    public MethodLogDO toDO() {
        MethodLogDO methodLogDO = new MethodLogDO();
        BeanUtils.copyProperties(this, methodLogDO);
        methodLogDO.setCallTime(this.callTime);
        return methodLogDO;
    }

}
