<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>日志页面</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">

</head>
<body>

<br><br>
<table class="layui-table" id="test" lay-filter="test"></table>

<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="detail">删除</a>
</script>

<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript">
layui.use(['form','layer','table'], function(){
	  var testTable = layui.table;
	  var $=layui.$;
	  var layer = layui.layer;
	  var laydate = layui.laydate;
	  var form = layui.form;
	  
	  testTable.render({
	    elem: '#test'
	    ,url:'log/findLoggings'
	    ,cols: [[
	      {type:'checkbox', fixed: 'left'}
	      ,{field:'eventId', width:80, title: 'ID', sort: true}
	      ,{field:'timestmp', width:160,title:'日志时间',templet:function(row){ return createTime(row.timestmp); }}
	      ,{field:'formattedMessage', width:580, title: '日志记录'}
	      ,{field:'right',width:130,title:'操作',align:'center',toolbar:'#barDemo'}
	    ]]
	    ,page: true // 开启分页
	    ,limits:[10,20,30,40,50]
	  });
	  
		//监听工具条
		testTable.on('tool(test)', function(obj){
		  var data = obj.data; //获得当前行数据
		  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		  var tr = obj.tr;
		  if(layEvent === 'detail'){
			  deleteLoggingEvent(data.eventId);
		  }
		});
		
		function deleteLoggingEvent(id){
			$.ajax({
				url:"log/deleteLogById/"+id,
				type:"delete",
				dataType:"json",
				success:function(data){
					layer.msg(data.msg);
					testTable.reload('test',{});
				}
			});
		}
		
		
});
</script>

<script type="text/javascript">
function createTime(v){
	var date = new Date(v);
    var y = date.getFullYear();
    var M = date.getMonth()+1;
    M = M<10?("0"+M):M;
    var d = date.getDate();
    d = d<10?("0"+d):d;
    var h = date.getHours();
    h = h<10?("0"+h):h;
    var m = date.getMinutes();
    m = m<10?("0"+m):m;
    var str = y+"-"+M+"-"+d+" "+h+":"+m;
    return str;
}
</script>

</body>
</html>