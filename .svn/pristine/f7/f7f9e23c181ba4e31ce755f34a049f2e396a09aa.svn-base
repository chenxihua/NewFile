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
<title>权限管理</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">

<link rel="stylesheet" href="<%=basePath%>transfer/layui/css/layui.css"
	media="all">
<link rel="stylesheet" href="<%=basePath%>transfer/css/cyType.css"
	media="all">
<link rel="stylesheet" href="<%=basePath%>transfer/css/cyStyle.css"
	media="all">
<link rel="stylesheet"
	href="<%=basePath%>transfer/css/font-awesome.min.css" media="all">
<script src="<%=basePath%>transfer/layui/layui.js"
	type="text/javascript" charset="utf-8"></script>
<script src="<%=basePath%>transfer/js/jquery-1.10.2.min.js"
	type="text/javascript" charset="utf-8"></script>

<script src="<%=basePath%>transfer/js/utils.js" type="text/javascript"
	charset="utf-8"></script>
<script src="<%=basePath%>transfer/js/transferTool.js"
	type="text/javascript" charset="utf-8"></script>
<body>
	<div class="layui-input-normal layui-form">
	
	<input type="hidden" name="roleId" value="${authRoleId}">
	
	<br>
		<div cyType="transferTool" cyProps="url:'permissionShuttle'"
			name="description" value="${authorities}" style="margin-left: 10%;"></div>
			
		<div  style="width: 350px;margin-left: 35%;margin-top: -30px;">
		<div class="layui-inline">
			<div class="layui-input-inline" style="width: 100px;">
				<button class="layui-btn layui-btn-normal" lay-submit="" lay-filter="saveAuthority">
				<i class="fa fa-floppy-o">&nbsp;</i>保存
			</button>
			</div>
		</div>
		<div class="layui-inline">
			<div class="layui-input-inline" style="width: 100px;">
				<button class="layui-btn layui-btn-primary" onclick="closeAlterAuth();">
				<i class="fa fa-floppy-o">&nbsp;</i>关闭
			</button>
			</div>
		</div>
		</div>
		
	</div>

	<script>
		layui.use('form', function() {
			var form = layui.form;

			//监听提交///保存或修改
			form.on('submit(saveAuthority)', function(data) {
 			   /* alert(JSON.stringify(data.field));  */
           	 $.ajax({
              	url: "<%=basePath%>alterroleauths"
                  , data: JSON.stringify(data)
                  , type: "post"
                  , contentType: "application/json"
                  , dataType: "json"
                  , success: function (data) {
                 	 if(data.success){
                 		 layer.open({
			            	        type: 1
			            	        ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
			            	        ,id: 'layer2' //防止重复弹出
			            	        ,content: '<i class="layui-icon layui-icon-face-smile" style="font-size: 50px; color: #1E9FFF; margin-left: 40%;"></i> ' + '<div style="padding: 20px 100px;">' +"修改成功" +'</div>'
			            	        ,btn: '确定'
			            	        ,btnAlign: 'c' //按钮居中
			            	        ,shade: 0 //不显示遮罩
			            	        ,yes: function(){
			            	          layer.closeAll();
			            	          window.parent.location.reload();
			            	        }
			            	      });
                 	 }else{
                 		 layer.open({
			            	        type: 1
			            	        ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
			            	        ,id: 'layer3' //防止重复弹出
			            	        ,content: '<i class="layui-icon layui-icon-face-cry" style="font-size: 50px; color: #1E9FFF; margin-left: 40%;"></i> ' + '<div style="padding: 20px 100px;">' +"修改失败" +'</div>'
			            	        ,btn: '确定'
			            	        ,btnAlign: 'c' //按钮居中
			            	        ,shade: 0 //不显示遮罩
			            	        ,yes: function(){
			            	          layer.closeAll();
			            	        }
			            	      });
                 	 }
                  },error:function(data){
                 	 alert("错误");
                  }
          });  
				return false;
			});

		});
	</script>
	<script type="text/javascript">
	
	function closeAlterAuth(){
		 window.parent.location.reload();
	}
	</script>
</body>


</html>