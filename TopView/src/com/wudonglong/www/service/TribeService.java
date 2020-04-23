package com.wudonglong.www.service;

import java.util.List;

import com.wudonglong.www.dao.TribeDao;
import com.wudonglong.www.po.Tribe;
import com.wudonglong.www.util.DBUtil;



public class TribeService {
	static TribeDao tribeDao = new TribeDao();
	
	
	
	
	//查询部落
	public List<Tribe> queryTribe(){
		return tribeDao.queryTribe();
	}
	
	//根据部落ID修改部落信息
	public boolean updateTribeByID(Tribe tribe) {
		return tribeDao.updateTribeByID(tribe);
	}
	
	//增加部落
	public boolean addTribe(Tribe tribe) {
		return tribeDao.addTribe(tribe);
	}
	
	//根据ID删除部落
	public boolean deleteTribe(Tribe tribe) {
		return tribeDao.deleteTribe(tribe);
	}
	
}
