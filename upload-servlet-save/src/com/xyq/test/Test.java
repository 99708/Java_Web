package com.xyq.test;

import java.sql.Connection;

import com.xyq.util.DBUtil;

public class Test {
	public static void main(String[] args) {
		Connection connection = DBUtil.getConnection();
		System.out.println(connection);
		String sql = "INSERT INTO t_upload ("
						+ " uname, pwd, real_name, save_file_name, "
						+ "file_type, file_date ) "
					+ "VALUES ("
						+ " 'admin', '123', '1.jpg', 'jlsfdj_1.jpg', 'jpeg', "
						+ "'2018-10-12' )";
		int n = DBUtil.executeDML(sql);
		System.out.println(n);
	}
}
