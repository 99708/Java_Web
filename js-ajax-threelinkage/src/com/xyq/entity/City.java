package com.xyq.entity;

public class City {
	private Integer id;
	private String name;
	private String code;
	private String province_code;
	
	public City(Integer id, String name, String code, String province_code) {
		this.id = id;
		this.name = name;
		this.code = code;
		this.province_code = province_code;
	}

	public City() {
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

	public String getProvince_code() {
		return province_code;
	}

	public void setProvince_code(String province_code) {
		this.province_code = province_code;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", code=" + code
				+ ", province_code=" + province_code + "]";
	}
}
