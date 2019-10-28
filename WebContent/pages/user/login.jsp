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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<base href="<%=request.getContextPath() + "/"%>">
<link rel="shortcut icon" href="img/favicon.png">

<title>CRM登录页面</title>

<!-- Bootstrap CSS -->
<link href="css/bootstrap/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap theme -->
<link href="css/bootstrap/bootstrap-theme.css" rel="stylesheet">
<!--external css-->
<!-- font icon -->
<link href="css/bootstrap/elegant-icons-style.css" rel="stylesheet" />
<link href="css/bootstrap/font-awesome.css" rel="stylesheet" />
<!-- Custom styles -->
<link href="css/bootstrap/style.css" rel="stylesheet">
<link href="css/bootstrap/style-responsive.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="js/md5.min.js"></script>

<link rel="stylesheet"
	href="common/layui-v2.3.0/css/layui.css" media="all">
<script src="common/layui-v2.3.0/layui.js" charset="utf-8"></script>
<!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
<!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

<body class="login-img3-body">

	<div class="container">

		<form id="submitValid" class="login-form" action="index" method="post"
			onsubmit="return doSubmit()">
			<div class="login-wrap">
				<p class="login-img">
					<i class="icon_lock_alt"></i>
				</p>
				<span id="loginMsg" style="color: red">${loginError}</span>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon_profile"></i></span>
					<input id="userName" name="account" type="text" class="form-control"
						placeholder="用户名/手机/邮箱" autofocus>
				</div>
				<span id="userMsg"></span>
				<div class="input-group">
					<span class="input-group-addon"><i class="icon_key_alt"></i></span>
					<input id="pwd" type="password" class="form-control"
						placeholder="密码">
					<!-- 隐藏表单域，存放加密后的密码 -->
					<input type='hidden' name="password" id='md5_pwd' />
				</div>
				<span id="pwdMsg"></span>
				<div class="input-group" id="validCode">
					<span class="input-group-addon"><i id="testa"
						class="icon_target"></i></span> <input id="valid" name="validCode"
						type="text" class="form-control" style="width: 40%"
						placeholder="验证码">&emsp;&emsp; <img id="validImg"
						alt="" src="getGifCode" style="width: 40%; height: 40px">
				</div>
				<span id="codeMsg">${validResult}</span> <label class="checkbox"> <input
					type="checkbox" value="remember-me"> 记住我 <span
					class="pull-right"> <a href="javascript:forgetPsw();"> 忘记密码?</a>
				</span>
				</label>
				<button id="sub" class="btn btn-primary btn-lg btn-block"
					type="submit">登陆</button>
			</div>
		</form>

	</div>

	<script type="text/javascript">
		jQuery(document).ready(
		//点击图片刷新验证码，进行图片的替换、同时清空验证码输入框
		function() {
			//验证码
			$("#validCode").on("click", 'img', function() {
				var i = new Image();
				i.style.width = '40%';
				i.style.height = '40px';
				i.src = 'getGifCode.action?' + Math.random();
				$(i).replaceAll(this);
				//清空输入框内容
				$("#valid").val("");
				$("#codeMsg").text("");

			});
		});

		//验证码输入框获得焦点的时候，隐藏验证码提示
		$(document).ready(function() {
			$("#valid").focus(function() {
				$("#codeMsg").text("");
				$("#loginMsg").text("");
			});
			$("#userName").focus(function() {
				$("#userMsg").text("");
			});
			$("#pwd").focus(function() {
				$("#pwdMsg").text("");
				$("#loginMsg").text("");
				//输入密码的时候更新一次验证码
				changeCode();
			});
		});

		//验证码的即时提示
		//动态事件绑定（监听失去焦点事件）
		//动态事件绑定

		$(document).ready(function() { //监听文档是否加载完毕
			$("#valid").blur(function() { //文档加载完毕后，监听失去焦点事件
				//1.获取valid的值
				var tempCode = $("#valid").val();
				if((tempCode.length != 4)|| (tempCode == "")){
					$("#codeMsg").text("验证码格式不正确");
					$("#codeMsg").css("color", "red");
					changeCodeKeepInfoAll();
				}else{
					//使用json发送数据到服务器
					//最后一个函数：回调函数，发送异步请求到服务器,服务器处理完以后返回相关数据，由浏览器自动调用
					$.get("checkvalidcode", {
						"validCode" : tempCode
					}, function(data) {
						//3.服务器返回查询结果后，提示用户
						//var d = eval(data);//把返回的字符串转换成json对象
						var obj = JSON.parse(data);
						if (obj.result) {
							$("#codeMsg").text("验证通过");
							$("#codeMsg").css("color", "green");
						} else {
							$("#codeMsg").text("验证码错误");
							$("#codeMsg").css("color", "red");
							changeCodeKeepInfoAll();
						}
					});
				}
				

			});
		});

		document.onkeydown = function(e) {
			if ((e.keyCode || e.which) == 13) {
				//先失去焦点
				document.getElementById("valid").blur();
				//0.6秒后系统进行提交表单
				setTimeout(function(){document.getElementById("sub").click();},300);
			}
		}

		//按下按回车，失去焦点、提交表单
