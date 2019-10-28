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
  <title>产品列表</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="<%=basePath%>common/layui-v2.3.0/css/layui.css"  media="all">
</head>
<body>
<form class="layui-form">
		<div class="demoTable">
	  		搜索订单：
	  	<div class="layui-inline">
	    <input class="layui-input" name="id"  autocomplete="off" placeholder="请输入搜索的内容">
	  	</div>
	  		<button type="button" class="layui-btn" id="searchBtn" data-type="reload">搜索</button>
		</div>
</form>
	<table id="ordersTable" class="layui-hide" ></table>
	<script src="<%=basePath%>common/layui-v2.3.0/layui.js" charset="utf-8"></script>
</body>
  <script type="text/javascript">
  layui.use(['form','layer','table'], function(){ 
	  //让layui识别$
	  var $ = layui.$;
	  var table = layui.table;
	  var form = layui.form;
	  //查看列表
		  table.render({
	      	elem: '#ordersTable'  //绑定table id
	      	,url:'${pageContext.request.contextPath}/orders/getOrders' //数据请求路径
	      	,cellMinWidth: 80
	      	,cols: [[
	      	  	 { field: 'id', width:70, title: '编号', sort: true}
	            ,{ field: 'areaName',   width:100, title: '送货地区'}                    
				  ,{ field: 'clientName',  width:260, title: '客户名称'}
				  ,{ field: 'recordTime',  width:200, title: '订单完成时间',sort: true, templet:function(d){ return myTimeConverter(d.recordTime); }  }
				  ,{ field: 'address',  width:200,  title: '详细地址'}
				  ,{ field: 'money',  width:90,  title: '总金额'}
				  ,
				   { field: 'status', templet:function(i){ 
					   if( i.status == 0 ) return "有效";
					   else if(i.status ==-1) return "已删除";
					}
				  ,width:80, title: '状态'}         
				  ,{ field: 'userName',  width:90,  title: '客户经理'}
	      	]]
	      ,page: true   //开启分页
	      ,limit:10   //默认十条数据一页
	      ,limits:[10,20,30,50]  //数据分页条
	      ,id: 'ordersTableReload'   
	    });
	  
		  //模糊查找
		  $('#searchBtn').click(function(){
				table.reload('ordersTableReload',{
					where:{
						'id':$('input[name=id]').val()
					}
				})
		  }) ;
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
</html>