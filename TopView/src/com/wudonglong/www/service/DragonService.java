package com.wudonglong.www.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wudonglong.www.dao.DragonDao;
import com.wudonglong.www.po.Dragon;
import com.wudonglong.www.po.Tribe;
import com.wudonglong.www.util.DBUtil;

public class DragonService {
	
	
	static DragonDao dragonDao = new DragonDao();
	
	//计算龙的总数
	public int getTatalCount() {
		return dragonDao.getTatalCount();
	}
	
	
	//增加龙
	public boolean addDragon(Dragon dragon) {
		return dragonDao.addDragon(dragon);
	}
	
	
	//根据部落ID查找龙信息(分页)
	public List<Dragon> queryDragonByTribeIDByPage(Tribe tribe,int currentPage,int pageSize) {
		return dragonDao.queryDragonByTribeIDByPage(tribe, currentPage, pageSize);
	}
	
	//根据ID修改龙
	public boolean updateDragonByID(Dragon dragon) {
		return dragonDao.updateDragonByID(dragon);
	}
	
	
	//查询所有的龙
	public List<Dragon> queryDragon() {
		return dragonDao.queryDragon();
	}
	
	//根据ID删除龙
	public boolean deleteDragon(int id) {
		return dragonDao.deleteDragon(id);
	}
	
	
	//分页查询龙
	public List<Dragon> queryDragonByPage(int currentPage,int pageSize) {
		return dragonDao.queryDragonByPage(currentPage, pageSize);
	}
	
	
	//计算驯龙高手管理的龙的总数
	public int getTotalTrainer(Tribe tribe) {
		return dragonDao.getTotalTrainer(tribe);	
	}
	
}	
