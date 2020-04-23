package com.wudonglong.www.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wudonglong.www.po.Tribe;
import com.wudonglong.www.service.TribeService;

public class TribeDeleteServlet extends HttpServlet {
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		Tribe tribe = new Tribe(id);
		
		TribeService tribeService = new TribeService();
		
		boolean flag = tribeService.deleteTribe(tribe);
	
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		if(flag == true) {
			request.getRequestDispatcher("LoginServlet").forward(request, response);
		}else {
			out.flush();
			out.println("<script>");
			out.println("alert('É¾³ýÊ§°Ü£¡');");
			out.println("history.back();");
			out.println("</script>");
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
