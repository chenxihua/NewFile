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
  <title>创建服务</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="<%=basePath%>common/layui-v2.3.0/css/layui.css"  media="all">
  <script type="text/javascript" src="<%=basePath%>common/layui-v2.3.0/layui.js"></script>   
  
</head>
  <body>

  <form class="layui-form" >

  
  <div class="layui-form-item">
    <label class="layui-form-label">产品名称</label>
    <div class="layui-input-block">
      <input type="text" name="name" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
    </div>
  </div>  
  
  <div class="layui-form-item">
    <label class="layui-form-label">产品价格</label>
    <div class="layui-input-block">
      <input type="text" name="price" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
    </div>
  </div>  

  <div class="layui-form-item">
    <label class="layui-form-label">库存</label>
    <div class="layui-input-block">
      <input type="text" name="stock" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
    </div>
  </div> 
  
  <div class="layui-form-item">
    <label class="layui-form-label">产品状态</label>
    <div class="layui-input-block">
      <input type="text" name="status" required  lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
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
	  <%--
	  //监听提交
		form.on('submit(formDemo)', function(data){
			$.post("<%=basePath %>/product/addProducts",data.field,function(ret){
				if(ret.msg){
					console.log(ret.msg);
					layer.msg("创建成功", {time: 2000});
					//设置为延迟执行				
					setTimeout( function() {
						//先得到当前iframe层的索引
						var index = parent.layer.getFrameIndex(window.name); 
						parent.layer.close(index);
					}, 2000 );
				}else{
					layer.msg("创建失败", {time: 2000});
				}
			},'json');
			return false;
		});
		  --%>
	  
	   //监听提交(2)
	   form.on('submit(formDemo)', function(data){
	      var formdata = data.field;
	      console.log(formdata);
	      $.ajax({
	          url : "<%=basePath%>/product/addProducts",
	          type : 'post',
	          dataType : 'json',
	         /*  contentType :"application/json", */
	          data : formdata,
	          success : function (ret) {
	        	  if(ret.msg){
						layer.msg("创建成功", {time: 2000});	
						//设置为延迟执行				
						setTimeout( function() {
							//先得到当前iframe层的索引
							var index = parent.layer.getFrameIndex(window.name); 
							parent.layer.close(index);
						}, 2000 );
					}else{
						layer.msg("创建失败", {time: 2000});
					}
	          }
	      })
	      return false; 	  
	  });
	
	  
	});
</script>
  

  </body>
</html>
