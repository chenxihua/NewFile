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
  <title>创建服务</title>  
  <meta name="renderer" content="webkit">
  <link rel="stylesheet" href="<%=basePath%>common/layui-v2.3.0/css/layui.css"  media="all">
  <script type="text/javascript" src="<%=basePath%>common/layui-v2.3.0/layui.js"></script>     
</head>
<body>

 <form class="layui-form" action="" method="post" name="myForm">  
  
  <div class="layui-form-item">
    <label class="layui-form-label">服务编号</label>
    <div class="layui-input-block">
      <input type="text" name="id" value="${service.id}"  readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>  
  
  <div class="layui-form-item">
    <label class="layui-form-label">服务类型</label>
    <div class="layui-input-block">
      <input type="text" name="type" value="${service.serviceType.typeName}"  readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div> 
  
  <div class="layui-form-item">
    <label class="layui-form-label">客户</label>
    <div class="layui-input-block">
      <input type="text" name="clientId" value="${service.client.name}"  readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>  
  
  <div class="layui-form-item">
    <label class="layui-form-label">联系方式</label>
    <div class="layui-input-block">
      <input type="text" name="contactWay" value="${service.contactWay}"  readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>  

  <div class="layui-form-item">
    <label class="layui-form-label">服务概要</label>
    <div class="layui-input-block">
      <input type="text" name="content" value="${service.content}"  readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div> 
  
  <div class="layui-form-item">
    <label class="layui-form-label">服务请求</label>
    <div class="layui-input-block">
      <input type="text" name="request" value="${service.request}"  readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>   
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">创建人</label>
    <div class="layui-input-block">
      <input type="text" name="creatorUser.name" value="${service.creatorUser.name}"  readonly="true" autocomplete="off" class="layui-input">      
    </div>
  </div>
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">创建时间</label>
    <div class="layui-input-block">
      <input type="text" name="createTime" value="${createTime}" readonly="true" autocomplete="off" class="layui-input">      
    </div>
  </div>
    
  <div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <input type="text" name="status" value="${status}" readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>  

  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">分配人</label>
    <div class="layui-input-block">
      <input type="text" name="assignerUser.name" value="${service.assignerUser.name}"  readonly="true" autocomplete="off" class="layui-input">      
    </div>
  </div>
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">分配时间</label>
    <div class="layui-input-block">
      <input type="text" name="assignTime" value="${assignTime}"  readonly="true" autocomplete="off" class="layui-input">      
    </div>
  </div>
      
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">处理人</label>
    <div class="layui-input-block">
      <input type="text" name="handlerUser.name" value="${service.handlerUser.name}"  readonly="true" autocomplete="off" class="layui-input">      
    </div>
  </div>
    
  <div class="layui-form-item">
    <label class="layui-form-label">服务处理</label>
    <div class="layui-input-block">
      <input type="text" name="handle" value="${service.handle}" readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div> 
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">处理时间</label>
    <div class="layui-input-block">
      <input type="text" name="handleTime" value="${handleTime}"  readonly="true" autocomplete="off" class="layui-input">      
    </div>
  </div>  
    
  <div class="layui-form-item">
    <label class="layui-form-label">客户满意度</label>
    <div class="layui-input-block">
      <input type="text" name="satisfaction" value="${service.satisfaction}" readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">处理结果</label>
    <div class="layui-input-block">
      <input type="text" name="result" value="${service.result}" readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">客户评价</label>
    <div class="layui-input-block">
      <input type="text" name="result" value="${service.comment}" readonly="true" autocomplete="off" class="layui-input">
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
