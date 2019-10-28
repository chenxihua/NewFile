<%@page import="com.neuedu.crm.bean.Message"%>
<%@page import="com.mysql.fabric.xmlrpc.base.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>公告列表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<%=basePath%>common/layui-v2.3.0/css/layui.css" media="all">
<script src="<%=basePath%>common/layui-v2.3.0/layui.js" charset="utf-8"></script>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>公告详情</legend>
	</fieldset>
	<form class="layui-form layui-form-pane" action="">
		<div class="layui-form-item">
			<label class="layui-form-label">公告标题</label>
			<div class="layui-input-inline">
				<input type="text" name="username" autocomplete="off"
					class="layui-input" value="${message.title}" disabled>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">发布人</label>
			<div class="layui-input-inline">
				<input type="text" name="username" autocomplete="off"
					class="layui-input" value="${message.publisher}" disabled>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">发布时间</label>
			<div class="layui-input-inline">
				<input id="publishTime" type="text" name="username"
					 class="layui-input" value="${publishTime}" disabled>
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">公告内容</label>
			<div class="layui-input-block">
				<textarea class="layui-textarea" disabled style="height: 160px;">${message.content}</textarea>
			</div>
		</div>
	</form>
</body>


</html>