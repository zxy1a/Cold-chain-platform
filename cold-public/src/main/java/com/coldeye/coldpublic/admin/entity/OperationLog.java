package com.coldeye.coldpublic.admin.entity;

import lombok.Data;

@Data
public class OperationLog {
    private String id;

    private String name;

    private String portrait;

    private String operationTime;

    private String storehouse;

    private String msg;

}
