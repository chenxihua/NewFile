<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>服务统计</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />

<script src="js/echarts.js"></script>
<script src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="common/layui/layui.js"></script>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">

</head>
<body>


<div class="layui-container"> 

  <!-- 服务类型统计 -->
  <div class="layui-row">
  	<div class="layui-col-md12">
  		<div style="font-size:22px;background:gray;margin:10px;padding:10px">
  			<p align="center">服务类型统计</p>
  		</div>
  	</div>
  </div>
  
  <div class="layui-row">
    <div class="layui-col-md6">
  	    <div id="main1" style="margin:0 atuo; width: 450px;height:400px;"></div>  	
    </div>
    <div class="layui-col-md6">
        <div id="bar1" style="width: 450px;height:400px;"></div>
    </div>
  </div>
  
  <br>
  <!-- 服务满意度统计 -->
  <div class="layui-row">
  	<div class="layui-col-md12">
  		<div style="font-size:22px;background:gray;margin:10px;padding:10px">
  			<p align="center">服务满意度统计</p>
  		</div>
  	</div>
  </div>
  
  <div class="layui-row">
    <div class="layui-col-md6">
  	    <div id="main2" style="margin:0 atuo; width: 450px;height:400px;"></div>  	
    </div>
    <div class="layui-col-md6">
        <div id="bar2" style="width: 450px;height:400px;"></div>
    </div>
  </div>
  
  <br>
  <!-- 服务状态统计 -->
  <div class="layui-row">
  	<div class="layui-col-md12">
  		<div style="font-size:22px;background:gray;margin:10px;padding:10px">
  			<p align="center">服务状态统计 </p>
  		</div>
  	</div>
  </div>
  <div class="layui-row">
    <div class="layui-col-md6">
  	    <div id="main3" style="margin:0 atuo; width: 450px;height:400px;"></div>  	
    </div>
   	<div class="layui-col-md6">
        <div id="bar3" style="width: 450px;height:400px;"></div>
    </div>
  </div>
    
</div>

</body>
<script>
	// 指定图表的配置项和数据（服务类型饼图） 
	var myChart1 = echarts.init(document.getElementById('main1'));
	myChart1.showLoading();
	$.get('service/serviceTypeForm').done(function (data) {
		var creditDatas = data.data;
		var credits = [];
		for(var i=0;i<creditDatas.length;i++){
			credits.push(creditDatas[i].counts);
		}
		myChart1.hideLoading();
	    myChart1.setOption({
	    	title: {
	            text: '服务类型饼图',
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
	                name: '',
	                type: 'pie',
	                radius: '55%',
	             	//饼图图形上的文本标签
	                label:{            
	                    normal:{
	                            show:true,
	                            //标签的位置
	                            textStyle : {
	                            fontWeight : 300 ,
	                            fontSize : 14   
	                         },
	                         formatter:'{b} :\n {c} ({d}%)'
	                         }
	                }, 
	                data:[
	                    {value:credits[0], name:'咨询'},
	                    {value:credits[1], name:'建议'},
	                    {value:credits[2], name:'投诉'}
	                ]
	            }
	        ]

	    });
	});
</script>

<script type="text/javascript">
// 指定图表的配置项和数据（服务类型柱状图） 
var myBar1 = echarts.init(document.getElementById('bar1'));
myBar1.showLoading();
$.get('service/serviceTypeForm').done(function (data) {
	var creditDatas = data.data;
	var credits = [];
	for(var i=0;i<creditDatas.length;i++){
		credits.push(creditDatas[i].counts);
	}
	myBar1.hideLoading();
	myBar1.setOption({
        title: {
            text: '服务类型柱状图'
        },
        tooltip: {},
        xAxis: {
            data: ["咨询","建议","投诉"]
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

<script>
//指定图表的配置项和数据（服务满意度饼图） 
var myChart2 = echarts.init(document.getElementById('main2'));
myChart2.showLoading();
$.get('service/serviceSatisfactionForm').done(function (data) {
	var satisfactDatas = data.data;
	var satis = [];
	for(var i=0;i<satisfactDatas.length;i++){
		satis.push(satisfactDatas[i].counts);
	}
	myChart2.hideLoading();
    myChart2.setOption({
    	title: {
            text: '客户满意度统计',
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
                name: '客户满意度统计',
                type: 'pie',
                radius: '55%',
             	//饼图图形上的文本标签
                label:{            
                    normal:{
                            show:true,
                            //标签的位置
                            textStyle : {
                            fontWeight : 300 ,
                            fontSize : 14   
                         },
                         formatter:'{b} :\n {c} ({d}%)'
                         }
                }, 
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
//指定图表的配置项和数据（服务满意度柱状图） 
var myBar2 = echarts.init(document.getElementById('bar2'));
myBar2.showLoading();
$.get('service/serviceSatisfactionForm').done(function (data) {
	var satisfactDatas = data.data;
	var satis = [];
	for(var i=0;i<satisfactDatas.length;i++){
		satis.push(satisfactDatas[i].counts);
	}
	myBar2.hideLoading();
	myBar2.setOption({
        title: {
            text: '客户满意度柱状图'
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

<script>
//指定图表的配置项和数据（服务状态饼图） 
var myChart3 = echarts.init(document.getElementById('main3'));
myChart3.showLoading();
$.get('service/serviceStatusForm').done(function (data) {
	var satisfactDatas = data.data;
	var satis = [];
	for(var i=0;i<satisfactDatas.length;i++){
		satis.push(satisfactDatas[i].counts);
	}
	myChart3.hideLoading();
    myChart3.setOption({
    	title: {
            text: '客户状态统计',
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
                name: '客户状态统计',
                type: 'pie',
                radius: '55%',
             	//饼图图形上的文本标签
                label:{            
                    normal:{
                            show:true,
                            //标签的位置
                            textStyle : {
                            fontWeight : 300 ,
                            fontSize : 14   
                         },
                         formatter:'{b} :\n {c} ({d}%)'
                         }
                }, 
                data:[
                    {value:satis[0], name:'已创建'},
                    {value:satis[1], name:'等待分配'},
                    {value:satis[2], name:'已分配'},
                    {value:satis[3], name:'等待反馈'},
                    {value:satis[4], name:'处理成功'},
                    {value:satis[4], name:'处理失败'}
                ]
            }
        ]
    });
});
</script>

<script type="text/javascript">
//指定图表的配置项和数据（服务状态柱状图） 
var mybar3 = echarts.init(document.getElementById('bar3'));
mybar3.showLoading();
$.get('service/serviceStatusForm').done(function (data) {
	var satisfactDatas = data.data;
	var satis = [];
	for(var i=0;i<satisfactDatas.length;i++){
		satis.push(satisfactDatas[i].counts);
	}
	mybar3.hideLoading();
	mybar3.setOption({
        title: {
            text: '服务状态柱状图'
        },
        tooltip: {},
        xAxis: {
            data: ["已创建","等待分配","已分配","等待反馈","处理成功", "处理失败 "]
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

</html>


