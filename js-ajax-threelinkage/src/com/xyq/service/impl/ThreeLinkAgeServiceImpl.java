package com.xyq.service.impl;

import java.util.List;

import com.xyq.dao.ThreeLinkAgeDao;
import com.xyq.dao.impl.ThreeLinkAgeDaoImpl;
import com.xyq.entity.City;
import com.xyq.entity.Province;
import com.xyq.entity.Town;
import com.xyq.service.ThreeLinkAgeService;

public class ThreeLinkAgeServiceImpl implements ThreeLinkAgeService{
	
	ThreeLinkAgeDao threeLinkAgeDao = new ThreeLinkAgeDaoImpl();
	
	@Override
	public List<Province> findProvinceList() {
		
		return threeLinkAgeDao.getProvinceList();
	}

	@Override
	public List<City> findCityList(String provinceCode) {
		return threeLinkAgeDao.getCityList(provinceCode);
	}

	@Override
	public List<Town> findTownList(String cityCode) {
		return threeLinkAgeDao.getTownList(cityCode);
	}

}
