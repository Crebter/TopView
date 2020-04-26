<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/login.css" rel="stylesheet" type="text/css">
<script src="js/jquery-1.8.3.js"></script>
<title>用户登陆页面</title>
</head>
<body>
	<div id="loginbox">
		<div id="form">
			<form action="LoginServlet" method="post">
			    <h1>用户登陆页面</h1> 
			    <hr/>
			    <table align="left">
			        <tr>
			            <td>账号：</td>
			            <td><input type="text" name="username" id="username"></td>
			        </tr>
			        <tr>
			            <td>密码：</td>
			            <td><input type="password" name="password" id="password"></td>
			        </tr>
			        <tr>
			            <td colspan="1">
			            </td>
			            <td>
			                <input type="submit" value="登陆"/>
			                <input type="reset" value="重置"/><br/><br/>
			                <a href="register.jsp" target="_blank">注册</a>
			            </td>
			        </tr>
			    </table>
			</form>
		</div>
	</div>	
</body>
</html>