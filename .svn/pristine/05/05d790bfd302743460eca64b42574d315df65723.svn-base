<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发送邮件</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">

</head>
<body>

<br><br>
<form class="layui-form" action="" lay-filter="example">
	
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">发送人</label>
      <div class="layui-input-inline">
        <input type="text" name="to" id="to" placeholder="xxxxxx@qq.com" lay-verify="required|email" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">发送标题</label>
    <div class="layui-input-block">
      <input type="text" name="titles" id="titles" lay-verify="required" autocomplete="off" placeholder="请输入内容标题" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">发送内容</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入具体发送内容" id="contents" class="layui-textarea" name="contents"></textarea>
    </div>
  </div>
  
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn layui-btn-ms" name="demo1" lay-submit lay-filter="demo1">发送邮件</button>
      <button type="reset" class="layui-btn layui-btn-primary layui-btn-ms">重置表单</button>
    </div>
  </div>
</form>


<script type="text/javascript" src="layui/layui.js"></script>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form;
  var layer = layui.layer;
  var layedit = layui.layedit;
  var $ = layui.$;
  
  var indexs = layedit.build('contents'); //建立编辑器
	//点击保存事件
	form.on('submit(demo1)',function(data){
		
	    var to = $("#to").val();
	    var titles = $("#titles").val();
	    var contents = layedit.getContent(indexs);
	    layedit.sync(indexs);
	    $.ajax({
	        type: "POST",
	        url: "send/sendEmails",
	        data: {"to":to,"titles":titles,"contents":contents},
	        dataType: "json",
	        success: function(data){
	        	top.layer.msg(data.msg+"，请继续操作");
	        	$("input").val("");
	        	$("textarea").val("");
	        },
	        error:function(){
	            top.layer.msg("服务器开小差了，请稍后再试...");
	        }
	   });
	   return false; 
	});
    
});
</script> 


</body>
</html>