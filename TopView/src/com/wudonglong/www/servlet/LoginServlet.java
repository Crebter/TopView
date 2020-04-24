package com.wudonglong.www.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wudonglong.www.po.Dragon;
import com.wudonglong.www.po.DragonPage;
import com.wudonglong.www.po.Tribe;
import com.wudonglong.www.po.TribePage;
import com.wudonglong.www.po.User;
import com.wudonglong.www.po.UserPage;
import com.wudonglong.www.service.DragonService;
import com.wudonglong.www.service.TribeService;
import com.wudonglong.www.service.UserService;


public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		User user = new User();
		User user2 = new User();
		User result = new User();
		Tribe tribe = new Tribe();
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		

		user.setUserName(userName);
		user.setPassword(password);
	

		
		UserService userService = new UserService();
		TribeService tribeService = new TribeService();
		DragonService dragonService = new DragonService();
		
		//�û���¼��֮�����sessionֵ,��session�л�ȡ�˺�����
		if(session.getAttribute("userinfo")!=null) {
			user2 = (User)session.getAttribute("userinfo");
			userName = user2.getUserName();
			password = user2.getPassword();
			result = userService.login(user2);
		}else {
			result = userService.login(user);
		}

		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		if(result != null )
		{		
			//�û���Ϣ
			session.setAttribute("userinfo", result);
			
			//����û���ѱ������,�����Ӧ�Ķ����ҳ���,������
			if(result.getType().equals("DragonTrainer")) {
				//ѱ�����ֹ���Ĳ���
				tribe = userService.queryTribeByID(result);
				
				session.setAttribute("tribe", tribe);
				
				DragonPage dragonPageTrainer = new DragonPage();
				//��������������
				int totalCountTrainer = dragonService.getTotalTrainer(tribe);
				dragonPageTrainer.setTotalCount(totalCountTrainer);
				
				//����ҳ���С
				int pageSizeTrainer = 5;
				dragonPageTrainer.setPageSize(pageSizeTrainer);
				
				//���ú�������������ҳ���С֮��,��ҳ���Զ��������
				int totalPageTrainer = dragonPageTrainer.getTotalPage();
				
				//���ǰ�˴�������currentPage
				String cPageTrainer = request.getParameter("currentPageTrainerDragon");
				
				//
				if(cPageTrainer == null || Integer.parseInt(cPageTrainer) < 1) {
					cPageTrainer = "1";
				}
				else if(Integer.parseInt(cPageTrainer) > totalPageTrainer) {
					//��totalPageת��String
					cPageTrainer = totalPageTrainer+"";
				}
				
				//�õ���ǰ�ڼ�ҳ,���ڲ�ѯ
				int currentPageTrainer = Integer.parseInt(cPageTrainer);
				dragonPageTrainer.setCurrentPage(currentPageTrainer);
				
				
				//ѱ�����ֹ������
				List<Dragon> dragons = dragonService.queryDragonByTribeIDByPage(tribe,currentPageTrainer,pageSizeTrainer);
				dragonPageTrainer.setDragons(dragons);
				
				//��ѱ�����ֲ鿴����
				session.setAttribute("dragonPageTrainer", dragonPageTrainer);
			}
	
			
			/*
			 * 
			 * ��ҳ��ѯ����:�ι���ҳ��
			 * 
			 */
			TribePage tribePage = new TribePage();
			
			//��������������
			int totalCountTribe = tribeService.getTatalCount();
			tribePage.setTotalCount(totalCountTribe);
			
			//����ҳ���С
			int pageSize = 5;
			tribePage.setPageSize(pageSize);
			
			//���ú�������������ҳ���С֮��,��ҳ���Զ��������
			int totalPageTribe = tribePage.getTotalPage();
			
			//���ǰ�˴�������currentPage
			String cPageTribe = request.getParameter("currentPageTribe");
			
			//
			if(cPageTribe == null || Integer.parseInt(cPageTribe) < 1) {
				cPageTribe = "1";
			}
			else if(Integer.parseInt(cPageTribe) > totalPageTribe) {
				//��totalPageת��String
				cPageTribe = totalPageTribe+"";
			}
			
			//�õ���ǰ�ڼ�ҳ,���ڲ�ѯ
			int currentPageTribe = Integer.parseInt(cPageTribe);
			tribePage.setCurrentPage(currentPageTribe);
			
			//��ѯ����
			List<Tribe> tribesNew = tribeService.queryTribeByPage(currentPageTribe, pageSize);
			tribePage.setTribes(tribesNew);
			
			session.setAttribute("tribePage", tribePage);
			
			
			
			/*
			 * 
			 * ��ҳ��ѯ��
			 * 
			 */
			DragonPage dragonPage = new DragonPage();
			
			//��������������
			int totalCountDragon = dragonService.getTatalCount();
			dragonPage.setTotalCount(totalCountDragon);
			
			//����ҳ���С
			int pageSizeDragon = 4;
			dragonPage.setPageSize(pageSizeDragon);
			
			//���ú�������������ҳ���С֮��,��ҳ���Զ��������
			int totalPageDragon = dragonPage.getTotalPage();
			
			//���ǰ�˴�������currentPage
			String cPageDragon = request.getParameter("currentPageDragon");
			
			//�ճ�ʼ��ʱ��cpageΪnull.����Ϊ�鿴��ҳ�վ�    
			if(cPageDragon == null || Integer.parseInt(cPageDragon) < 1) {
				cPageDragon = "1";
			}
			else if(Integer.parseInt(cPageDragon) > totalPageDragon) {
				//��totalPageת��String
				cPageDragon = totalPageDragon+"";
			}
			
			//�õ���ǰ�ڼ�ҳ,���ڲ�ѯ
			int currentPageDragon = Integer.parseInt(cPageDragon);
			dragonPage.setCurrentPage(currentPageDragon);
			
			//��ѯ��
			List<Dragon> DragonsNew = dragonService.queryDragonByPage(currentPageDragon, pageSizeDragon);
			dragonPage.setDragons(DragonsNew);
			
			session.setAttribute("dragonPage", dragonPage);
			
			
			
			/*
			 * 
			 * ��ҳ��ѯѱ������
			 * 
			 */
			
			UserPage userPage = new UserPage();
			
			//��������������
			int totalCountUser = userService.getTatalCount();
			userPage.setTotalCount(totalCountUser);
			
			//����ҳ���С
			int pageSizeUser = 5;
			userPage.setPageSize(pageSizeUser);
			
			//���ú�������������ҳ���С֮��,��ҳ���Զ��������
			int totalPageUser = userPage.getTotalPage();
			
			//���ǰ�˴�������currentPage
			String cPageUser = request.getParameter("currentPageUser");
			
			//�ճ�ʼ��ʱ��cpageΪnull.����Ϊ�鿴��ҳ�վ�    
			if(cPageUser == null || Integer.parseInt(cPageUser) < 1) {
				cPageUser = "1";
			}
			else if(Integer.parseInt(cPageUser) > totalPageUser) {
				//��totalPageת��String
				cPageUser = totalPageUser+"";
			}
			
			//�õ���ǰ�ڼ�ҳ,���ڲ�ѯ
			int currentPageUser = Integer.parseInt(cPageUser);
			userPage.setCurrentPage(currentPageUser);
			
			//��ѯ�û�
			List<User> UsersNew = userService.queryUserByPage(currentPageUser, pageSizeUser);
			userPage.setUsers(UsersNew);
			
			
			
			
			//����������ѱ������
			session.setAttribute("userPage", userPage);
			
			
			
			String type = result.getType();
			if(type.equals("Visiter")) {
				request.getRequestDispatcher("Visiter.jsp").forward(request, response);
			}else if(type.equals("DragonTrainer")) {
				request.getRequestDispatcher("DragonTrainer.jsp").forward(request, response);
			}else if(type.equals("DragonMother")) {
				request.getRequestDispatcher("DragonMother.jsp").forward(request, response);
			}
		} else if(result == null) {
			out.flush();
			out.println("<script>");
			out.println("alert('�˻����������');");
			out.println("history.back();");
			out.println("</script>");
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
