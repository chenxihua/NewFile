<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户交往记录</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">

</head>
<body>


<br>
<div class="layui-btn-group demoTable">
<button class="layui-btn" id="newSave" data-type="getSaveData">新增历史交往记录</button>
</div>

<table class="layui-table" id="test" lay-filter="test"></table>
<script type="text/html" id="barDemo">
<a class="layui-btn layui-btn-success layui-btn-xs" lay-event="detail">查看更新</a>
<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="deleteMan">删除</a>
</script>



<script type="text/javascript" src="layui/layui.js"></script>
<script src="js/myutil.js"></script>
<script type="text/javascript">
layui.use(['form','layer','table'], function(){
	  var table = layui.table;
	  var $=layui.$;
	  var layer = layui.layer;
	  var laydate = layui.laydate;
	  var form = layui.form;
	  
	  //从url中获取参数，
	  var data = getParm();
	  var clientId = data.id;
	  
	  table.render({
	    elem: '#test'
	    ,url:'record/selectRecordByIdInfos/'+clientId
	    ,cols: [[
	      {type:'checkbox', fixed: 'left'}
	      ,{field:'id', width:80, title: '编号', sort: true}
	      ,{field:'recordTime', width:130, title: '时间',templet:function(row){ return createTime(row.recordTime);}}
	      ,{field:'location', width:110,title:'地点'}
	      ,{field:'outline', width:120, title: '概要'}
	      ,{field:'userId',width:130, title: '处理人',templet:function(row){ return idToString(row.userId); }}
	      ,{field:'right',width:220,title:'操作',align:'center',toolbar:'#barDemo'}
	    ]]
	    ,page: true // 开启分页
	    ,limits:[10,15,20,25,30]
	    ,done: function(data){
	    	console.log(data);
	    }
	  });
	  
		//监听工具条
		table.on('tool(test)', function(obj){
		  var rowdata = obj.data; //获得当前行数据
		  var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
		  var tr = obj.tr;
		  if(layEvent === 'detail'){
			  showContactRecordInfos('编辑交往记录信息',rowdata.id);
		  }else if(layEvent === 'deleteMan'){
			  //layer.msg(rowdata.id);
			  deleteRecordById(rowdata.id);
		  }
		});
		
		//添加按钮触发时间
		$("#newSave").click(function(){
			addContactRecordInfos("新增交往记录信息",clientId);
        });
		// 新增 
		function addContactRecordInfos(title,id){
			var url = "pages/client/addContactRecord.jsp?clientId="+id;
			layer.open({
                type : 2,
                title : title,
                closeBtn : 1,
                area : ['770px','430px'],
                shadeClose : false,
                content : url,
                end : function() {
                    table.reload('test',{});
                }
			}); 
		}
		// 更新 
		function showContactRecordInfos(title,id){
			var url = "pages/client/EditContactRecord.jsp?id="+id;
			layer.open({
                type : 2,
                title : title,
                closeBtn : 1,
                area : ['770px','430px'], 
                shadeClose : false,
                content : url,
                end : function() {
                    table.reload('test',{});
                }
			}); 
		}
		
		// 删除一条交往记录 
		function deleteRecordById(RecordId){
			$.ajax({
				url:"record/deleteRecordById/"+RecordId,
				type:"delete",
				dataType:"json",
				success:function(data){
					layer.msg(data.msg);
					table.reload('test',{});
				}
			});
		}
		
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