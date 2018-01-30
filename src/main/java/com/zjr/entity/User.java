package com.zjr.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户bean
 */
@Data
public class User implements Serializable {

	private Integer id;
	private String loginName;
	private String password;
	//用户状态,1正常2失效 默认1
	private Integer statusVal = 1;
}
