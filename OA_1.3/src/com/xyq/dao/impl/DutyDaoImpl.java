package com.xyq.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xyq.dao.DutyDao;
import com.xyq.util.DBUtil;
import com.xyq.vo.DutyVo;

public class DutyDaoImpl implements DutyDao {

	@Override
	public List<DutyVo> getDudyList() {
		String sql = "select "
				+ " emp.empid, emp.realname, d.deptname, dt.dtdate, dt.signintime, "
				+ "dt.signouttime "
				+ "from duty dt"
				+ " inner join employee emp   "
				+ " on dt.emprid = emp.empid  "
				+ " inner join dept d         "
				+ " on emp.deptno = d.deptno  "
				+ " order by dtid";           
		List<DutyVo> dutyVoList = new ArrayList<DutyVo>();
		//1、获取连接
		Connection connection = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				String empid = rs.getString("empid");
				String realname = rs.getString("realname");
				String deptname = rs.getString("deptname");
				String signintime = rs.getString("signintime");
				String signouttime = rs.getString("signouttime");
				
				Date dtdate = rs.getDate("dtdate");
				DutyVo dutyVo = new DutyVo(empid, realname, deptname, dtdate, signintime, signouttime);
				dutyVoList.add(dutyVo);
			}                                 
			return dutyVoList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//关闭资源
			DBUtil.closeAll(connection, ps, rs);
		}
		return null;
	}

}
