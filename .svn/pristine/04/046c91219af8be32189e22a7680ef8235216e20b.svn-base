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
<title>公告列表</title>
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
			<label class="layui-form-label" style="width: 60px;">发布人</label>
			<div class="layui-input-inline" style="width: 80px;">
				<input type="text" name="publisher" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 50px;">标题</label>
			<div class="layui-input-inline" style="width: 130px;">
				<input id="title" type="text" name="title" autocomplete="off"
					class="layui-input">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 50px;">时间</label>
			<div class="layui-input-inline" style="width: 150px;">
				<input type="text" name="beginTime" autocomplete="off"
					class="layui-input" id="beginDate" placeholder="年-月-日 时 :分:秒">
			</div>
		</div>
		<div class="layui-inline">
			<label class="layui-form-label" style="width: 5px;">-</label>
			<div class="layui-input-inline" style="width: 150px;">
				<input type="text" name="endTime" autocomplete="off"
					class="layui-input" id="endDate" placeholder="年-月-日 时 :分:秒">
			</div>
		</div>
		&emsp;&emsp;

		<shiro:hasPermission name="发布公告">
		<div class="layui-inline">
			<div class="layui-input-inline" style="width: 100px;">
				<select name="status" lay-verify="">
				<shiro:lacksRole name="管理员">
					<option value="1" selected>已接收</option>
					<option value="2">已发布</option>
				</shiro:lacksRole>
				
				 <shiro:hasRole name="管理员">
				 	<option value="2" selected>已发布</option>
				 	<option value="1" disabled>已接收</option>
				 </shiro:hasRole>
				</select>
			</div>
		</div>

		&emsp;&emsp;

		<!-- <a href="" class="layui-btn layui-btn-normal">查询</a> -->
		<button class="layui-btn layui-btn-normal" lay-submit
			lay-filter="formDemo">查&nbsp;&nbsp;询</button>
			&nbsp;
			<hr class="layui-bg-gray">&emsp;
	<div class="layui-inline">
			<div class="layui-input-inline" style="width: 80px;">
				
<input type="button" class="layui-btn layui-btn-danger" value="发布公告" onclick="publishMsg();">
			
			</div>
		</div>
		</shiro:hasPermission>
		
		
		<shiro:lacksPermission name="发布公告">
		&emsp;
		<div class="layui-inline">
			<div class="layui-input-inline" style="width: 100px;">
				<select name="status" lay-verify="">
					<option value="1" selected>已接收</option>
					<option value="2" disabled>已发布</option>

				</select>
			</div>
		</div>
		&emsp;&emsp;
		<div class="layui-inline" style="margin-left: 30px">
			<div class="layui-input-inline" style="width: 50px;">
				
