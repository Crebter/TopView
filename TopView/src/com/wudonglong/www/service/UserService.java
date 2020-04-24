package com.wudonglong.www.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wudonglong.www.dao.TribeDao;
import com.wudonglong.www.dao.UserDao;
import com.wudonglong.www.po.Tribe;
import com.wudonglong.www.po.User;
import com.wudonglong.www.util.DBUtil;

public class UserService {
	static UserDao userDao = new UserDao();
	static TribeDao tribeDao = new TribeDao();
	//查询用户总数量
	public int getTatalCount() {
		return userDao.getTatalCount();
	}
	
	public boolean updateUserBycard(User user) {
		return userDao.updateUserBycard(user);
	}
	
	
	public User login(User user) {
		return userDao.login(user);
	}
	
	public boolean addUser(User user) {
		if(userDao.isExist(user.getCard()) == true) {
			return false;
		}
		else {
			return userDao.addUser(user);
		}
	}
	
	public Tribe queryTribeByID(User user) {
		return tribeDao.queryTribeByID(user);
	}
	
	public List<User> queryDragonTrianer() {
		return userDao.queryDragonTrianer();
	}
	
	public boolean deleteUser(User user) {
		
		return userDao.deleteUser(user);
	}
	
	//分页查询用户
	public List<User> queryUserByPage(int currentPage, int pageSize) {
		return userDao.queryUserByPage(currentPage, pageSize);
	}
	
}
