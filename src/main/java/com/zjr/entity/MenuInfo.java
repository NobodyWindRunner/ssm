package com.zjr.entity;

import java.io.Serializable;

import lombok.Data;

/**
 *  菜单bean
 */
@Data
public class MenuInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	// 菜单编号
	private Integer id;
	
	// 菜单名称
	private String menuName;
	
	
	// 连接地址
	private String menuUrl;
	
	// 字段排序
	private Integer orderNum;
	
	// 功能说明
	private String menuDesc;
	
	// 页面截图
	private String imgUrl;
	
	// 父类别
	private Integer parentId;
}
