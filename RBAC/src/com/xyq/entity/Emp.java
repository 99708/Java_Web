package com.xyq.entity;

public class Emp {
	private String empid;
	private String password;
	private int rid;
	public String getEmpid() {
		return empid;
	}
	public void setEmpid(String empid) {
		this.empid = empid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public Emp(String empid, String password, int rid) {
		super();
		this.empid = empid;
		this.password = password;
		this.rid = rid;
	}
	public Emp() {
		super();
	}
	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", password=" + password + ", rid="
				+ rid + "]";
	}
	
	
}
