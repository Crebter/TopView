package com.wudonglong.www.po;

import java.util.List;

//��ҳ�İ�����
public class UserPage {
	
//	��ǰҳcurrentPage
	private int currentPage;
	
//	ҳ���СpageSize
	private int pageSize;
	
//	��ǰҳ�����ݼ���
	private List<User> users;
	
//	������totalCount
	private int totalCount;
	
//	��ҳ�� totalPage
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
	 * ��ҳ�� = ��������%ҳ���С == 0 �� ��������/ҳ���С �� ��������/ҳ���С+1
	 * 
	 * ����������������setTotalCount()��ҳ���С��setPageSize()�Ժ��Զ��������ҳ��
	 * 
	 * 
	 * һ��Ҫע���Ⱥ�˳��
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
//		return totalPage = pageSize%pageSize == 0 �� totalCount/pageSize �� pageSize/pageSize+1
//	}
//	
	
	
	
}
