package com.xyq.test;

import java.sql.Connection;

import com.xyq.util.DBUtil;

public class Test {
	public static void main(String[] args) {
		Connection connection = DBUtil.getConnection();
		System.out.println(connection);
	}
}
