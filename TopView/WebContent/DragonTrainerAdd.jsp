<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/visiter.css" rel="stylesheet" type="text/css">

<title>Insert title here</title>
<script src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
    $(document).ready(function(){
        //alert("测试jQuery是否能用");
        $("#form1").submit(function(){
            var username=$("#username").val();//获取提交的值
            if(username.length==0){//进行判断，如果获取的值为0那么提示账号不能为空
                //alert("aa");//测试使用
                $("#nameError").html("账号不能为空");
                return false;
            }
            
            //密码进行验证不能为空
            var password=$("#password").val();//获取提交的密码的值
            if(password.length==0){
                $("#passwordError").html("密码不能为空");
                return false;
            }
            
            //确认密码进行验证
            var relpassword=$("#relpassword").val();//获取提交的确认密码的值
            if(relpassword.length==0){
                $("#relpasswordError").html("确认密码不能为空");
                return false;
            }
            
            if(password!=relpassword){
                $("#relpasswordError").html("确认密码输入不正确，请重新输入");
                return false;
            }
            
            var card=$("#card").val();//获取提交的值
            if(card.length==0){//进行判断，如果获取的值为0那么提示账号不能为空
                //alert("aa");//测试使用
                $("#cardError").html("身份证号不能为空");
                return false;
            }
            
            var phone=$("#phone").val();//获取提交的值
            if(phone.length==0){//进行判断，如果获取的值为0那么提示账号不能为空
                //alert("aa");//测试使用
                $("#phoneError").html("电话号码不能为空");
                return false;
            }
            
        });
    
    });
</script>
</head>
<body>
		<form action="RegisterServlet" method="post" id="form1">
		    <h1 align="center">用户注册页面</h1> 
		    <h4 align="center">ps:身份证号不能与他人一致</h4>
		    <h5 align="center" color="red">tip:请记住添加的驯龙高手的编号->用于添加部落</h5>
		    <hr/>
				<table align="center" id="table">
		    	<tr>
		        	<td>
			        <select  name="type" id="type" >
			        	<option value="DragonTrainer">驯龙高手</option>
			        </td>
			        </select>
		     	</tr>
		        <tr>
		            <td>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</td>
		            <td>
		                <input type="text" name="username" id="username"/>
		                <div id="nameError" style="display:inline;color:red;"></div>
		            </td>
		        </tr>
		        <tr>
		            <td>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</td>
		            <td>
		                <input type="password" name="password" id="password">
		                <div id="passwordError" style="display:inline;color:red;"></div>
		            </td>
		        </tr>
		        <tr>
		            <td>确认密码：</td>
		            <td>
		                <input type="password" name="relpassword" id="relpassword">
		                <div id="relpasswordError" style="display:inline;color:red;"></div>
		            </td>
		        </tr>
		        <tr>
		            <td>电话号码：</td>
		            <td><input type="text" name="phone" id="phone">
		            <div id="phoneError" style="display:inline;color:red;"></div>
		            </td>
		        </tr>
		        <tr>
		            <td>身份证号：</td>
		            <td><input type="text" name="card" id="card">
		            <div id="cardError" style="display:inline;color:red;"></div>
		            </td>
		        </tr>
		        <tr>
		            <td colspan="1">
		            </td>
		            <td>
		                <input type="submit" value="注册"/>
		                <input type="reset" value="重置"/>
		                <a href="LoginServlet" >返回</a>
		            </td>
		        </tr>
		    </table>
		</form>
</body>
</html>