<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售机会不按时开发</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">


</head>
<body>
<h3 align="center">超过10天不开发销售机会的信息</h3>

<table class="layui-table" id="testOver" lay-filter="testOver"></table>
<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-success layui-btn-xs" lay-event="detail">项目详情</a>
<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="edit">重新分配</a>
</script>

<script type="text/javascript" src="layui/layui.js"></script>
<script type="text/javascript">
layui.use(['form','layer','table'], function(){
	  var table = layui.table;
	  var form = layui.form;
	  var $=layui.$;
	  table.render({
	    elem: '#testOver'
	    ,url:'saleChance/selectStatusTwoForOverTime'
	    ,cols: [[
	      {type:'checkbox', fixed: 'left'}
	      ,{field:'id', width:80, title: 'ID', sort: true}
	      ,{field:'client', width:130, title: '客户名称'}
	      ,{field:'creator', width:110, title: '创建人',templet:function(row){ return idToString(row.creator); }}
	      ,{field:'createTime', width:120, title: '创建时间',templet:function(row){ return createTime(row.createTime); }}
	      ,{field:'chanceSource',width:130, title: '机会来源'}
	      ,{field:'odds', width:110, title: '成功率', sort: true,templet:function(data){return data.odds+'%';}}	
	      ,{field:'right',width:220,title:'操作',align:'center',toolbar:'#barDemo'}
	    ]]
	    ,page: true // 开启分页
	    ,limits:[10,15,20,25,30]
	    ,done: function(data, count){
	    	console.log(data);
	    	console.log(count);
	    }
	  });
	//监听工具条
	table.on('tool(testOver)', function(obj){
	  var data = obj.data; //获得当前行数据
	  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
	  var tr = obj.tr;
	  if(layEvent === 'detail'){
		  showSaleChanceInfos('查看开发情况',data.id);
	  }else if(layEvent === 'edit'){
		  // 更新状态 (status), 把它变成status=1； 
		  updateSaleStatusToOne(data.id);
	  }
	});
	
	// 查看销售机会的基本开发情况 
	function showSaleChanceInfos(title,id){
		var url = "pages/sale/saleDetails.jsp?id="+id;
		layer.open({
			type:2,
			title:title,
			closeBtn : 1, 
            area : ['850px','550px'],
            shadeClose : false,
            content : url,
		});
	}
	function updateSaleStatusToOne(id){
		$.ajax({
			url:"saleChance/auditSuccessBtn",
			data:{"id":id},
			dataType:"json",
			success:function(data){
				layer.msg("重新分配成功,请继续操作...");
				table.reload('testOver',{});
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