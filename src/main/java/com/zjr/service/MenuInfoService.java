package com.zjr.service;

import java.util.List;

import com.zjr.entity.MenuInfo;

public interface MenuInfoService {

	/**
	 * @return 返回所以菜单
	 */
	List<MenuInfo> query();
}
