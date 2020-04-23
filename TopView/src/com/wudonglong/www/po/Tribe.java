package com.wudonglong.www.po;

import java.io.Serializable;

public class Tribe implements Serializable{
	private String name;
	private String introduction;
	private String area;
	private String address;
	private int id;
	public Tribe() {
	}
	
	public Tribe(int id) {
		this.id = id;
	}
	
	
	
	public Tribe(String name, String introduction, String area, String address) {
		this.name = name;
		this.introduction = introduction;
		this.area = area;
		this.address = address;
	}
	
	public Tribe(int id,String name, String introduction, String area, String address) {
		this.id = id;
		this.name = name;
		this.introduction = introduction;
		this.area = area;
		this.address = address;
	}
	
	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getArea() {
		return area;
	}




	public void setArea(String area) {
		this.area = area;
	}




	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
