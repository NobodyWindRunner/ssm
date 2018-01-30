package com.zjr.dao;

import com.zjr.dto.UserDto;
import com.zjr.entity.User;
import com.zjr.util.PageList;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;


public interface UserDao {

	/**
	 * 添加用户
	 */
	public boolean save(User user);

	/**
	 * 删除用户
	 */
	public boolean delete(int id);

	/**
	 * 更新用户
	 */
	public boolean update(User user);

	/**
	 * 	根据ID获取用户
	 */
	public User get(int id);

	/**
	 * 	根据ID获取用户
	 */
	public User getByName(String loginName);

	/**
	 * 分页列表
	 */
	public List<UserDto> queryByPage( @Param("page")int page,@Param("size")int size);

	/**
	 * 数据总量
	 */
	public int count();

	/**
	 * 按姓名查询总量
	 */
	public int countByName(String loginName);
	/**
	 * 模糊查询
	 */
	public List<UserDto> queryByName(@Param("loginName")String loginName, @Param("page")int page,@Param("size")int size);

	/**
	 * 匹配查询
	 */
	public User getById(User user);

	public Set<String> queryRolesByName(String loginName);

	User queryUserByName(String loginName);
}
