<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
			<form action="TribeAddServlet" method="post">
				<table align="center">
				<caption>添加的部落信息</caption>
						<tr><td>编号:<input type="text" name="id" ></td></tr>
						<tr><td>名字:<input type="text" name="name" ></td><tr>
						<tr><td>面积:<input type="text" name="area" ></td></tr>
						<tr><td>地址:<input type="text" name="address" ></td></tr>	
						<tr><td>简介:<input type="text" name="introduction" ></td></tr>	
						<tr><td><input type="submit" value="提交">               <a href="LoginServlet">返回</a></td>
				</table>
				
			</form>
			

		
		
</body>
</html>