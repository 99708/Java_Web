package com.xyq.entity;

public class Emp {
	
	private Integer empno;
	private String ename;
	private String job;
	
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public Emp(Integer empno, String ename, String job) {
		this.empno = empno;
		this.ename = ename;
		this.job = job;
	}
	public Emp() {
	}
	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", job=" + job
				+ "]";
	}
	
}

