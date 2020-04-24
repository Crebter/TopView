<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
			<form action="UserUpdateServlet" method="post"> 
				<table align="center" >
					<caption>您的信息：(若要修改,请填写修改的值)</caption>
					<thead>
						<tr>
							<th>身份</th>
							<th>用户</th>
							<th>密码</th>
							<th>电话</th>
							<th>身份证号</th>
							
						</tr>
					</thead>
					<tbody>
						<tr>
							<td ><input type="text" name="type" value="${sessionScope.userinfo.type }" readonly></td>
							<td><input type="text" name="username" value="${sessionScope.userinfo.userName }"></td>
							<td><input type="password" name="password" value="${sessionScope.userinfo.password }"></td>
							<td><input type="text" name="phone" value="${sessionScope.userinfo.phone }"></td>
							<td><input type="text" name="card" value="${sessionScope.userinfo.card }" readonly></td>
							<td><input type="submit" value="修改"></td>
							<td>                        </td>
							<td><a href="exit.jsp">退出登录</a></td>
						</tr >

					</tbody>
				</table>
			</form>
			
			</br>

			<table align="center" style="border-collapse:separate; border-spacing:170px 10px;">
				<caption>部落信息</caption>
					<thead>
						<tr>
							<th>编号</th>
							<th>名字</th>
							<th>简介</th>
							<th>面积</th>
							<th>地址</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="Tribe" items="${sessionScope.tribePage.getTribes()}">
							<tr>
								<td>${Tribe.id }</td>
								<td>${Tribe.name }</td>
								<td>${Tribe.introduction }</td>
								<td>${Tribe.area }</td>
								<td>${Tribe.address }</td>
							</tr>
						</c:forEach>
							<tr>
								<td>&nbsp;</td>
								<td>总页数:${sessionScope.tribePage.getTotalPage() }</td>
								<td>&nbsp;</td>
								<td>当前页数:${sessionScope.tribePage.getCurrentPage() }</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><a href="LoginServlet?currentPageTribe=1">首页</a></td>
								<td><a href="LoginServlet?currentPageTribe=${sessionScope.tribePage.getCurrentPage()-1 }">上一页</a></td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td><a href="LoginServlet?currentPageTribe=${sessionScope.tribePage.getCurrentPage()+1 }">下一页</a></td>
								<td><a href="LoginServlet?currentPageTribe=1${sessionScope.tribePage.getTotalPage() }">尾页</a></td>
							</tr>
					</tbody>
			</table>
			

			
			
			
		
			<table align="center" style="border-collapse:separate; border-spacing:170px 10px;">
				<caption>龙信息</caption>
					<thead>
						<tr>
							<th>名字</th>
							<th>年龄</th>
							<th>简介</th>
							<th>所属部落</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="dragonsVisiter" items="${sessionScope.dragonPage.getDragons()}">
							<tr>
								<td>${dragonsVisiter.name }</td>
								<td>${dragonsVisiter.age }</td>
								<td>${dragonsVisiter.introduction }</td>
								<td>${dragonsVisiter.tribeid }</td>
							</tr>
						</c:forEach>
							<tr>
								<td>&nbsp;</td>
								<td>总页数:${sessionScope.dragonPage.getTotalPage() }</td>
								<td>当前页数:${sessionScope.dragonPage.getCurrentPage() }</td>
								<td>&nbsp;</td>
							</tr>
							<tr>
								<td><a href="LoginServlet?currentPageDragon=1">首页</a></td>
								<td><a href="LoginServlet?currentPageDragon=${sessionScope.dragonPage.getCurrentPage()-1 }">上一页</a></td>
								<td><a href="LoginServlet?currentPageDragon=${sessionScope.dragonPage.getCurrentPage()+1 }">下一页</a></td>
								<td><a href="LoginServlet?currentPageDragon=1${sessionScope.dragonPage.getTotalPage() }">尾页</a></td>
							</tr>
						
					</tbody>
			</table>
			
			


					
					
					
			
			
			
			
			
</body>
</html>