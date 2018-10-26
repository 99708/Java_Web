package com.xyq.dao;

import java.util.List;

import com.xyq.vo.DutyVo;

public interface DutyDao {
	/**
	 * 查询出勤情况
	 * @return
	 */
	public List<DutyVo> getDudyList();
}
