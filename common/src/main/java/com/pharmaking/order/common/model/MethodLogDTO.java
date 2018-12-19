package com.pharmaking.order.common.model;

import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class MethodLogDTO {

    private String projectName;
    private String moduleName;
    private String name;
    private Integer callTime;

    public MethodLogDTO() {}

    public MethodLogDTO(LogContext logContext, MonitorConfig monitorConfig) {
        this.projectName = monitorConfig.getProjectCode();
        this.moduleName = monitorConfig.getModuleCode();
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
