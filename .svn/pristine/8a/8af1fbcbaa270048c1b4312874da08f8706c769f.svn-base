<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>myProject</title>
<% String name = (String)session.getAttribute("username"); %>
<%
	String basePath = request.getContextPath()+"/";
%>
<base href="<%=basePath %>" />
<script src="js/echarts.js"></script>
<script src="js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="common/layui/layui.js"></script>
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">
</head>
<body>
   <body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom 
    <div id="main" style="width: 800px;height:600px;"></div>   -->  
    <div class="layui-row">
  	<div class="layui-col-md12">
  		<div style="font-size:22px;background:gray;margin:10px;padding:10px">
  			<p align="center">客户贡献度数据示意图</p>
  		</div>
  	</div>
  </div>
  
  <div class="layui-row">
    <div class="layui-col-md12">
    	<div id="bar-draw" style="width: 800px;height:600px;"></div>
    </div> 
  </div>
  
  <div class="layui-row">
    <div class="layui-col-md12">
        <div id="pie-draw" style="width: 1000px;height:800px;"></div>
    </div>
  </div>
  
</body>
</body>

<script>
	// 指定图表的配置项和数据
	var myChart1 = echarts.init(document.getElementById('pie-draw'));
	$.get("orders/echarts").done(function(result){
		//拿到数据放入var定义的各个数组中
	   // console.log(result.data); 
		myChart1.hideLoading();
	    myChart1.setOption({
	        title: {
	        },
	        tooltip: {},
	        legend: {
	        	orient: 'vertical',
	        	left: 'left'
	        },
	        
	        series:[{
	       		/* name:'客户名称', */
	       		type:'pie',
	       		/* roseType: 'angle', */
	       		//饼图的半径大小  
	       		radius : '55%',
	       		//饼图的位置 
                right: ['80%', '55%'],
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
	       		data:(function () {
	       		 var datas = result.data;
	       		 var arr=[];
	       		 for(var i=0;i<datas.length;i++){
	       			 arr.push({"name":datas[i].clientName,"value":datas[i].money});
	       		 }
                    return arr;
                })()
	       	 }]
	    }); 
	}) 
</script>
<script>
// 指定图表的配置项和数据
	var myChart2 = echarts.init(document.getElementById('bar-draw'));
	$.get("orders/echarts").done(function(result){
		//拿到数据放入var定义的各个数组中
	    var datas = result.data;
	    console.log(datas); 
	    var dataClientName=[];
	    var dataMoney=[];
	    for(var i=0;i<datas.length;i++){
	    	dataClientName.push(datas[i].clientName);
	    	dataMoney.push(datas[i].money);
	    } 
	    
		myChart2.hideLoading();
	    myChart2.setOption({
	        title: {
	            text: '柱状图' 
	        },
	        tooltip: {},
			
	        legend: {
	           /*  data:['客户id']  */
	        },
	        grid: {
	            left: '5%',
	            right: '10%',
	            bottom: '5%',
	            containLabel: true
	        },
	        xAxis: {
	           data: dataClientName,
	           axisTick: {
	                alignWithLabel: true
	            },
		        axisLabel:{
		        	interval: '0',//横轴全部显示
		        	rotate : -30,//-30度倾角
		        }
	        },
	        yAxis: {},
	        series:[{
	       		type:'bar',
	       		barCategoryGap:'40%',
	       		data:(function () {
		       		 var datas = result.data;
		       		 var arr=[];
		       		 for(var i=0;i<datas.length;i++){
		       			 arr.push({"name":datas[i].clientName,"value":datas[i].money});
		       		 }
	                    return arr;
	                })()
	       	 }]
	    }); 
	})
</script>
</html>