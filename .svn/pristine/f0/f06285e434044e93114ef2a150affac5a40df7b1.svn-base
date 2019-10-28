<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看详情</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">

</head>
<body>

<br><br>
<form class="layui-form" action="" lay-filter="example">
	<input type="hidden" name="id" value="" />
	<input type="hidden" name="clientId" value="" />
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
        <input type="text" name="odds" lay-verify="required" autocomplete="off" class="layui-input">
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
      <label class="layui-form-label">分配人</label>
      <div class="layui-input-inline">
        <input type="text" name="assignee" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">创建人</label>
      <div class="layui-input-inline">
        <input type="text" name="creator" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">创建时间</label>
      <div class="layui-input-block">
        <input type="text" name="createTime" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">分配给</label>
      <div class="layui-input-inline">
        <input type="text" name="assigner" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">分配时间</label>
      <div class="layui-input-block">
        <input type="text" name="assignTime" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">描述内容</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入内容" class="layui-textarea" name="description"></textarea>
    </div>
  </div>

 
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn layui-btn-ms" name="demo1" lay-submit lay-filter="demo1">确定</button>
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
  var thisindex = parent.layer.getFrameIndex(window.name);
  //从url中获取参数，判断机会是更新还是添加
  var data = getParm();
  var id = data.id;
  updataSaleChanceById(id);
  
  //根据ID获取销售机会实例，并填充到表单数据
  function updataSaleChanceById(id){
  	$.ajax({
  		type: "POST",
  		url : "saleChance/showSaleInfos",
  		data: { "id": id},
  		dataType : "json",
  		success : function(data){
  			if(data.success){
  				form.val('example',{
  					"id":data.data.id
  					,"clientId":data.data.clientId
  					,"client":data.data.client	
  					,"assignee":idToString(data.data.assignee)
  	  				,"assigner":idToString(data.data.assigner)
  	  				,"assignTime":createTime(data.data.assignTime)
  	  				,"chanceSource":data.data.chanceSource
  	  				,"creator":idToString(data.data.creator)
  	  				,"createTime":createTime(data.data.createTime)
  	  				,"description":data.data.description
  	  				,"linkman":data.data.linkman
  	  				,"linkmanPhone":data.data.linkmanPhone
  	  				,"odds":data.data.odds+"%"
  	  				,"outline":data.data.outline
  	  				,"status":data.data.status
  				});
  			}
  			form.render();
  		}
  	});
  }
	//点击确定退出事件  
	form.on('submit(demo1)',function(data){
		parent.layer.close(thisindex);
	});
	
	
	// 这个函数是通过id查询User表中的名字，（包括创建者，分配者） 
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