package com.neuedu.crm.view;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.neuedu.crm.bean.Outflow;
import com.neuedu.crm.bean.Service;
import com.neuedu.crm.service.ClientService;
import com.neuedu.crm.service.OutflowService;
import com.neuedu.crm.service.ServiceService;
import com.neuedu.crm.service.ServiceTypeService;
import com.neuedu.crm.service.UserService;

/**
 * controller层：流失管理
 * @author Mechan
 *
 */
@RequestMapping("/outflow")
@Controller
public class OutflowController {
	
	@Autowired
	private OutflowService outflowService;
		
	/**
	 * 经理/主管操作：查看流失详情
	 */
	@RequestMapping("/selectOutflowById")
	@ResponseBody
	public ModelAndView selectOutflowById( HttpServletRequest request ){	
		
		Integer oid = -1;
		if( request.getParameter("id") != null )
			oid = Integer.valueOf( request.getParameter("id") );
		Outflow outflow = outflowService.selectById(oid);	
		
		//格式转换
		SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String handleTime=null;
		String lastOrderTime=null;
		String outflowTime=null;
		
		if( outflow.getHandleTime()!=null )
			handleTime = timeFormatter.format( outflow.getHandleTime() );
		if( outflow.getLastOrderTime()!=null )
			lastOrderTime = timeFormatter.format( outflow.getLastOrderTime() );
		if( outflow.getOutflowTime()!=null )
			outflowTime = timeFormatter.format( outflow.getOutflowTime() );
		
		Integer statusNum = outflow.getStatus();
		String status = null;
		switch ( statusNum ) {
		case -1: status="已删除"; break;
		case 0: status="流失预警"; break;
		case 1: status="暂缓流失"; break;
		case 2: status="确认流失"; break;
		default: break;
		}
		
		ModelAndView view = new ModelAndView("outflow/outflowDetail");
		view.getModel().put( "outflow", outflow );
		view.getModel().put( "handleTime", handleTime );
		view.getModel().put( "lastOrderTime", lastOrderTime );
		view.getModel().put( "outflowTime", outflowTime );
		view.getModel().put( "status", status );

		return view;
	}
	
	/**
	 * 主管操作：显示流失列表 
	 * @return
	 */	
	@RequestMapping("/outflowList")
	@ResponseBody
	public String outflowList( @RequestParam(value="page", defaultValue="1")Integer page,  
			@RequestParam(value="limit", defaultValue="10") Integer limit, HttpServletRequest request  ) {
		
		//获取当前用户id
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("id");
		System.out.println("主管操作：显示流失列表 , 主管编号：" + userId);		
		PageInfo<Outflow> pager = outflowService.outflowList( page, limit, userId );		
		System.out.println("当前页记录数：" + pager.getList().size() + ", 总记录数：" + pager.getTotal());

        //用google json来传值  (用hashmap会有时间格式错误)
        JsonArray json =  new Gson().toJsonTree( pager.getList(), new TypeToken<List<Outflow>>() 
        	{}.getType()).getAsJsonArray();
        String js = json.toString();  
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+pager.getTotal()+",\"data\":"+js+"}";  
        return jso;  
	}
	
	/**
	 * 经理操作：显示流失处理列表 
	 * @return
	 */	
	@RequestMapping("/handleOutflowList")
	@ResponseBody
	public String handleOutflowList( @RequestParam(value="page", defaultValue="1")Integer page,  
			@RequestParam(value="limit", defaultValue="10") Integer limit, HttpServletRequest request  ) {
		
		//获取当前用户id
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("id");
		System.out.println("经理操作：显示流失列表 , 经理编号：" + userId);		
		PageInfo<Outflow> pager = outflowService.handleOutflowList( page, limit, userId );		
		System.out.println("当前页记录数：" + pager.getList().size() + ", 总记录数：" + pager.getTotal());

        //用google json来传值  (用hashmap会有时间格式错误)
        JsonArray json =  new Gson().toJsonTree( pager.getList(), new TypeToken<List<Outflow>>() 
        	{}.getType()).getAsJsonArray();
        String js = json.toString();  
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+pager.getTotal()+",\"data\":"+js+"}";  
        return jso;  
	}
	
	
	/**
	 * 经理操作：跳转到暂缓流失页面
	 */	
	@RequestMapping("/toDeferOutflow")
	@ResponseBody
	public ModelAndView toDeferOutflow( HttpServletRequest request ){	
		
		ModelAndView view = null;
		Integer id = -1;
		if( request.getParameter("id") != null )
			id = Integer.valueOf( request.getParameter("id") );
		System.out.println("正在跳转到暂缓流失，id: " + id);
		Outflow outflow = outflowService.selectById(id);	
		
		//根据状态跳转到不同页面
		if( outflow.getStatus() == 0 || outflow.getStatus() == 1 ) {
			//状态为流失预警（0）或暂缓流失（1）时，跳转到暂缓流失页面
			view = new ModelAndView("outflow/deferOutflow");
			view.getModel().put( "outflow", outflow );
		} else {
			//状态不是流失预警（0）或暂缓流失（1）时，跳转到错误提示页面
			view = new ModelAndView("outflow/statusError");
			view.getModel().put( "outflow", outflow );
			view.getModel().put("info1", "操作无效");
			view.getModel().put("info2", "不能对已流失的客户执行暂缓流失操作");
		}
		
		return view;
	}
	
	/**
	 * 经理操作：暂缓流失
	 * @return
	 */
	@RequestMapping("/deferOutflow") 
	@ResponseBody
	public Map<String, Object> deferOutflow( Outflow newOutflow ){
		
		Map<String, Object> ret = outflowService.deferOutflow(newOutflow);			
		return ret;
	}
		
	/**
	 * 经理操作：跳转到确认流失页面
	 */	
	@RequestMapping("/toConfirmOutflow")
	@ResponseBody
	public ModelAndView toConfirmOutflow( HttpServletRequest request ){	
		
		ModelAndView view = null;
		Integer id = -1;
		if( request.getParameter("id") != null )
			id = Integer.valueOf( request.getParameter("id") );
		System.out.println("正在跳转到确认流失，id: " + id);
		Outflow outflow = outflowService.selectById(id);	
		
		//根据状态跳转到不同页面
		if( outflow.getStatus() == 1 ) {
			//状态为暂缓流失（1）时，跳转到确认流失页面
			view = new ModelAndView("outflow/confirmOutflow");
			view.getModel().put( "outflow", outflow );
		} else {
			//状态不是暂缓流失（1）时，跳转到错误提示页面
			view = new ModelAndView("outflow/statusError");
			view.getModel().put( "outflow", outflow );
			view.getModel().put("info1", "操作无效");
			view.getModel().put("info2", "只有在暂缓流失状态下才能启用确认流失操作");
		}
		
		return view;
	}
		
	/**
	 * 经理操作：确认流失
	 * @return
	 */
	@RequestMapping("/confirmOutflow") 
	@ResponseBody
	public Map<String, Object> confirmOutflow( Outflow newOutflow ){
		
		Map<String, Object> ret = outflowService.confirmOutflow(newOutflow);			
		return ret;
	}
}
