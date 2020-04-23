package com.wudonglong.www.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wudonglong.www.po.Tribe;
import com.wudonglong.www.po.User;
import com.wudonglong.www.util.DBUtil;

public class TribeDao {
	private final String url = "jdbc:mysql://localhost:3306/topview?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
	private final String username ="root";
	private final String userpwd = "wudonglong";
	
	
	
	//查询所有部落信息
	public List<Tribe> queryTribe() {
		ResultSet rs = null;
		List<Tribe> tribes = new ArrayList<>();
		Tribe tribe = null;
		String sql = "select * from tribe";
		
		rs = DBUtil.excuteQuery(sql, null);
		
		try {
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String introduction = rs.getString("introduction");
				String area = rs.getString("area");
				String address = rs.getString("address");
				tribe = new Tribe(id,name,introduction,area,address);
				tribes.add(tribe);
			}
			return tribes;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.con);
		}
	}
	
	
	
	//查询单个部落
	public Tribe queryTribeByID(User user) {
		ResultSet rs = null;
		Tribe tribe = null;
		String sql = "select * from tribe where id=?";
		Object[] params = {user.getId()};
		rs = DBUtil.excuteQuery(sql, params);
		try {
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String introduction = rs.getString("introduction");
				String area = rs.getString("area");
				String address = rs.getString("address");

				tribe = new Tribe(id,name,introduction,area,address);
			}
			return tribe;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.con);
		}
	}
	
	
	//根据部落ID修改部落信息
	public boolean updateTribeByID(Tribe tribe) {
		String sql = "update tribe set name=?,introduction=?,area=?,address=? where id=?";		
		Object[] params = {tribe.getName(),tribe.getIntroduction(),tribe.getArea(),tribe.getAddress(),tribe.getId()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	
	//增加部落
	public boolean addTribe(Tribe tribe) {
		//int id,String name, String introduction, String area, String address
		String sql = "insert into tribe(id,name,introduction,area,address) values(?,?,?,?,?) ";
		Object[] params = {tribe.getId(),tribe.getName(),tribe.getIntroduction(),tribe.getArea(),tribe.getAddress()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//根据ID删除部落
	public boolean deleteTribe(Tribe tribe) {
		String sql = "delete from tribe where id = ?";
		Object[] params = {tribe.getId()};
		return DBUtil.executeUpdate(sql, params);
	}
}
