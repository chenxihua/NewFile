<%@page import="com.mysql.fabric.xmlrpc.base.Data"%>
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
<title>个人信息页面</title>
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

	<form class="layui-form layui-form-pane" action="">
		<fieldset class="layui-elem-field layui-field-title"
			style="margin-top: 50px;">
			<legend>个人信息</legend>
		</fieldset>


		<div class="layui-form-item">
		<input type="hidden" name="id" value="${user.id}">
			<div class="layui-inline">
				<label class="layui-form-label">用户名</label>
				<div class="layui-input-inline">
					<input type="text" name="name" autocomplete="off"
						class="layui-input" value="${user.name}" disabled>
				</div>
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-block">


				<input type="radio" name="gender" value="男" title="男"
					lay-filter="gender"> <input type="radio" name="gender"
					value="女" title="女" lay-filter="gender">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">直属上级</label>
			<div class="layui-input-inline">
				<input type="text" autocomplete="off"
					class="layui-input" value="${superior}" disabled>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">手机号</label>
				<div class="layui-input-inline">
					<input type="text" name="phoneNum" autocomplete="off"
						class="layui-input" lay-filter="phone" value="${user.phoneNum}">
				</div>
			</div>
			<div class="layui-inline">
				<i class="layui-icon layui-icon-edit"
					style="font-size: 30px; color: #1E9FFF;"></i>
			</div>
		</div>

		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">邮箱</label>
				<div class="layui-input-inline">
					<input type="text" name="email" autocomplete="off"
						class="layui-input" lay-filter="email" value="${user.email}">
				</div>
			</div>
			<div class="layui-inline">
				<i class="layui-icon layui-icon-edit"
					style="font-size: 30px; color: #1E9FFF;"></i>
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">上次登录</label>
			<div class="layui-input-inline">
				<input type="text" autocomplete="off"
					class="layui-input" value="${lastLogin}" disabled>
			</div>
		</div>
		<br>
		<div class="layui-form-item" style="margin-left: 6%;">
			<div class="layui-inline">
					<!-- <button class="layui-btn" onclick="forgetPsw();">修改密码</button> -->
			<a class="layui-btn" href="javascript:forgetPsw();">修改密码</a>
			</div>
			<div class="layui-inline">
					<button class="layui-btn" lay-submit="" lay-filter="saveInfo">保存</button>
			</div>
		</div>
	</form>

	<script type="text/javascript">
		layui.use([ 'layer', 'form', 'element' ], function() {
			var layer = layui.layer, form = layui.form, element = layui.element

			var sex = "${user.gender}";
			$("input[name='gender'][value=" + sex + "]").prop("checked", true);

			
			
            form.on('submit(saveInfo)', function(data){
            	 $.ajax({
                     	url: "<%=basePath%>/alteruserinfo"
                         , data: data.field
                         , type: "post"
                         , dataType: "json"
                         , success: function (data) {
                        	 if(data.result){
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
			
			form.render();
			//……
			//你的js/jquery代码都应该写在这里面
					
		});
	</script>
	
	<script type="text/javascript">
	function forgetPsw(){
		layui.use([ 'layer', 'form', 'element' ], function() {
			var layer = layui.layer, form = layui.form, element = layui.element
			var url = '<%=basePath%>pages/public/retrievepassword.jsp?';
			layer.open({
				type : 2,
				title : '找回密码',
				closeBtn : 1,
				id : 'retrievePsw',
				area : [ '430px', '380px' ],
				/* skin : "layui-layer-molv", */
				/* skin: 'layui-layer-lan', */
				skin: 'layui-layer-molv', //加上边框
				anim: 5,
				content : url,
				end : function() {
					layer.closeAll();
				}
			});
		});
	}
	
	</script>

</body>


</html>