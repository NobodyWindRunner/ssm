package com.zjr.dto;

import com.zjr.entity.Department;
import lombok.Data;

/**
 * 员工bean
 */
@Data
public class EmployeeDto {

    private Integer id;
    private String name;
    private String sex;
    private String job;
    private Integer deptId;
    private int page;
    private int size;

}
