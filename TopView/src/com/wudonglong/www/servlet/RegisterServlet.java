package com.wudonglong.www.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wudonglong.www.po.User;
import com.wudonglong.www.service.UserService;


public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		type = new String(type.getBytes("iso-8859-1"),"utf-8");
		int card = Integer.parseInt(request.getParameter("card"));
		int phone = Integer.parseInt(request.getParameter("phone"));

		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
//		String userName, String password, String type, int card, int phone

		User user = new User(userName,password,type,card,phone);
		UserService userService = new UserService();
		PrintWriter out = response.getWriter();
		boolean flag = userService.addUser(user);
		if(flag == true) {
			out.flush();
			out.println("<script>");
			out.println("alert('注册成功,请登陆！');");
			out.println("history.back();");
			out.println("</script>");
		}else if (flag == false) {
			out.flush();
			out.println("<script>");
			out.println("alert('该用户已存在，请登陆');");
			out.println("history.back();");
			out.println("</script>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
