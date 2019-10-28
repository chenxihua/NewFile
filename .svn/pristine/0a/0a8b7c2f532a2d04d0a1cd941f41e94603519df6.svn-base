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
		  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;搜索产品：
		  	<div class="layui-inline">
		    	<input class="layui-input" name="name"  autocomplete="off" placeholder="请输入商品的名称">
		  	</div>
		  	
		  	<div class="layui-inline">
			    <label class="layui-form-label">范围</label>
			     <div class="layui-input-inline" style="width: 100px;">
			        <input type="text" name="priceMin" placeholder="￥" autocomplete="off" class="layui-input">
			     </div>
	      			-
			     <div class="layui-input-inline" style="width: 100px;">
			        <input type="text" name="priceMax" placeholder="￥" autocomplete="off" class="layui-input">
			     </div>
    		</div>
		  	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		  		<button type="button" class="layui-btn" id="searchBtn" data-type="reload">搜索</button>
		</div>
</form>
	<table id="productTable" class="layui-hide" ></table>
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
	      	elem: '#productTable'  //绑定table id
	      	,url:'${pageContext.request.contextPath}/product/getProducts2' //数据请求路径
	      	,cellMinWidth: 80
	      	,cols: [[
	            { field: 'id', width:80, title: '编号', sort: true}
	            ,{ field: 'name',   width:180, title: '名称'}                    
				  ,{ field: 'price',  width:100, title: '价格'}
				  ,{ field: 'stock',  width:90,  title: '库存'}
				  ,
				   { field: 'status', templet:function(i){ 
					   if( i.status == 0 ) return "上架中";
					   else if(i.status ==-1) return "已删除";
					   else return "已下架"; }
				  ,width:200, title: '状态'}         
	      	]]
	      ,page: true   //开启分页
	      ,limit:10   //默认十条数据一页
	      ,limits:[10,20,30,50]  //数据分页条
	      ,id: 'productTableReload'   
	    });
	  
		  //模糊查找
		  $('#searchBtn').click(function(){
				table.reload('productTableReload',{
					where:{
						'name':$('input[name=name]').val(),
						'priceMin':$('input[name=priceMin]').val(),
						'priceMax':$('input[name=priceMax]').val()
					}
				})
		  }) ;
	  
	});
  </script>
</html>