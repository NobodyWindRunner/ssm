package com.zjr.dto;

import lombok.Data;

import java.io.Serializable;

/**
 *  菜单bean
 */
@Data
public class MenuInfoDto implements Serializable {

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

	private int page;
	private int size;
}
