package com.wudonglong.www.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wudonglong.www.po.Dragon;
import com.wudonglong.www.po.Tribe;
import com.wudonglong.www.util.DBUtil;



public class DragonDao {
	
	//���ݲ���ID��������Ϣ
	public List<Dragon> queryDragonByTribeID(Tribe tribe) {
		ResultSet rs = null;
		List<Dragon> dragons = new ArrayList<>();
		Dragon dragon = null;
		String sql = "select * from dragon where tribeid=?";
		Object[] params = {tribe.getId()};
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
	
	//��ѯ���е���
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
	
	
	//����ID�޸�����Ϣ
	public boolean updateDragonByID(Dragon dragon) {
		String sql = "update dragon set name=?,age=?,health=?,introduction=? where id=?";		
		Object[] params = {dragon.getName(),dragon.getAge(),dragon.getHealth(),dragon.getIntroduction(),dragon.getId()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//������
	public boolean addDragon(Dragon dragon) {
		String sql = "insert into dragon(name,introduction,age,health,tribeid) values(?,?,?,?,?) ";
		Object[] params = {dragon.getName(),dragon.getIntroduction(),dragon.getAge(),dragon.getHealth(),dragon.getTribeid()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//����IDɾ����
	public boolean deleteDragon(int id) {
		String sql="delete from dragon where id=?";
		Object[] params = {id};
		return DBUtil.executeUpdate(sql, params);
	}
	
}
