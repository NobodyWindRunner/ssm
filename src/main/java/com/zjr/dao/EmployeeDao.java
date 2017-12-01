package com.zjr.dao;

import com.zjr.dto.EmployeeDto;
import com.zjr.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface EmployeeDao {

	/**
	 * 添加员工
	 */
	public boolean save(Employee employee);

	/**
	 * 删除员工
	 */
	public boolean delete(int id);

	/**
	 * 更新员工
	 */
	public boolean update(Employee employee);

	/**
	 * 	根据ID获取员工
	 */
	public Employee get(int id);

	/**
	 * 分页列表
	 */
	public List<EmployeeDto> queryByPage(@Param("page") int page, @Param("size") int size);

	/**
	 * 数据总量
	 */
	public int count();

	/**
	 * 按姓名查询总量
	 */
	public int countByName(String name);
	/**
	 * 模糊查询
	 */
	public List<EmployeeDto> queryByName(@Param("name") String loginName, @Param("page") int page, @Param("size") int size);

	/**
	 * 匹配查询
	 */
	public Employee getById(Employee employee);
}
