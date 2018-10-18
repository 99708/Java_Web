package com.xyq.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		//1、对登陆界面和对登陆处理的Servlet放行
		//1.1、进行强转
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		//1.2、获取session对象
		HttpSession session = req.getSession();
		Object obj = session.getAttribute("user");
		//1.3、获取请求的URi
		String uri = req.getRequestURI();
		if(uri.indexOf("login.jsp") >= 0 || uri.indexOf("loginServlet.xyq") >= 0 || obj != null){
			chain.doFilter(request, response);
		}else{
			//如果是非法登陆，跳转到登陆界面
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
		}
	}

	@Override
	public void destroy() {
		
	}

}
