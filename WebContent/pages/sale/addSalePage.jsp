<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增编辑页面</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />

<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">


</head>
<body>
<br><br>
<form class="layui-form" action="" lay-filter="example">
	
	<input type="hidden" name="id" value="" />
	<input type="hidden" name="clientId" value="" />
	<input type="hidden" name="assignee" value="" />
	<input type="hidden" name="status" value="" />
	
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">客户名称</label>
      <div class="layui-input-inline">
        <input type="text" name="client" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">成功机率</label>
      <div class="layui-input-inline">
        <input type="text" name="odds" lay-verify="required|number" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">概要</label>
    <div class="layui-input-block">
      <input type="text" name="outline" lay-verify="title" autocomplete="off" placeholder="请输入概要" class="layui-input">
    </div>
  </div>
  <div class="layui-form-item">
	  <label class="layui-form-label">机会来源</label>
	  <div class="layui-input-block">
	    <input type="text" name="chanceSource" lay-verify="title" autocomplete="off" placeholder="请输入机会来源" class="layui-input">
	  </div>
	</div>
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">联系人</label>
      <div class="layui-input-inline">
        <input type="text" name="linkman" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">联系电话</label>
      <div class="layui-input-inline">
        <input type="tel" name="linkmanPhone" lay-verify="required|phone" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
	<div class="layui-form-item">
	  <div class="layui-inline">
	    <label class="layui-form-label">创建人</label>
	    <div class="layui-input-inline">
	      <select id="creatorSelect" name="creator" lay-search  lay-verify="required" lay-filter="creatorSelect"></select>
	    </div>
	  </div>
	  <div class="layui-inline">
	    <label class="layui-form-label">分配给</label>
	    <div class="layui-input-inline">
	      <select id="managerSelect" name="assigner" lay-search  lay-verify="required" lay-filter="managerSelect"></select>
	    </div>
	  </div>
	</div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">具体描述</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入内容" class="layui-textarea" name="description"></textarea>
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
  
  //渲染所有下拉框
  loadAllSelect();
  
	//点击保存事件
	form.on('submit(demo1)',function(data){
	    var formdata = data.field;
	    $.ajax({
	        type: "POST",
	        url: "saleChance/saveNewSaleChance",
	        data: formdata,
	        dataType: "json",
	        success: function(data){
	        	console.log(data);
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
	  loadCreatorSelect();//加载分配人下拉框 
	  loadManagerSelect();//加载分配给经理的下拉框 
	  form.render(null,'example');
  }
  // 渲染创建人下拉框  
  function loadCreatorSelect(){
	  $.ajax({
		  url:"saleChance/showCreateres",
		  type:"POST",
		  dataType:"json",
		  async:false,
		  success:function(data){
			  var html = '';
			  if(data.success){
				  $("#creatorSelect").html("");
				  var creaters = data.data;
				  html += "<option value=''></option>";
				  for(i=0;i<creaters.length;i++){
					  html += "<option value='"+creaters[i].id+"'>"+creaters[i].name+"</option>";
				  }
				  $("#creatorSelect").html(html);
			  }else{
				  layer.msg("读取客户数据出错！");
			  }
		  }
	  });
  }
  // 渲染经理下拉框 
  function loadManagerSelect(){
	  $.ajax({
		  url:"saleChance/showAllManager",
		  type:"POST",
		  dataType:"json",
		  async:false,
		  success:function(data){
			  var html = '';
			  if(data.success){
				  $("#managerSelect").html("");
				  var managers = data.data;
				  html += "<option value=''></option>";
				  for(i=0;i<managers.length;i++){
					  html += "<option value='"+managers[i].id+"'>"+managers[i].name+"</option>";
				  }
				  $("#managerSelect").html(html);
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



