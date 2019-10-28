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
<title>创建角色</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<%=basePath%>common/layui-v2.3.0/css/layui.css" media="all">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/md5.min.js"></script>
<script src="<%=basePath%>common/layui-v2.3.0/layui.js" charset="utf-8"></script>
</head>
<body>

	<form class="layui-form layui-form-pane" action="">

		<div
			style="width: 300px; height: 150px; margin-left: auto; margin-right: auto;margin-top: 8%;">
			<div class="layui-inline">
				<label class="layui-form-label">角色名</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="roleName" type="text" name="name" autocomplete="off"
						class="layui-input" lay-verify="required">
				</div>
			</div>

			<div class="layui-inline">
				<i class="layui-icon layui-icon-edit"
					style="font-size: 30px; color: #1E9FFF;"></i>
			</div>



			<div id="empty">
				<br><br>
			</div>

			<div class="layui-inline">
				<div class="layui-input-inline"
					style="width: 200px; margin-left: 54%">
					<button class="layui-btn layui-btn-normal" lay-submit
						lay-filter="addRole">创建角色</button>
				</div>

			</div>
		</div>

	</form>

	<script>
		layui.use([ 'layer', 'form', 'element' ], function() {
			var layer = layui.layer, form = layui.form, element = layui.element

            form.on('submit(addRole)', function(data){
               	 $.ajax({
                     	url: "<%=basePath%>/addRole",
															data : data.field,
															type : "post",
															dataType : "json",
															success : function(
																	data) {
																if (data.success) {
																	layer
																			.open({
																				type : 1,
																				offset : 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
																				,
																				id : 'layer2' //防止重复弹出
																				,
																				content : 
																					'<div style="padding: 20px 50px;">'
																						+ '&emsp;'
																						+ data.message
																						+ '</div>',
																				btn : '确定',
																				btnAlign : 'c' //按钮居中
																				,
																				shade : 0 //不显示遮罩
																				,
																				yes : function() {
																					layer
																							.closeAll();
																					window.parent.location
																							.reload();
																				}
																			});
																} else {
																	layer
																			.open({
																				type : 1,
																				offset : 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
																				,
																				id : 'layer3' //防止重复弹出
																				,
																				content : '<i class="layui-icon layui-icon-face-cry" style="font-size: 50px; color: #1E9FFF; margin-left: 40%;"></i> '
																						+ '<div style="padding: 20px 100px;">'
																						+ data.message
																						+ '</div>',
																				btn : '确定',
																				btnAlign : 'c' //按钮居中
																				,
																				shade : 0 //不显示遮罩
																				,
																				yes : function() {
																					layer
																							.closeAll();
																				}
																			});
																}
															},
															error : function(
																	data) {
																alert("错误");
															}
														});

												return false;
											});

							form.render();

						});

		function closeAdduser() {
			window.parent.location.reload();
		}
	</script>
</body>


</html>