<button class="layui-btn layui-btn-normal" lay-submit
			lay-filter="formDemo">查&nbsp;&nbsp;询</button>
			
			</div>
		</div>
		</shiro:lacksPermission>
		
		<!-- 列表, test -->
		<table class="layui-hide" id="test" lay-filter="demoEvent"></table>
	</form>

	<!-- 列表内容, form -->
	<script>			
		layui.use(['form','layer','table'], function(){
          	var table = layui.table,form = layui.form,$=layui.$;
          	table.render({
            	elem: '#test'  //绑定table id
            	,url:'<%=basePath%>/message/accepted'  //数据请求路径
            	,cellMinWidth: 80
            	,cols: [[
            		
                   { field: 'id', width:120, title: '编号', event: 'setSign', style:'cursor: pointer;', sort: true , align:'center'}
                   ,{field: 'status',style:'display:none;'}          
                   ,{ field: 'publisher', width:200, title: '发布人', sort: true , align:'center'}   
                   ,{ field: 'title', width:380, title: '标题', sort: true , align:'center'}                    
                  ,{ field: 'publishTime', width:280, title: '发布时间',align:'center', templet :function (row){
                      return createTime(row.publishTime);
                  }     
                  }
                  ,{ fixed: 'right',title: '操作', width:150, align:'center', toolbar: '#toolBar'}//一个工具栏  具体请查看layui官网
                  
            	]]
            
            ,page: true   //开启分页
            ,limit:10   //默认十条数据一页
            ,limits:[10,20,30,50]  //数据分页条
            ,id: 'testReload'
            ,done: function(res, curr, count){
            	$("[data-field='status']").css('display','none');
            	}
          });
          	
            form.on('submit(formDemo)', function(data){
            	table.reload('testReload',{
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
              if(obj.event === 'detail') {
          				var url = '<%=basePath%>message/msgdetails/' + data.status;
					layer.open({
						type : 2,
						title : '公告信息',
						closeBtn : 1,
						id : 'msgDetails',
						area : [ '400px', '500px' ],
						/* skin : "layui-layer-molv", */
						/* skin: 'layui-layer-lan', */
						skin: 'layui-layer-molv', //加上边框
						btn : [ '关闭' ],
						anim: 5,
						content : url,
						end : function() {
							layer.closeAll();
						}
					});

				}

			});
		});
		
		function publishMsg(){
			var url = '<%=basePath%>pages/user/announcements.jsp?';
			layer.open({
				type : 2,
				title : '发布公告',
				closeBtn : 1,
				id : 'msgDetails',
				area : [ '450px', '500px' ],
				/* skin : "layui-layer-molv", */
				/* skin: 'layui-layer-lan', */
				skin: 'layui-layer-molv', //加上边框
				btn : [ '发布','关闭' ],
				anim: 5,
				content : url,
				yes: function(index){
					 var msgData = window["layui-layer-iframe" + index].getIFrameDate();
			        if(msgData.title.trim() == ""){
			        	layer.open({
			                type: 1 //此处以iframe举例
			                ,title: '提示'
			                ,offset: 'auto'
			                ,shade: 0
			                ,maxmin: true
			                ,content: '<i class="layui-icon layui-icon-face-surprised" style="font-size: 50px; color: #1E9FFF; margin-left: 40%;"></i> ' + '<div style="padding: 20px 100px;">' +"标题不能为空" +'</div>'
			                ,btn: ['确定'] //只是为了演示
			                ,zIndex: layer.zIndex //重点1
			                ,success: function(layero){
			                  layer.setTop(layero); //重点2
			                }
			              });
			        }else if(msgData.content.trim() == ""){
			        	layer.open({
			                type: 1 //此处以iframe举例
			                ,title: '提示'
			                ,offset: 'auto'
			                ,shade: 0
			                ,maxmin: true
			                ,content: '<i class="layui-icon layui-icon-face-surprised" style="font-size: 50px; color: #1E9FFF; margin-left: 40%;"></i> ' + '<div style="padding: 20px 100px;">' +"请填写公告内容" +'</div>'
			                ,btn: ['确定'] //只是为了演示
			                ,zIndex: layer.zIndex //重点1
			                ,success: function(layero){
			                  layer.setTop(layero); //重点2
			                }
			              });
			        }
			        else{
						 $.ajax({
					            url:"<%=basePath%>message/savemsg",
					            data:{'title':msgData.title,'content':msgData.content , 'recipient':msgData.recipients},
					            type:"Post",
					            dataType:"json",
					            success:function(data,index){
					            	if(data.success == true){
					            		layer.open({
					            	        type: 1
					            	        ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
					            	        ,id: 'layer2' //防止重复弹出
					            	        ,content: '<i class="layui-icon layui-icon-face-smile" style="font-size: 50px; color: #1E9FFF; margin-left: 40%;"></i> ' + '<div style="padding: 20px 100px;">' +"发布成功" +'</div>'
					            	        ,btn: '确定'
					            	        ,btnAlign: 'c' //按钮居中
					            	        ,shade: 0 //不显示遮罩
					            	        ,yes: function(){
					            	          layer.closeAll();
					      			        if((${id} == 1)){
					    						 location.reload();	//重载页面
					    					};
					            	        }
					            	      });
					            	}else{
					            		layer.open({
					            	        type: 1
					            	        ,offset: 'auto' //具体配置参考：http://www.layui.com/doc/modules/layer.html#offset
					            	        ,id: 'layer3' //防止重复弹出
					            	        ,content: '<i class="layui-icon layui-icon-face-cry" style="font-size: 50px; color: #1E9FFF; margin-left: 40%;"></i> ' + '<div style="padding: 20px 100px;">' +"发布失败" +'</div>'
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
					                layer.closeAll();
					            }
					        });
			        }
			    },
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