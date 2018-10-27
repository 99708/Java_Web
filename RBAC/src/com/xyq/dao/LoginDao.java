package com.xyq.dao;

import java.util.List;

import com.xyq.entity.Emp;
import com.xyq.entity.Menu;

public interface LoginDao {
	/**
	 * 登陆处理
	 * @param empid
	 * @param pwd
	 * @return
	 */
	public Emp getEmp(String empid, String pwd);
	
	/**
	 * 菜单处理
	 * @param rid
	 * @param pid
	 * @return
	 */
	
	public List<Menu> getMenu(int rid, int pid);
}
