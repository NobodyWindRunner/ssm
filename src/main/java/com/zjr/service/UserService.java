package com.zjr.service;

import com.zjr.dto.UserDto;
import com.zjr.entity.User;
import com.zjr.util.PageList;



public interface UserService {
	
	/**
	 * 增
	 */
	boolean add(User user);

	/**
	 * 删(根据id)
	 */
	boolean del(int id);
	
	/**
	 * 改
	 */
	boolean update(User user);

	/**
	 * 查
	 */
	User get(int id);
	
	/**
	 * 列
	 */
	PageList<UserDto> queryByPage(int page,int size);
	/**
	 * 计
	 */
	int count();

	/**
	 * 重
	 */
	boolean checkName(String name);

	/**
	 *模糊列
	 */
	PageList<UserDto> queryByName(String loginName, int page,int size);
}
