<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户信息表</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">

</head>
<body>


<table class="layui-table" id="test" lay-filter="test"></table>
<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-success layui-btn-xs" lay-event="detail">查看详情</a>
</script>





<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript">
layui.use(['form','layer','table'], function(){
	  var table = layui.table;
	  var $=layui.$;
	  var layer = layui.layer;
	  var laydate = layui.laydate;
	  var form = layui.form;
	  
	  table.render({
	    elem: '#test'
	    ,url:'client/showClientInfos'
	    ,cols: [[
	      {type:'checkbox', fixed: 'left'}
	      ,{field:'id', width:80, title: 'ID', sort: true}
	      ,{field:'name', width:190, title: '客户名称'}
	      ,{field:'clientManager', width:110,title:'客户经理',templet:function(row){ return idToString(row.clientManager); }}
	      ,{field:'clientClassId', width:120, title: '客户等级',templet:function(row){ return idToClientClass(row.clientClassId); }}
	      ,{field:'phoneNum',width:130, title: '联系方式'}
	      ,{field:'internetAddr',width:200, title: '网址'}
	      ,{field:'right',width:160,title:'操作',align:'center',toolbar:'#barDemo'}
	    ]]
	    ,page: true // 开启分页
	    ,limits:[10,15,20,25,30]
	  });
	  
	  // 监听工具条事件
	table.on('tool(test)', function(obj){
	    var data = obj.data; //获得当前行数据
	    var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
	    var tr = obj.tr;
	    if(layEvent === 'detail'){
	    	window.location.href="pages/client/showDetailInfos.jsp?id="+data.id;
	    }
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
	
	// 这个函数是根据等级id，查询这个等级的名字 
	function idToClientClass(classId){
		var className = '';
		$.ajax({
			url:"client/selectClientClassById/"+classId,
			dataType:"json",
			async:false,
			type:"GET",
			success:function(data){
				className = data.data.name;
			}
		});
		return className;
	}
	  
	  
});
</script>





</body>

</html>




