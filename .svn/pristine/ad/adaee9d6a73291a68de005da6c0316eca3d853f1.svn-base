<%@page import="com.mysql.fabric.xmlrpc.base.Data"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>流失处理列表</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="<%=basePath%>common/layui-v2.3.0/css/layui.css"  media="all">
  <script src="<%=basePath%>common/layui-v2.3.0/layui.js" charset="utf-8"></script>  
</head>

<body>	
			
	<!-- 列表, test -->
	<table class="layui-hide" id="test" lay-filter="test"></table>
	
	<script type="text/javascript" id="barDemo">
	  <a class="layui-btn layui-btn-xs" lay-event="deferOutflow">暂缓流失</a>
	  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="confirmOutflow">确认流失</a>
	</script>
	
	<!-- 用script渲染table, form -->		
	<script>			
		layui.use(['form','layer','table'], function(){
          	var table = layui.table;
          	var $=layui.$;
      	  	var layer = layui.layer;
      	  	var laydate = layui.laydate;
          	var form = layui.form;
          	
          	table.render({
            	elem: '#test'  //绑定table id
            	,url:'<%=basePath %>/outflow/handleOutflowList'  //数据请求路径
            	,cellMinWidth: 80
            	,cols: [[
            		
                   { field: 'id', width:80, title: '编号', event: 'seeDetail', style:'cursor: pointer;', sort: true}
  				  ,{ field: 'client',  templet:function(d){ if( d.client!=null ) return d.client.name; else return "";}, width:200, title:'客户', sort: true}
  				  ,{ field: 'handlerUser',  templet:function(d){ if( d.handlerUser!=null ) return d.handlerUser.name; else return "";  }, width:100, title:'客户经理', sort: true}
                  ,{ field: 'lastOrderTime', width:200, title: '最后下单时间', sort: true, templet:function(d){ if(d.lastOrderTime!=null) return myTimeConverter(d.lastOrderTime); else return ""; } }
                  ,{ field: 'outflowTime', width:200, title: '流失时间', sort: true, templet:function(d){ if(d.outflowTime!=null) return myTimeConverter(d.outflowTime); else return ""; } }
                     
                  ,{ field: 'status',  
   					 templet:function(d){ 
   						  if( d.status == -1 ) 
   							  return '已删除';    						  
   						  else if( d.status == 0 ) 
   							  return '流失预警'; 
   						  else if( d.status == 1 )
   							  return '暂缓流失';
   	   					  else if( d.status == 2 )
   	   						  return '确认流失';						  
   	   					  else
   	   						  return 'error';
   	   					},
   					  width:90, title:'状态', sort: true}
   				  
                  ,{ fixed: 'right',title: '操作', width:180, align:'center', toolbar: '#barDemo'}//一个工具栏  具体请查看layui官网

            	]]
            
            ,page: true   //开启分页
            ,limit:10   //默认十条数据一页
            ,limits:[10,20,30,50]  //数据分页条
          });          	  		 

  	table.on('tool(test)', function(obj){
		var data = obj.data;
	    
		//查看详情
    	if(obj.event === 'seeDetail'){
  			layer.open({
  				title: ['查看流失详情','font-size:18px'],
  		  		type: 2, 
  		  		area: ['450px', '450px'],
  		  		content: '<%=basePath %>/outflow/selectOutflowById.action?id='+data.id 
  			});   
    	} 
    		
		//暂缓流失  		
    	if(obj.event === 'deferOutflow'){
  			layer.open({
  				title: ['暂缓流失','font-size:18px'],
  		  		type: 2, 
				closeBtn : 1, 
  		  		area: ['450px', '520px'],
                shadeClose : false,
  		  		content: '<%=basePath %>/outflow/toDeferOutflow.action?id='+data.id,
                end : function() {
                    table.reload('test',{});
                }
  			});  
		} 
		
    	//确认流失
    	if(obj.event === 'confirmOutflow'){
  			layer.open({
  				title: ['确认流失','font-size:18px'],
  		  		type: 2, 
  		  		area: ['450px', '520px'],
  		  		content: '<%=basePath %>/outflow/toConfirmOutflow.action?id='+data.id,
                end : function() {
                    table.reload('test',{});
                }
  			});  
		} 
  	});
  	
  	//时间格式转换
  	function myTimeConverter(v){
			var date = new Date(v);
	    	var y = date.getFullYear();
	    	var m = date.getMonth()+1;
	    	m = m<10?'0'+m:m;
	    	var d = date.getDate();
	    	d = d<10?("0"+d):d;
	    	var H = date.getHours();
	    	H = H<10?'0'+H:H;
	    	var M = date.getMinutes();
	    	M = M<10?'0'+M:M;
	    	var S = date.getSeconds();
	    	S = S<10?'0'+S:S;

	    	var str = y+"-"+m+"-"+d+" "+H+":"+M+":"+S;
	    	return str;
		}
		
  });
  </script>

</body>
</html>