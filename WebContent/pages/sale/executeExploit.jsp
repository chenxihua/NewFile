<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>执行开发计划</title>
<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">


</head>
<body>

<br><br>
<form class="layui-form" action="" lay-filter="example">
	<input type="hidden" name="id" value="" />
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
</form>

<!-- ----------------    以上是显示表单的内容    ---------------- -->
<!-- ----------------    下面是显示执行开发计划的数目和结果    ---------------- -->
<table class="layui-table" id="test" lay-filter="test"></table>
<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="detail">更新编辑</a>
</script>
<br>
<div class="layui-btn-group demoTable">
<button class="layui-btn" id="newSave" data-type="getSaveData">执行开发</button>
<button class="layui-btn layui-btn-success" id="exploitSuccess">开发成功</button>
<button class="layui-btn layui-btn-danger" id="exploitFail">开发失败</button>
<button class="layui-btn" id="returnRrePgae">返回上页</button>
</div>

<script type="text/javascript" src="layui/layui.js"></script>
<script src="js/myutil.js"></script>
<script>
layui.use(['form','table','layedit','laydate'], function(){
  var form = layui.form;
  var table = layui.table;
  var layer = layui.layer;
  var layedit = layui.layedit;
  var laydate = layui.laydate;
  var $ = layui.$;
  var thisindex = parent.layer.getFrameIndex(window.name);
  // 添加全局路径变量
  var submitUrl = '';
  //从url中获取参数，判断机会是更新还是添加
  var data = getParm();
  var id = data.id;
  updataSaleChanceById(id);
  
  // 下面是显示执行开发计划的数目和结果
  table.render({
  	elem: '#test'
  	,url:'exploit/showPlanInfos?id='+id
  	,cols: [[
    	{field:'id', width:80, title: 'ID', sort: true}
    	,{field:'saleChanceId', width:130, title: '销售机会id'}
   		,{field:'createTime', width:130,title:'创建时间',templet:function(row){ return createTime(row.createTime); }}
    	,{field:'plan',width:130, title: '计划'}
    	,{field:'effect',width:130, title: '结果'}
    	,{field:'right',width:220,title:'操作',align:'center',toolbar:'#barDemo'}
  	]]
  	,page: true // 开启分页
  	,limits:[10,15,20,25,30]
  });
  
	//监听工具条
	table.on('tool(test)', function(obj){
	  var data = obj.data; //获得当前行数据
	  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
	  var tr = obj.tr;
	  if(layEvent === 'detail'){
		  saveOrEditPlanInfos('开发计划详情',data.id);
	  }
	});
  
  //根据ID获取销售机会实例，并填充到表单数据
  function updataSaleChanceById(id){
  	$.ajax({
  		type: "POST",
  		url : "saleChance/showSaleInfos",
  		data: {"id":id},
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
  
  //添加按钮触发时间
  $("#newSave").click(function(){
	  saveOrEditPlanInfos("添加开发计划",-1);
  })
  
  // 添加开发成功按钮事件 
  $("#exploitSuccess").click(function(){
	  exploitSuccessById(id);
  })
  
  // 添加开发失败按钮事件 
  $("#exploitFail").click(function(){
	  exploitFailById(id);
  })
  
  $("#returnRrePgae").click(function(){
	  window.history.back(-1);  // 返回历史窗口 
  })
  
  // 新增或者编辑开发计划
  function saveOrEditPlanInfos(title,id){
	  // 用于编辑 
	  if(id>0){
		  submitUrl = "pages/sale/addOrEditPlan.jsp?id="+id;
		  layer.open({
			  type:2,
			  title:'销售机会信息',
			  closeBtn : 1, 
              area : ['700px','400px'],
              shadeClose : false,
              content : submitUrl,
              end : function() {
              	table.reload('test',{});
              }
		  });
	  }else{
		  // 用于新增  
		  submitUrl = "pages/sale/addOrEditPlan.jsp";
		  layer.open({
			  type:2,
			  title:title,
			  closeBtn : 1, 
	          area : ['700px','400px'],
	          shadeClose : false,
	          content : submitUrl,
	          end : function() {
	        	  table.reload('test',{});
	          }
		  });
	  }
  }
  
  function exploitSuccessById(id){
	  $.ajax({
		  type:"PUT",
		  url:"saleChance/exploitSuccess",
		  data:{"id":id},
		  dataType : "json",
  		  success : function(data){
  			  console.log(data);
  			  layer.msg(data.msg); 
  		  }
	  });
  }
  function exploitFailById(id){
	  $.ajax({
		  type:"PUT",
		  url:"saleChance/exploitFail",
		  data:{"id":id},
		  dataType : "json",
  		  success : function(data){
  			  console.log(data);
  			  layer.msg(data.msg); 
  		  }
	  });
  }
  
  
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