/* 		document.onkeyup = function(e) {
			if ((e.keyCode || e.which) == 13) {
				//先失去焦点
				//document.getElementById("valid").blur();
				//失去焦点后模拟点击提交按钮
				document.getElementById("sub").click();
			}
		} */

		function changeCode() {
			var img = document.getElementById('validImg');
			img.src = 'getGifCode.action?' + Math.random();
			////清空输入框内容
			$("#valid").val("");
			$("#codeMsg").text(""); 
		}
		function changeCodeKeepInfo() {
			var img = document.getElementById('validImg');
			img.src = 'getGifCode.action?' + Math.random();
			////清空输入框内容
			$("#valid").val("");
		}
		function changeCodeKeepInfoAll() {
			var img = document.getElementById('validImg');
			img.src = 'getGifCode.action?' + Math.random();
		}

		//使用js进行表单的提交
		function doSubmit() {

			var form = document.getElementById('submitValid');
			//获取验证码的状态（验证通过/验证码错误）
			var status = document.getElementById('codeMsg');

			//获取所有input组件
			var account = document.getElementById('userName');
			var input_pwd = document.getElementById('pwd');
			var encrypt_pwd = document.getElementById('md5_pwd');
			var valid_code = document.getElementById('valid');
			//待实现：（做完项目有时间可以使用springmvc验证框架进行验证 BindingResult result）
			//如果账户/密码/验证码为空，返回false
			//否则检查验证码状态，成功则加密提交
			
			//alert("原文" + input_pwd.value);
			if (account.value == "") {
				$("#userMsg").text("账号不能为空");
				$("#userMsg").css("color", "red");
				return false;
			} else {
				$("#userMsg").text("");
			}
			if (input_pwd.value == "") {
				$("#pwdMsg").text("密码不能为空");
				$("#pwdMsg").css("color", "red");
				return false;
			} else {
				$("#pwdMsg").text("");
			}
			if (input_pwd.value.length < 6) {
				$("#pwdMsg").text("密码不能少于6个字符");
				$("#pwdMsg").css("color", "red");
				return false;
			} else {
				$("#pwdMsg").text("");

			}
			if ((valid_code.length < 4) || (valid_code.value == "")) {
				$("#codeMsg").text("验证码格式不正确");
				$("#codeMsg").css("color", "red");
				return false;
			}
			if (status.innerHTML == "验证通过") {
				//只有验证码状态等于验证通过的时候，才加密、提交表单
				var temp = Array.from(input_pwd.value).reverse().join('') + input_pwd.value.length + input_pwd.value;
				
				encrypt_pwd.value = md5(temp);
				//alert("第一次加密" + encrypt_pwd.value);
				//进行二次加密
				encrypt_pwd.value = md5(encrypt_pwd.value);
				//alert("第二次加密" + encrypt_pwd.value);
				return true;
			} else {
				//验证不通过
				changeCodeKeepInfo();
				return false;
			}
		}
		
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