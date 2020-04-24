package com.wudonglong.www.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wudonglong.www.dao.TribeDao;
import com.wudonglong.www.po.Tribe;
import com.wudonglong.www.util.DBUtil;



public class TribeService {
	static TribeDao tribeDao = new TribeDao();
	
	
	
	//��ѯ����
	public List<Tribe> queryTribe(){
		return tribeDao.queryTribe();
	}
	
	//���ݲ���ID�޸Ĳ�����Ϣ
	public boolean updateTribeByID(Tribe tribe) {
		return tribeDao.updateTribeByID(tribe);
	}
	
	//���Ӳ���
	public boolean addTribe(Tribe tribe) {
		return tribeDao.addTribe(tribe);
	}
	
	//����IDɾ������
	public boolean deleteTribe(Tribe tribe) {
		return tribeDao.deleteTribe(tribe);
	}
	
	//��ҳ��ѯ����
	public List<Tribe> queryTribeByPage(int currentPage, int pageSize) {
		return tribeDao.queryTribeByPage(currentPage, pageSize);
	}
	
	//������������
	public int getTatalCount() {
		return tribeDao.getTatalCount();
	}
	
	
}
