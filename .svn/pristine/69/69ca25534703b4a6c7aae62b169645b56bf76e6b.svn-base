<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增交往记录</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">


</head>
<body>


<br>
<form class="layui-form" action="" lay-filter="example">
	<input type="hidden" name="id" value="" />
	<input type="hidden" name="status" value="" />
	<input type="hidden" name="clientId" value="" />
	
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">处理人</label>
      <div class="layui-input-inline">
       <!--  <input type="text" name="name" lay-verify="required" autocomplete="off" class="layui-input"> -->
       <select id="userSelect" name="userId" lay-search  lay-verify="required" lay-filter="userSelect"></select>
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">时间</label>
      <div class="layui-input-inline">
        <!-- <input type="text" name="recordTime" lay-verify="required" autocomplete="off" class="layui-input"> -->
        <input type="text" name="recordTime" id="date11" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">地点</label>
      <div class="layui-input-inline">
        <input type="text" name="location" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">概要</label>
      <div class="layui-input-inline">
        <input type="text" name="outline" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">详细信息</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入详细信息" class="layui-textarea" name="detail"></textarea>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">备注</label>
    <div class="layui-input-block">
      <input type="text" name="remark" lay-verify="title" autocomplete="off" placeholder="请输入备注" class="layui-input">
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
  
  //日期
  laydate.render({
    elem: '#date11'
  });
  
  //渲染所有下拉框
  loadAllSelect();
  
  //从url中获取参数
  var data = getParm();
  var clientId = data.clientId;
  
	//点击保存事件
	form.on('submit(demo1)',function(data){
	    var formdata = data.field;
	    console.log(formdata);
	    $.ajax({
	        type: "POST",
	        url: "record/saveRecord/"+clientId,
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
	
	  // 渲染下拉框 
	  function loadAllSelect(){
		  loadManagerSelect();//加载处理人的下拉框(也就是经理的下拉框) 
		  form.render(null,'example');
	  }
	  
	  function loadManagerSelect(){
		  $.ajax({
			  url:"saleChance/showAllManager",
			  type:"POST",
			  dataType:"json",
			  async:false,
			  success:function(data){
				  console.log(data.data);
				  var html = '';
				  if(data.success){
					  $("#userSelect").html("");
					  var managers = data.data;
					  html += "<option value=''></option>";
					  for(i=0;i<managers.length;i++){
						  html += "<option value='"+managers[i].id+"'>"+managers[i].name+"</option>";
					  }
					  $("#userSelect").html(html);
				  }else{
					  layer.msg("读取客户数据出错！");
				  }
			  }
		  });
	  }
	
});
</script>

</body>
</html>