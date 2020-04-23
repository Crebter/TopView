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
	
	//������
	public boolean addDragon(Dragon dragon) {
		return dragonDao.addDragon(dragon);
	}
	
	
	//���ݲ���ID��������Ϣ
	public List<Dragon> queryDragonByTribeID(Tribe tribe) {
		return dragonDao.queryDragonByTribeID(tribe);
	}
	
	//����ID�޸���
	public boolean updateDragonByID(Dragon dragon) {
		return dragonDao.updateDragonByID(dragon);
	}
	
	
	//��ѯ���е���
	public List<Dragon> queryDragon() {
		return dragonDao.queryDragon();
	}
	
	//����IDɾ����
	public boolean deleteDragon(int id) {
		return dragonDao.deleteDragon(id);
	}
	
}	
