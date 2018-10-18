package com.xyq.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class DBUtil {
	
	//连接参数
	private static String Driver;
	private static String Url;
	private static String UserName;
	private static String PassWord;
	
	static {
		//读取配置文件
		Properties p = new Properties();
		InputStream is = DBUtil.class.getResourceAsStream("/db.properties");
		try {
			//加载配置文件
			p.load(is);
			Driver = p.getProperty("Driver");
			Url = p.getProperty("Url");
			UserName = p.getProperty("UserName");
			PassWord = p.getProperty("PassWord");
			//加载驱动
			Class.forName(Driver);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	
	//获取连接
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(Url, UserName, PassWord);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	//关闭资源
	public static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//封装增删改
	public static int executeDML(String sql, Object...obj) {
		//jdbc变量
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			//获取连接
			conn = getConnection();
			//开启事务
			conn.setAutoCommit(false);
			//创建sql命令对象
			ps = conn.prepareStatement(sql);
			//给占位符赋值
			for(int i=0; i<obj.length; i++) {
				ps.setObject(i+1, obj[i]);
			}
			//执行sql
			int i = ps.executeUpdate();
			//返回
			if(i > 0) {
				conn.commit();
				return i;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			//关闭资源
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
}
