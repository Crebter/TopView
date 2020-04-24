package com.wudonglong.www.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wudonglong.www.po.Dragon;
import com.wudonglong.www.po.Tribe;
import com.wudonglong.www.util.DBUtil;



public class DragonDao {
	
	//计算驯龙高手管理的龙的总数
	public int getTotalTrainer(Tribe tribe) {
		ResultSet rs = null;
		String sql = "select * from dragon where tribeid=?";
		Object[] params = {tribe.getId()};
		int count = 0;
		rs = DBUtil.excuteQuery(sql, params);
		try {
			while(rs.next()) {
				count++;
			}
			return count;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.con);
		}
	}
	
	
	//计算龙的总数
	public int getTatalCount() {
		String sql = "select * from dragon";
		return DBUtil.getTatalCount(sql);
	}
	
	
	//根据部落ID查找龙信息
	public List<Dragon> queryDragonByTribeIDByPage(Tribe tribe,int currentPage,int pageSize) {
		ResultSet rs = null;
		List<Dragon> dragons = new ArrayList<>();
		Dragon dragon = null;
		String sql = "select * from dragon where tribeid=? limit ?,?";
		Object[] params = {tribe.getId(),(currentPage-1)*pageSize,pageSize};
		rs = DBUtil.excuteQuery(sql, params);
		try {
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String introduction = rs.getString("introduction");
				int age = rs.getInt("age");
				String health = rs.getString("health");
				int tribeid = rs.getInt("tribeid");
				dragon = new Dragon(id,name,introduction,age,health,tribeid);
				dragons.add(dragon);
			}
			return dragons;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.con);
		}
	}
	
	//查询所有的龙
	public List<Dragon> queryDragon() {
		ResultSet rs = null;
		List<Dragon> dragons = new ArrayList<>();
		Dragon dragon = null;
		String sql = "select * from dragon ";
		rs = DBUtil.excuteQuery(sql, null);
		try {
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String introduction = rs.getString("introduction");
				int age = rs.getInt("age");
				String health = rs.getString("health");
				int tribeid = rs.getInt("tribeid");
				dragon = new Dragon(id,name,introduction,age,health,tribeid);
				dragons.add(dragon);
			}
			return dragons;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.con);
		}
	}
	
	//分页查询龙
	public List<Dragon> queryDragonByPage(int currentPage,int pageSize) {
		ResultSet rs = null;
		List<Dragon> dragons = new ArrayList<>();
		Dragon dragon = null;
		String sql = "select * from dragon limit ?,? ";
		
		Object[] params = {(currentPage-1)*pageSize,pageSize};
		rs = DBUtil.excuteQuery(sql, params);
		try {
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String introduction = rs.getString("introduction");
				int age = rs.getInt("age");
				String health = rs.getString("health");
				int tribeid = rs.getInt("tribeid");
				dragon = new Dragon(id,name,introduction,age,health,tribeid);
				dragons.add(dragon);
			}
			return dragons;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.con);
		}
	}
	
	
	
	
	//根据ID修改龙信息
	public boolean updateDragonByID(Dragon dragon) {
		String sql = "update dragon set name=?,age=?,health=?,introduction=? where id=?";		
		Object[] params = {dragon.getName(),dragon.getAge(),dragon.getHealth(),dragon.getIntroduction(),dragon.getId()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//增加龙
	public boolean addDragon(Dragon dragon) {
		String sql = "insert into dragon(name,introduction,age,health,tribeid) values(?,?,?,?,?) ";
		Object[] params = {dragon.getName(),dragon.getIntroduction(),dragon.getAge(),dragon.getHealth(),dragon.getTribeid()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//根据ID删除龙
	public boolean deleteDragon(int id) {
		String sql="delete from dragon where id=?";
		Object[] params = {id};
		return DBUtil.executeUpdate(sql, params);
	}
	
}
