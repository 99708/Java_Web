package com.xyq.service;

import java.util.List;

import com.xyq.vo.DutyVo;

public interface DutyService {
	/**
	 * 查询出勤情况
	 * @return
	 */
	public List<DutyVo> getDudyList();
}
