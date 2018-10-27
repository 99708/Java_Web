package com.xyq.service.impl;

import java.util.List;

import com.xyq.dao.LoginDao;
import com.xyq.dao.impl.LoginDaoImpl;
import com.xyq.entity.Emp;
import com.xyq.entity.Menu;
import com.xyq.service.LoginService;

public class LoginServiceImpl implements LoginService {

	LoginDao loginDao = new LoginDaoImpl();
	
	@Override
	public Emp findEmp(String empid, String pwd) {
		return loginDao.getEmp(empid, pwd);
	}

	@Override
	public List<Menu> findMenu(int rid, int pid) {
		//得到一级菜单
		List<Menu> menus = loginDao.getMenu(rid, pid);
		//根据一级菜单获取二级菜单
		for(Menu m : menus){
			int mid = m.getMid();
			List<Menu> m2 = loginDao.getMenu(rid, mid);
			m.setNextmenu(m2);
		}
		return menus;
		
	}

}
