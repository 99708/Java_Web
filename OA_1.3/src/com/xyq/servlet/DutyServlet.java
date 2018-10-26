package com.xyq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.xyq.service.DutyService;
import com.xyq.service.impl.DutyServiceImpl;
import com.xyq.vo.DutyVo;


public class DutyServlet extends BaseServlet {

	private static final long serialVersionUID = 1L;
	
	/**
	 * 查询员工的签到状态
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	public void findDutyList(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		//调用Service层的方法
		DutyService dutyService = new DutyServiceImpl();
		List<DutyVo> dutyVoList = dutyService.getDudyList();
		//转发到dutyList.jsp界面
		req.setAttribute("dutyVoList", dutyVoList);
		req.getRequestDispatcher("/duty/dutyList.jsp").forward(req, resp);
	}
}
