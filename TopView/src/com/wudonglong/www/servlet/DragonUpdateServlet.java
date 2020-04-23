package com.wudonglong.www.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wudonglong.www.po.Dragon;
import com.wudonglong.www.service.DragonService;


public class DragonUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		int age = Integer.parseInt(request.getParameter("age"));
		String name = request.getParameter("name");
		String health = request.getParameter("health");
		String introduction = request.getParameter("introduction");
		
		Dragon dragon = new Dragon(id,name,introduction,age,health);
		DragonService dragonService = new DragonService();
		
		boolean flag = dragonService.updateDragonByID(dragon);
		
		
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
