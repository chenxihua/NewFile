<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SonderCRM</title>

<%
	String basePath = request.getContextPath()+"/";
%>
<base href="<%=basePath %>" />

</head>
<body>
	
	
	已经重新提交了
	<h3>这里是SonderCRM的index页面</h3>
	
	<br><br>
	<a href="system/goToLogin">测试登录</a>
	<br><br>
	<a href="pages/directorsPage.jsp">直接跳转</a>
	
</body>
</html>