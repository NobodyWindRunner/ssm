package com.zjr.controller;

import com.zjr.dto.EmployeeDto;
import com.zjr.entity.Department;
import com.zjr.entity.Employee;
import com.zjr.service.DepartmentService;
import com.zjr.service.EmployeeService;
import com.zjr.util.Comm;
import com.zjr.util.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * 用户控制层
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DepartmentService departmentService;

	@RequestMapping("new")
	public String data(HttpServletRequest req){
		req.setAttribute("depList", departmentService.queryAll());
		return "employee/empEdit";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Employee employee,HttpServletRequest req,HttpServletResponse rep) throws IOException{
		//所有情况都需要预先载入该下拉列表
		req.setAttribute("depList", departmentService.queryAll());
		if(employee.getName()!=null&&employee.getName()!=""){
			if(employee.getDeptId()!=null){
				employeeService.add(employee);
				req.setAttribute("message", "添加编号为 "+employee.getId()+" 员工成功！");
				return "employee/empEdit";
			}
			req.setAttribute("message","请选择部门！");
			return "employee/empEdit";
		}
		req.setAttribute("message", "员工名不能为空！");
		return "employee/empEdit";
	}
	 
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(Employee employee,Integer page,HttpServletRequest req,HttpServletResponse rep) throws IOException {
		//所有情况都需要预先载入该下拉列表
		req.setAttribute("depList", departmentService.queryAll());
		req.setAttribute("obj", employee);
		if (employee.getName() != null && employee.getName() != "") {
			if (employee.getDeptId() != null) {
				employeeService.update(employee);
				return list(page, req);
			}
			req.setAttribute("message", "请选择部门！");
			return "employee/empEdit";
		}
		req.setAttribute("message", "当前员工 编号+" + employee.getId() + "！员工名不能为空！");
		return "employee/empEdit";
	}
	    
	@RequestMapping("list")
	public String list(Integer page, HttpServletRequest req){
		//所有情况都需要预先载入该下拉列表
		req.setAttribute("depList", departmentService.queryAll());
		PageList<EmployeeDto> data=employeeService.queryByPage(page==null?1:page,Comm.PAGE_SIZE);
		req.setAttribute("data", data);
		req.setAttribute("page", page);
		return "employee/empList";
	}
	    
	@RequestMapping("del")
	public String del(Integer id,Integer page, HttpServletRequest req){
		employeeService.del(id);
		return list(page, req);
	}
	    
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public String get(int id,Integer page,HttpServletRequest req,HttpServletResponse rep) throws IOException{
		//所有情况都需要预先载入该下拉列表
		List<Department> depList =departmentService.queryAll();
		req.setAttribute("depList", depList);
		Employee employee = employeeService.get(id);
		if(employee.getId()==null){
			return list(page, req);
		}else{
			req.setAttribute("obj", employee);
			req.setAttribute("page", page);
			req.setAttribute("message", "当前员工 编号"+employee.getId()+"！");
			return "employee/empEdit";
		}
	}

	@RequestMapping(value = "like", method = RequestMethod.GET)
	public String like(String name,Integer page,HttpServletRequest req,HttpServletResponse rep){
		PageList<EmployeeDto> data=employeeService.queryByName(name, page==null?1:page, Comm.PAGE_SIZE);
		req.setAttribute("data", data);
		req.setAttribute("page", page);
		return "employee/empList";
	}
}
