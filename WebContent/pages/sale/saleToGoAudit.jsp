<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>分配销售机会</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />

<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">

</head>
<body>

 
<table class="layui-table" id="test" lay-filter="test"></table>
<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-xs" lay-event="edit">立刻分配</a>
</script>       
          
<script type="text/javascript" src="layui/layui.js"></script>

<script type="text/javascript">
layui.use(['form','layer','table'], function(){
	  var table = layui.table;
	  var form = layui.form;
	  var $=layui.$;
	  table.render({
	    elem: '#test'
	    ,url:'saleChance/selectAllStatusOne'
	    ,cols: [[
	      {type:'checkbox', fixed: 'left'}
	      ,{field:'id', width:80, title: 'ID', sort: true}
	      ,{field:'client', width:130, title: '客户名称'}
	      ,{field:'creator', width:110, title: '创建人',templet:function(row){ return idToString(row.creator); }}
	      ,{field:'createTime', width:120, title: '创建时间',templet:function(row){ return createTime(row.createTime); }}
	      ,{field:'chanceSource',width:130, title: '机会来源'}
	      ,{field:'odds', width:110, title: '成功率', sort: true,templet:function(data){return data.odds+'%';}}	
	      ,{field:'assigner',width:130,title:'分配给',templet:function(row){ return idToString(row.assigner); }}
	      ,{field:'right',width:150,title:'分配操作',align:'center',toolbar:'#barDemo'}
	    ]]
	    ,page: true // 开启分页
	    ,limits:[10,15,20,25,30]
	  });
	  
	//监听工具条
	table.on('tool(test)', function(obj){
	  var data = obj.data; //获得当前行数据
	  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
	  var tr = obj.tr;
	  if(layEvent === 'edit'){
		  assignToManager(data.id);
	  }
	});
	
	function assignToManager(id){
		$.ajax({
			url:"saleChance/assignToManager",
			type:"PUT",
			data:{"id":id},
			dataType:"json",
			success:function(data){
				layer.msg("分配成功！");
				table.reload('test',{});
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