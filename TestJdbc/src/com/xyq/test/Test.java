package com.xyq.test;

import java.util.ArrayList;

import com.xyq.dao.TestDao;
import com.xyq.entity.Town;

public class Test {

	public static void main(String[] args) {
		TestDao testDao = new TestDao();
		ArrayList<Town> list = testDao.execute("620524");
		System.out.println(list);
	}
}
