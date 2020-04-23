package com.wudonglong.www.po;

import java.io.Serializable;

public class Dragon implements Serializable{
	private int id;
	private String name;
	private String introduction;
	private int age;
	private String health;
	private int tribeid;
	public Dragon() {
	}
	
	
	public Dragon(int id,String name, String introduction, int age, String health) {
		this.id = id;
		this.name = name;
		this.introduction = introduction;
		this.age = age;
		this.health = health;
	}
	
	
	
	public Dragon(String name, String introduction, int age, String health,int tribeid) {
		this.name = name;
		this.introduction = introduction;
		this.age = age;
		this.health = health;
		this.tribeid = tribeid;
	}
	
	public Dragon(int id,String name, String introduction, int age, String health,int tribeid) {
		this.id = id;
		this.name = name;
		this.introduction = introduction;
		this.age = age;
		this.health = health;
		this.tribeid = tribeid;
	}
	
	

	
	
	
	public int getTribeid() {
		return tribeid;
	}




	public void setTribeid(int tribeid) {
		this.tribeid = tribeid;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHealth() {
		return health;
	}
	public void setHealth(String health) {
		this.health = health;
	}
	
	
	
	
}
