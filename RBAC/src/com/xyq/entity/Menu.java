package com.xyq.entity;

import java.io.Serializable;
import java.util.List;

public class Menu implements Serializable{
	private static final long serialVersionUID = 1L;
	private int mid;
	private String mname;
	private String murl;
	private String mdesc;
	private int pid;
	
	private List<Menu> nextmenu;

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMurl() {
		return murl;
	}

	public void setMurl(String murl) {
		this.murl = murl;
	}

	public String getMdesc() {
		return mdesc;
	}

	public void setMdesc(String mdesc) {
		this.mdesc = mdesc;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public List<Menu> getNextmenu() {
		return nextmenu;
	}

	public void setNextmenu(List<Menu> nextmenu) {
		this.nextmenu = nextmenu;
	}

	public Menu(int mid, String mname, String murl, String mdesc, int pid,
			List<Menu> nextmenu) {
		super();
		this.mid = mid;
		this.mname = mname;
		this.murl = murl;
		this.mdesc = mdesc;
		this.pid = pid;
		this.nextmenu = nextmenu;
	}
	
	public Menu(int mid, String mname, String murl) {
		this.mid = mid;
		this.mname = mname;
		this.murl = murl;
	}

	public Menu() {
		super();
	}
	
	
}
