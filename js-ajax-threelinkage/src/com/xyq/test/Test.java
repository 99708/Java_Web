package com.xyq.test;

import java.util.List;

import com.xyq.entity.Town;
import com.xyq.service.ThreeLinkAgeService;
import com.xyq.service.impl.ThreeLinkAgeServiceImpl;


public class Test {
	public static void main(String[] args) {
//		Connection connection = DBUtil.getConnection();
//		System.out.println(connection);
		ThreeLinkAgeService threeLinkAgeService = new ThreeLinkAgeServiceImpl();
		List<Town> townList = threeLinkAgeService.findTownList("620500");
		System.out.println(townList);
	}
}
