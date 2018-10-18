package com.xyq.test;

import java.sql.Connection;
import java.util.ArrayList;

import com.xyq.entity.Emp;
import com.xyq.util.DBUtil;

public class Test {
	public static void main(String[] args) {
		/*Connection connection = DBUtil.getConnection();
		System.out.println(connection);
		String sql = "select count(*) from t_emp";
		int count = DBUtil.getCount(sql);
		System.out.println(count);*/
		String sql = "select * from t_emp limit ?, ?";
		ArrayList<Emp> executeSelect = DBUtil.executeSelect(sql, new Emp(), 0, 10);
		System.out.println(executeSelect.size());
	}
}
