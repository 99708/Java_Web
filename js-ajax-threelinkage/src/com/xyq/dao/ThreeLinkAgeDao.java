package com.xyq.dao;

import java.util.List;

import com.xyq.entity.City;
import com.xyq.entity.Province;
import com.xyq.entity.Town;

public interface ThreeLinkAgeDao {
	List<Province> getProvinceList();
	List<City> getCityList(String provinceCode);
	List<Town> getTownList(String cityCode);
}
