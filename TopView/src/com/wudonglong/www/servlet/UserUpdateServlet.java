package com.wudonglong.www.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wudonglong.www.po.User;
import com.wudonglong.www.service.UserService;


public class UserUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int phone = Integer.parseInt(request.getParameter("phone"));
		int card =Integer.parseInt(request.getParameter("card"));
		User user = new User(username,password,phone,card);
		
		UserService userService = new UserService();
		boolean flag = userService.updateUserBycard(user);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		if(flag == true) {
			out.flush();
			out.println("<script>");
			out.println("alert('修改成功！');");
			out.println("history.back();");
			out.println("</script>");
		}else {
			out.flush();
			out.println("<script>");
			out.println("alert('修改失败！');");
			out.println("history.back();");
			out.println("</script>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
