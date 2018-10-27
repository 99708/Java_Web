package com.xyq.service;

import java.util.List;

import com.xyq.entity.Emp;
import com.xyq.entity.Menu;

public interface LoginService {
	/**
	 * 登陆处理
	 * @param empid
	 * @param pwd
	 * @return
	 */
	public Emp findEmp(String empid, String pwd);
	/**
	 * 菜单处理
	 * @param rid
	 * @param pid
	 * @return
	 */
	public List<Menu> findMenu(int rid, int pid);
}
