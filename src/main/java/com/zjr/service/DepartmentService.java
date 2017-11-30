package com.zjr.service;

import com.zjr.dto.DepartmentDto;
import com.zjr.entity.Department;
import com.zjr.util.PageList;



public interface DepartmentService {

	/**
	 * 增
	 */
	boolean add(Department department);

	/**
	 * 删(根据id)
	 */
	boolean del(int id);

	/**
	 * 改
	 */
	boolean update(Department department);

	/**
	 * 查
	 */
	Department get(int id);

	/**
	 * 列
	 */
	PageList<DepartmentDto> queryByPage(int page, int size);
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
	PageList<DepartmentDto> queryByName(String name, int page, int size);
}
