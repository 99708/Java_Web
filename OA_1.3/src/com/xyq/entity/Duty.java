package com.xyq.entity;

import java.util.Date;

public class Duty {
	
	private int dtid;
	private String emprid;
	private Date dtdate;
	private String siginintime;
	private String siginouttime;
	
	public Duty() {
		super();
	}
	public Duty(int dtid, String emprid, Date dtdate, String siginintime,
			String siginouttime) {
		super();
		this.dtid = dtid;
		this.emprid = emprid;
		this.dtdate = dtdate;
		this.siginintime = siginintime;
		this.siginouttime = siginouttime;
	}
	public int getDtid() {
		return dtid;
	}
	public void setDtid(int dtid) {
		this.dtid = dtid;
	}
	public String getEmprid() {
		return emprid;
	}
	public void setEmprid(String emprid) {
		this.emprid = emprid;
	}
	public Date getDtdate() {
		return dtdate;
	}
	public void setDtdate(Date dtdate) {
		this.dtdate = dtdate;
	}
	public String getSiginintime() {
		return siginintime;
	}
	public void setSiginintime(String siginintime) {
		this.siginintime = siginintime;
	}
	public String getSiginouttime() {
		return siginouttime;
	}
	public void setSiginouttime(String siginouttime) {
		this.siginouttime = siginouttime;
	}
	
}
