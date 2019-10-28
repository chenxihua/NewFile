<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>数据可视化</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />

<script src="js/echarts.js"></script>
<script src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="common/layui/layui.js"></script>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">

</head>
<body>


<div class="layui-container"> 

	<!-- 客户信用等级 -->
  <div class="layui-row">
  	<div class="layui-col-md12">
  		<div style="font-size:22px;background:gray;margin:10px;padding:10px">
  			<p align="center">客户信用等级数据显示图</p>
  		</div>
  	</div>
  </div>
  <div class="layui-row">
    <div class="layui-col-md6">
    	<div id="main1" style="width: 350px;height:330px;"></div>
    </div>
    <div class="layui-col-md6">
        <div id="main2" style="width: 350px;height:330px;"></div>
    </div>
  </div>
  
  <!-- 客户满意度 -->
  <div class="layui-row">
  	<div class="layui-col-md12">
  		<div style="font-size:22px;background:gray;margin:10px;padding:10px">
  			<p align="center">客户满意度数据显示图</p>
  		</div>
  	</div>
  </div>
  <div class="layui-row">
    <div class="layui-col-md6">
    	<div id="satisfaction1" style="width: 350px;height:330px;"></div>
    </div>
    <div class="layui-col-md6">
        <div id="satisfaction2" style="width: 350px;height:330px;"></div>
    </div>
  </div>
  
  <!-- 客户等级 -->
  <div class="layui-row">
  	<div class="layui-col-md12">
  		<div style="font-size:22px;background:gray;margin:10px;padding:10px">
  			<p align="center">客户等级数据显示图</p>
  		</div>
  	</div>
  </div>
  <div class="layui-row">
    <div class="layui-col-md6">
    	<div id="clientClass1" style="width: 350px;height:330px;"></div>
    </div>
    <div class="layui-col-md6">
        <div id="clientClass2" style="width: 350px;height:330px;"></div>
    </div>
  </div>
  
</div>




<script>
	// 指定图表的配置项和数据（信用等级饼图） 
	var myChart1 = echarts.init(document.getElementById('main1'));
	myChart1.showLoading();
	$.get('client/showClientCredit').done(function (data) {
		var creditDatas = data.data;
		var credits = [];
		for(var i=0;i<creditDatas.length;i++){
			credits.push(creditDatas[i].counts);
		}
		myChart1.hideLoading();
	    myChart1.setOption({
	    	title: {
	            text: '客户信用等级饼图',
	            x:'center'
	        },
	        itemStyle: {
	            shadowBlur: 200,
	            shadowOffsetX: 0,
	            shadowOffsetY: 0,
	            shadowColor: 'rgba(0, 0, 0, 0.5)'
	        },
	        series : [
	            {
	                name: '客户信用等级',
	                type: 'pie',
	                radius: '55%',
	                data:[
	                    {value:credits[0], name:'一星'},
	                    {value:credits[1], name:'两星'},
	                    {value:credits[2], name:'三星'},
	                    {value:credits[3], name:'四星'},
	                    {value:credits[4], name:'五星'}
	                ]
	            }
	        ]
	    });
	});
