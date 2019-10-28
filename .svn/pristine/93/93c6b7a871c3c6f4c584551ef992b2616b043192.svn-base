<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增和编辑联系人信息</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">

</head>
<body>

<br><br>
<form class="layui-form" action="" lay-filter="example">
	<input type="hidden" name="id" value="" />
	<input type="hidden" name="status" value="" />
	<input type="hidden" name="clientId" value="" />
	
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">姓名</label>
      <div class="layui-input-inline">
        <input type="text" name="name" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">性别</label>
      <div class="layui-input-inline">
        <input type="text" name="gender" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">职位</label>
      <div class="layui-input-inline">
        <input type="text" name="position" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">办公电话</label>
      <div class="layui-input-inline">
        <input type="text" name="officePhone" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">手机</label>
      <div class="layui-input-inline">
        <input type="text" name="phoneNum" lay-verify="required|phone" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">备注</label>
      <div class="layui-input-inline">
        <input type="text" name="remark" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn layui-btn-ms" name="demo1" lay-submit lay-filter="demo1">保 存</button>
      <button type="reset" class="layui-btn layui-btn-primary layui-btn-ms">重 置</button>
    </div>
  </div>
</form>



<script type="text/javascript" src="layui/layui.js"></script>
<script src="js/myutil.js"></script>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form;
  var layer = layui.layer;
  var layedit = layui.layedit;
  var laydate = layui.laydate;
  var $ = layui.$;
  
  //从url中获取参数，判断机会是更新还是添加
  var data = getParm();
  var id = data.id;
  	
  updateLinkmanInfos(id);
  
  //根据的ID获取开发计划实例，并填充到表单数据（重点掌握!） 
  function updateLinkmanInfos(id){
	  //layer.msg(id);
   	$.ajax({
  		type: "POST",
  		url : "linkman/showLinkmanInfos",
  		data: {"manId":id},
  		dataType : "json",
  		success : function(data){
  			if(data.success){
  				console.log(data);
  				form.val('example', {
				  "id":data.data.id
  				  ,"name":data.data.name
				  ,"gender":data.data.gender
				  ,"position":data.data.position
				  ,"officePhone":data.data.officePhone
				  ,"phoneNum":data.data.phoneNum
				  ,"clientId":data.data.clientId
				  ,"remark":data.data.remark
				});
  			}
  			form.render();
  		}
  	});
  }
  
	//点击保存事件
	form.on('submit(demo1)',function(data){
	    var formdata = data.field;
	    console.log(formdata);
	    $.ajax({
	        type: "POST",
	        url: "linkman/updateLinkmanInfos",
	        data: formdata,
	        dataType: "json",
	        success: function(data){
	            if(data.success){//成功
	            	top.layer.msg(data.msg); 
	                //关闭当前弹出层
	                var thisindex = parent.layer.getFrameIndex(window.name);
	                parent.layer.close(thisindex);
	            }
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



