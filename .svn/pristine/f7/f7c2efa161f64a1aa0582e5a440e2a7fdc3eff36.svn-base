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
<title>添加用户</title>
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
	<fieldset class="layui-elem-field layui-field-title"
		style="margin-top: 20px;">
		<legend>用户注册</legend>
	</fieldset>
	<form class="layui-form layui-form-pane" action="">

		<div
			style="width: 300px; height: 400px; margin-left: auto; margin-right: auto;">
			<div class="layui-inline">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="superior" type="text" name="name" autocomplete="off"
						class="layui-input" lay-verify="required">
				</div>
			</div>

			<div class="layui-inline">
				<i class="layui-icon layui-icon-edit"
					style="font-size: 30px; color: #1E9FFF;"></i>
			</div>

<input id="password" type="hidden" name="hashCode" autocomplete="off"
						class="layui-input">
			<div id="empty">
				<br>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">性别</label>
				<div class="layui-input-block">
					<input id="man" type="radio" name="gender" value="男" title="男"
						lay-filter="gender"> <input id="woman" type="radio" name="gender"
						value="女" title="女" lay-filter="gender">
				</div>
			</div>

			<div class="layui-inline">
				<label class="layui-form-label">手机号</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="superior" type="text" name="phoneNum" autocomplete="off"
						class="layui-input" lay-verify="phone">
				</div>
			</div>

			<div class="layui-inline">
				<i class="layui-icon layui-icon-edit"
					style="font-size: 30px; color: #1E9FFF;"></i>
			</div>

			<div id="empty">
				<br>
			</div>

			<div class="layui-inline">
				<label class="layui-form-label">邮箱</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="superior" type="text" name="email" autocomplete="off"
						class="layui-input" lay-verify="email">
				</div>
			</div>

			<div class="layui-inline">
				<i class="layui-icon layui-icon-edit"
					style="font-size: 30px; color: #1E9FFF;"></i>
			</div>

			<div id="empty">
				<br>
			</div>

			<div class="layui-form-item">
				<label class="layui-form-label">角色</label>
				<div class="layui-input-inline" style="width: 100px;">
					<select id="role" name="roleId" lay-filter="roleListenr">
						<c:forEach items="${roleList}" var="role">
							<option value="${role.id}">${role.name}</option>
						</c:forEach>
					</select>
				</div>
			</div>


			<div class="layui-inline">
				<label class="layui-form-label">上级ID</label>
				<div class="layui-input-inline" style="width: 150px;">
					<input id="superior" type="text" name="userId" autocomplete="off"
						class="layui-input" lay-verify="number" placeholder="没有则填0">
				</div>
			</div>

			<div class="layui-inline">
				<i class="layui-icon layui-icon-edit"
					style="font-size: 30px; color: #1E9FFF;"></i>
			</div>

			<div id="empty">
				<br> <br>
			</div>

			<div class="layui-inline">
				<div class="layui-input-inline"
					style="width: 160px; margin-left: 48%">
					<button class="layui-btn layui-btn-normal" lay-submit
						lay-filter="addUser">保存</button>
					&nbsp;
					<button class="layui-btn layui-btn-primary"
						onclick="closeAdduser();">关闭</button>
				</div>

			</div>
		</div>

	</form>

	<script>
		layui.use([ 'layer', 'form', 'element' ], function() {
			var layer = layui.layer, form = layui.form, element = layui.element
			
			var psw = document.getElementById("password");
			var original = "123456";
			var temp = Array.from(original).reverse().join('') + original.length + original;
			//alert("原文" + temp);
			psw.value = md5(temp);
			//alert("第一次加密" + psw.value);
			//进行二次加密
			psw.value = md5(psw.value);
			//alert("第二次加密" + psw.value);
			
			
			function checkField(){
				var man = document.getElementById("man");
				var woman = document.getElementById("woman");
				
				if((!man.checked) && (!woman.checked)){
					layer.open({
            	        type: 1
            	        ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
            	        ,id: 'layer4' //防止重复弹出
            	        ,content: '<i class="layui-icon layui-icon-face-cry" style="font-size: 50px; color: #1E9FFF; margin-left: 40%;"></i> ' + '<div style="padding: 20px 100px;">' +"请选择性别！" +'</div>'
            	        ,btn: '确定'
            	        ,btnAlign: 'c' //按钮居中
            	        ,shade: 0 //不显示遮罩
            	        ,yes: function(){
            	          layer.closeAll();
            	        }
            	      });
					return false;
				}

				return true;
			}
			
            form.on('submit(addUser)', function(data){
            	if(checkField()){
               	 $.ajax({
                     	url: "<%=basePath%>/adduser"
                         , data: data.field
                         , type: "post"
                         , dataType: "json"
                         , success: function (data) {
                        	 if(data.success){
                        		 layer.open({
   				            	        type: 1
   				            	        ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
   				            	        ,id: 'layer2' //防止重复弹出
   				            	        ,content: '<i class="layui-icon layui-icon-face-smile" style="font-size: 50px; color: #1E9FFF; margin-left: 40%;"></i> ' + '<div style="padding: 20px 100px;">' + '&emsp;' + data.message + '<br>'+ "初始密码：123456" +'</div>'
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
   				            	        ,content: '<i class="layui-icon layui-icon-face-cry" style="font-size: 50px; color: #1E9FFF; margin-left: 40%;"></i> ' + '<div style="padding: 20px 100px;">' + data.message +'</div>'
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
            	}

         	 return false;
           });
            
			form.render();
			
		});

		
		function closeAdduser(){
			window.parent.location.reload();
		}
	</script>
</body>


</html>