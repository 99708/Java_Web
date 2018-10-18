package com.xyq.dao.impl;

import java.util.List;

import com.xyq.dao.ThreeLinkAgeDao;
import com.xyq.entity.City;
import com.xyq.entity.Province;
import com.xyq.entity.Town;
import com.xyq.util.DBUtil;

public class ThreeLinkAgeDaoImpl implements ThreeLinkAgeDao {

	@Override
	public List<Province> getProvinceList() {
		String sql = "select * from t_province";
		return DBUtil.executeSelect(sql, new Province());
	}

	@Override
	public List<City> getCityList(String provinceCode) {
		String sql = "select * from t_city where province_code = ?";
		return DBUtil.executeSelect(sql, new City(), provinceCode);
	}

	@Override
	public List<Town> getTownList(String cityCode) {
		String sql = "select * from t_town where city_code = ?";
		return DBUtil.executeSelect(sql, new Town(), cityCode);
	}

}
