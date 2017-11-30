package com.zjr.service;

import com.zjr.dto.ProjectDto;
import com.zjr.dto.UserDto;
import com.zjr.entity.Project;
import com.zjr.util.PageList;


public interface ProjectService {

	/**
	 * 增
	 */
	boolean add(Project project);

	/**
	 * 删(根据id)
	 */
	boolean del(int id);

	/**
	 * 改
	 */
	boolean update(Project project);

	/**
	 * 查
	 */
	Project get(int id);

	/**
	 * 列
	 */
	PageList<ProjectDto> queryByPage(int page,int size);

	/**
	 * 旧列
	 */
	PageList<ProjectDto>queryHisByPage(int page,int size);
	/**
	 * 计
	 */
	int count();

	/**
	 * 重
	 */
	boolean checkName(String proName);

	/**
	 *模糊列
	 */
	PageList<ProjectDto> queryByName(String proName, int page, int size);
}
