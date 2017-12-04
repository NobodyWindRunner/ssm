package com.zjr.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zjr.service.UserService;
import com.zjr.util.Comm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zjr.entity.MenuInfo;
import com.zjr.entity.User;
import com.zjr.service.LoginService;
import com.zjr.service.MenuInfoService;


/**
 * 菜单控制层
 */
@Controller
public class IndexMenuController{

	private static final Logger logger = LoggerFactory.getLogger(IndexMenuController.class);

	@Resource
    private MenuInfoService service;
//	@Resource
//	private LoginService loginService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="menu",method = RequestMethod.POST)
	public String addMenu(HttpServletRequest req){
		//查询所有菜单
		List<MenuInfo> list=service.query();
		//设置属性将遍历到的集合传到首页
		req.setAttribute("menus", list);
		return "index";
	}

	@RequestMapping(value = "login")
	public String index(HttpServletRequest req){
		//登录页
		return "login";
	}

	@RequestMapping(value = "logout")
	public String logout(HttpServletRequest req, HttpServletResponse rep,HttpSession session) throws IOException, IOException {
		session = req.getSession(false);
		if(session!=null){
			session.removeAttribute(Comm.USER_SESSION_NAME);
		}
		return "login";
	}

//	@RequestMapping(value = "index")
//    public String login(User user,HttpServletRequest req,HttpSession session)throws IOException{
//    	if(user.getId()==null&&user.getPassword()==null){
//			req.setAttribute("message", "请输入用户名跟密码");
//    	}else if(user.getId()==null){
//			req.setAttribute("message", "用户名不能为空");
//    	}else if(user.getPassword()==null){
//			req.setAttribute("message", "密码不能为空");
//    		return "login";
//    	}else{
//    		User logUser =loginService.login(user);
//    		if(logUser!=null &&logUser.getPassword().equals(user.getPassword())){
//				session.setAttribute(Comm.USER_SESSION_NAME, logUser);
//				this.addMenu(req);
//				return "index";
//			}
//			req.setAttribute("message", "用户名或密码错误");
//    	}
//    	return "login";
//    }
	@RequestMapping(value = "index")
	public String login(User user,Model model,HttpServletRequest req,HttpSession session)throws IOException{
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getLoginName(),user.getPassword());
		try {
			subject.login(usernamePasswordToken);
			session.setAttribute(Comm.USER_SESSION_NAME,user);
			this.addMenu(req);
			return "index";
		} catch (Exception e) {
			req.setAttribute("message", "用户名或密码错误");
			e.printStackTrace();
			return "login";
		}
	}
}