</script>
<script type="text/javascript">
// 指定图表的配置项和数据（信用等级其他图） 
var myChart2 = echarts.init(document.getElementById('main2'));
myChart2.showLoading();
$.get('client/showClientCredit').done(function (data) {
	var creditDatas = data.data;
	var credits = [];
	for(var i=0;i<creditDatas.length;i++){
		credits.push(creditDatas[i].counts);
	}
	myChart2.hideLoading();
	myChart2.setOption({
        title: {
            text: '客户信用等级柱状图'
        },
        tooltip: {},
        xAxis: {
            data: ["一星","两星","三星","四星","五星"]
        },
        yAxis: {},
        series: [{
            name: '数量',
            type: 'bar',
            data: credits
        }]
    });
});
</script> 
<!--    二           -->
<script>
	// 指定图表的配置项和数据（信用等级饼图） 
	var myChart3 = echarts.init(document.getElementById('satisfaction1'));
	myChart3.showLoading();
	$.get('client/showSatisfaction').done(function (data) {
		var satisfactDatas = data.data;
		var satis = [];
		for(var i=0;i<satisfactDatas.length;i++){
			satis.push(satisfactDatas[i].counts);
		}
		myChart3.hideLoading();
	    myChart3.setOption({
	    	title: {
	            text: '客户满意度饼图',
	            x:'center'
	        },
	        itemStyle: {
	            shadowBlur: 200,  // 阴影的大小
	            shadowOffsetX: 0,  // 阴影水平方向上的偏移
	            shadowOffsetY: 0,  // 阴影垂直方向上的偏移
	            shadowColor: 'rgba(0, 0, 0, 0.5)'  // 阴影颜色
	        },
	        series : [
	            {
	                name: '',
	                type: 'pie',
	                radius: '55%',
	                data:[
	                    {value:satis[0], name:'一星'},
	                    {value:satis[1], name:'两星'},
	                    {value:satis[2], name:'三星'},
	                    {value:satis[3], name:'四星'},
	                    {value:satis[4], name:'五星'}
	                ]
	            }
	        ]
	    });
	});
</script>
<script type="text/javascript">
// 指定图表的配置项和数据（信用等级其他图） 
var myChart4 = echarts.init(document.getElementById('satisfaction2'));
myChart4.showLoading();
$.get('client/showSatisfaction').done(function (data) {
	var satisfactDatas = data.data;
	var satis = [];
	for(var i=0;i<satisfactDatas.length;i++){
		satis.push(satisfactDatas[i].counts);
	}
	myChart4.hideLoading();
	myChart4.setOption({
        title: {
            text: '客户满意度等级柱状图'
        },
        tooltip: {},
        xAxis: {
            data: ["一星","两星","三星","四星","五星"]
        },
        yAxis: {},
        series: [{
            name: '数量',
            type: 'bar',
            data: satis
        }]
    });
});
</script> 
<!--  =========  三     ============= -->
<script>
	// 指定图表的配置项和数据（信用等级饼图） 
	var myChart5 = echarts.init(document.getElementById('clientClass1'));
	myChart5.showLoading();
	$.get('client/showClientClasses').done(function (data) {
		var classDatas = data.data;
		var classes = [];
		for(var i=0;i<classDatas.length;i++){
			classes.push(classDatas[i].counts);
		}
		myChart5.hideLoading();
	    myChart5.setOption({
	    	title: {
	            text: '客户战略等级饼图', 
	            x:'center'
	        },
	        itemStyle: {
	            shadowBlur: 200,
	            shadowOffsetX: 0,
	            shadowOffsetY: 0,
	            shadowColor: 'rgba(0, 0, 0, 0.5)'
	        },
	        series : [
	            {
	                name: '客户信用等级',
	                type: 'pie',
	                radius: '55%',
	                data:[
	                    {value:classes[0], name:'战略合作伙伴'},
	                    {value:classes[1], name:'合作伙伴'},
	                    {value:classes[2], name:'大客户'},
	                    {value:classes[3], name:'重点客户'},
	                    {value:classes[4], name:'普通客户'}
	                ]
	            }
	        ]
	    });
	});
</script>
<script type="text/javascript">
// 指定图表的配置项和数据（信用等级其他图） 
var myChart6 = echarts.init(document.getElementById('clientClass2'));
myChart6.showLoading();
$.get('client/showClientClasses').done(function (data) {
	var classDatas = data.data;
	var classes = [];
	for(var i=0;i<classDatas.length;i++){
		classes.push(classDatas[i].counts);
	}
	myChart6.hideLoading();
	myChart6.setOption({
        title: {
            text: '客户战略等级柱状图'
        },
        tooltip: {},
        xAxis: {
            data: ["战略","合作","大客户","重点","普通"]
        },
        yAxis: {},
        series: [{
            name: '数量',
            type: 'bar',
            data: classes
        }]
    });
});
</script> 

</body>
</html>


