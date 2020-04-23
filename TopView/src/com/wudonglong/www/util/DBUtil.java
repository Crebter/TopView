package com.wudonglong.www.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//ͨ�õ����ݲ�������

public class DBUtil {
	private static final String url = "jdbc:mysql://localhost:3306/topview?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
	private static final String username ="root";
	private static final String userpwd = "wudonglong";
	public static Connection con = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs = null;
	
	//��ѯĳ�������������е����ݵ�����
	public static int getTatalCount(String sql) {
		int count = 0;
		try {
			pstmt = createPreParedStatement(sql, null);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				count++;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(rs, pstmt, con);
		}
		return count;
	}
	
	//�������
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return con = DriverManager.getConnection(url, username, userpwd);
	}
	
	//����pstmt
	public static PreparedStatement createPreParedStatement(String sql,Object[] params) throws ClassNotFoundException, SQLException {
		pstmt = getConnection().prepareStatement(sql);
		if(params!=null) {
			for(int i=0;i<params.length;i++) {
				pstmt.setObject(i+1, params[i]);
			}				
		}
		return pstmt;
		
	}
	
	//�ر�
	public static void closeAll(ResultSet rs,Statement stmt,Connection con) {
		try {
			if(rs!=null)
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(pstmt!=null)
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		try {
			if(con!=null)
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//ͨ�õ���ɾ��
	public static boolean executeUpdate(String sql,Object[] params) {
		try {
			pstmt = createPreParedStatement(sql,params);
			
			int count = pstmt.executeUpdate();
			if(count>0) {
				return true;
			}else {
				return false;
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
				closeAll(null, pstmt, con);
		}
	}

	//ͨ�õĲ�
		public static ResultSet excuteQuery(String sql,Object[] params) {
				try {
					pstmt = createPreParedStatement(sql,params);
					rs = pstmt.executeQuery();
					return rs;//����sql�����������۸��ӣ�����ͨ�ô���ֻ�ܷ��ؽ����
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
					return null;
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
	}

}
