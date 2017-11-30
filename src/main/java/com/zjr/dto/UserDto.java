package com.zjr.dto;

import lombok.Data;

@Data
public class UserDto {
    private Integer id;
    private String loginName;
    private String password;
    private Integer statusVal;
    private int page;
    private int size;

}
