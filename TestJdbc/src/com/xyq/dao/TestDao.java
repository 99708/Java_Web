package com.xyq.dao;

import java.util.ArrayList;

import com.xyq.entity.Town;
import com.xyq.util.DBUtil;

public class TestDao {
	public ArrayList<Town> execute(String cityCode) {
		String sql = "select * from t_town where code = ?";
		return DBUtil.executeSelect(sql, new Town(), cityCode);
	}

}
