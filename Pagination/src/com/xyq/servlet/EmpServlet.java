package com.xyq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xyq.entity.Emp;
import com.xyq.service.EmpService;
import com.xyq.service.impl.EmpServiceImpl;
import com.xyq.util.PageUtil;

public class EmpServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//1、设置编码
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		int currentPage1 = 1;
		//2、获取请求数据
		String currentPage = req.getParameter("currentPage");
		if(currentPage != null && !"".equals(currentPage)){
			currentPage1 = Integer.valueOf(currentPage);
		}
		
		//3、处理请求数据
			//3.1查询总的记录数
			EmpService empService = new EmpServiceImpl();
			int count = empService.findCount();
			int pageSize = 10;
			int navigationNumber = 10;
			PageUtil pageUtil = new PageUtil(count, pageSize, currentPage1, navigationNumber);
			//3.2、进行分页查询
			List<Emp> empList = empService.findEmpList(pageUtil.getStartRow(), pageUtil.getPageSize());
			pageUtil.setPageData(empList);
		//4、响应请求
			//4.1、设置共享数据
			req.setAttribute("pageUtil", pageUtil);
			//4.2、请求转发到jsp
			req.getRequestDispatcher("/empList.jsp").forward(req, resp);
		
	}
}
