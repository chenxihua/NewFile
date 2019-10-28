<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户联系人</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">

</head>
<body>


<br>
<div class="layui-btn-group demoTable">
<button class="layui-btn" id="newSave" data-type="getSaveData">新增联系人</button>
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
	  
	  //从url中获取参数，判断机会是更新还是添加
	  var data = getParm();
	  var clientId = data.id;
	  
	  table.render({
	    elem: '#test'
	    ,url:'linkman/selectAllsLinkmanInfos/'+clientId
	    ,cols: [[
	      {type:'checkbox', fixed: 'left'}
	      ,{field:'id', width:80, title: '编号', sort: true}
	      ,{field:'name', width:130, title: '姓名'}
	      ,{field:'gender', width:110,title:'性别'}
	      ,{field:'position', width:120, title: '职位'}
	      ,{field:'officePhone',width:130, title: '办公电话'}
	      ,{field:'phoneNum', width:110, title: '手机'}	
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
			  //layer.msg(rowdata.id);
			  showLinkmanInfos('编辑联系人信息',rowdata.id);
		  }else if(layEvent === 'deleteMan'){
			  //layer.msg("执行删除操作");
			  deletelinkmanById(rowdata.id);
		  }
		});
		
		//添加按钮触发时间
		$("#newSave").click(function(){
			showAddLinkmanInfos("新增联系人信息",clientId);
        });
		// 新增 
		function showAddLinkmanInfos(title,id){
			var url = "pages/client/addLinkman.jsp?clientId="+id;
			layer.open({
                type : 2,
                title : title,
                closeBtn : 1,
                area : ['700px','350px'],
                shadeClose : false,
                content : url,
                end : function() {
                    table.reload('test',{});
                }
			}); 
		}
		// 更新 
		function showLinkmanInfos(title,id){
			var url = "pages/client/EditLinkman.jsp?id="+id;
			layer.open({
                type : 2,
                title : title,
                closeBtn : 1,
                area : ['700px','350px'], 
                shadeClose : false,
                content : url,
                end : function() {
                    table.reload('test',{});
                }
			}); 
		}
		
		// 删除一个联系人 
		function deletelinkmanById(linkmanId){
			$.ajax({
				url:"linkman/deletelinkmanById/"+linkmanId,
				type:"delete",
				dataType:"json",
				success:function(data){
					layer.msg(data.msg);
					table.reload('test',{});
				}
			});
		}
});
</script>

</body>
</html>