package com.zjr.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.zjr.dao.MenuDao;
import org.springframework.stereotype.Service;

import com.zjr.entity.MenuInfo;
import com.zjr.service.MenuInfoService;

@Service
public class MenuInfoServiceImpl implements MenuInfoService {

	

	@Resource
	private MenuDao dao;
	@Override
	public List<MenuInfo> query() {
		// TODO Auto-generated method stub
		return dao.query();
	}

}
