<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>开发销售计划</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">


</head>
<body>

<br><br>
<form class="layui-form" action="" lay-filter="example">
	<input type="hidden" name="id" value="" />
	<input type="hidden" name="status" value="" />
	
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">销售编号</label>
      <div class="layui-input-inline">
        <input type="text" name="saleChanceId" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">创建时间</label>
      <div class="layui-input-inline">
        <input type="text" name="createTime" id="date1" lay-verify="required|date" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">方案计划</label>
    <div class="layui-input-block">
      <input type="text" name="plan" autocomplete="off" placeholder="请输入概要" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">方案结果</label>
      <div class="layui-input-inline">
        <input type="text" name="effect" autocomplete="off" class="layui-input">
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
  
  //日期
  laydate.render({
	  elem: '#date1'
  });
  
  // 获取全局变量 
  var submitUrl = '';
  //从url中获取参数，判断机会是更新还是添加
  var data = getParm();
  if(data != null) {//编辑销售机会
  	var id = data.id;
  	submitUrl = "exploit/updateDevelopProcess";
  	updateDevelopPlan(id);
  }else{//添加销售机会
  	submitUrl = "exploit/saveDevelopPlan";
  }
  
  //根据开发计划的ID获取开发计划实例，并填充到表单数据（重点掌握!） 
  function updateDevelopPlan(id){
  	$.ajax({
  		type: "POST",
  		url : "exploit/showOneInfos",
  		data: {"id":id},
  		dataType : "json",
  		success : function(data){
  			if(data.success){
  				console.log(data);
  				form.val('example', {
				  "id":data.data.id
  				  ,"saleChanceId":data.data.saleChanceId
				  ,"createTime":createTime(data.data.createTime)
				  ,"plan":data.data.plan
				  ,"effect":data.data.effect
				  ,"status":data.data.status
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
	        url: submitUrl,
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
<script type="text/javascript">
function createTime(v){
	var date = new Date(v);
    var y = date.getFullYear();
    var m = date.getMonth()+1;
    m = m<10?'0'+m:m;
    var d = date.getDate();
    d = d<10?("0"+d):d;
    var str = y+"-"+m+"-"+d;
    return str;
}
</script>

</body>
</html>