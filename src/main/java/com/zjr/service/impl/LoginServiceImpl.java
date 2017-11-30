package com.zjr.service.impl;

import com.zjr.dao.UserDao;
import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.zjr.entity.User;
import com.zjr.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserDao dao;
	
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		return dao.getById(user);
	}
}
