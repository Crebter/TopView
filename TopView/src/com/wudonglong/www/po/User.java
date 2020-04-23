package com.wudonglong.www.po;

import java.io.Serializable;

public class User implements Serializable{
	private String userName;
	private String password;
	private String type;
	private int id;
	private int card;
	private int phone;
	public User() {
		
	}
	
	public User(int id) {
		this.id = id;
	}
	
	public User(int id,int phone,String userName,String password) {
		this.id = id;
		this.phone = phone;
		this.userName = userName;
		this.password = password;
	}
	
	public User(String userName, String password,int phone,int card) {
		this.userName = userName;
		this.password = password;
		this.phone = phone;
		this.card = card;
	}
	
	
	
	
	public User(String userName, String password, String type, int card, int phone) {
		this.userName = userName;
		this.password = password;
		this.type = type;
		this.card = card;
		this.phone = phone;
	}
	
	
	public User(String userName, String password,String type) {
		this.userName = userName;
		this.password = password;
		this.type = type;
	}
	
	
	public User( int id,String userName, String password, String type, int card, int phone) {
		this.userName = userName;
		this.password = password;
		this.type = type;
		this.id = id;
		this.card = card;
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCard() {
		return card;
	}
	public void setCard(int card) {
		this.card = card;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	
	
	
	
	
}
