package com.zjr.service.impl;

import com.zjr.dao.DepartmentDao;
import com.zjr.dto.DepartmentDto;
import com.zjr.entity.Department;
import com.zjr.service.DepartmentService;
import com.zjr.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentDao dao;
	
	@Override
	public boolean add(Department department) {
		// TODO Auto-generated method stub
		return dao.save(department);
	}

	@Override
	public boolean del(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}
	
	@Override
	public boolean update(Department department) {
		// TODO Auto-generated method stub
		return dao.update(department);
	}

	@Override
	public Department getById(int id) {
		// TODO Auto-generated method stub
		return dao.getById(id);
	}

	@Override
	public Department getByName(String name) {
		// TODO Auto-generated method stub
		return dao.getByName(name);
	}

	@Override
	public List<Department> queryAll(){
		return dao.queryAll();
	}

	@Override
	public PageList<DepartmentDto> queryByPage( int page,int size) {
		List<DepartmentDto> list=dao.queryByPage((page-1)*size,size);
		// 防止获取到当前页面的数据为刚刚那条数据的那一页，而导致没有数据，这里做判断
		if (list.size() == 0 && page > 1) {
			// 返回上一页数据
			page = page - 1;
			list = dao.queryByPage((page-1)*size,size);
		}
		int count = dao.count();
		return new PageList<DepartmentDto>(list, page, size, count);
	}
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}


	@Override
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		Department department=dao.getByName(name);
		return department!=null;
	}

	@Override
	public PageList<DepartmentDto> queryByName(String name, int page,int size) {
		List<DepartmentDto> list=dao.queryByName(name,(page-1)*size,size);
		if(list.size()==0&&page>1){
			page=page-1;
			list=dao.queryByName(name,(page-1)*size,size);
		}
		int count=dao.countByName(name);
		return new PageList<DepartmentDto>(list, page, size, count);
	}
}
