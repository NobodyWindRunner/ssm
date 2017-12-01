package com.zjr.service;

import com.zjr.dto.EmployeeDto;
import com.zjr.entity.Employee;
import com.zjr.util.PageList;


public interface EmployeeService {

	/**
	 * 增
	 */
	boolean add(Employee employee);

	/**
	 * 删(根据id)
	 */
	boolean del(int id);

	/**
	 * 改
	 */
	boolean update(Employee employee);

	/**
	 * 查
	 */
	Employee get(int id);

	/**
	 * 列
	 */
	PageList<EmployeeDto> queryByPage(int page, int size);
	/**
	 * 计
	 */
	int count();

	/**
	 *模糊列
	 */
	PageList<EmployeeDto> queryByName(String name, int page, int size);
}
