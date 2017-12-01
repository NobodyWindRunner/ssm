package com.zjr.controller;

import com.zjr.dto.DepartmentDto;
import com.zjr.entity.Department;
import com.zjr.service.DepartmentService;
import com.zjr.util.Comm;
import com.zjr.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 用户控制层
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("new")
	public String data(HttpServletRequest req){
		return "department/depEdit";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Department department,HttpServletRequest req,HttpServletResponse rep) throws IOException{
		if(department.getName()!=null&&department.getName()!=""){
			departmentService.add(department);
			req.setAttribute("message", "添加编号为 "+department.getId()+" 部门成功！");
			return "department/depEdit";
		}
		req.setAttribute("message", "部门名不能为空！");
		return "department/depEdit";
	}
	 
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(Department department,Integer page,HttpServletRequest req,HttpServletResponse rep) throws IOException{
		req.setAttribute("obj", department);
		if(department.getName()!=null&&department.getName()==""){
			req.setAttribute("message", "当前部门 编号+"+department.getId()+"！部门名不能为空！");
			return "department/depEdit";
		}
		departmentService.update(department);
		return list(page, req);
	}
	    
	@RequestMapping("list")
	public String list(Integer page, HttpServletRequest req){
		PageList<DepartmentDto> data=departmentService.queryByPage(page==null?1:page,Comm.PAGE_SIZE);
		req.setAttribute("data", data);
		req.setAttribute("page", page);
		return "department/depList";
	}
	    
	@RequestMapping("del")
	public String del(Integer id,Integer page, HttpServletRequest req){
		departmentService.del(id);
		return list(page, req);
	}
	    
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public String get(int id,Integer page,HttpServletRequest req,HttpServletResponse rep) throws IOException{
		Department department = departmentService.getById(id);
		if(department.getId()==null){
			return list(page, req);
		}else{
			req.setAttribute("obj", department);
			req.setAttribute("page", page);
			req.setAttribute("message", "当前部门 编号"+department.getId()+"！");
			return "department/depEdit";
		}
	}

	@ResponseBody
	@RequestMapping(value = "check",method = RequestMethod.GET)
	public String check(String name, HttpServletRequest req){
		String str="success";
		if(departmentService.checkName(name)){
			str="fail";
		}
		return str;
	}

	@RequestMapping(value = "like", method = RequestMethod.GET)
	public String like(String name,Integer page,HttpServletRequest req,HttpServletResponse rep){
		PageList<DepartmentDto> data=departmentService.queryByName(name, page==null?1:page, Comm.PAGE_SIZE);
		req.setAttribute("data", data);
		req.setAttribute("page", page);
		return "department/depList";
	}
}
