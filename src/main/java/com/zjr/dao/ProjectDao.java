package com.zjr.dao;

import com.zjr.dto.ProjectDto;
import com.zjr.entity.Project;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ProjectDao {

	/**
	 * 添加项目
	 */
	public boolean save(Project project);

	/**
	 * 删除项目
	 */
	public boolean delete(int id);

	/**
	 * 更新项目
	 */
	public boolean update(Project project);

	/**
	 * 	根据ID获取项目
	 */
	public Project get(int id);

	/**
	 * 	根据Name获取项目
	 */
	public Project getByName(String proName);

	/**
	 * 分页列表
	 */
	public List<ProjectDto> queryByPage(@Param("page") int page,@Param("size") int size);

	/**
	 * 历史项目分页列表
	 */
	public List<ProjectDto> queryHisByPage(@Param("page") int page,@Param("size") int size);

	/**
	 * 数据总量
	 */
	public int count();

	/**
	 * 历史项目总量
	 */
	public int countByStatus();

	/**
	 * 按项目名查询总量
	 */
	public int countByName(String proName);
	/**
	 * 模糊查询
	 */
	public List<ProjectDto> queryByName(@Param("proName") String proName, @Param("page") int page,@Param("size") int size);

	/**
	 * 匹配查询
	 */
	public Project getById(Project project);
}
