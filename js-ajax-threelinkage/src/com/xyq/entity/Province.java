package com.xyq.entity;

public class Province {
	private Integer id;
	private String name;
	private String code;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Province(Integer id, String name, String code) {
		this.id = id;
		this.name = name;
		this.code = code;
	}
	public Province(String name, String code) {
		this.name = name;
		this.code = code;
	}
	public Province() {
	}
	
	@Override
	public String toString() {
		return "Province [id=" + id + ", name=" + name + ", code="
				+ code + "]";
	}
	
}
