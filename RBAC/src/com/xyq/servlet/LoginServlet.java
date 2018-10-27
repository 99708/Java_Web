package com.xyq.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xyq.entity.Emp;
import com.xyq.entity.Menu;
import com.xyq.service.LoginService;
import com.xyq.service.impl.LoginServiceImpl;


public class LoginServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	public void findEmp(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//设置编码格式
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		//获取请求数据
		String uname = req.getParameter("uname");
		String password = req.getParameter("password");
		//调用service层方法
		LoginService loginService = new LoginServiceImpl();
		Emp emp = loginService.findEmp(uname, password);
		List<Menu> menuList = null;
		if(emp != null){ //如果用户正常登陆，查询菜单
			int rid = emp.getRid();
			menuList = loginService.findMenu(rid, 0);
		}
		//响应结果
		HttpSession session = req.getSession();
		session.setAttribute("emp", emp);
		session.setAttribute("menuList", menuList);
		resp.sendRedirect(req.getContextPath()+"/system/main.jsp");
		
	}

}
