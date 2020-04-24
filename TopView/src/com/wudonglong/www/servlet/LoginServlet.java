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
		
		//用户登录过之后会有session值,从session中获取账号密码
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
			//用户信息
			session.setAttribute("userinfo", result);
			
			//如果用户是驯龙高手,则把相应的东西找出来,否则不找
			if(result.getType().equals("DragonTrainer")) {
				//驯龙高手管理的部落
				tribe = userService.queryTribeByID(result);
				
				session.setAttribute("tribe", tribe);
				
				DragonPage dragonPageTrainer = new DragonPage();
				//设置总数据条数
				int totalCountTrainer = dragonService.getTotalTrainer(tribe);
				dragonPageTrainer.setTotalCount(totalCountTrainer);
				
				//设置页面大小
				int pageSizeTrainer = 5;
				dragonPageTrainer.setPageSize(pageSizeTrainer);
				
				//设置好总数据条数跟页面大小之后,总页数自动计算出来
				int totalPageTrainer = dragonPageTrainer.getTotalPage();
				
				//获得前端传过来的currentPage
				String cPageTrainer = request.getParameter("currentPageTrainerDragon");
				
				//
				if(cPageTrainer == null || Integer.parseInt(cPageTrainer) < 1) {
					cPageTrainer = "1";
				}
				else if(Integer.parseInt(cPageTrainer) > totalPageTrainer) {
					//将totalPage转成String
					cPageTrainer = totalPageTrainer+"";
				}
				
				//得到当前第几页,用于查询
				int currentPageTrainer = Integer.parseInt(cPageTrainer);
				dragonPageTrainer.setCurrentPage(currentPageTrainer);
				
				
				//驯龙高手管理的龙
				List<Dragon> dragons = dragonService.queryDragonByTribeIDByPage(tribe,currentPageTrainer,pageSizeTrainer);
				dragonPageTrainer.setDragons(dragons);
				
				//给驯龙高手查看的龙
				session.setAttribute("dragonPageTrainer", dragonPageTrainer);
			}
	
			
			/*
			 * 
			 * 分页查询部落:参观者页面
			 * 
			 */
			TribePage tribePage = new TribePage();
			
			//设置总数据条数
			int totalCountTribe = tribeService.getTatalCount();
			tribePage.setTotalCount(totalCountTribe);
			
			//设置页面大小
			int pageSize = 5;
			tribePage.setPageSize(pageSize);
			
			//设置好总数据条数跟页面大小之后,总页数自动计算出来
			int totalPageTribe = tribePage.getTotalPage();
			
			//获得前端传过来的currentPage
			String cPageTribe = request.getParameter("currentPageTribe");
			
			//
			if(cPageTribe == null || Integer.parseInt(cPageTribe) < 1) {
				cPageTribe = "1";
			}
			else if(Integer.parseInt(cPageTribe) > totalPageTribe) {
				//将totalPage转成String
				cPageTribe = totalPageTribe+"";
			}
			
			//得到当前第几页,用于查询
			int currentPageTribe = Integer.parseInt(cPageTribe);
			tribePage.setCurrentPage(currentPageTribe);
			
			//查询部落
			List<Tribe> tribesNew = tribeService.queryTribeByPage(currentPageTribe, pageSize);
			tribePage.setTribes(tribesNew);
			
			session.setAttribute("tribePage", tribePage);
			
			
			
			/*
			 * 
			 * 分页查询龙
			 * 
			 */
			DragonPage dragonPage = new DragonPage();
			
			//设置总数据条数
			int totalCountDragon = dragonService.getTatalCount();
			dragonPage.setTotalCount(totalCountDragon);
			
			//设置页面大小
			int pageSizeDragon = 4;
			dragonPage.setPageSize(pageSizeDragon);
			
			//设置好总数据条数跟页面大小之后,总页数自动计算出来
			int totalPageDragon = dragonPage.getTotalPage();
			
			//获得前端传过来的currentPage
			String cPageDragon = request.getParameter("currentPageDragon");
			
			//刚初始化时，cpage为null.设置为查看首页收据    
			if(cPageDragon == null || Integer.parseInt(cPageDragon) < 1) {
				cPageDragon = "1";
			}
			else if(Integer.parseInt(cPageDragon) > totalPageDragon) {
				//将totalPage转成String
				cPageDragon = totalPageDragon+"";
			}
			
			//得到当前第几页,用于查询
			int currentPageDragon = Integer.parseInt(cPageDragon);
			dragonPage.setCurrentPage(currentPageDragon);
			
			//查询龙
			List<Dragon> DragonsNew = dragonService.queryDragonByPage(currentPageDragon, pageSizeDragon);
			dragonPage.setDragons(DragonsNew);
			
			session.setAttribute("dragonPage", dragonPage);
			
			
			
			/*
			 * 
			 * 分页查询驯龙高手
			 * 
			 */
			
			UserPage userPage = new UserPage();
			
			//设置总数据条数
			int totalCountUser = userService.getTatalCount();
			userPage.setTotalCount(totalCountUser);
			
			//设置页面大小
			int pageSizeUser = 5;
			userPage.setPageSize(pageSizeUser);
			
			//设置好总数据条数跟页面大小之后,总页数自动计算出来
			int totalPageUser = userPage.getTotalPage();
			
			//获得前端传过来的currentPage
			String cPageUser = request.getParameter("currentPageUser");
			
			//刚初始化时，cpage为null.设置为查看首页收据    
			if(cPageUser == null || Integer.parseInt(cPageUser) < 1) {
				cPageUser = "1";
			}
			else if(Integer.parseInt(cPageUser) > totalPageUser) {
				//将totalPage转成String
				cPageUser = totalPageUser+"";
			}
			
			//得到当前第几页,用于查询
			int currentPageUser = Integer.parseInt(cPageUser);
			userPage.setCurrentPage(currentPageUser);
			
			//查询用户
			List<User> UsersNew = userService.queryUserByPage(currentPageUser, pageSizeUser);
			userPage.setUsers(UsersNew);
			
			
			
			
			//给龙妈管理的驯龙高手
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
			out.println("alert('账户或密码错误');");
			out.println("history.back();");
			out.println("</script>");
			}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
