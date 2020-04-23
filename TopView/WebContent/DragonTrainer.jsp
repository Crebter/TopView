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
						</tr >

					</tbody>
				</table>
			</form>
			
			
			
			<form action="TribeUpdateServlet" method="post"> 
				<table align="center" >
					<caption>您的部落：</caption>
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
						<tr>
							<td><input type="text" name="id" value="${sessionScope.tribe.id }" readonly></td>
							<td ><input type="text" name="name" value="${sessionScope.tribe.name }"></td>
							<td><input type="text" name="introduction" value="${sessionScope.tribe.introduction }"></td>
							<td><input type="text" name="area" value="${sessionScope.tribe.area }"></td>
							<td><input type="text" name="address" value="${sessionScope.tribe.address }"></td>
							<td><input type="submit" value="修改"></td>
						</tr>
					</tbody>
				</table>
			</form>
			
			<br/>
			
			
			<form action="DragonUpdateServlet" method="post">
				<table align="center" style="border-collapse:separate; border-spacing:20px 10px;">
				<caption>龙信息</caption>
					<thead>
						<tr>
							<th>名字</th>
							<th>简介</th>
							<th>年龄</th>
							<th>健康状况</th>
							<th>所处部落编号</th>
							<th>修改</th>
							<th>操作</th>
						</tr>
						<!-- <input type="text" name="name" value=" -->
					</thead>
					<tbody>
						<c:forEach var="Dragon" items="${sessionScope.dragons}">
							<tr>
								<input type="hidden" name="id" value="${Dragon.id }">
								<td><input type="text" name="name" value="${Dragon.name }"></td>
								<td><input type="text" name="introduction" value="${Dragon.introduction }"></td>
								<td><input type="text" name="age" value="${Dragon.age}"></td>
								<td><input type="text" name="health" value="${Dragon.health}"></td>
								<td><input type="text" name="tribeid" value="${Dragon.tribeid }"readonly></td>
								<td><input type="submit" value="修改"></td>
								<td><a href="DragonDeleteServlet?id=${Dragon.id }" >删除</a></td>
							</tr>
							
						</c:forEach>
						
					</tbody>		
				</table>
				<a href="DragonAdd.jsp" align="center">新增</a>
				
			</form>
			
</body>
</html>