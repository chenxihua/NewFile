<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>客户流失详情</title>  
  <meta name="renderer" content="webkit">
  <link rel="stylesheet" href="<%=basePath%>common/layui-v2.3.0/css/layui.css"  media="all">
  <script type="text/javascript" src="<%=basePath%>common/layui-v2.3.0/layui.js"></script>     
</head>
<body>

<form class="layui-form" action="" method="post" name="myForm">  
  	<c:if test="${info1!=null}">
  	 	<br>
  		<br>
  		<br>
  		<br>
  		<br>
		<div style="text-align:center; font-size: 20px;">${info1}</div>
		<br>
		<br>		
		<div style="text-align:center; font-size: 15px;">${info2}</div>
	</c:if>  
  
  <br>
  <br>
  <br>
  <br>
  <br>
  <br>
  <br> 
  <br>
  <br>
  <br>
  <br>
  <br>

  <div class="layui-form-item">
    <div class="layui-input-block">
    	<button class="layui-btn" style="margin-left: 80px;" lay-submit lay-filter="formDemo">关闭</button>    	    	
    </div>    
  </div>
</form>
 
<script>

layui.use('form', function(){
	var form = layui.form;
	var $ = layui.$;
	 
	//监听提交
	form.on('submit(formDemo)', function(data){
		var index = parent.layer.getFrameIndex(window.name); 
		parent.layer.close(index);
	});
});

</script>
  
</body>
</html>
