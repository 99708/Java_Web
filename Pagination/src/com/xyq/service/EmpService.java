package com.xyq.service;

import java.util.List;

import com.xyq.entity.Emp;

public interface EmpService {

	int findCount();

	List<Emp> findEmpList(int startRow, int pageSize);

}
