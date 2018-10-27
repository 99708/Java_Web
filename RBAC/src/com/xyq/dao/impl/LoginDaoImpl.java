package com.xyq.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xyq.dao.LoginDao;
import com.xyq.entity.Emp;
import com.xyq.entity.Menu;
import com.xyq.util.DBUtil;

public class LoginDaoImpl implements LoginDao {

	@Override
	public Emp getEmp(String empid, String pwd) {
		String sql = "select * from t_user where empid = ? and password = ?";
		//1、获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Emp emp = null;
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, empid);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while(rs.next()){
				
				int rid = rs.getInt("rid");
				String empid2 = rs.getString("empid");
				String pwd2 = rs.getString("password");
				
				emp = new Emp(empid2, pwd2, rid);
			}
			return emp;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtil.closeAll(connection, ps, rs);
		}
		return null;
	}

	@Override
	public List<Menu> getMenu(int rid, int pid) {
		String sql = "select * from t_menu tm  "
					+" inner join t_role_menu trm "
					+" on tm.mid = trm.mid  "
					+" inner join t_role r "
					+" on r.rid = trm.rid  "
					+" where r.rid = ? and tm.pid = ? ";
		//1、获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Menu> menuList = new ArrayList<Menu>();
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, rid);
			ps.setInt(2, pid);
			rs = ps.executeQuery();
			while(rs.next()){
				
				int mid = rs.getInt("mid");
				String mname = rs.getString("mname");
				String murl = rs.getString("murl");
				Menu menu = new Menu(mid, mname, murl);
				menuList.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtil.closeAll(connection, ps, rs);
		}
		return menuList;
	}

}
