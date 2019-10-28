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
<title>用户设置</title>
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
		<legend>用户设置</legend>
	</fieldset>
	<form class="layui-form layui-form-pane" action="">
		<div class="layui-form-item">
			<label class="layui-form-label">用户ID</label>
			<div class="layui-input-inline">
				<input id="id" type="text" name="id" autocomplete="off" class="layui-input"
					value="${userDetails.id}" disabled>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-inline">
				<input id="userId" type="text" name="name" autocomplete="off"
					class="layui-input" value="${userDetails.name}" disabled>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">角色</label>
			<div class="layui-input-inline" style="width: 100px;">
				<select id="role" name="roleId" lay-filter="roleListenr">
					<c:forEach items="${roles}" var="role">
						<option value="${role.id}">${role.name}</option>
					</c:forEach>
				</select>
			</div>
		</div>

		<div id="newSuperior">
			<div class="layui-inline">
				<label class="layui-form-label">上级ID</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="superior" type="text" name="superior" autocomplete="off"
						class="layui-input" value="${userDetails.userId}">
				</div>
			</div>

			<div class="layui-inline">
				<i class="layui-icon layui-icon-edit"
					style="font-size: 30px; color: #1E9FFF;"></i>
			</div>
		</div>
		
		<div>
		<br>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">账号状态</label>
			<div class="layui-input-inline" style="width: 100px;">
				<select id="accountStatus" name="status" lay-verify="">
					<option value="1">正常</option>
					<option value="0">禁止登陆</option>
				</select>
			</div>
		</div>

	</form>
	<!-- 列表内容, form -->
	<script>
		layui.use([ 'form', 'layer', 'table' ], function() {
			var table = layui.table, form = layui.form, $ = layui.$;
			var element = layui.element;


			$(document).ready(
					function() {
						//回显后台获取的角色，以及帐号状态（正常/禁止登陆）
						var key = "${userDetails.roleId}";
						var flag = "${userDetails.status}";
						//根据值让option选中 
						$("#role option[value='" + key + "']").attr("selected",
								"selected");
						$("select[name='status']").prop("value", flag);
					});

			form.render();

		});
	</script>

	<script type="text/javascript">
		function getData() {
			var id = document.getElementById("id").value;
			
			var obj = document.getElementById("role"); //定位id
			var index = obj.selectedIndex; //获取选中的索引
			var roleId = obj.options[index].value; //获取选中的文本
			
			
			var superior = document.getElementById("superior").value;
			
			var status = document.getElementById("accountStatus").value;
			
			
			var data = {"id":id,"roleId":roleId,"userId":superior, "status":status};
			return data;
		}
	</script>
</body>


</html>