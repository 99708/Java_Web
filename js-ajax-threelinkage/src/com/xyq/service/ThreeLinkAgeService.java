package com.xyq.service;

import java.util.List;

import com.xyq.entity.City;
import com.xyq.entity.Province;
import com.xyq.entity.Town;

public interface ThreeLinkAgeService {
	List<Province> findProvinceList();
	List<City> findCityList(String provinceCode);
	List<Town> findTownList(String cityCode);
}
