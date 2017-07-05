<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="refresh" content="10;url=login.html">
<title>Register Result</title>
</head>
<body >
	<% String f = (String)request.getAttribute("res");
		if(f.equals("true")){
	%>
	<p>恭喜您注册成功, <span style='font-family:"consolas";' id="cnt"></span>秒后将自动跳转登录页面</p>
	<a href="login.html">点击跳转</a>
	<script type="text/javascript">
		var sec = 10;
		function cnt()
		{
			document.getElementById("cnt").innerHTML = sec--;
			setTimeout("cnt()", 1000);
		}
		window.onload = cnt();
	</script>
	<%
		}else{	
	%>
	<p>抱歉, 该用户名已被注册</p>
	<p><a href="register.html">点击返回注册页面</a></p>
	<p><a href="login.html">去往登录页面</a></p>
	<% } %>
</body>
</html>