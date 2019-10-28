<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>编辑交往记录</title>

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
       <input type="text" name="userId" autocomplete="off" class="layui-input">
       <!-- <select id="userSelect" name="userId" lay-search  lay-verify="required" lay-filter="userSelect"></select> -->
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">时间</label>
      <div class="layui-input-inline">
        <input type="text" name="recordTime" lay-verify="required" autocomplete="off" class="layui-input">
        <!-- <input type="text" name="recordTime" id="date11" lay-verify="required" autocomplete="off" class="layui-input"> -->
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
      <button class="layui-btn layui-btn-ms" name="demo1" lay-submit lay-filter="demo1">确定退出</button>
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
  	
  updateContactRecordInfos(id);
  
  //根据的ID获取开发计划实例，并填充到表单数据（重点掌握!） 
  function updateContactRecordInfos(id){
   	$.ajax({
  		type: "POST",
  		url : "record/selectOneRecord",
  		data: {"RecordId":id},
  		dataType : "json",
  		success : function(data){
  			if(data.success){
  				form.val('example', {
				  "id":data.data.id
  				  ,"userId":idToString(data.data.userId)
				  ,"recordTime":createTime(data.data.recordTime)
				  ,"location":data.data.location
				  ,"outline":data.data.outline
				  ,"detail":data.data.detail
				  ,"remark":data.data.remark
				  ,"clientId":data.data.clientId
				  ,"status":data.data.status
				});
  			}
  			form.render();
  		}
  	});
  }
  
	//点击确定退出事件  
	form.on('submit(demo1)',function(data){
		//关闭当前弹出层
        var thisindex = parent.layer.getFrameIndex(window.name);
        parent.layer.close(thisindex);
	});
  
	// 这个函数是通过id查询User表中的名字，（包括客户经理）   
	function idToString(creatId){
		var countName = '';
		$.ajax({
			url:"saleChance/selectCreatorName/"+creatId,
			dataType:"json",
			async:false,
			type:"GET",
			success:function(data){
				countName = data.data.name;
			}
		});
		return countName;
	}
  

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