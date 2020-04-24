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

			
			
			<form action="UserUpdateServlet" method="post"> 
				<table align="center" >
					<caption>驯龙高手信息</caption>
					<thead>
						<tr>
							<th>身份</th>
							<th>编号</th>
							<th>账号</th>
							<th>密码</th>
							<th>电话</th>
							<th>身份证号</th>
							<th>修改</th>
							<th>删除</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="Trainers" items="${sessionScope.userPage.getUsers()}">
							<tr>
								<td><input type="text" name="type" value="${Trainers.type }" readonly></td>
								<td><input type="text" name="id" value="${Trainers.id }" readonly></td>
								<td><input type="text" name="username" value="${Trainers.userName }"></td>
								<td><input type="password" name="password" value="${Trainers.password }"></td>
								<td><input type="text" name="phone" value="${Trainers.phone }"></td>
								<td><input type="text" name="card" value="${Trainers.card }"readonly></td>
								<td><input type="submit" value="修改"></td>
								<td><a href="UserDeleteServlet?id=${Trainers.id }">删除</a></td>
							</tr>
						</c:forEach>
													<tr>

								<td>&nbsp;</td>
								<td>&nbsp;</td>
								<td>总页数:${sessionScope.userPage.getTotalPage() }</td>
								<td>当前页数:${sessionScope.userPage.getCurrentPage() }</td>
								<td>&nbsp;</td>
								<td>&nbsp;</td>

							</tr>
							<tr>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
								<td><a href="LoginServlet?currentPageUser=1">首页</a></td>
								<td><a href="LoginServlet?currentPageUser=${sessionScope.userPage.getCurrentPage()-1 }">上一页</a></td>
								<td><a href="LoginServlet?currentPageUser=${sessionScope.userPage.getCurrentPage()+1 }">下一页</a></td>
								<td><a href="LoginServlet?currentPageUser=1${sessionScope.userPage.getTotalPage() }">尾页</a></td>
								<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
							</tr>
						
					</tbody>
				</table>
				<a href="DragonTrainerAdd.jsp" align="center">新增</a>
			</form>

			
			<form action="TribeUpdateServlet" method="post"> 
				<table align="center" >
					<caption>所有部落信息</caption>
					<thead>
						<tr>
							<th>部落编号</th>
							<th>名字</th>
							<th>简介</th>
							<th>面积</th>
							<th>地址</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="Tribes" items="${sessionScope.tribePage.getTribes() }">
							<tr>
								<td><input type="text" name="id" value="${Tribes.id }" readonly></td>
								<td ><input type="text" name="name" value="${Tribes.name }"></td>
								<td><input type="text" name="introduction" value="${Tribes.introduction }"></td>
								<td><input type="text" name="area" value="${Tribes.area }"></td>
								<td><input type="text" name="address" value="${Tribes.address }"></td>
								<td><input type="submit" value="修改"></td>
								<td><a href="TribeDeleteServlet?id=${Tribes.id }">删除</a>
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
				<a href="TribeAdd.jsp">新增</a>
			</form>			
			
			
			
			
			
</body>
</html>