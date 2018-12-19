package com.pharmaking.order.common.model;

import lombok.Data;

import java.util.Date;

@Data
public class MethodLogDO {
    private Integer id;

    private String projectCode;

    private String moduleCode;

    private String name;

    private Integer callTime;

    private Boolean deleteStatus;

    private Date createTime;

    private Date modifyTime;

}