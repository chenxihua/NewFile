<%@page import="com.mysql.fabric.xmlrpc.base.Data"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>角色列表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet"
	href="<%=basePath%>common/layui-v2.3.0/css/layui.css" media="all">
<script type="text/javascript" src="<%=basePath%>js/jquery-1.8.3.min.js"></script>
<script src="<%=basePath%>common/layui-v2.3.0/layui.js" charset="utf-8"></script>

</head>
<body>

	<form class="layui-form" action="<%=basePath%>/message/accepted">

<br>
<!-- 		<hr class="layui-bg-red"> -->
		&emsp;
		<div class="layui-inline">
			<div class="layui-input-inline" style="width: 80px;">
				<input type="button" class="layui-btn layui-btn-danger" value="添加角色"
					onclick="addRole();">
			</div>

		</div>


		<!-- 列表, test -->
		<table class="layui-hide" id="roleList" lay-filter="demoEvent"></table>
	</form>

	<script type="text/html" id="toolBar">
 <a data-method="notice" class="layui-btn layui-btn-sm" lay-event="authManagement">权限</a>
</script>

	<!-- 列表内容, form -->
	<script>			
		layui.use(['form','layer','table'], function(){
          	var table = layui.table,form = layui.form,$=layui.$;
          	 var layer = layui.layer;
          	table.render({
            	elem: '#roleList'  //绑定table id
            	,url:'<%=basePath%>/queryroles'  //数据请求路径
            	,cellMinWidth: 80
            	,cols: [[
            		
                   { field: 'num', width:200, title: '编号', event: 'setSign', style:'cursor: pointer;', sort: true , align:'center'}
                   ,{ field: 'id', width:250, title: '角色ID', sort: true , align:'center'}        
                   ,{ field: 'name', width:280, title: '角色名', sort: true , align:'center'}   
                   ,{ field: 'status', width:250, title: '角色状态', sort: true , align:'center' , templet : function(d){
                	 	return d.status == 1?"正常":"<span style='color: red'>禁用<span>"
                   }}  
                  ,{field: 'right', title: '操作', width:200, align:'center', toolbar: '#toolBar'}//一个工具栏  具体请查看layui官网
            	]]
            
            ,page: true   //开启分页
            ,limit:10   //默认十条数据一页
            ,limits:[10,20,30,50]  //数据分页条
            ,id: 'userReload'
            ,done: function(res, curr, count){
            	} 
            	
          });

            form.on('submit(formDemo2)', function(data){
            	table.reload('userReload',{
                    method:'post',
                    where:{param:JSON.stringify(data.field)},
                    page: {
                        curr: 1 //重新从第 1 页开始
                      }
                });

               /*  layer.msg(JSON.stringify(data.field)); */
                return false;
              });
            
            //监听工具条
            table.on('tool(demoEvent)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
              var data = obj.data //获得当前行数据
              if(obj.event === 'authManagement') {
    				var url = '<%=basePath%>queryroleauthority/' + data.id;
				layer.open({
					type : 2,
					title : '权限管理',
					closeBtn : 1,
					id : 'authForRole',
					area : [ '630px', '480px' ],
					/* skin : "layui-layer-molv", */
					/* skin: 'layui-layer-lan', */
					skin: 'layui-layer-molv', //加上边框
					anim: 5,
					content : url,
					end : function() {
					}
				});

			}
			});

		});
		
		function addRole(){
			var url = '<%=basePath%>pages/user/addrole.jsp?';
			layer.open({
				type : 2,
				title : '创建角色',
				closeBtn : 1,
				id : 'addRole',
				area : [ '400px', '250px' ],
				/* skin : "layui-layer-molv", */
				/* skin: 'layui-layer-lan', */
				skin: 'layui-layer-molv', //加上边框
				anim: 5,
				content : url,
				end : function() {
					layer.closeAll();
				}
			});
		}
		
	</script>


</body>


</html>