<%@page import="com.neuedu.crm.bean.Message"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
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
<title>发布公告</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<%=basePath%>common/layui-v2.3.0/css/layui.css" media="all">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script src="<%=basePath%>common/layui-v2.3.0/layui.js" charset="utf-8"></script>
</head>
<body>
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>发布公告</legend>
	</fieldset>
	<form class="layui-form layui-form-pane" action="">
		<div class="layui-form-item">
			<label class="layui-form-label">公告标题</label>
			<div class="layui-input-inline">
				<input id="title" type="text" autocomplete="off" class="layui-input" placeholder="请输入标题">
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">公告内容</label>
			<div class="layui-input-block">
				<textarea id="content" class="layui-textarea" style="height: 150px;" placeholder="请输入公告内容" ></textarea>
			</div>
		</div>
		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">发送对象</label>
			<div class="layui-input-block">

				<shiro:hasRole name="管理员">
					<input id="all" type="checkbox" title="所有人" lay-filter="sendAll">
					<input id="senior" type="checkbox" title="高管" lay-filter="other">
					<input id="director" type="checkbox" title="主管" lay-filter="other">
					<input id="manager" type="checkbox" title="客户经理" lay-filter="other">
				</shiro:hasRole>

				<shiro:hasRole name="高管">
					<input id="directorForAll" type="checkbox" title="所有主管" lay-filter="sendAll">
					<input id="directorForOne" type="checkbox" title="直属主管" lay-filter="other">
				</shiro:hasRole>

				<shiro:hasRole name="主管">
					<input id="managerForAll" type="checkbox" title="所有经理" lay-filter="sendAll">
					<input id="managerForOne" type="checkbox" title="直属经理" lay-filter="other">
				</shiro:hasRole>

			</div>
		</div>
	</form>
	
	<script>
	
	layui.use([ 'layer', 'form', 'element' ], function() {
		var layer = layui.layer, form = layui.form, element = layui.element
		
		form.on('checkbox(sendAll)' , function(data){
			
			$("#senior").prop("checked",false);
			$("#director").prop("checked", false);
			$("#manager").prop("checked", false);
			$("#directorForOne").prop("checked",false);
			$("#managerForOne").prop("checked",false);
			form.render();
		});
		form.on('checkbox(other)' , function(data){
			
			$("#all").prop("checked",false);
			$("#directorForAll").prop("checked",false);
			$("#managerForAll").prop("checked",false);
			form.render();
		});
		
	});
		
		function getIFrameDate() {
			
			var recipient = "";
			
			//获取选中的checkbox
			var all = document.getElementById('all');
			var senior = document.getElementById('senior');
			var director = document.getElementById('director');
			var manager = document.getElementById('manager');
			var directorForAll = document.getElementById('directorForAll');
			var directorForOne = document.getElementById('directorForOne');
			var managerForAll = document.getElementById('managerForAll');
			var managerForOne = document.getElementById('managerForOne');
			
			if((null != all) && (all.checked) ){
				recipient += "all";
			}
			if((null != senior) && (senior.checked)){
				recipient += "seniors";
			}
			if((null != director) && (director.checked)){
				recipient += "directors";
			}
			if((null != manager) && (manager.checked)){
				recipient += "managers";
			}
			if((null != directorForAll) && (directorForAll.checked)){
				recipient += "directors";
			}
			if((null != directorForOne) && (directorForOne.checked)){
				recipient += "directorForOne";
			}
			if((null != managerForAll) && (managerForAll.checked)){
				recipient += "managers";
			}
			if((null != managerForOne) && (managerForOne.checked)){
				recipient += "managerForOne";
			}
			var data = {
				title : document.getElementById('title').value,
				content : document.getElementById('content').value,
				recipients : recipient
			};
			return data;
		}
			
	</script>
</body>


</html>