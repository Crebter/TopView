package com.wudonglong.www.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wudonglong.www.po.User;
import com.wudonglong.www.util.DBUtil;

//数据库访问层

//实现类
public class UserDao {
	

	public boolean isExist(int card) {
		return queryUserByID(card)==null?false:true;
	}


	//登陆验证
	public User login(User user) {
		ResultSet rs = null;
		User result = null;
	try {	
		String sql = "select * from User where username=? and password=?";
		Object[] params = {user.getUserName(),user.getPassword()};
		rs = DBUtil.excuteQuery(sql, params);
		if(rs.next()){
			int id = rs.getInt("id");
			String userName = rs.getString("username");
			String password = rs.getString("password");
			int card = rs.getInt("card");
			int phone = rs.getInt("phone");
			String type = rs.getString("type");
//			String userName, String password, String type, int card, int phone
			result = new User(id,userName,password,type,card,phone);
		}
		return result;
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	}finally {
		DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.con);
	}
		
		
		
		
		
		
		
	}	
//	public List<User> queryUserByPage(int currentPage, int pageSize) {
//		ResultSet rs = null;
//		List<User> user = new ArrayList<>();
//		User User = new User();
//		String sql = "select * from User limit ?,?";
//		
//		Object[] params = {(currentPage-1)*pageSize,pageSize};
//		rs = DBUtil.excuteQuery(sql, params);
//		
//		try {
//			while(rs.next()) {
//				int id = rs.getInt("id");
//				String sname = rs.getString("sname");
//				int sage = rs.getInt("sage");
//				String saddress = rs.getString("saddress");
////				User = new User(id,sname,sage,saddress);
//				Users.add(User);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return Users;
//	}
//	

	
	//增加用户
	public boolean addUser(User User) {
		String sql = "insert into User(username,password,type,id,card,phone) values(?,?,?,?,?,?) ";
		Object[] params = {User.getUserName(),User.getPassword(),User.getType(),User.getId(),User.getCard(),User.getPhone()};
		return DBUtil.executeUpdate(sql, params);
	}


	
	//根据card查找用户
	public User queryUserByID(int card) {
			User result = null;
			ResultSet rs = null;
		try {	
			String sql = "select * from User where card = ?";
			Object[] params = {card};
			rs = DBUtil.excuteQuery(sql, params);
			if(rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("username");
				String password = rs.getString("password");
				card = rs.getInt("card");
				int phone = rs.getInt("phone");
				String type = rs.getString("type");
//				id userName password type card phone
				result = new User(id,userName,password,type,card,phone);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.con);
		}
	}

	//根据学号修改用户
	public boolean updateUserBycard(User user) {
		String sql = "update User set username=?,password =? ,phone=? where card=?";
		Object[] params = {user.getUserName(),user.getPassword(),user.getPhone(),user.getCard()};
		return DBUtil.executeUpdate(sql, params);
	}

	//查找所有驯龙高手
	public List<User> queryDragonTrianer() {
			User user = null;
			List<User> results = new ArrayList<>();
			ResultSet rs = null;
		try {
			String sql = "select * from User where type = 'DragonTrainer' ";
			rs = DBUtil.excuteQuery(sql, null);
			while(rs.next()) {
				String type = rs.getString("type");
				String userName = rs.getString("username");
				String password = rs.getString("password");
				int id = rs.getInt("id");
				int card = rs.getInt("card");
				int phone = rs.getInt("phone");
	//			id userName password type card phone
				user = new User(id,userName,password,type,card,phone);
				results.add(user);
			}
			return results;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.con);
		}
	}

	
	//根据ID删除用户
	public boolean deleteUser(User user) {
		String sql="delete from User where id=?";
		Object[] params = {user.getId()};
		return DBUtil.executeUpdate(sql, params);
	}
	
}
