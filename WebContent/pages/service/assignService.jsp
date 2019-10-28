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
  <title>服务分配页面</title>  
  <meta name="renderer" content="webkit">
  <link rel="stylesheet" href="<%=basePath%>common/layui-v2.3.0/css/layui.css"  media="all">
  <script type="text/javascript" src="<%=basePath%>common/layui-v2.3.0/layui.js"></script>     
</head>
<body>

 <form class="layui-form" >  
  <div class="layui-form-item">
    <label class="layui-form-label">服务编号</label>
    <div class="layui-input-inline">
      <input type="text" name="id" value="${service.id}" style="color:#c2c2c2;" readonly="true" autocomplete="off" class="layui-input">
    </div>
    <label class="layui-form-label">服务类型</label>
    <div class="layui-input-inline">
      <input type="text" value="${service.serviceType.typeName}" style="color:#c2c2c2;" readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div> 
  
  <div class="layui-form-item">
    <label class="layui-form-label">客户</label>
    <div class="layui-input-block">
      <input type="text" value="${service.client.name}" style="color:#c2c2c2;" readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>  

  <div class="layui-form-item">
    <label class="layui-form-label">服务概要</label>
    <div class="layui-input-block">
      <input type="text" value="${service.content}" style="color:#c2c2c2;" readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div> 
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">服务请求</label>
    <div class="layui-input-inline">
      <input type="text" value="${service.request}" style="color:#c2c2c2;" readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">创建人</label>
    <div class="layui-input-inline">
      <input type="text" value="${service.creatorUser.name}" style="color:#c2c2c2;" readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>
  
  <div class="layui-form-item">
    <label class="layui-form-label">分配给</label>
    <div class="layui-input-block">
      <select name="handler" lay-verify="required" lay-search lay-filter="component">
        <option value=""></option>
		<c:forEach items="${users}" var="u">
			<option value="${u.id}">${u.name}</option>
		</c:forEach>
      </select>
    </div>
  </div>      
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
 </form>
 
<script>
layui.use('form', function(){
	var form = layui.form;
	var $ = layui.$;
	
	//监听提交
	form.on('submit(formDemo)', function(data){
		$.post("<%=basePath %>service/assignService.action",data.field,function(ret){
			if(ret.msg){
				layer.msg("分配成功", {time: 500});	
				//设置为延迟执行				
				setTimeout( function() {
					//先得到当前iframe层的索引
					var index = parent.layer.getFrameIndex(window.name); 
					parent.layer.close(index);
				}, 500 );
			}else{
				layer.msg("分配失败", {time: 500});
			}
		},'json');
		return false;
	});
		
});
</script>
  
</body>
</html>
