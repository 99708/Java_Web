package com.xyq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1、获取请求数据
		String uname = req.getParameter("uname");
		//2、获得session对象
		HttpSession session = req.getSession();
		//如果登陆成功将用户信息保存到session中
		if(!("".equals(uname))){
			session.setAttribute("user", uname);
			//响应成功登陆的界面
			req.getRequestDispatcher("/main.jsp").forward(req, resp);
		}else{
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}
		
	}
}
