package com.wudonglong.www.po;

import java.util.List;

//分页的帮助类
public class UserPage {
	
//	当前页currentPage
	private int currentPage;
	
//	页面大小pageSize
	private int pageSize;
	
//	当前页的数据集合
	private List<User> users;
	
//	总数据totalCount
	private int totalCount;
	
//	总页数 totalPage
	private int totalPage;

	
	
	public UserPage(){
	}
	
	public UserPage(int currentPage, int pageSize, List<User> users, int totalCount, int totalPage) {
	this.currentPage = currentPage;
	this.pageSize = pageSize;
	this.users = users;
	this.totalCount = totalCount;
	this.totalPage = totalPage;
	}
	

	
	
	
	/*
	 * 总页数 = 数据总数%页面大小 == 0 ？ 数据总数/页面大小 ： 数据总数/页面大小+1
	 * 
	 * 当调用数据总数的setTotalCount()和页面大小的setPageSize()以后，自动计算出总页数
	 * 
	 * 
	 * 一定要注意先后顺序！
	 */

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		this.totalPage = this.totalCount%this.pageSize == 0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;

	}



	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		return totalPage;
	}

//	public void setTotalPage(int totalPage) {
//		this.totalPage = totalPage;
//		
//		return totalPage = pageSize%pageSize == 0 ？ totalCount/pageSize ： pageSize/pageSize+1
//	}
//	
	
	
	
}
