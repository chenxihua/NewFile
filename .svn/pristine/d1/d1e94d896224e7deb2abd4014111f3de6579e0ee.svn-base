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
  <title>服务再分配页面</title>  
  <meta name="renderer" content="webkit">
  <link rel="stylesheet" href="<%=basePath%>common/layui-v2.3.0/css/layui.css"  media="all">
  <script type="text/javascript" src="<%=basePath%>common/layui-v2.3.0/layui.js"></script>     
</head>
<body>

 <form class="layui-form" >  
  <div class="layui-form-item">
    <div class="layui-input-inline">
      <input type="hidden" name="id" value="${service.id}" autocomplete="off" class="layui-input">
    </div>
  </div>  
  <div style="text-align:center;">
  	确认将编号为${service.id}的服务再分配?      
  </div>
  <br><br><br><br>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="affirmativeDemo">是</button>
      <button class="layui-btn" lay-submit lay-filter="negativeDemo">否</button>
    </div>
  </div>
 </form>
 
<script>
layui.use('form', function(){
	var form = layui.form;
	var $ = layui.$;
	
	//监听提交
	form.on('submit(affirmativeDemo)', function(data){
		$.post("<%=basePath %>service/reAssignService.action",data.field,function(ret){
			if(ret.msg){
				layer.msg("服务再分配成功", {time: 500});	
				//设置为延迟执行				
				setTimeout( function() {
					//先得到当前iframe层的索引
					var index = parent.layer.getFrameIndex(window.name); 
					parent.layer.close(index);
				}, 500 );
			}else{
				layer.msg( ret.info, {time: 1500});
			}
		},'json');
		return false;
	});
	
	//监听提交
	form.on('submit(negativeDemo)', function(data){
		var index = parent.layer.getFrameIndex(window.name); 
		parent.layer.close(index);
	});
});
</script>
  
</body>
</html>
