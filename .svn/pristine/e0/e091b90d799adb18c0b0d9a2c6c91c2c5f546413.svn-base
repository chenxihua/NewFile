<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增客户页面</title>

<% String basePath = request.getContextPath()+"/"; %>
<base href="<%=basePath %>" />
<link rel="stylesheet" type="text/css" href="layui/css/layui.css" media="all">

</head>
<body>


<br><br>
<form class="layui-form" action="" lay-filter="example">
	<input type="hidden" name="id" value="" />
	<input type="hidden" name="status" value="" />
	
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
        <select id="managerSelect" name="clientManager" lay-search  lay-verify="required" lay-filter="managerSelect"></select>
      </div>
    </div>
    <div class="layui-inline">
      <label class="layui-form-label">客户等级</label>
      <div class="layui-input-inline">
        <select id="classSelect" name="clientClassId" lay-search  lay-verify="required" lay-filter="classSelect"></select>
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
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn layui-btn-ms" name="demo1" lay-submit lay-filter="demo1">保 存</button>
      <button type="reset" class="layui-btn layui-btn-primary layui-btn-ms">重 置</button>
    </div>
  </div>
</form>


<script type="text/javascript" src="layui/layui.js"></script>
<script src="js/myutil.js"></script>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form;
  var layer = layui.layer;
  var layedit = layui.layedit;
  var laydate = layui.laydate;
  var $ = layui.$;
  
  var saledata = getParm();
  //渲染所有下拉框
  loadAllSelect();
  
	//点击保存事件
	form.on('submit(demo1)',function(data){
	    var formdata = data.field;
	    var saleId = saledata.id;
	    // 立志教的字符串拼接问题，可以尝试这种方法 
	    //formdata = formdata.append("&saleId="+saleId);
	    $.ajax({
	        type: "POST",
	        url: "client/saveClient/"+saleId,
	        data:formdata,
	        dataType: "json",
	        success: function(data){
	            if(data.success){//成功
	            	top.layer.msg(data.msg); 
	                //关闭当前弹出层
	                var thisindex = parent.layer.getFrameIndex(window.name);
	                parent.layer.close(thisindex);
	            }
	        },
	        error:function(){
	            top.layer.msg("服务器开小差了，请稍后再试...");
	        }
	   });
	   return false; 
	});
  
  // 渲染下拉框 
  function loadAllSelect(){
	  loadManagerSelect();//加载分配给经理的下拉框 
	  loadClientClassSelect();// 加载客户等级下拉框 
	  form.render(null,'example');
  }
  // 渲染经理下拉框 
  function loadManagerSelect(){
	  $.ajax({
		  url:"saleChance/showAllManager",
		  type:"POST",
		  dataType:"json",
		  async:false,
		  success:function(data){
			  console.log(data.data);
			  var html = '';
			  if(data.success){
				  $("#managerSelect").html("");
				  var managers = data.data;
				  html += "<option value=''></option>";
				  for(i=0;i<managers.length;i++){
					  html += "<option value='"+managers[i].id+"'>"+managers[i].name+"</option>";
				  }
				  $("#managerSelect").html(html);
			  }else{
				  layer.msg("读取客户数据出错！");
			  }
		  }
	  });
  }
  
  // 加载等级下拉框
  function loadClientClassSelect(){
	  $.ajax({
		  url:"client/clientClasses",
		  type:"POST",
		  dataType:"json",
		  async:false,
		  success:function(data){
			  console.log(data.data);
			  var html = '';
			  if(data.success){
				  $("#classSelect").html("");
				  var managers = data.data;
				  html += "<option value=''></option>";
				  for(i=0;i<managers.length;i++){
					  html += "<option value='"+managers[i].id+"'>"+managers[i].name+"</option>";
				  }
				  $("#classSelect").html(html);
			  }else{
				  layer.msg("读取客户数据出错！");
			  }
		  }
	  });
  }
});
</script> 




</body>

</html>


