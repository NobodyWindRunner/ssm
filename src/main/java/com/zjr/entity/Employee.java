package com.zjr.entity;

import lombok.Data;

/**
 * 员工bean
 */
@Data
public class Employee {

    private Integer id;
    private String name;
    private String sex;
    private String job;
    private Integer deptId;
}
