package com.zjr.dao;

import com.zjr.dto.DepartmentDto;
import com.zjr.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DepartmentDao {

	/**
	 * 添加用户
	 */
	public boolean save(Department department);

	/**
	 * 删除用户
	 */
	public boolean delete(int id);

	/**
	 * 更新用户
	 */
	public boolean update(Department department);

	/**
	 * 	根据ID获取用户
	 */
	public Department get(int id);

	/**
	 * 	根据ID获取用户
	 */
	public Department getByName(String name);

	/**
	 * 分页列表
	 */
	public List<DepartmentDto> queryByPage(@Param("page") int page, @Param("size") int size);

	/**
	 * 数据总量
	 */
	public int count();

	/**
	 * 按部门名查询总量
	 */
	public int countByName(String name);
	/**
	 * 模糊查询
	 */
	public List<DepartmentDto> queryByName(@Param("name") String loginName, @Param("page") int page, @Param("size") int size);

	/**
	 * 匹配查询
	 */
	public Department getById(Department department);
}
