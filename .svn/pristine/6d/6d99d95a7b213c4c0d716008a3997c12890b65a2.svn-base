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
<title>用户列表</title>
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
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 50px;">用户ID</label>
			<div class="layui-input-inline" style="width: 100px;">
				<input type="text" name="id" autocomplete="off" class="layui-input">
			</div>
		</div>


		<div class="layui-inline">
			<label class="layui-form-label" style="width: 60px;">角色</label>
			<div class="layui-input-inline" style="width: 100px;">
				<select name="roleId" lay-verify="">
					<option value="0" selected>&emsp;全部</option>
					<option value="3">客户经理</option>
					<option value="2">&emsp;主管</option>
					<option value="4">&emsp;高管</option>
				</select>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 80px;">账号状态</label>
			<div class="layui-input-inline" style="width: 100px;">
				<select name="status" lay-verify="">
					<option value="2" selected>&emsp;全部</option>
					<option value="1">&emsp;正常</option>
					<option value="0">禁止登陆</option>
				</select>
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 110px;">上次登录时间</label>
			<div class="layui-input-inline" style="width: 150px;">
				<input type="text" name="beginTime" autocomplete="off"
					class="layui-input" id="beginDate" placeholder="年-月-日   时 :分:秒">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 5px;">-</label>
			<div class="layui-input-inline" style="width: 150px;">
				<input type="text" name="endTime" autocomplete="off"
					class="layui-input" id="endDate" placeholder="年-月-日   时 :分:秒">
			</div>
		</div>
		&emsp;&emsp;
		<button class="layui-btn layui-btn-normal" lay-submit
			lay-filter="formDemo2">查&nbsp;&nbsp;询</button>
		&nbsp;
		<hr class="layui-bg-gray">
		&emsp;
		<div class="layui-inline">
			<div class="layui-input-inline" style="width: 80px;">
				<input type="button" class="layui-btn layui-btn-danger" value="创建用户"
					onclick="register();">
			</div>

		</div>


		<!-- 列表, test -->
		<table class="layui-hide" id="userList" lay-filter="demoEvent"></table>
	</form>

	<script type="text/html" id="toolBar">
 <a data-method="notice" class="layui-btn layui-btn-sm" lay-event="toupdateuserinfo">编辑</a>
</script>

	<!-- 列表内容, form -->
	<script>			
		layui.use(['form','layer','table'], function(){
          	var table = layui.table,form = layui.form,$=layui.$;
          	 var layer = layui.layer;
          	table.render({
            	elem: '#userList'  //绑定table id
            	,url:'<%=basePath%>/queryusers'  //数据请求路径
            	,cellMinWidth: 80
            	,cols: [[
            		
                   { field: 'num', width:120, title: '编号', event: 'setSign', style:'cursor: pointer;', sort: true , align:'center'}
                   ,{ field: 'id', width:120, title: '用户ID', sort: true , align:'center'}        
                   ,{ field: 'name', width:160, title: '用户名', sort: true , align:'center'}   
                   ,{ field: 'roleName', width:160, title: '角色', sort: true , align:'center'} 
                   ,{ field: 'superior', width:160, title: '上级', sort: true , align:'center'} 
                   ,{ field: 'accountStatus', width:150, title: '账号状态', sort: true , align:'center' , templet : function(d){
                	 	return d.accountStatus == "正常"?"正常":"<span style='color: red'>禁止登陆<span>"
                   }}  
                  ,{ field: 'lastLoginTime', width:160, title: '上次登录时间',align:'center', templet :function (row){
                      return createTime(row.lastLoginTime);
                  }
                  }        
                  ,{field: 'right', title: '操作', width:150, align:'center', toolbar: '#toolBar'}//一个工具栏  具体请查看layui官网
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
              if(obj.event === 'toupdateuserinfo') {
    				var url = '<%=basePath%>toupdateuserinfo/' + data.id;
				layer.open({
					type : 2,
					title : '个人信息',
					closeBtn : 1,
					id : 'userDetails',
					area : [ '400px', '500px' ],
					/* skin : "layui-layer-molv", */
					/* skin: 'layui-layer-lan', */
					skin: 'layui-layer-molv', //加上边框
					btn : [ '保存','关闭' ],
					anim: 5,
					content : url,
					yes: function(index , layero){
						 /* var userData = window["layui-layer-iframe" + index].getIFrameDate(); */
						 
						 var userData = $(layero).find("iframe")[0].contentWindow.getData();

						 var flag = true;
							var reg = new RegExp("^[0-9]*$");
							 if((userData.userId == "") || (userData.userId == null)){
									layer.msg('请输入上级ID，没有则填0', {
										  icon: 2,
										  time: 3000 
										});
									
									flag = false;
								} 

							if (!(reg.test(userData.userId))){
									layer.msg('上级ID只能输入数值型字符', {
										  icon: 2,
										  time: 3000 
										});   
									flag = false;
								}
						 if(flag){
							 $.ajax({
						            url:"<%=basePath%>updateuserinfo"
						            ,data:userData
						            ,type:"Post"
						            ,dataType:"json"
						            ,success: function (data) {
			                        	 if(data.result){
			                        		 layer.open({
							            	        type: 1
							            	        ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
							            	        ,id: 'layer2' //防止重复弹出
							            	        ,content: '<i class="layui-icon layui-icon-face-smile" style="font-size: 50px; color: #1E9FFF; margin-left: 40%;"></i> ' + '<div style="padding: 20px 100px;">' +"修改成功" +'</div>'
							            	        ,btn: '确定'
							            	        ,btnAlign: 'c' //按钮居中
							            	        ,shade: 0 //不显示遮罩
							            	        ,yes: function(){
							            	          layer.closeAll();
							                    	  location.reload();	//重载页面
							            	        }
							            	      });
			                        	 }else{
			                        		 layer.open({
							            	        type: 1
							            	        ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
							            	        ,id: 'layer3' //防止重复弹出
							            	        ,content: '<i class="layui-icon layui-icon-face-cry" style="font-size: 50px; color: #1E9FFF; margin-left: 40%;"></i> ' + '<div style="padding: 20px 100px;">' +"修改失败" +'</div>'
							            	        ,btn: '确定'
							            	        ,btnAlign: 'c' //按钮居中
							            	        ,shade: 0 //不显示遮罩
							            	        ,yes: function(){
							            	          layer.closeAll();
							            	        }
							            	      });
			                        	 }
			                         },
						            error:function(){
						                alert("错误");
						            }
						        });
						 }

				    },
					end : function() {
					}
				});

			}
			});

		});
		
		function register(){
			var url = '<%=basePath%>toadduser';
			layer.open({
				type : 2,
				title : '注册用户',
				closeBtn : 1,
				id : 'addUser',
				area : [ '400px', '500px' ],
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

	<script type="text/html" id="toolBar">
  <a data-method="notice" class="layui-btn layui-btn-sm" lay-event="detail">详情</a>
</script>
	<script type="text/javascript">
		/**
		 * 时间格式转换器
		 */
		function createTime(v) {
			
			if( v == "无"){
				return "无";
			} 
			var date = new Date(v);
			var y = date.getFullYear();
			var m = date.getMonth() + 1;
			m = m < 10 ? '0' + m : m;
			var d = date.getDate();
			d = d < 10 ? ("0" + d) : d;
			var h = date.getHours();
			h = h < 10 ? ("0" + h) : h;
			var M = date.getMinutes();
			M = M < 10 ? ("0" + M) : M;
			var str = y + "-" + m + "-" + d + " " + h + ":" + M;
			return str;
		}

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