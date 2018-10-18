package com.xyq.dao.impl;

import java.util.List;

import com.xyq.dao.EmpDao;
import com.xyq.entity.Emp;
import com.xyq.util.DBUtil;

public class EmpDaoImpl implements EmpDao {

	@Override
	public int getCount() {
		String sql = "select count(*) from t_emp";
		return DBUtil.getCount(sql);
	}

	@Override
	public List<Emp> getEmpList(int startRow, int pageSize) {
		String sql = "select * from t_emp limit ?, ?";
		return DBUtil.executeSelect(sql, new Emp(), startRow, pageSize);
	}

}
