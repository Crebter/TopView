package com.wudonglong.www.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wudonglong.www.po.Tribe;
import com.wudonglong.www.service.TribeService;


public class TribeUpdateServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String introduction = request.getParameter("introduction");
		String area = request.getParameter("area");
		String address = request.getParameter("address");
		
		Tribe tribe = new Tribe(id,name,introduction,area,address);
		TribeService tribeService = new TribeService();
		
		boolean flag = tribeService.updateTribeByID(tribe);
		
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
