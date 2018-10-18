package com.xyq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.xyq.entity.City;
import com.xyq.service.ThreeLinkAgeService;
import com.xyq.service.impl.ThreeLinkAgeServiceImpl;

public class CityServlet extends HttpServlet {
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
		resp.setContentType("text/json;setchar=utf-8");
		
		//2、获取请求数据
		String provinceCode = req.getParameter("provinceCode");
		
		//3、调用service层获取数据
		ThreeLinkAgeService threeLinkAgeService = new ThreeLinkAgeServiceImpl();
		List<City> cityList = threeLinkAgeService.findCityList(provinceCode);
		
		//4、将list转为json
		Gson gson = new Gson();
		String proJson = gson.toJson(cityList);
		
		//5、响应数据
		resp.getWriter().println(proJson);
	}
	
	
	
	
	
	
	
	
	
	

}
