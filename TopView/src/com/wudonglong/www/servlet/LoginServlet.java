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
import com.wudonglong.www.po.Tribe;
import com.wudonglong.www.po.User;
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
			
			List<User> results = userService.queryDragonTrianer();
			List<Tribe> tribes = tribeService.queryTribe();
			List<Dragon> dragonsVisiter = dragonService.queryDragon();
			
			
			
			//�û���Ϣ
			session.setAttribute("userinfo", result);
			
			//����û���ѱ������,�����Ӧ�Ķ����ҳ���,������
			if(result.getType().equals("DragonTrainer")) {
				//ѱ�����ֹ���Ĳ���
				tribe = userService.queryTribeByID(result);
				
				session.setAttribute("tribe", tribe);
				
				//ѱ�����ֹ������
				List<Dragon> dragons = dragonService.queryDragonByTribeID(tribe);
				
				//��ѱ�����ֲ鿴����
				session.setAttribute("dragons", dragons);
			}
			
			
			//���ι��ߡ����迴�����еĲ���
			session.setAttribute("tribes", tribes);
			
			//���ι��߿������е���
			session.setAttribute("dragonsVisiter", dragonsVisiter);
			
			//����������ѱ������
			session.setAttribute("results", results);
			
			
			
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
