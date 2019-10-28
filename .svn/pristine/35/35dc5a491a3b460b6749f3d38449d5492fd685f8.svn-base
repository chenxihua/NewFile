package com.neuedu.crm.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neuedu.crm.bean.Service;
import com.neuedu.crm.bean.ServiceType;
import com.neuedu.crm.bean.User;
import com.neuedu.crm.bean.UserExample;
import com.neuedu.crm.service.ClientService;
import com.neuedu.crm.service.ServiceService;
import com.neuedu.crm.service.ServiceTypeService;
import com.neuedu.crm.service.UserService;
import com.neuedu.crm.utils.Operation;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.neuedu.crm.bean.AmountOne;
import com.neuedu.crm.bean.AmountTwo;
import com.neuedu.crm.bean.Client;
import com.neuedu.crm.bean.Message;
import com.neuedu.crm.bean.SaleChance;
/**
 * controller层：服务管理
 * @author Mechan
 *
 */
@RequestMapping("/service")
@Controller
public class ServiceController {
	
	@Autowired
	private ServiceService serviceService;
	@Autowired 
	private ServiceTypeService serviceTypeService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private UserService userService;
	
		
	/**
	 * 经理操作：显示服务处理列表 
	 * @return
	 */
	@RequestMapping("/handleList")
	@ResponseBody
	//@Operation(name="显示服务处理列表 ")
	public String handleList(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "limit", defaultValue = "10") Integer limit, HttpServletRequest request, String param) {
		
		System.out.println("进入handleList");

		HttpSession session = request.getSession(true);	
		PageInfo<Service> pager = serviceService.handleList( page, limit, session, param );
					
		System.out.println("当前页记录数：" + pager.getList().size() + ", 总记录数：" + pager.getTotal());
		
        //用google json来传值  (用hashmap会有时间格式错误)
        JsonArray json =  new Gson().toJsonTree( pager.getList(), new TypeToken<List<Service>>() 
        	{}.getType()).getAsJsonArray();
        String js = json.toString();  
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+pager.getTotal()+",\"data\":"+js+"}"; 
        System.out.println("Json数据：");
        System.out.println(jso);
        return jso;  
	}
	
	/**
	 * 经理操作：显示服务反馈列表 
	 * @return
	 */	
	@RequestMapping("/feedbackList")
	@ResponseBody
	//@Operation(name="显示服务反馈列表")
	public String feedbackList( @RequestParam(value="page", defaultValue="1")Integer page,  
			@RequestParam(value="limit", defaultValue="10") Integer limit, HttpServletRequest request, String param ) {
		
		HttpSession session = request.getSession(true);	

		PageInfo<Service> pager = serviceService.feedbackList( page, limit, session, param );		
		System.out.println("当前页记录数：" + pager.getList().size() + ", 总记录数：" + pager.getTotal());

        //用google json来传值到jsp页面
        JsonArray json =  new Gson().toJsonTree( pager.getList(), new TypeToken<List<Service>>() 
        	{}.getType()).getAsJsonArray();
        String js = json.toString();  
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+pager.getTotal()+",\"data\":"+js+"}";  
        return jso;  
	}
		
	/**
	 * 经理操作：显示服务反馈列表 
	 * @return
	 */	
	@RequestMapping("/archiveList")
	@ResponseBody
	//@Operation(name="显示服务归档列表 ")
	public String archiveList( @RequestParam(value="page", defaultValue="1")Integer page,  
			@RequestParam(value="limit", defaultValue="10") Integer limit, HttpServletRequest request, String param ) {
		
		HttpSession session = request.getSession(true);	
		
		PageInfo<Service> pager = serviceService.archiveList( page, limit, session, param );		
		System.out.println("当前页记录数：" + pager.getList().size() + ", 总记录数：" + pager.getTotal());

        //用google json来传值  (用hashmap会有时间格式错误)
        JsonArray json =  new Gson().toJsonTree( pager.getList(), new TypeToken<List<Service>>() 
        	{}.getType()).getAsJsonArray();
        String js = json.toString();  
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+pager.getTotal()+",\"data\":"+js+"}";  
        return jso;  
	}
		
	/**
	 * 主管操作：显示服务分配列表 
	 * @return
	 */	
	@RequestMapping("/assignList")
	@ResponseBody
	//@Operation(name="显示服务分配列表")
	public String assignList( @RequestParam(value="page", defaultValue="1")Integer page,  
			@RequestParam(value="limit", defaultValue="10") Integer limit, HttpServletRequest request, String param ) {
		
		HttpSession session = request.getSession(true);	
	
		PageInfo<Service> pager = serviceService.assignList( page, limit, session, param );		
		System.out.println("当前页记录数：" + pager.getList().size() + ", 总记录数：" + pager.getTotal());

        //用google json来传值  (用hashmap会有时间格式错误)
        JsonArray json =  new Gson().toJsonTree( pager.getList(), new TypeToken<List<Service>>() 
        	{}.getType()).getAsJsonArray();
        String js = json.toString();  
        String jso = "{\"code\":0,\"msg\":\"\",\"count\":"+pager.getTotal()+",\"data\":"+js+"}";  
        return jso;  
	}
	
	/**
	 * 经理操作：准备创建服务(获取服务类型，创建人，创建时间)
	 * @return
	 */
	@RequestMapping("/toCreateService")
	//@Operation(name="准备创建服务")
	public String toCreateService( Model model ){	
	
		List<Client> clientList = clientService.selectAllClients();
		System.out.println("toCreateService报告，客户数量：" + clientList.size());		
		model.addAttribute("clientList", clientList);
		
		return "service/createService";
	}
	
	/**
	 * 经理操作：创建服务
	 * @return
	 */
	@RequestMapping("/createService") 
	@ResponseBody
	@Operation(name="创建服务")
	public Map<String, Object> createService( Service newService, HttpServletRequest request ){

		int userId = (int) request.getSession().getAttribute("id");
		Map<String, Object> ret = serviceService.createService( userId, newService);			
		return ret;
	}
	
	/**
	 * 经理/主管操作：查看服务详情
	 */
	@RequestMapping("/selectServiceById")
	@ResponseBody
	//@Operation(name="查看服务详情")
	public ModelAndView selectServiceById( HttpServletRequest request ){	
		
		Integer userId = -1;
		if( request.getParameter("userId") != null )
			userId = Integer.valueOf( request.getParameter("userId") );
		Service service = serviceService.selectById(userId);	
		
		//格式转换
		SimpleDateFormat timeFormatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String createTime=null;
		String assignTime=null;
		String handleTime=null;
		
		if( service.getCreateTime()!=null )
			createTime = timeFormatter.format( service.getCreateTime() );
		if( service.getAssignTime()!=null )
			assignTime = timeFormatter.format( service.getAssignTime() );
		if( service.getHandleTime()!=null )
			handleTime = timeFormatter.format( service.getHandleTime() );
		
		Integer statusNum = service.getStatus();
		String status = null;
		switch ( statusNum ) {
		case -1: status="已删除"; break;
		case 0: status="已创建"; break;
		case 1: status="等待分配"; break;
		case 2: status="已分配"; break;
		case 3: status="等待反馈"; break;
		case 4: status="处理成功"; break;
		case 5: status="处理失败"; break;
		default: break;
		}
		
		ModelAndView view = new ModelAndView("service/serviceDetail");
		view.getModel().put( "service", service );
		view.getModel().put( "createTime", createTime);
		view.getModel().put( "assignTime", assignTime);
		view.getModel().put( "handleTime", handleTime);
		view.getModel().put( "status", status);

		return view;
	}
		
	/**
	 * 经理操作：跳转到服务处理页面
	 */	
	@RequestMapping("/toHandleService")
	@ResponseBody
	//@Operation(name="跳转到服务处理页面")
	public ModelAndView toHandleService( HttpServletRequest request ){	

		Integer userId = -1;
		if( request.getParameter("userId") != null )
			userId = Integer.valueOf( request.getParameter("userId") );
		System.out.println("正在跳转到服务处理，userId: " + userId);
		Service service = serviceService.selectById(userId);	
		
		ModelAndView view = new ModelAndView("service/handleService");
		view.getModel().put( "service", service );
		
		return view;
	}
	
	/**
	 * 经理操作：处理服务
	 * @return
	 */
	@RequestMapping("/handleService") 
	@ResponseBody
	@Operation(name="处理服务")
	public Map<String, Object> handleService( Service newService ){
		
		System.out.println("所改记录的id是: "+ newService.getId() + ", 取得服务处理内容: " + newService.getHandle());
		
		Service oldService = serviceService.selectById( newService.getId() );		
		if( oldService.getHandler() == null ) {
			newService.setHandler( oldService.getCreator() );
		}		
		newService.setHandleTime( new Date() );
		//设置状态为等待反馈
		newService.setStatus(3);
		
		//根据实例更新记录
		int result = serviceService.updateService(newService);
		System.out.println("更新服务表的记录数：" + result);
		boolean msg = false;
		if( result>0 ) {
			msg = true;
		} else {
			msg = false;
		}		
		Map<String, Object> ret = new HashMap<>();
		ret.put("msg", msg);
		
		return ret;
	}
	
	/**
	 * 经理操作：跳转到服务反馈页面
	 */	
	@RequestMapping("/toFeedbackService")
	@ResponseBody
	//@Operation(name="经理操作：跳转到服务反馈页面")
	public ModelAndView toFeedbackService( HttpServletRequest request ){	

		Integer id = -1;
		if( request.getParameter("id") != null )
			id = Integer.valueOf( request.getParameter("id") );
		System.out.println("正在跳转到服务反馈，id: " + id);
		Service service = serviceService.selectById(id);	
		
		ModelAndView view = new ModelAndView("service/feedbackService");
		view.getModel().put( "service", service );
		
		return view;
	}
		
	/**
	 * 经理操作：服务反馈
	 * @return
	 */
	@RequestMapping("/feedbackService") 
	@ResponseBody
	@Operation(name="服务反馈")
	public Map<String, Object> feedbackService( Service newService ){
		
		Map<String, Object> ret = serviceService.feedbackService(newService);			
		return ret;
	}
	
	/**
	 * 经理操作：跳转到请求分配服务
	 * @return
	 */
	@RequestMapping("/toReqForAssignService") 
	@ResponseBody
	//@Operation(name="经理操作：跳转到请求分配服务")
	public ModelAndView toReqForAssignService( HttpServletRequest request ){	

		Integer id = -1;
		if( request.getParameter("id") != null )
			id = Integer.valueOf( request.getParameter("id") );
		System.out.println("正在跳转到请求分配服务，userId: " + id);
		Service service = serviceService.selectById( id );	
		
		ModelAndView view = new ModelAndView("service/reqForAssignService");
		view.getModel().put( "service", service );
		
		return view;
	}
	
	/**
	 * 经理操作：请求分配服务
	 * @return
	 */
	@RequestMapping("/reqForAssignService") 
	@ResponseBody
	@Operation(name="请求分配服务")
	public Map<String, Object> reqForAssignService( Service newService ){
		
		Map<String, Object> ret = serviceService.reqForAssignService( newService );				
		return ret;
	}
	
	/**
	 * 主管操作：跳转到分配服务, debugging
	 * @return
	 */	
	@RequestMapping("/toAssignService")
	@ResponseBody
	//@Operation(name="主管操作：跳转到分配服务")
	public ModelAndView toAssignService( HttpServletRequest request ){	

		//获取当前用户id
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("id");
		System.out.println("主管操作：跳转到分配服务, 主管编号：" + userId);
		
		Integer id = -1;
		if( request.getParameter("id") != null )
			id = Integer.valueOf( request.getParameter("id") );
		System.out.println("正在跳转到服务分配，服务编号: " + id);
				
		Service service = serviceService.selectById(id);		
		//选择当前用户的所有直接下级
		List<User> users = userService.selectDirectLowerById( userId );
		
		ModelAndView view = new ModelAndView("service/assignService");
		view.getModel().put( "service", service );
		view.getModel().put("users", users);
		
		return view;
	}	
	
	/**
	 * 主管操作：分配服务
	 * @return
	 */
	@RequestMapping("/assignService") 
	@ResponseBody
	@Operation(name="分配服务")
	public Map<String, Object> assignService( Service newService ){
		Map<String, Object> ret = serviceService.assignService( newService );
		
		System.out.println("Gson数据：");
		Gson gson = new Gson();		
		System.out.println( gson.toJson(ret) );
		
		return ret;
	}	
	
	/**
	 * 主管操作：跳转到再分配服务
	 * @return
	 */
	@RequestMapping("/toReAssignService") 
	@ResponseBody
	//@Operation(name="主管操作：跳转到再分配服务")
	public ModelAndView toReAssignService( HttpServletRequest request ){	

		Integer id = -1;
		if( request.getParameter("id") != null )
			id = Integer.valueOf( request.getParameter("id") );
		System.out.println("正在跳转到再分配服务，id: " + id);
		Service service = serviceService.selectById( id );	
		
		ModelAndView view = new ModelAndView("service/reAssignService");
		view.getModel().put( "service", service );
		
		return view;
	}
	
	/**
	 * 主管操作：再分配服务, debugging
	 * @return
	 */
	@RequestMapping("/reAssignService") 
	@ResponseBody
	@Operation(name="再分配服务")
	public Map<String, Object> reAssignService( HttpServletRequest request, Service se ){
		
		//获取当前用户id
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("id");
		System.out.println("主管操作：跳转到再分配服务, 主管编号：" + userId);	
		Map<String, Object> ret = null;

		System.out.println("se的id是：" + se.getId() );
		se = serviceService.selectById( se.getId() );
		//如果服务状态为处理成功，不能对服务进行再分配
		if( se.getStatus() == 4 ) {
			ret = new HashMap<>();
			ret.put("msg", false);
			ret.put("info", "再分配失败，只能对处理失败的服务进行再分配");
			return ret;
		} else {
			ret = serviceService.reAssignService( userId, se );				
			return ret;
		}
	}
	
	/**
	 * 主管操作：显示服务类型及对应的服务数量（饼状图或柱状图）
	 * @return
	 */
	@RequestMapping("/serviceTypeForm")
	@ResponseBody
	//@Operation(name="主管操作：显示服务类型及对应的服务数量")
	public Map<String,Object> serviceTypeForm(){
		Map<String,Object> map = new HashMap<>();
		List<AmountOne> amounts = serviceService.selectAllServiceTypeForm();
		map.put("code", 0);
		map.put("data", amounts);
		map.put("success", true);
		map.put("msg", "数据显示成功");
		
		System.out.println("serviceTypeForm Gson数据：");
		Gson gson = new Gson();		
		System.out.println( gson.toJson(map) );
		
		return map;
	}
	
	/**
	 * 主管操作：显示服务满意度及对应的服务数量（饼状图或柱状图）
	 * @return
	 */
	@RequestMapping("/serviceSatisfactionForm")
	@ResponseBody
	//@Operation(name="主管操作：显示服务满意度及对应的服务数量")
	public Map<String,Object> serviceSatisfactionForm(){
		Map<String,Object> map = new HashMap<>();
		List<AmountTwo> amounts = serviceService.selectAllServiceSatisfactionForm();
		map.put("code", 0);
		map.put("data", amounts);
		map.put("success", true);
		map.put("msg", "数据显示成功");
		
		System.out.println("serviceSatisfactionForm Gson数据：");
		Gson gson = new Gson();		
		System.out.println( gson.toJson(map) );
		
		return map;
	}
	
	/**
	 * 主管操作：显示服务服务状态及对应的服务数量（饼状图或柱状图）
	 * @return
	 */
	@RequestMapping("/serviceStatusForm")
	@ResponseBody
	//@Operation(name="主管操作：显示服务服务状态及对应的服务数量")
	public Map<String,Object> serviceStatusForm(){
		Map<String,Object> map = new HashMap<>();
		List<AmountTwo> amounts = serviceService.selectAllServiceStatusForm();
		map.put("code", 0);
		map.put("data", amounts);
		map.put("success", true);
		map.put("msg", "数据显示成功");
		
		System.out.println("serviceStatusForm Gson数据：");
		Gson gson = new Gson();		
		System.out.println( gson.toJson(map) );
		
		return map;
	}
}
