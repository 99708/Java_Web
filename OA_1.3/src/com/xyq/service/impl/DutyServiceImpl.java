package com.xyq.service.impl;

import java.util.List;

import com.xyq.dao.DutyDao;
import com.xyq.dao.impl.DutyDaoImpl;
import com.xyq.service.DutyService;
import com.xyq.vo.DutyVo;

public class DutyServiceImpl implements DutyService {
	
	DutyDao dutyDao = new DutyDaoImpl();
	
	@Override
	public List<DutyVo> getDudyList() {
		return dutyDao.getDudyList();
	}

}
