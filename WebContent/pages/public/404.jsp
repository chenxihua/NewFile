<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>404</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>transfer/css/layui.css" media="all">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script src="<%=basePath%>common/layui-v2.3.0/layui.js" charset="utf-8"></script>
</head>
<body class="childrenBody">
	<div style="text-align: center; padding: 11% 0;">
		<i class="layui-icon"
			style="line-height: 20rem; font-size: 20rem; color: #393D50;"></i>
		<p style="font-size: 20px; font-weight: 300; color: #999;">我勒个去，网页走丢了!</p>
	</div>
	<div class="layui-form" align="center" style="margin-top: -100px;">
		<button class="layui-btn layui-btn-normal" lay-submit
			lay-filter="turnback">返回</button>
	</div>

	<script>
		layui.use([ 'layer', 'form', 'element' ], function() {

			var layer = layui.layer, form = layui.form, element = layui.element

			form.on('submit(turnback)', function(data) {
				window.location.href='<%=basePath%>index';
				return false;
			});
		});
	</script>
</body>
</html>