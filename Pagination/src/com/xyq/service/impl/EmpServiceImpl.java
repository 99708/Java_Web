package com.xyq.service.impl;

import java.util.List;

import com.xyq.dao.EmpDao;
import com.xyq.dao.impl.EmpDaoImpl;
import com.xyq.entity.Emp;
import com.xyq.service.EmpService;

public class EmpServiceImpl implements EmpService {

	EmpDao empDao = new EmpDaoImpl();
	@Override
	public int findCount() {
		return empDao.getCount();
	}

	@Override
	public List<Emp> findEmpList(int startRow, int pageSize) {
		return empDao.getEmpList(startRow, pageSize);
	}

}
