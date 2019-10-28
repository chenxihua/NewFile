<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增客户信息</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">


</head>
<body>


<table class="layui-table" id="test" lay-filter="test"></table>
<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-success layui-btn-xs" lay-event="detail">新增客户信息</a>
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
	    ,url:'saleChance/selectAllStatusFour'
	    ,cols: [[
	      {type:'checkbox', fixed: 'left'}
	      ,{field:'id', width:80, title: 'ID', sort: true}
	      ,{field:'client', width:130, title: '客户名称'}
	      ,{field:'creator', width:110,title:'创建人',templet:function(row){ return idToString(row.creator); }}
	      ,{field:'createTime', width:120, title: '创建时间',templet:function(row){ return createTime(row.createTime); }}
	      ,{field:'chanceSource',width:130, title: '机会来源'}
	      ,{field:'odds', width:110, title: '成功率', sort: true,templet:function(data){return data.odds+'%';}}	
	      ,{field:'right',width:220,title:'操作',align:'center',toolbar:'#barDemo'}
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
		    addNewClientInfos('创建客户信息',data.id);
	    }
	});	  
	  
	function addNewClientInfos(title,id){
		var url = "pages/client/addClient.jsp?id="+id;
		layer.open({
			type:2,
			title:title,
			closeBtn : 1, 
            area : ['850px','550px'],
            shadeClose : false,
            content : url,
            end : function() {
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