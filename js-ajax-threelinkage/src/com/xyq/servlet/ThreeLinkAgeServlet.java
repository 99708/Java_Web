package com.xyq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyq.entity.Province;
import com.xyq.service.ThreeLinkAgeService;
import com.xyq.service.impl.ThreeLinkAgeServiceImpl;

public class ThreeLinkAgeServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//1、设置编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		
		//2、调用service层的方法获得省份的集合
		ThreeLinkAgeService threeLinkAgeService = new ThreeLinkAgeServiceImpl();
		List<Province> provinceList = threeLinkAgeService.findProvinceList();
		
		//3、响应数据，将数据存放到request作用域中
		req.setAttribute("provinceList", provinceList);
		
		//4、通过请求转发跳转到一个页面
		req.getRequestDispatcher("/threeLinkAge.jsp").forward(req, resp);
		
	}
}
