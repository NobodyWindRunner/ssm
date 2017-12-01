package com.zjr.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zjr.dto.ProjectDto;
import com.zjr.util.Comm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zjr.entity.Project;
import com.zjr.service.ProjectService;
import com.zjr.util.PageList;


/**
 * 项目控制层
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	private ProjectService proService;

	@RequestMapping("new")
	public String data(HttpServletRequest req){
		return "project/proEdit";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add(Project project,HttpServletRequest req,HttpServletResponse rep) throws IOException{
		if(project.getProName()!=null&&project.getProName()!=""){
			proService.add(project);
			req.setAttribute("message", "添加编号为 "+project.getId()+" 项目成功！");
			return "project/proEdit";
		}
		req.setAttribute("message", "项目名称不能为空！");
		return "project/proEdit";
	}
	 
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(Project project,Integer page,HttpServletRequest req,HttpServletResponse rep) throws IOException{
		req.setAttribute("obj", project);
		if(project.getProName()!=null&&project.getProName()==""){
			req.setAttribute("message", "当前项目 编号"+project.getId()+"！项目名称不能为空！");
			return "project/proEdit";
		}
		proService.update(project);
		return list(page, req);
	}
	    
	@RequestMapping("list")
	public String list(Integer page, HttpServletRequest req){
		PageList<ProjectDto> data=proService.queryByPage(page==null?1:page, Comm.PAGE_SIZE);
		req.setAttribute("data", data);
		req.setAttribute("page", page);
		return "project/proList";
	}
	    
	@RequestMapping("hislist")
	public String hislist(Integer page, HttpServletRequest req){
		PageList<ProjectDto> data=proService.queryHisByPage(page==null?1:page,Comm.PAGE_SIZE);
		req.setAttribute("data", data);
		req.setAttribute("page", page);
		return "project/proHisList";
	}
	     
	@RequestMapping("del")
	public String del(Integer id,Integer page, HttpServletRequest req){
		proService.del(id);
		return list(page, req);
	}
	    
	@RequestMapping(value = "get", method = RequestMethod.GET)
	public String get(int id,Integer page,HttpServletRequest req,HttpServletResponse rep) throws IOException{
		Project project = proService.get(id);
		if(project.getId()==null){
			return list(page, req);
		}else{
			req.setAttribute("obj", project);
			req.setAttribute("page", page);
			req.setAttribute("message", "当前项目 编号"+project.getId());
			return "project/proEdit";
		}
	}
	    
	@ResponseBody
	@RequestMapping(value = "check",method = RequestMethod.GET)
	public String check(String proName, HttpServletRequest req){
		String str="success";
		if(proService.checkName(proName)){
			str="fail";
		}
		return str;
	}

	@RequestMapping(value = "like", method = RequestMethod.GET)
	public String like(String proName,Integer page,HttpServletRequest req,HttpServletResponse rep){
		PageList<ProjectDto> data=proService.queryByName(proName, page==null?1:page,Comm.PAGE_SIZE);
		req.setAttribute("data", data);
		req.setAttribute("page", page);
		return "project/proList";
	}
}
