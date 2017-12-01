package com.zjr.service.impl;

import com.zjr.dao.EmployeeDao;
import com.zjr.dto.EmployeeDto;
import com.zjr.entity.Employee;
import com.zjr.service.EmployeeService;
import com.zjr.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao dao;
	
	@Override
	public boolean add(Employee employee) {
		// TODO Auto-generated method stub
		return dao.save(employee);
	}

	@Override
	public boolean del(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}
	
	@Override
	public boolean update(Employee employee) {
		// TODO Auto-generated method stub
		return dao.update(employee);
	}

	@Override
	public Employee get(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public PageList<EmployeeDto> queryByPage( int page,int size) {
		List<EmployeeDto> list=dao.queryByPage((page-1)*size,size);
		// 防止获取到当前页面的数据为刚刚那条数据的那一页，而导致没有数据，这里做判断
		if (list.size() == 0 && page > 1) {
			// 返回上一页数据
			page = page - 1;
			list = dao.queryByPage((page-1)*size,size);
		}
		int count = dao.count();
		return new PageList<EmployeeDto>(list, page, size, count);
	}
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}


	@Override
	public PageList<EmployeeDto> queryByName(String name, int page,int size) {
		List<EmployeeDto> list=dao.queryByName(name,(page-1)*size,size);
		if(list.size()==0&&page>1){
			page=page-1;
			list=dao.queryByName(name,(page-1)*size,size);
		}
		int count=dao.countByName(name);
		return new PageList<EmployeeDto>(list, page, size, count);
	}
}
