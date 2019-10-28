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
  <title>暂缓流失</title>  
  <meta name="renderer" content="webkit">
  <link rel="stylesheet" href="<%=basePath%>common/layui-v2.3.0/css/layui.css"  media="all">
  <script type="text/javascript" src="<%=basePath%>common/layui-v2.3.0/layui.js"></script>     
</head>
<body>

 <form class="layui-form" action="" method="post" name="myForm">  
  <div class="layui-form-item">
    <label class="layui-form-label">编号</label>
    <div class="layui-input-block">
      <input type="text" name="id" value="${outflow.id}" style="color:#c2c2c2;" readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>  
  
  <div class="layui-form-item">
    <label class="layui-form-label">客户</label>
    <div class="layui-input-block">
      <input type="text" name="" value="${outflow.client.name}" style="color:#c2c2c2;" readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div> 
  
  <div class="layui-form-item">
    <label class="layui-form-label">客户经理</label>
    <div class="layui-input-block">
      <input type="text" name="" value="${outflow.handlerUser.name}" style="color:#c2c2c2;" readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>  
  
  <div class="layui-form-item">
    <label class="layui-form-label" style="font-size: 13px;">最后下单时间</label>
    <div class="layui-input-block">
      <input type="text" name="" value="${outflow.lastOrderTime}" style="color:#c2c2c2;" readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>   
       
  <div class="layui-form-item">
    <label class="layui-form-label">状态</label>
    <div class="layui-input-block">
      <input type="text" name="" value="${outflow.status}" style="color:#c2c2c2;" readonly="true" autocomplete="off" class="layui-input">
    </div>
  </div>  
    
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">暂缓措施</label>
    <div class="layui-input-block">
      <textarea name="deferMeasure" class="layui-textarea" lay-verify="required">${outflow.deferMeasure}</textarea>
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
//document.forms.myForm.createTime.value = myTimeConverter( ${service.createTime} );
layui.use('form', function(){
	var form = layui.form;
	var $ = layui.$;
	
	//监听提交
	form.on('submit(formDemo)', function(data){
		$.post("<%=basePath %>outflow/deferOutflow.action",data.field,function(ret){
			if(ret.msg){
				layer.msg("提交成功", {time: 500});	
				//设置为延迟执行				
				setTimeout( function() {
					//先得到当前iframe层的索引
					var index = parent.layer.getFrameIndex(window.name); 
					parent.layer.close(index);
				}, 500 );
			}else{
				layer.msg("提交失败", {time: 500});
			}
		},'json');
		return false;
	});
		
});

//时间格式转换
function myTimeConverter(v){
	var date = new Date(v);
	var y = date.getFullYear();
	var m = date.getMonth()+1;
	m = m<10?'0'+m:m;
	var d = date.getDate();
	d = d<10?("0"+d):d;
	var H = date.getHours();
	H = H<10?'0'+H:H;
	var M = date.getMinutes();
	M = M<10?'0'+M:M;
	var S = date.getSeconds();
	S = S<10?'0'+S:S;

	var str = y+"-"+m+"-"+d+" "+H+":"+M+":"+S;
	return str;
}
</script>
  
</body>
</html>
