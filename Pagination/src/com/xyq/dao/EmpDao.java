package com.xyq.dao;

import java.util.List;

import com.xyq.entity.Emp;

public interface EmpDao {

	int getCount();

	List<Emp> getEmpList(int startRow, int pageSize);

}
