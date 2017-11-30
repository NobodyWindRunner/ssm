package com.zjr.entity;


import lombok.Data;

/**
 * 项目bean
 */

@Data
public class Project {
	
	//项目编号
	private Integer id;
	
	//项目名称
	private String proName;
	
	//项目描述
	private String detail;
	
	//项目状态,0未启动 1进行中 2已完成 3已删除
	private Integer statusVal=1;
}
