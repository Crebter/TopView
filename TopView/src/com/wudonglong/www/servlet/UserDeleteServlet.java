package com.wudonglong.www.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wudonglong.www.po.User;
import com.wudonglong.www.service.UserService;


public class UserDeleteServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));

		
		
		User user = new User(id);
		
		UserService userService = new UserService();
		
		boolean flag = userService.deleteUser(user);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		if(flag == true) {
			request.getRequestDispatcher("LoginServlet").forward(request, response);
		}else {
			out.flush();
			out.println("<script>");
			out.println("alert('ɾ��ʧ�ܣ�');");
			out.println("history.back();");
			out.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
