<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>重置密码</title>

<%
	String basePath = request.getContextPath() + "/";
%>
<base href="<%=basePath%>" />

<link rel="stylesheet"
	href="<%=basePath%>common/slide/layui/css/layui.css" media="all">
<link rel="stylesheet"
	href="<%=basePath%>common/slide/layui/css/admin.css" media="all">
<link rel="stylesheet" href="<%=basePath%>common/slide/step/step.css"
	media="all">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/md5.min.js"></script>

</head>
<body>
	<div class="layui-step">
		<div class="layui-step-content layui-clear"
			style="background-color: white;">
			<!-- 填写帐号 -->
			<div class="layui-step-content-item layui-form-item"
				style="font-size: 18px; color: black;">
				<div class="layui-inline"
					style="margin-left: 33px; margin-top: 40px;">
					<label class="layui-form-label">输入帐号</label>
					<div class="layui-input-inline" style="width: 200px;">
						<input id="account" type="text" name="name" autocomplete="off"
							class="layui-input" placeholder="用户名/邮箱/手机号" value="${name}">
					</div>
				</div>
			</div>

			<!-- 验证帐号 -->
			<div class="layui-step-content-item layui-form-item"
				style="font-size: 18px; color: black;">
				<div class="layui-inline"
					style="margin-left: 32px; margin-top: 16px;">
					<label class="layui-form-label">邮箱</label>
					<div class="layui-input-inline" style="width: 200px;">
						<label id="showEmail" class="layui-form-label"
							style="width: 230px;margin-left: -100px;color: gray; font-size: 15px;"></label>
					</div>

					<input id="sendEmail" type="button"
						class="layui-btn layui-btn-sm layui-btn-normal" value="获取验证码"
						onclick="settime(this)" style="margin-top: 3px;"/>
				</div>
				
				<div class="layui-inline"
					style="margin-left: 48px; margin-top: 28px;">
					<label class="layui-form-label">验证码</label>
					<div class="layui-input-inline" style="width: 200px;">
						<input id="emailCode" type="text" name="name" autocomplete="off"
							class="layui-input" style="width: 115px;margin-left: 6px;">
					</div>

				</div>
			</div>

			<!-- 重置密码 -->
			<div class="layui-step-content-item layui-form-item"
				style="font-size: 18px; color: black;">
				<div class="layui-inline"
					style="margin-left: 33px; margin-top: 12px;">
					<label class="layui-form-label">新密码</label>
					<div class="layui-input-inline" style="width: 200px;">
						<input id="passwordBefore" type="password" name="name" autocomplete="off"
							class="layui-input">
					</div>
				</div>
				<div class="layui-inline"
					style="margin-left: 33px; margin-top: 10px;">
					<label class="layui-form-label">确认密码</label>
					<div class="layui-input-inline" style="width: 200px;">
						<input id="passwordAfter" type="password" name="name" autocomplete="off"
							class="layui-input">
					</div>
				</div>
			</div>

			<!-- 完成 -->
			<div class="layui-step-content-item layui-form-item"
				style="font-size: 18px; color: black;">
				<div class="layui-inline"
					style="margin-left: 100px; margin-top: 32px;">
					<i class="layui-icon layui-icon-face-smile" style="font-size: 46px; color: green;"></i> 
					<div class="layui-input-inline" style="width: 180px;">
						<label class="layui-form-label" style="margin-top: -70px;margin-left: -60px;margin-top: -42px; width: 100px;font-size: 22px;color: #1bbc9b">修改成功</label>
					</div>
				</div>
			</div>
			
			
		</div>
		<div class="layui-step-btn"
			style="width: 250px; margin-left: auto; margin-right: auto; margin-top: -20px;">
			<div class="layui-btn-group">
				<!-- <button class="layui-btn prev">上一步</button> -->
				<button id="nextStep" class="layui-btn next">下一步</button>
			</div>
		</div>
	</div>
	<script src="<%=basePath%>common/slide/layui/layui.js"></script>

	<script>
        
        layui.config({
            base: "<%=basePath%>common/slide/layui/lay/mymodules/"
		}).use([ 'form', 'layer', 'jquery', 'step' ], function() {
			var $ = layui.jquery;
			var step = layui.step;
			var form = layui.form;
			var layer = layui.layer;
			
			//判断是修改密码进入还是忘记密码进入
			//如果是修改密码，则账号输入框不可编辑
			if($("#account").val() != ""){
				$("#account").attr("disabled",true);
			}
			
			step.render({
				elem : '.layui-step',
				title : [ "填写帐号", "验证帐号", "重置密码", "完成" ],
				// description: ["aaa","bbb","ccc","ddd"],
				currentStep: 1,
				canIconClick : false,
			});
			$(".prev").on("click", function() {
				step.prev();
			})
			$(".next").on("click", function() {
				
				if($("#nextStep").text() == "完成"){
					window.parent.location.reload();
				}
				
				
				
				if(step.currentStep == 1){
					var account = $("#account").val();
					if(account == ""){
						layer.msg("请输入账号");
					}else{
						$.ajax({
				            url:"<%=basePath%>queryemail"
				            ,data: {'name' : account}
				            ,type:"Post"
				            ,dataType:"json"
				            ,success: function (data) {
				            	if(data.success){
				            		$("#showEmail").html(data.showEmail);
				    				step.next();
				            	}else{
				            		layer.msg("用户不存在");
				            		return false;
				            	}
	                         },
				            error:function(){
				                alert("错误");
				            }
				        });
					}
					
				}
				
				if(step.currentStep == 2){
					
					var emailCode = $("#emailCode").val();
					if(emailCode == ""){
						layer.msg("请输入验证码！");
					}else{
						//如果验证码校验正确，进入下一步重置密码，如果不正确，则提示验证码错误！
						$.ajax({
				            url:"<%=basePath%>checkemailcode"
				            ,type:"Post"
				            ,data:{'emailcode': emailCode}
				            ,contentType: "application/json"
				            ,dataType:"json"
				            ,success: function (data) {
				            	if(data.success){
				            		layer.msg("验证成功！",{
				            			  icon: 1,
				            			  time: 1100 //2秒关闭（如果不配置，默认是3秒）
				            			});
				            		
				            		//1秒后跳转到重置密码页面
				            		setTimeout(function(){step.next();},1500);
				            		
				            	}
				            	else{
				            		layer.msg("验证码不正确");
				            	}
		                     },
				            error:function(){
				                alert("错误");
				            }
				        });
					}
					
					
				}
				
				if(step.currentStep == 3){
					//把两次输入的进行非空验证，对比验证
					var pswBefore = $("#passwordBefore").val();
					var pswAfter = $("#passwordAfter").val();
					
					if(pswBefore == ""){
						layer.msg("请输入密码");
					}
					else if(pswAfter == ""){
						layer.msg("请输入确认密码");
					}else if((pswBefore.length < 6) || (pswAfter.length < 6)){
						layer.msg("密码长度不得少于6位")
					}
					else if(pswBefore != pswAfter){
						layer.msg("两次输入的密码不一致");
					}else{
						
						//验证成功，进行加密，并返回给控制器
						var temp = Array.from(pswBefore).reverse().join('') + pswAfter.length + pswAfter;
						//alert("原文" + temp);
						var password;
						password = md5(temp);
						//alert("第一次加密" + password);
						//进行二次加密
						password = md5(password);
						//alert("第二次加密" + password);
						
						//使用ajax请求，更新用户的密码
						$.ajax({
				            url:"<%=basePath%>alterpassword"
				            ,type:"Post"
				            ,data: {'password': password}
				            ,contentType: "application/json"
				            ,dataType:"json"
				            ,success: function (data) {
				            	if(data.success){
				            		$("#nextStep").text("完成");
				            		step.next();
				            	}
				            	else{
				            		layer.msg("修改失败");
				            	}
		                     },
				            error:function(){
				                alert("错误");
				            }
				        });
					}
					
				}
				
				
			})
			
		});
	</script>

	<script type="text/javascript">
		var countdown = 300;
		var flag = 1;
		function settime(obj) {
			if (countdown == 0) {
				flag = 1;
				obj.removeAttribute("disabled");
				obj.value = "获取验证码";
				countdown = 300;
				$("#sendEmail").css('background-color','#1E9FFF');
				return;
			} else {
				
				obj.setAttribute("disabled", true);
				obj.value = "重新发送(" + countdown + ")";
				countdown--;
				$("#sendEmail").css('background-color','gray');
				
				if(flag != 0){
					$.ajax({
			            url:"<%=basePath%>sendemail"
			            ,type:"Post"
			            ,dataType:"json"
			            ,success: function (data) {
			            	if(!data.success){
			            		layer.msg("验证码发送失败");
			            	}
			            	else{
			            		layer.msg("验证码发送成功");
			            	}
	                     },
			            error:function(){
			                alert("错误");
			            }
			        });
				}
				flag = 0;
				
			}
			setTimeout(function() {
				settime(obj)
			}, 1000)
		}
	</script>
</body>
</html>