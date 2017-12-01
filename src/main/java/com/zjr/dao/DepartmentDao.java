package com.zjr.dao;

import com.zjr.dto.DepartmentDto;
import com.zjr.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface DepartmentDao {

	/**
	 * 添加部门
	 */
	public boolean save(Department department);

	/**
	 * 删除部门
	 */
	public boolean delete(int id);

	/**
	 * 更新部门
	 */
	public boolean update(Department department);

	/**
	 * 	根据ID获取部门
	 */
	public Department getById(int id);

	/**
	 * 	根据Name获取部门
	 */
	public Department getByName(String name);

	/**
	 * 列表
	 */
	public List<Department> queryAll();

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

}
