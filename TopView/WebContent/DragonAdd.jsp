<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/visiter.css" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
		
			<form action="DragonAddServlet" method="post">
				<table align="center" id="table">
				<caption>添加的龙信息</caption>
							<tr><td>名字:<input type="text" name="name" ></td><tr>
							<tr><td>简介:<input type="text" name="introduction" ></td></tr>
							<tr><td>年 龄:<input type="text" name="age" ></td></tr>	
							<tr><td>健康状况:<input type="text" name="health" ></td></tr>	
							<tr><td>所处部落的编号:<input type="text" name="tribeid" ></td></tr>	
							<tr><td><input type="submit" value="提交"></td>
							</tr>	
							
				</table>
			</form>
</body>
</html>