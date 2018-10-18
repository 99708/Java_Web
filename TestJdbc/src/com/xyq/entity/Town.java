package com.xyq.entity;

public class Town {
	private Integer id;
	private String name;
	private String code;
	private String city_code;
	
	public String getCity_code() {
		return city_code;
	}
	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}
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
	public Town(Integer id, String name, String code) {
		this.id = id;
		this.name = name;
		this.code = code;
	}
	public Town(String name, String code) {
		this.name = name;
		this.code = code;
	}
	public Town() {
	}
	@Override
	public String toString() {
		return "Town [id=" + id + ", name=" + name + ", code=" + code
				+ ", city_code=" + city_code + "]";
	}
	
}
