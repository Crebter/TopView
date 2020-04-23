package com.wudonglong.www.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wudonglong.www.po.Dragon;
import com.wudonglong.www.service.DragonService;


public class DragonAddServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String introduction = request.getParameter("introduction");
		int age = Integer.parseInt(request.getParameter("age"));
		String health = request.getParameter("health");
		int tribeid = Integer.parseInt(request.getParameter("tribeid"));
		
		Dragon dragon = new Dragon(name,introduction,age,health,tribeid);
		
		DragonService dragonService = new DragonService();
		
		boolean flag = dragonService.addDragon(dragon);
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		if(flag == true) {
			request.getRequestDispatcher("LoginServlet").forward(request, response);
		}else {
			out.flush();
			out.println("<script>");
			out.println("alert('ÐÂÔöÊ§°Ü£¡');");
			out.println("history.back();");
			out.println("</script>");
		}
	
		

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
