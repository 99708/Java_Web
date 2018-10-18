package com.xyq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.xyq.entity.Town;
import com.xyq.service.ThreeLinkAgeService;
import com.xyq.service.impl.ThreeLinkAgeServiceImpl;

public class TownServlet extends HttpServlet {
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
		
		//2、获取请求信息
		String cityCode = req.getParameter("cityCode");
		//3、调用service层
		ThreeLinkAgeService threeLinkAgeService = new ThreeLinkAgeServiceImpl();
		List<Town> townList = threeLinkAgeService.findTownList(cityCode);
		//4、将list转为json
		Gson gson = new Gson();
		String townJson = gson.toJson(townList);
		//5、响应结果
		resp.getWriter().println(townJson);
		
	}

}









