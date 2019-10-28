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
  <title>服务分配列表</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="<%=basePath%>common/layui-v2.3.0/css/layui.css"  media="all">
  <script src="<%=basePath%>common/layui-v2.3.0/layui.js" charset="utf-8"></script>  
</head>

<body>	
			
<br>
	<form class="layui-form" action="<%=basePath%>/service/handleList">		
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 30px;">客户</label>
			<div class="layui-input-inline" style="width: 100px;">
				<input type="text" name="clientName" autocomplete="off" class="layui-input">
			</div>
		</div>
		
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 60px;">服务概要</label>
			<div class="layui-input-inline" style="width: 100px;">
				<input type="text" name="content" autocomplete="off" class="layui-input">
			</div>
		</div>
		
		<div class="layui-inline">
    		<label class="layui-form-label" style="width: 60px;">服务类型</label>
    		<div class="layui-input-inline" style="width: 100px;">
      			<select name="type">
        			<option value="-2">所有类型</option>
			        <option value="1">咨询</option>
        			<option value="2">建议</option>
        			<option value="3">投诉</option>
      			</select>
    		</div>
  		</div>
  		
  		<div class="layui-inline">
			<label class="layui-form-label" style="width: 60px;">创建时间</label>
			<div class="layui-input-inline" style="width: 150px;">
				<input type="text" name="beginTime" autocomplete="off"
					class="layui-input" id="beginDate" placeholder="年-月-日   时 :分:秒">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 10px;">-</label>
			<div class="layui-input-inline" style="width: 150px;">
				<input type="text" name="endTime" autocomplete="off"
					class="layui-input" id="endDate" placeholder="年-月-日   时 :分:秒">
			</div>
		</div>
  						
		<button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo2" style="width: 80px;">
			查&nbsp询
		</button>
					
		<!-- 列表, test -->
		<table class="layui-hide" id="test" lay-filter="test"></table>				
	</form>
	
	<script type="text/javascript" id="barDemo">
	  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="assignService">分配</a>
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
            	,url:'<%=basePath %>/service/assignList'  //数据请求路径
            	,cellMinWidth: 80
            	,cols: [[
            		
                   { field: 'id', width:80, title: '编号', event: 'seeDetail', style:'cursor: pointer;', sort: true}
  				  ,{ field: 'client',  templet:function(d){ if( d.client!=null ) return d.client.name; else return "";}, width:200, title:'客户', sort: true}
                  ,{ field: 'content', width:180, title: '服务概要', sort: true}                    
  				  ,{ field: 'serviceType',  templet:function(d){ if( d.serviceType!=null ) return d.serviceType.typeName; else return "error"; }, width:100, title:'服务类型', sort: true}
  				  ,{ field: 'creatorUser',  templet:function(d){ if( d.creatorUser!=null ) return d.creatorUser.name; else return "";  }, width:90, title:'创建人', sort: true}
                  ,{ field: 'createTime', width:200, title: '创建时间', sort: true, templet:function(d){  if(d.createTime!=null) return myTimeConverter(d.createTime); else return ""; } }
                  
                  ,{ field: 'status',  
   					 templet:function(d){ 
   						  if( d.status == -1 ) 
   							  return '已删除';    						  
   						  else if( d.status == 0 ) 
   							  return '已创建'; 
   						  else if( d.status == 1 )
   							  return '等待分配';
   	   					  else if( d.status == 2 )
   	   						  return '已分配';
   	   					  else if( d.status == 3 )
	   						  return '等待反馈';
   	   					  else if( d.status == 4 )
	   						  return '处理成功';
   	   					  else if( d.status == 5 )
	   						  return '处理失败';   						  
   	   					  else
   	   						  return 'error';
   	   					},
   					  width:90, title:'状态', sort: true}
   				  
                  ,{ fixed: 'right',title: '操作', width:150, align:'center', toolbar: '#barDemo'}//一个工具栏  具体请查看layui官网

            	]]
            
            ,page: true   //开启分页
            ,limit:10   //默认十条数据一页
            ,limits:[10,20,30,50]  //数据分页条
          });          	

          	//多条件查询
          	form.on('submit(formDemo2)', function(data){
            	table.reload('test',{
                    method:'post',
                    where:{param:JSON.stringify(data.field)},
                    page: {
                        curr: 1 //重新从第 1 页开始
                      }
                });

               /*  layer.msg(JSON.stringify(data.field)); */
                return false;
              });
  	//创建服务  	  
	  $("#createServiceBtn").click( function(){  		  
  			layer.open({
  				title: ['创建服务','font-size:18px'],
  		  		type: 2, 
  		  		area: ['450px', '450px'],
  	  		  	//若不想让iframe出现滚动条，你还可以content: ['http://sentsin.com', 'no']
  		  		content: '<%=basePath %>service/toCreateService.action',
                end : function() {
                    table.reload('test',{});
                }
  			});   	  		
  	  });  	    		 

  	table.on('tool(test)', function(obj){
		var data = obj.data;
	    
		//查看详情
    	if(obj.event === 'seeDetail'){
  			layer.open({
  				title: ['查看服务详情','font-size:18px'],
  		  		type: 2, 
  		  		area: ['450px', '450px'],
  		  		content: '<%=basePath %>/service/selectServiceById.action?userId='+data.id 
  			});   
    	} else 
    				
    	//分配服务
    	if(obj.event === 'assignService'){
  			layer.open({
  				title: ['分配服务','font-size:18px'],
  		  		type: 2, 
  		  		area: ['450px', '520px'],
  		  		content: '<%=basePath %>service/toAssignService.action?id='+data.id,
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
		/**
		 * 日期选择器
		 */
		layui.use('laydate', function() {
			var laydate = layui.laydate;
			//日期时间选择器
			laydate.render({
				elem : '#beginDate',
				type : 'datetime',
				theme : '#393D49'
			});
			//日期时间选择器
			laydate.render({
				elem : '#endDate',
				type : 'datetime',
				theme : '#393D49'
			});
		});	
  </script>

</body>
</html>