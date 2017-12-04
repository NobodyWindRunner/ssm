package com.zjr.service.impl;

import com.zjr.dao.UserDao;
import com.zjr.dto.UserDto;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zjr.entity.User;
import com.zjr.service.UserService;
import com.zjr.util.PageList;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;
	
	@Override
	public boolean add(User user) {
		// TODO Auto-generated method stub
		return dao.save(user);
	}

	@Override
	public boolean del(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}
	
	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return dao.update(user);
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public PageList<UserDto> queryByPage( int page,int size) {
		List<UserDto> list=dao.queryByPage((page-1)*size,size);
		// 防止获取到当前页面的数据为刚刚那条数据的那一页，而导致没有数据，这里做判断
		if (list.size() == 0 && page > 1) {
			// 返回上一页数据
			page = page - 1;
			list = dao.queryByPage((page-1)*size,size);
		}
		int count = dao.count();
		return new PageList<UserDto>(list, page, size, count);
	}
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}


	@Override
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		User user=dao.getByName(name);
		return user!=null;
	}

	@Override
	public PageList<UserDto> queryByName(String loginName, int page,int size) {
		List<UserDto> list=dao.queryByName(loginName,(page-1)*size,size);
		if(list.size()==0&&page>1){
			page=page-1;
			list=dao.queryByName(loginName,(page-1)*size,size);
		}
		int count=dao.countByName(loginName);
		return new PageList<UserDto>(list, page, size, count);
	}

	@Override
	public Set<String> queryRolesByName(String loginName){
		return dao.queryRolesByName(loginName);
	}

	@Override
	public User queryUserByName(String loginName) {
		return dao.queryUserByName(loginName);
	}
}
