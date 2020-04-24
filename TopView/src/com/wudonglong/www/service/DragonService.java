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
	
	//������������
	public int getTatalCount() {
		return dragonDao.getTatalCount();
	}
	
	
	//������
	public boolean addDragon(Dragon dragon) {
		return dragonDao.addDragon(dragon);
	}
	
	
	//���ݲ���ID��������Ϣ(��ҳ)
	public List<Dragon> queryDragonByTribeIDByPage(Tribe tribe,int currentPage,int pageSize) {
		return dragonDao.queryDragonByTribeIDByPage(tribe, currentPage, pageSize);
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
	
	
	//��ҳ��ѯ��
	public List<Dragon> queryDragonByPage(int currentPage,int pageSize) {
		return dragonDao.queryDragonByPage(currentPage, pageSize);
	}
	
	
	//����ѱ�����ֹ������������
	public int getTotalTrainer(Tribe tribe) {
		return dragonDao.getTotalTrainer(tribe);	
	}
	
}	
