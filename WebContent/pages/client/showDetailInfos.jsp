<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户具体详情</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">


</head>
<body>


<br><br>
<form class="layui-form" action="" lay-filter="example">
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">客户编号</label>
      <div class="layui-input-inline">
        <input type="text" name="id" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">客户状态</label>
      <div class="layui-input-inline">
        <input type="text" name="status" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>	
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">客户名称</label>
      <div class="layui-input-inline">
        <input type="text" name="name" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">客户地区</label>
      <div class="layui-input-inline">
        <input type="text" name="areaId" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">客户经理</label>
      <div class="layui-input-inline">
        <input type="text" name="clientManager" autocomplete="off" class="layui-input">
        <!-- <select id="managerSelect" name="clientManager" lay-search  lay-verify="required" lay-filter="managerSelect"></select> -->
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">客户等级</label>
      <div class="layui-input-inline">
        <input type="text" name="clientClassId" autocomplete="off" class="layui-input">
        <!-- <select id="classSelect" name="clientClassId" lay-search  lay-verify="required" lay-filter="classSelect"></select> -->
      </div>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">客户满意度</label>
      <div class="layui-input-inline">
        <select id="satisfactSelect" name="satisfaction" lay-search  lay-verify="required">
			<option value=""></option>
			<option value="1">★</option>
			<option value="2">★★</option>
			<option value="3">★★★</option>
			<option value="4">★★★★</option>
			<option value="5">★★★★★</option>
        </select>
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">客户信用度</label>
      <div class="layui-input-inline">
        <select id="creditSelect" name="credit" lay-search  lay-verify="required">
			<option value=""></option>
			<option value="1">★</option>
			<option value="2">★★</option>
			<option value="3">★★★</option>
			<option value="4">★★★★</option>
			<option value="5">★★★★★</option>
        </select>
      </div>
    </div>
  </div>
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">地址</label>
      <div class="layui-input-inline">
        <input type="text" name="address" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">邮政编号</label>
      <div class="layui-input-inline">
        <input type="text" name="postcode" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">联系方式</label>
      <div class="layui-input-inline">
        <input type="text" name="phoneNum" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">传真</label>
      <div class="layui-input-inline">
        <input type="text" name="fax" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">网址</label>
      <div class="layui-input-inline">
        <input type="text" name="internetAddr" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">营业执照注册号</label>
      <div class="layui-input-inline">
        <input type="text" name="licenceNum" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">法人</label>
      <div class="layui-input-inline">
        <input type="text" name="corporation" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">注册资金(万元)</label>
      <div class="layui-input-inline">
        <input type="text" name="regCapital" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">年营业额(万元)</label>
      <div class="layui-input-inline">
        <input type="text" name="annualTurnover" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">开户银行</label>
      <div class="layui-input-inline">
        <input type="text" name="depositBank" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">银行账号</label>
      <div class="layui-input-inline">
        <input type="text" name="bankAccount" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">地税登记号</label>
      <div class="layui-input-inline">
        <input type="text" name="landTaxNum" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">国税登记号</label>
      <div class="layui-input-inline">
        <input type="text" name="nationalTaxNum" lay-verify="required" autocomplete="off" class="layui-input">
      </div>
    </div>
  </div>
</form>

<div class="layui-btn-group demoTable">
<button class="layui-btn" id="clientEmployee">联系人</button>
<button class="layui-btn layui-btn-success" id="contactRecord">交往记录</button>
<button class="layui-btn layui-btn-success" id="returnRrePgae">返回上页</button>
</div>


<script type="text/javascript" src="layui/layui.js"></script>
<script src="js/myutil.js"></script>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form;
  var layer = layui.layer;
  var layedit = layui.layedit;
  var laydate = layui.laydate;
  var $ = layui.$;
  
  //从url中获取参数，判断机会是更新还是添加
  var data = getParm();
  showClientDetailInfos(data.id);
  
  //根据客户表的ID获取客户实例，并填充到表单数据（重点掌握!）  
  function showClientDetailInfos(id){
  	$.ajax({
  		type: "POST",
  		url : "client/showClientById",
  		data: {"id":id},
  		dataType : "json",
  		success : function(data){
  			if(data.success){
  				console.log(data);
  				form.val('example', {
				  "id":data.data.id
  				  ,"name":data.data.name
				  ,"areaId":data.data.areaId
				  ,"address":data.data.address
				  ,"clientManager":idToString(data.data.clientManager)
				  ,"clientClassId":idToClientClass(data.data.clientClassId)
				  ,"satisfaction":data.data.satisfaction
				  ,"credit":data.data.credit
				  ,"postcode":data.data.postcode
				  ,"phoneNum":data.data.phoneNum
				  ,"fax":data.data.fax
				  ,"internetAddr":data.data.internetAddr
				  ,"licenceNum":data.data.licenceNum
				  ,"corporation":data.data.corporation
				  ,"regCapital":data.data.regCapital
				  ,"annualTurnover":data.data.annualTurnover
				  ,"depositBank":data.data.depositBank
				  ,"bankAccount":data.data.bankAccount
				  ,"landTaxNum":data.data.landTaxNum
				  ,"nationalTaxNum":data.data.nationalTaxNum
				  ,"status":data.data.status
				});
  			}
  			form.render();
  		}
  	});
  }
  
  //点击查看客户所有联系人事件  
  $("#clientEmployee").click(function(){
	  window.location.href='pages/client/clientEmployee.jsp?id='+data.id;
  });
  
  //点击查看历史记录事件 
  $("#contactRecord").click(function(){
	  window.location.href='pages/client/clientRecord.jsp?id='+data.id;
  });
  
  // 点击返回事件 
  $("#returnRrePgae").click(function(){
	  window.history.back(-1);  // 返回历史窗口 
  });
  
  
	// 这个函数是通过id查询User表中的名字，（包括客户经理）   
	function idToString(creatId){
		var countName = '';
		$.ajax({
			url:"saleChance/selectCreatorName/"+creatId,
			dataType:"json",
			async:false,
			type:"GET",
			success:function(data){
				countName = data.data.name;
			}
		});
		return countName;
	}
	
	// 这个函数是根据等级id，查询这个等级的名字 
	function idToClientClass(classId){
		var className = '';
		$.ajax({
			url:"client/selectClientClassById/"+classId,
			dataType:"json",
			async:false,
			type:"GET",
			success:function(data){
				className = data.data.name;
			}
		});
		return className;
	}
  

});
</script>


</body>


</html>




