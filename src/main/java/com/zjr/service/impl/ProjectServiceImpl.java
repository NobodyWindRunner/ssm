package com.zjr.service.impl;

import com.zjr.dao.ProjectDao;
import com.zjr.dto.ProjectDto;
import com.zjr.entity.Project;
import com.zjr.service.ProjectService;
import com.zjr.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao dao;
	
	@Override
	public boolean add(Project project) {
		// TODO Auto-generated method stub
		return dao.save(project);
	}

	@Override
	public boolean del(int id) {
		// TODO Auto-generated method stub
		return dao.delete(id);
	}
	
	@Override
	public boolean update(Project project) {
		// TODO Auto-generated method stub
		return dao.update(project);
	}

	@Override
	public Project get(int id) {
		// TODO Auto-generated method stub
		return dao.get(id);
	}

	@Override
	public PageList<ProjectDto> queryByPage( int page,int size) {
		List<ProjectDto> list=dao.queryByPage((page-1)*size,size);
		// 防止获取到当前页面的数据为刚刚那条数据的那一页，而导致没有数据，这里做判断
		if (list.size() == 0 && page > 1) {
			// 返回上一页数据
			page = page - 1;
			list = dao.queryByPage((page-1)*size,size);
		}
		int count = dao.count();
		return new PageList<ProjectDto>(list, page, 8, count);
	}

	@Override
	public PageList<ProjectDto> queryHisByPage( int page,int size) {
		List<ProjectDto> list=dao.queryHisByPage((page-1)*size,size);
		// 防止获取到当前页面的数据为刚刚那条数据的那一页，而导致没有数据，这里做判断
		if (list.size() == 0 && page > 1) {
			// 返回上一页数据
			page = page - 1;
			list = dao.queryHisByPage((page-1)*size,size);
		}
		int count = dao.countByStatus();
		return new PageList<ProjectDto>(list, page, 8, count);
	}
	
	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}


	@Override
	public boolean checkName(String proName) {
		// TODO Auto-generated method stub
		Project user=dao.getByName(proName);
		return user!=null;
	}

	@Override
	public PageList<ProjectDto> queryByName(String proName, int page,int size) {
		List<ProjectDto> list=dao.queryByName(proName,(page-1)*size,size);
		if(list.size()==0&&page>1){
			page=page-1;
			list=dao.queryByName(proName,(page-1)*size,size);
		}
		int count=dao.countByName(proName);
		return new PageList<ProjectDto>(list, page, 8, count);
	}
}
