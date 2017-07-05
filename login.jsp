<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login Page</title>
    <link type = "text/css" rel="stylesheet" href="css/login.css"/>
    <script src="js/login.js"></script>
</head>
<body>

	<% String f = (String)request.getAttribute("res"); 
		if(f.substring(0, 1).equals("1")){
			
	%>
	<p>Hello, <%= ((String)request.getAttribute("res")).substring(1) %></p>
	<% }else{
		%>
		<script type="text/javascript">
			window.onload=show;
		</script>
		<form style="margin:auto;" action="login.do" method="POST">
    		<center>用户登录</center><br/><br/>
    		USER: <br/> <input type="text" name="user"></input><br/><br/>
    		PASS: <br/><input type="password" name="pass"></input>
    		<br/>
    		<br/>
   		<input style="color: #fff;" type="submit" value="login"></input>
   		<br/><br/>
   		还没有账号? <a href="register.html">立即注册</a>
   		<br/>
   		<br/>
   		The time: <p id="time"></p>
		</form>
	<% 	if(f.equals("0")){
		%><p>用户名错误</p>
		<%}else{ %>
		<p>密码错误</p>
		<%}} %>
		
    
</body>
</html>