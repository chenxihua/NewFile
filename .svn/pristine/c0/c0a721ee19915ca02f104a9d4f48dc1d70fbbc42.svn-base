<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://shiro.apache.org/tags" prefix="shiro"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户关系管理系统</title>

<%
	String basePath = request.getContextPath() + "/";
%>
<base href="<%=basePath%>" />
<link rel="stylesheet" type="text/css" href="common/layui/css/layui.css"
	media="all">
<link rel="stylesheet" type="text/css" href="common/global.css"
	media="all">
<link rel="stylesheet" type="text/css" href="css/adminstyle.css"
	media="all">


</head>
<body>



	<div class="layui-layout layui-layout-admin" id="layui_layout">
		<!-- 顶部区域 -->
		<div class="layui-header header header-demo">
			<div class="layui-main">
				<!-- logo区域 -->
				<div class="admin-logo-box">
					<a class="logo" href="pages/public/commonuserPage.jsp" title="logo">CRM
						管理系统</a>
					<!-- <div class="larry-side-menu">
					 <i class="fa fa-bars" aria-hidden="true"></i>
				</div> -->
				</div>
				<!-- 顶级菜单区域 -->
				<div class="layui-larry-menu"></div>
				<!-- 右侧导航 -->
				<ul class="layui-nav larry-header-item">
					<li class="layui-nav-item">账户名：${name}</li>

					<li class="layui-nav-item"><a href="javascript:readyLogout()"> <i
							class="iconfont icon-exit"></i> 退出
					</a></li>
				</ul>
			</div>
		</div>
		<!-- 左侧侧边导航开始 -->
		<div class="layui-side layui-side-bg layui-larry-side" id="larry-side">
			<div class="layui-side-scroll" id="larry-nav-side" lay-filter="side">

				<!-- 左侧菜单 -->
				<ul class="layui-nav layui-nav-tree">
					<li class="layui-nav-item layui-this"><a href="javascript:;"
						data-url="pages/public/commonuserPage.jsp"> <i
							class="iconfont icon-home1" data-icon='icon-home1'></i> <span>后台首页</span>
					</a></li>
					<shiro:hasPermission name="销售机会">
					<!-- 销售机会模块 -->
					<li class="layui-nav-item"><a href="javascript:;"> <i
							class="iconfont icon-jiaoseguanli2"></i> <span>销售机会</span> <em
							class="layui-nav-more"></em>
					</a>
						<dl class="layui-nav-child">
							<!-- 主管动作 -->
							<shiro:hasPermission name="销售机会审核">
							<dd>
								<a href="javascript:;" data-url="pages/sale/saletables.jsp">
									<i class="iconfont icon-yonghu1" data-icon='icon-yonghu1'></i>
									<span>销售机会审核</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<shiro:hasPermission name="分配销售机会">
							<dd>
								<a href="javascript:;" data-url="pages/sale/saleToGoAudit.jsp">
									<i class="iconfont icon-yonghu1" data-icon='icon-yonghu1'></i>
									<span>分配销售机会</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<shiro:hasPermission name="销售超期不开发">
							<dd>
								<a href="javascript:;" data-url="pages/sale/overtimeSale.jsp">
									<i class="iconfont icon-jiaoseguanli4"
									data-icon='icon-jiaoseguanli4'></i> <span>销售超期不开发</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<!-- 经理动作 -->
							<shiro:hasPermission name="新建销售机会">
							<dd>
								<a href="javascript:;" data-url="pages/sale/addSalePage.jsp">
									<i class="iconfont icon-jiaoseguanli4"
									data-icon='icon-jiaoseguanli4'></i> <span>新建销售机会</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<shiro:hasPermission name="销售机会开发">
							<dd>
								<a href="javascript:;" data-url="pages/sale/exploitSale.jsp">
									<i class="iconfont icon-jiaoseguanli4"
									data-icon='icon-jiaoseguanli4'></i> <span>销售机会开发</span>
								</a>
							</dd>
							</shiro:hasPermission>
						</dl></li>
						</shiro:hasPermission>
					<!-- ----------------------------------------------------- -->
					<shiro:hasPermission name="客户管理">
					<!-- 客户管理模块 -->
					<li class="layui-nav-item"><a href="javascript:;"> <i
							class="iconfont icon-jiaoseguanli2"></i> <span>客户管理</span> <em
							class="layui-nav-more"></em>
					</a>
						<dl class="layui-nav-child">
							<!-- 经理动作 -->
							<shiro:hasPermission name="客户信息录入">
							<dd>
								<a href="javascript:;" data-url="pages/client/preInsertClient.jsp"> <i
									class="iconfont icon-yonghu1" 
									data-icon='icon-yonghu1'></i><span>客户信息录入</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<shiro:hasPermission name="查看客户信息">
							<dd>
								<a href="javascript:;" data-url="pages/client/clientInfos.jsp"> <i
									class="iconfont icon-yonghu1" 
									data-icon='icon-yonghu1'></i><span>查看客户信息</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<shiro:hasPermission name="客户流失处理">
							<dd>														
								<a href="javascript:;" data-url="<%=basePath%>pages/outflow/handleOutflowList.jsp"> <i
									class="iconfont icon-jiaoseguanli4"
									data-icon='icon-jiaoseguanli4'></i> <span>客户流失处理</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<shiro:hasPermission name="客户流失管理">
							<dd>													
								<a href="javascript:;" data-url="<%=basePath%>pages/outflow/outflowList.jsp"> <i
									class="iconfont icon-jiaoseguanli4"
									data-icon='icon-jiaoseguanli4'></i> <span>客户流失管理</span>
								</a>
							</dd>
							</shiro:hasPermission>
							
						</dl></li>
						</shiro:hasPermission>

					<shiro:hasPermission name="服务管理">
					<!-- 服务和业务管理模块 -->
					<li class="layui-nav-item"><a href="javascript:;"> <i
							class="iconfont icon-jiaoseguanli2"></i> <span>服务管理</span> <em
							class="layui-nav-more"></em>
					</a>
						<dl class="layui-nav-child">
							<shiro:hasPermission name="服务处理">
							<dd>							
								<a href="javascript:;"
									data-url="<%=basePath%>pages/service/handleList.jsp"> <i
									class="iconfont icon-yonghu1" data-icon='icon-yonghu1'></i> <span>服务处理</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<shiro:hasPermission name="服务反馈">
							<dd>
								
								<a href="javascript:;"
									data-url="<%=basePath%>pages/service/feedbackList.jsp"> 
									<i class="iconfont icon-jiaoseguanli4"
									data-icon='icon-jiaoseguanli4'></i> <span>服务反馈</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<shiro:hasPermission name="服务归档">
							<dd>
								<a href="javascript:;"
									data-url="<%=basePath%>pages/service/archiveList.jsp"> 
									<i class="iconfont icon-jiaoseguanli4"
									data-icon='icon-jiaoseguanli4'></i> <span>服务归档</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<shiro:hasPermission name="服务分配">
							<dd>
							
								<a href="javascript:;"
									data-url="<%=basePath%>pages/service/assignList.jsp"> 
									<i class="iconfont icon-jiaoseguanli4"
									data-icon='icon-jiaoseguanli4'></i> <span>服务分配</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<shiro:hasPermission name="服务归档和再分配">
							<dd>
								<a href="javascript:;"
									data-url="<%=basePath%>pages/service/reAssignList.jsp">
									<i class="iconfont icon-jiaoseguanli4"
									data-icon='icon-jiaoseguanli4'></i> <span>服务归档和再分配</span>
								</a>
							</dd>
							</shiro:hasPermission>					
						</dl></li>
					</shiro:hasPermission>

					<shiro:hasPermission name="统计报表">
						<!-- 统计报表模块 -->
						<li class="layui-nav-item"><a href="javascript:;"> <i
								class="iconfont icon-jiaoseguanli2"></i> <span>统计报表</span> <em
								class="layui-nav-more"></em>
						</a>
							<dl class="layui-nav-child">
								<shiro:hasPermission name="客户贡献度分析">
								<dd>
									<a href="javascript:;" data-url="pages/basic/contribute.jsp"> <i
										class="iconfont icon-yonghu1" data-icon='icon-yonghu1'></i> <span>客户贡献度分析</span>
									</a>
								</dd>
								</shiro:hasPermission>
								<shiro:hasPermission name="客户构成分析">
								<dd>
									<a href="javascript:;" data-url="pages/sale/clientConisit.jsp"> <i
										class="iconfont icon-jiaoseguanli4" 
										data-icon='icon-jiaoseguanli4'></i> <span>客户构成分析</span>
									</a>
								</dd>
								</shiro:hasPermission>
								<shiro:hasPermission name="客户服务分析">
								<dd>
									<a href="javascript:;" data-url="<%=basePath%>pages/service/serviceStatistics.jsp"> <i
										class="iconfont icon-jiaoseguanli4"
										data-icon='icon-jiaoseguanli4'></i> <span>客户服务分析</span>
									</a>
								</dd>
								</shiro:hasPermission>
							</dl></li>

					</shiro:hasPermission>

					<shiro:hasPermission name="基础数据管理">
					<!-- 基础数据模块 -->
					<li class="layui-nav-item"><a href="javascript:;"> <i
							class="iconfont icon-jiaoseguanli2"></i> <span>基础数据管理</span> <em
							class="layui-nav-more"></em>
					</a>
						<dl class="layui-nav-child">
							<shiro:hasPermission name="产品列表">
							<dd>
								<a href="javascript:;" 
								data-url="pages/basic/productServices.jsp"> 
								<i class="iconfont icon-yonghu1" 
								data-icon='icon-yonghu1'></i> 
									<span>产品列表</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<shiro:hasPermission name="历史订单列表">
							<dd>
								<a href="javascript:;"
									data-url="pages/basic/ordersServices.jsp"> 
									<i class="iconfont icon-jiaoseguanli4"
									data-icon='icon-yonghu1'></i> 
									<span>历史订单列表</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<shiro:hasPermission name="订单项列表">
							<dd>
								<a href="javascript:;"
									data-url="<%=basePath%>/pages/basic/ordersItemServices.jsp"> <i
									class="iconfont icon-jiaoseguanli4"
									data-icon='icon-yonghu1'></i> 
									<span>订单项列表</span>
								</a>
							</dd>
							</shiro:hasPermission>
						</dl></li>
					</shiro:hasPermission>

					<shiro:hasPermission name="用户中心">
					<!-- 用户中心模块 -->
					<li class="layui-nav-item"><a href="javascript:;"> <i
							class="iconfont icon-jiaoseguanli2"></i> <span>用户中心</span> <em
							class="layui-nav-more"></em>
					</a>
						<dl class="layui-nav-child">
							<shiro:hasPermission name="公告栏">
							<dd>
								<a href="javascript:;" data-url="pages/user/message.jsp"> <i
									class="iconfont icon-yonghu1" data-icon='icon-yonghu1'></i> <span>公告栏</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<shiro:hasPermission name="发送邮件">
							<dd>
								<a href="javascript:;" data-url="pages/utils/sendEmails.jsp"> <i
									class="iconfont icon-yonghu1" 
									data-icon='icon-yonghu1'></i><span>发送邮件</span>
								</a>
							</dd>
							</shiro:hasPermission>
							
							<shiro:hasPermission name="个人信息">
							<dd>
								<a href="javascript:;" data-url="<%=basePath%>queryuserinfo">
									<i class="iconfont icon-yonghu1" data-icon='icon-yonghu1'></i>
									<span>个人信息</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<shiro:hasPermission name="用户管理">
							<dd>
								<a href="javascript:;" data-url="<%=basePath%>pages/user/usermanagement.jsp">
									<i class="iconfont icon-yonghu1" data-icon='icon-yonghu1'></i>
									<span>用户管理</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<shiro:hasPermission name="角色管理">
							<dd>
								<a href="javascript:;" data-url="<%=basePath%>pages/user/rolemanagement.jsp">
									<i class="iconfont icon-yonghu1" data-icon='icon-yonghu1'></i>
									<span>角色管理</span>
								</a>
							</dd>
							</shiro:hasPermission>
							<shiro:hasPermission name="查看日志">
							<dd>
								<a href="javascript:;" data-url="pages/utils/logPages.jsp"> <i
									class="iconfont icon-yonghu1" 
									data-icon='icon-yonghu1'></i><span>查看日志</span>
								</a>
							</dd>
							</shiro:hasPermission>
						</dl></li>
					</shiro:hasPermission>
					<!-- ========================================= -->
					
					<!-- ------------------------以上为新增额外功能---------------------------- -->
					<!-- 友链设置 -->
					<li>
						<!-- 自己加 -->
					</li>
				</ul>
			</div>
		</div>

		<!-- 左侧侧边导航结束 -->
		<!-- 右侧主体内容 -->
		<div class="layui-body" id="larry-body"
			style="bottom: 0; border-left: solid 2px #2299ee;">
			<div class="layui-tab layui-tab-card larry-tab-box" id="larry-tab"
				lay-filter="demo" lay-allowclose="true">
				<div class="go-left key-press pressKey" id="titleLeft"
					title="滚动至最右侧">
					<i class="larry-icon larry-weibiaoti6-copy"></i>
				</div>
				<ul class="layui-tab-title">
					<li class="layui-this" id="admin-home"><i
						class="iconfont icon-diannao1"></i><em>后台首页</em></li>
				</ul>
				<div class="go-right key-press pressKey" id="titleRight"
					title="滚动至最左侧">
					<i class="larry-icon larry-right"></i>
				</div>
				<ul class="layui-nav closeBox">
					<li class="layui-nav-item"><a href="javascript:;"><i
							class="iconfont icon-caozuo"></i> 页面操作</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;" class="refresh refreshThis"><i
									class="layui-icon">&#x1002;</i> 刷新当前</a>
							</dd>
							<dd>
								<a href="javascript:;" class="closePageOther"><i
									class="iconfont icon-prohibit"></i> 关闭其他</a>
							</dd>
							<dd>
								<a href="javascript:;" class="closePageAll"><i
									class="iconfont icon-guanbi"></i> 关闭全部</a>
							</dd>
						</dl></li>
				</ul>
				<div class="layui-tab-content" style="min-height: 150px;">
					<div class="layui-tab-item layui-show">
						<iframe class="larry-iframe" data-id='0'
							src="pages/public/commonuserPage.jsp"></iframe>
					</div>
				</div>
			</div>
		</div>
		<!-- 底部区域 -->
		<div class="layui-footer layui-larry-foot" id="larry-footer">
			<div class="layui-mian">
				<p class="p-admin">
					<span>2018 &copy;</span> Sonder, 版权所有
				</p>
			</div>
		</div>
	</div>
	<!-- 加载js文件-->
	<script type="text/javascript" src="common/layui/layui.js"></script>
	<script type="text/javascript" src="js/larry.js"></script>
	<script type="text/javascript" src="js/index.js"></script>
	<!-- 锁屏 -->
	<div class="lock-screen" style="display: none;">
		<div id="locker" class="lock-wrapper">
			<div id="time"></div>
			<div class="lock-box center">
				<img src="images/userimg.jpg" alt="">
				<h1>admin</h1>
				<duv class="form-group col-lg-12"> <input type="password"
					placeholder='锁屏状态，请输入密码解锁' id="lock_password"
					class="form-control lock-input" autofocus name="lock_password">
				<button id="unlock" class="btn btn-lock">解锁</button>
				</duv>
			</div>
		</div>
	</div>

<script>
		layui.use([ 'layer', 'form', 'element' ], function() {
			var layer = layui.layer, form = layui.form, element = layui.element
			
		});

		
		function closeAdduser(){
			window.parent.location.reload();
		}
	</script>
	
	<script type="text/javascript">
	function readyLogout(){
		layer.open({
			type : 1,
			offset : 'auto',
			skin : "layui-layer-molv",
		    /* skin: 'layui-layer-lan', */
			id : 'layer2' ,
			offset: 'auto',
			area : [ '280px', '200px' ],
			content : '<div style="width: 130px;padding: 30px;margin-left: 65px;margin-top: 5px; font-size: 18px;line-height: 22px; font-weight: 300;">确认退出？</div>',
			btn : ['确定','关闭'],
			btnAlign : 'c' ,
			shade : 0.5 ,
			yes : function() {
				window.location.href='logoutcrm';
			}
		});
	}
	</script>
	
		<script type="text/javascript">
    window.onload = function(){
        history.forward();
    }
</script>
</body>
</html>