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
  <div class="layui-form-item">
    <label class="layui-form-label">编号</label>
    <div class="layui-input-block">
      <input type="text" name="id" value="${outflow.id}"  readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>  
  
  <div class="layui-form-item">
    <label class="layui-form-label">客户</label>
    <div class="layui-input-block">
      <input type="text" name="client.name" value="${outflow.client.name}"  readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div> 
  
  <div class="layui-form-item">
    <label class="layui-form-label">客户经理</label>
    <div class="layui-input-block">
      <input type="text" name="handlerUser.name" value="${outflow.handlerUser.name}"  readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>  
  
  <div class="layui-form-item">
    <label class="layui-form-label">暂缓时间</label>
    <div class="layui-input-block">
      <input type="text" name="handleTime" value="${handleTime}"  readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>  

  <div class="layui-form-item">
    <label class="layui-form-label">暂缓措施</label>
    <div class="layui-input-block">
      <input type="text" name="deferMeasure" value="${outflow.deferMeasure}"  readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div> 
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="font-size: 13px;">最后下单时间</label>
    <div class="layui-input-block">
      <input type="text" name="lastOrderTime" value="${lastOrderTime}"  readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>   
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label" style="font-size: 13px;">确认流失时间</label>
    <div class="layui-input-block">
      <input type="text" name="outflowTime" value="${outflowTime}"  readonly="true" autocomplete="off" class="layui-input">      
    </div>
  </div>
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">流失原因</label>
    <div class="layui-input-block">
      <input type="text" name="reason" value="${outflow.reason}" readonly="true" autocomplete="off" class="layui-input">      
    </div>
  </div>
    
  <div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <input type="text" name="status" value="${status}" readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>  

  
    
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
