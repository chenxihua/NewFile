package com.neuedu.crm.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neuedu.crm.bean.AmountOne;
import com.neuedu.crm.bean.AmountTwo;
import com.neuedu.crm.bean.Client;
import com.neuedu.crm.bean.ClientExample;
import com.neuedu.crm.bean.Service;
import com.neuedu.crm.bean.ServiceExample;
import com.neuedu.crm.bean.ServiceType;
import com.neuedu.crm.bean.User;
import com.neuedu.crm.bean.UserExample;
import com.neuedu.crm.dao.ClientMapper;
import com.neuedu.crm.dao.ServiceMapper;
import com.neuedu.crm.dao.ServiceTypeMapper;
import com.neuedu.crm.dao.UserMapper;
import com.neuedu.crm.service.ServiceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service实现层：服务管理
 * @author Mechan
 */
@org.springframework.stereotype.Service
@Transactional(rollbackFor=Exception.class)
public class ServiceServiceImpl implements ServiceService{

	@Autowired
	private ServiceMapper serviceMapper;
	@Autowired
	private ClientMapper clientMapper;
	@Autowired
	private ServiceTypeMapper serviceTypeMapper;
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public List<Service> selectAll() {
		return serviceMapper.selectByExample(null);
	}

	@Override
	public Service selectById(Integer id) {
		
		Service se = serviceMapper.selectByPrimaryKey(id);		
		
		//填充每条记录的关联属性(即外键)(注意要填充assignerUser)
		Client client = clientMapper.selectByPrimaryKey( se.getClientId() );
		ServiceType type = serviceTypeMapper.selectByPrimaryKey( se.getType() );
		User creatorUser = userMapper.selectByPrimaryKey( se.getCreator() );
		User assignerUser = userMapper.selectByPrimaryKey( se.getAssigner() );
		User handlerUser = userMapper.selectByPrimaryKey( se.getHandler() );
		
		se.setClient(client);
		se.setServiceType(type);
		se.setCreatorUser(creatorUser);
		se.setAssignerUser(assignerUser);
		se.setHandlerUser(handlerUser);
		
		return se;
	}

	@Override
	public List<Service> selectByExamplePager(ServiceExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> createService( Integer userId, Service newService) {
		
		System.out.println( "创建新服务，服务概要: " + newService.getContent());
		newService.setCreator( userId );
		newService.setCreateTime( new Date() );
		newService.setStatus(0);
		System.out.println( "createService得到的service对象" + newService.toString() );
		int result = serviceMapper.insertSelective(newService);
		System.out.println("已创建服务记录数目：" + result );
		
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

	@Override
	public int updateService(Service record) {
		return serviceMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void assignService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void handleService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> feedbackService(Service newService) {
		
		System.out.println("服务反馈， 服务记录的id是: "+ newService.getId() + ", 取得服务处理结果: " + newService.getResult());		
		Service oldService = serviceMapper.selectByPrimaryKey( newService.getId() );
		//根据满意度设置状态为处理成功或失败(满意度大于等于3则处理成功，否则处理失败)
		if( newService.getSatisfaction() >= 3 ) {
			newService.setStatus(4);			
		}
		else {
			newService.setStatus(5);			
		}
		
		//根据实例更新记录
		int result = serviceMapper.updateByPrimaryKeySelective(newService);
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
		
	@Override
	public void terminateService() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Service> selectNotAssign( List<User> userList ) {
		List<Service> serviceList = new ArrayList<>();

		//找出指定员工所有处于“已创建”状态中的服务
		for (User u : userList) {
			ServiceExample example = new ServiceExample();
			ServiceExample.Criteria criteria = example.createCriteria();
			criteria.andStatusEqualTo(0);
			criteria.andCreatorEqualTo( u.getId() );
			List<Service> services = serviceMapper.selectByExample(example);
			
			for (Service se : services) {
				//填充每条记录的关联属性(即外键)
				Client client = clientMapper.selectByPrimaryKey( se.getClientId() );
				ServiceType type = serviceTypeMapper.selectByPrimaryKey( se.getType() );
				User creatorUser = userMapper.selectByPrimaryKey( se.getCreator() );
				
				se.setClient(client);
				se.setServiceType(type);
				se.setCreatorUser(creatorUser);
				serviceList.add(se);
			}
		}
			
		return serviceList;
	}

	@Override
	public  PageInfo<Service> employeesServices( Integer page, Integer rows, Integer userId) {
		List<Service> serviceList = new ArrayList<>();
		ServiceExample example = new ServiceExample();
		
		ServiceExample.Criteria criteria = example.createCriteria();
		criteria.andCreatorEqualTo(userId);
		criteria.andAssignerIsNull();
		
		ServiceExample.Criteria criteria2 = example.createCriteria();
		criteria2.andHandlerEqualTo(userId);
		
		example.or(criteria2);
		PageHelper.startPage( page, rows);	
		List<Service> services = serviceMapper.selectByExample(example);

		//性能过低
		for (Service se : services) {
			//填充每条记录的关联属性(即外键)
			Client client = clientMapper.selectByPrimaryKey( se.getClientId() );
			ServiceType type = serviceTypeMapper.selectByPrimaryKey( se.getType() );
			User creatorUser = userMapper.selectByPrimaryKey( se.getCreator() );
			User handlerUser = userMapper.selectByPrimaryKey( se.getHandler() );
			
			se.setClient(client);
			se.setServiceType(type);
			se.setCreatorUser(creatorUser);
			se.setHandlerUser(handlerUser);
			serviceList.add(se);
		}
		
		PageInfo pager = new PageInfo(services);
		
		return pager;
	}

	@Override
	public PageInfo<Service> handleList( Integer page, Integer limit, HttpSession session, String param ) {
		
		String clientName=null;
		String content=null;
		int type=-2;
		String beginTime = null;
		String endTime = null;
		Date beginDate = null;
		Date endDate = null;
		List<Integer> clientIds = new ArrayList<>();
		Integer userId = (Integer) session.getAttribute("id");

		
		ServiceExample serviceExample = new ServiceExample();
		ServiceExample.Criteria serviceCriteria = serviceExample.createCriteria();
		ServiceExample.Criteria serviceCriteria2 = serviceExample.createCriteria();		

		ClientExample clientExample = new ClientExample();
		ClientExample.Criteria clientCriteria = clientExample.createCriteria();
		
		//获取查询条件
		if ( (null != param) && (!(("").equals(param))) ) {
			//初始化json转换器
			JsonParser parser = new JsonParser();
			JsonObject jsonParam = (JsonObject) parser.parse(param);
			
			clientName = jsonParam.get("clientName").getAsString();
			content = jsonParam.get("content").getAsString();
			type = jsonParam.get("type").getAsInt();
			
			beginTime = jsonParam.get("beginTime").getAsString();
			endTime = jsonParam.get("endTime").getAsString();

			 //将字符串格式转换为时间格式
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			try {
				// 查询条项：开始日期、结束日期
				if ((null != beginTime) && (!(("").equals(beginTime)))) {
					beginDate = simpleDateFormat.parse(beginTime);				
				}
				if ((null != endTime) && (!(("").equals(endTime)))) {
					endDate = simpleDateFormat.parse(endTime);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		//判断查询条件是否为空
		if( (null!=clientName) && (!("").equals(clientName)) ) {
			clientCriteria.andNameLike("%" + clientName + "%");
			List<Client> clients = clientMapper.selectByExample( clientExample );
			for (Client cl : clients) {
				clientIds.add( cl.getId() );
			}
			if( clientIds.size()>0 ) {
				serviceCriteria.andClientIdIn( clientIds );
				serviceCriteria2.andClientIdIn( clientIds );
			} else {
				serviceCriteria.andClientIdEqualTo(-1);
				serviceCriteria2.andClientIdEqualTo(-1);
			}		
		}
		if( (null!=content) && (!("").equals(content)) ) {
			serviceCriteria.andContentLike("%" + content + "%");
			serviceCriteria2.andContentLike("%" + content + "%");
		}
		if( -2!=type) {
			serviceCriteria.andTypeEqualTo(type);
			serviceCriteria2.andTypeEqualTo(type);
		}
		if ((beginDate != null) && (endDate != null)) {
			// 输入的时期范围有上限和下限
			serviceCriteria.andCreateTimeBetween(beginDate, endDate);
			serviceCriteria2.andCreateTimeBetween(beginDate, endDate);
		} else if ((beginDate != null) && (endDate == null)) {
			// 输入的时间范围没有下限
			serviceCriteria.andCreateTimeGreaterThanOrEqualTo(beginDate);
			serviceCriteria2.andCreateTimeGreaterThanOrEqualTo(beginDate);
		} else if ((beginDate == null) && (endDate != null)) {
			// 输入的时间范围没有上限
			serviceCriteria.andCreateTimeLessThanOrEqualTo(endDate);
			serviceCriteria2.andCreateTimeLessThanOrEqualTo(endDate);
		}
			
		/**基本查询---waiting for test：
		查看自己能处理的服务记录: 
			1.状态为已创建(0), 创建者是自己, 分配者为空;
			2.状态为已分配(2), 处理者是自己
		*/
		serviceCriteria.andStatusEqualTo(0);
		serviceCriteria.andCreatorEqualTo(userId);
		serviceCriteria.andAssignerIsNull();
		serviceCriteria2.andStatusEqualTo(2);
		serviceCriteria2.andHandlerEqualTo(userId);
		serviceExample.or(serviceCriteria2);
		
		PageHelper.startPage( page, limit );	
		List<Service> services = serviceMapper.selectByExample( serviceExample );
		
		//性能过低
		for (Service se : services) {
			//填充每条记录的关联属性(即外键)
			Client client = clientMapper.selectByPrimaryKey( se.getClientId() );
			ServiceType type2 = serviceTypeMapper.selectByPrimaryKey( se.getType() );
			User creatorUser = userMapper.selectByPrimaryKey( se.getCreator() );
			User handlerUser = userMapper.selectByPrimaryKey( se.getHandler() );
			
			se.setClient(client);
			se.setServiceType(type2);
			se.setCreatorUser(creatorUser);
			se.setHandlerUser(handlerUser);
		}
		
		PageInfo pager = new PageInfo(services);
		
		return pager;		
	}
			
	@Override
	public PageInfo<Service> feedbackList( Integer page, Integer limit, HttpSession session, String param ) {
		
		String clientName=null;
		String content=null;
		int type=-2;
		String beginTime = null;
		String endTime = null;
		Date beginDate = null;
		Date endDate = null;
		List<Integer> clientIds = new ArrayList<>();
		Integer userId = (Integer) session.getAttribute("id");
		
		ServiceExample serviceExample = new ServiceExample();
		ServiceExample.Criteria serviceCriteria = serviceExample.createCriteria();		
		ClientExample clientExample = new ClientExample();
		ClientExample.Criteria clientCriteria = clientExample.createCriteria();
		
		//获取查询条件
		if ( (null != param) && (!(("").equals(param))) ) {
			//初始化json转换器
			JsonParser parser = new JsonParser();
			JsonObject jsonParam = (JsonObject) parser.parse(param);
			
			clientName = jsonParam.get("clientName").getAsString();
			content = jsonParam.get("content").getAsString();
			type = jsonParam.get("type").getAsInt();
			
			beginTime = jsonParam.get("beginTime").getAsString();
			endTime = jsonParam.get("endTime").getAsString();

			 //将字符串格式转换为时间格式
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			try {
				// 查询条项：开始日期、结束日期
				if ((null != beginTime) && (!(("").equals(beginTime)))) {
					beginDate = simpleDateFormat.parse(beginTime);				
				}
				if ((null != endTime) && (!(("").equals(endTime)))) {
					endDate = simpleDateFormat.parse(endTime);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		//判断查询条件是否为空
		if( (null!=clientName) && (!("").equals(clientName)) ) {
			clientCriteria.andNameLike("%" + clientName + "%");
			List<Client> clients = clientMapper.selectByExample( clientExample );
			for (Client cl : clients) {
				clientIds.add( cl.getId() );
			}
			if( clientIds.size()>0 ) {
				serviceCriteria.andClientIdIn( clientIds );
			} else {
				serviceCriteria.andClientIdEqualTo(-1);
			}		
		}
		if( (null!=content) && (!("").equals(content)) ) {
			serviceCriteria.andContentLike("%" + content + "%");
		}
		if( -2!=type) {
			serviceCriteria.andTypeEqualTo(type);
		}
		if ((beginDate != null) && (endDate != null)) {
			// 输入的时期范围有上限和下限
			serviceCriteria.andHandleTimeBetween(beginDate, endDate);
		} else if ((beginDate != null) && (endDate == null)) {
			// 输入的时间范围没有下限
			serviceCriteria.andHandleTimeGreaterThanOrEqualTo(beginDate);
		} else if ((beginDate == null) && (endDate != null)) {
			// 输入的时间范围没有上限
			serviceCriteria.andHandleTimeLessThanOrEqualTo(endDate);
		}
			
		/**
		 * 基本查询--查看自己能填写客户反馈的服务记录:
		 * 1.处理者是自己，状态为等待反馈(3);
		*/
		serviceCriteria.andHandlerEqualTo(userId);
		serviceCriteria.andStatusEqualTo(3);
		
		PageHelper.startPage( page, limit );	
		List<Service> services = serviceMapper.selectByExample( serviceExample );

		//性能过低
		for (Service se : services) {
			//填充每条记录的关联属性(即外键)
			Client client = clientMapper.selectByPrimaryKey( se.getClientId() );
			ServiceType type2 = serviceTypeMapper.selectByPrimaryKey( se.getType() );
			User creatorUser = userMapper.selectByPrimaryKey( se.getCreator() );
			User handlerUser = userMapper.selectByPrimaryKey( se.getHandler() );
			
			se.setClient(client);
			se.setServiceType(type2);
			se.setCreatorUser(creatorUser);
			se.setHandlerUser(handlerUser);
		}
		
		PageInfo pager = new PageInfo(services);
		
		return pager;
	}
	
	@Override
	public PageInfo<Service> archiveList( Integer page, Integer limit, HttpSession session, String param ) {
		
		String clientName=null;
		String content=null;
		int type=-2;
		String beginTime = null;
		String endTime = null;
		Date beginDate = null;
		Date endDate = null;
		List<Integer> clientIds = new ArrayList<>();
		Integer userId = (Integer) session.getAttribute("id");
		
		ServiceExample serviceExample = new ServiceExample();
		ServiceExample.Criteria serviceCriteria = serviceExample.createCriteria();		
		ClientExample clientExample = new ClientExample();
		ClientExample.Criteria clientCriteria = clientExample.createCriteria();
		
		//获取查询条件
		if ( (null != param) && (!(("").equals(param))) ) {
			//初始化json转换器
			JsonParser parser = new JsonParser();
			JsonObject jsonParam = (JsonObject) parser.parse(param);
			
			clientName = jsonParam.get("clientName").getAsString();
			content = jsonParam.get("content").getAsString();
			type = jsonParam.get("type").getAsInt();
			
			beginTime = jsonParam.get("beginTime").getAsString();
			endTime = jsonParam.get("endTime").getAsString();

			 //将字符串格式转换为时间格式
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			try {
				// 查询条项：开始日期、结束日期
				if ((null != beginTime) && (!(("").equals(beginTime)))) {
					beginDate = simpleDateFormat.parse(beginTime);				
				}
				if ((null != endTime) && (!(("").equals(endTime)))) {
					endDate = simpleDateFormat.parse(endTime);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		//判断查询条件是否为空
		if( (null!=clientName) && (!("").equals(clientName)) ) {
			System.out.println("要搜索的客户：" + clientName );
			clientCriteria.andNameLike("%" + clientName + "%");
			List<Client> clients = clientMapper.selectByExample( clientExample );
			for (Client cl : clients) {
				clientIds.add( cl.getId() );
			}
			if( clientIds.size()>0 ) {
				serviceCriteria.andClientIdIn( clientIds );
			} else {
				serviceCriteria.andClientIdEqualTo(-1);
			}		
		}
		if( (null!=content) && (!("").equals(content)) ) {
			serviceCriteria.andContentLike("%" + content + "%");
		}
		if( -2!=type) {
			serviceCriteria.andTypeEqualTo(type);
		}
		if ((beginDate != null) && (endDate != null)) {
			// 输入的时期范围有上限和下限
			serviceCriteria.andHandleTimeBetween(beginDate, endDate);
		} else if ((beginDate != null) && (endDate == null)) {
			// 输入的时间范围没有下限
			serviceCriteria.andHandleTimeGreaterThanOrEqualTo(beginDate);
		} else if ((beginDate == null) && (endDate != null)) {
			// 输入的时间范围没有上限
			serviceCriteria.andHandleTimeLessThanOrEqualTo(endDate);
		}
			
		/**
		 * 基本查询--查看所有处理成功或失败的服务记录:
		 * 1.状态为处理成功(4)或处理失败(5)
		*/		
		serviceCriteria.andStatusBetween(4, 5);
				
		PageHelper.startPage( page, limit);	
		List<Service> services = serviceMapper.selectByExample(serviceExample);

		//性能过低
		for (Service se : services) {
			//填充每条记录的关联属性(即外键)
			Client client = clientMapper.selectByPrimaryKey( se.getClientId() );
			ServiceType type2 = serviceTypeMapper.selectByPrimaryKey( se.getType() );
			User creatorUser = userMapper.selectByPrimaryKey( se.getCreator() );
			User handlerUser = userMapper.selectByPrimaryKey( se.getHandler() );
			
			se.setClient(client);
			se.setServiceType(type2);
			se.setCreatorUser(creatorUser);
			se.setHandlerUser(handlerUser);
		}
		
		PageInfo pager = new PageInfo(services);
		
		return pager;
	}

	@Override
	public PageInfo<Service> assignList( Integer page, Integer limit, HttpSession session, String param ) {
		
		String clientName=null;
		String content=null;
		int type=-2;
		String beginTime = null;
		String endTime = null;
		Date beginDate = null;
		Date endDate = null;
		List<Integer> clientIds = new ArrayList<>();
		Integer userId = (Integer) session.getAttribute("id");

		
		ServiceExample serviceExample = new ServiceExample();
		ServiceExample.Criteria serviceCriteria = serviceExample.createCriteria();		
		ClientExample clientExample = new ClientExample();
		ClientExample.Criteria clientCriteria = clientExample.createCriteria();
		
		//获取查询条件
		if ( (null != param) && (!(("").equals(param))) ) {
			//初始化json转换器
			JsonParser parser = new JsonParser();
			JsonObject jsonParam = (JsonObject) parser.parse(param);
			
			clientName = jsonParam.get("clientName").getAsString();
			content = jsonParam.get("content").getAsString();
			type = jsonParam.get("type").getAsInt();
			
			beginTime = jsonParam.get("beginTime").getAsString();
			endTime = jsonParam.get("endTime").getAsString();

			 //将字符串格式转换为时间格式
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			try {
				// 查询条项：开始日期、结束日期
				if ((null != beginTime) && (!(("").equals(beginTime)))) {
					beginDate = simpleDateFormat.parse(beginTime);				
				}
				if ((null != endTime) && (!(("").equals(endTime)))) {
					endDate = simpleDateFormat.parse(endTime);
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		//判断查询条件是否为空
		if( (null!=clientName) && (!("").equals(clientName)) ) {
			clientCriteria.andNameLike("%" + clientName + "%");
			List<Client> clients = clientMapper.selectByExample( clientExample );
			for (Client cl : clients) {
				clientIds.add( cl.getId() );
			}
			if( clientIds.size()>0 ) {
				serviceCriteria.andClientIdIn( clientIds );
			} else {
				serviceCriteria.andClientIdEqualTo(-1);
			}
		}
		if( (null!=content) && (!("").equals(content)) ) {
			serviceCriteria.andContentLike("%" + content + "%");
		}
		if( -2!=type) {
			serviceCriteria.andTypeEqualTo(type);
		}
		if ((beginDate != null) && (endDate != null)) {
			// 输入的时期范围有上限和下限
			serviceCriteria.andCreateTimeBetween(beginDate, endDate);
		} else if ((beginDate != null) && (endDate == null)) {
			// 输入的时间范围没有下限
			serviceCriteria.andCreateTimeGreaterThanOrEqualTo(beginDate);
		} else if ((beginDate == null) && (endDate != null)) {
			// 输入的时间范围没有上限
			serviceCriteria.andCreateTimeLessThanOrEqualTo(endDate);
		}
			
		/**
		 * 基本查询--查看自己能分配的服务:
		 * 1.创建者是自己的员工, 且状态为等待分配（1）
		*/	
		UserExample userExample = new UserExample();
		UserExample.Criteria userCriteria = userExample.createCriteria();

		userCriteria.andUserIdEqualTo( userId );
		List<User> myEmployees = userMapper.selectByExample(userExample);
		List<Integer> myEmployeeIds = new ArrayList<>();
		for (User user : myEmployees) {
			myEmployeeIds.add( user.getId() );
		}
		//有下级才能查
		if( !myEmployeeIds.isEmpty() ) {
			//System.out.println("非空");
			serviceCriteria.andCreatorIn(myEmployeeIds);
		} else {
			System.out.println("当前用户没有下级，不能进行服务分配！");
			serviceCriteria.andCreatorEqualTo(-1);
		}
		serviceCriteria.andStatusEqualTo(1);

		PageHelper.startPage( page, limit );	
		List<Service> services = serviceMapper.selectByExample(serviceExample);

		//性能过低
		for (Service se : services) {
			//填充每条记录的关联属性(即外键)
			Client client = clientMapper.selectByPrimaryKey( se.getClientId() );
			ServiceType type2 = serviceTypeMapper.selectByPrimaryKey( se.getType() );
			User creatorUser = userMapper.selectByPrimaryKey( se.getCreator() );
			User handlerUser = userMapper.selectByPrimaryKey( se.getHandler() );
			
			se.setClient(client);
			se.setServiceType(type2);
			se.setCreatorUser(creatorUser);
			se.setHandlerUser(handlerUser);
		}
		
		PageInfo pager = new PageInfo(services);
		
		return pager;
	}
	
	@Override
	public PageInfo<Service> directorsServices(Integer page, Integer rows, List<User> userList ) {

		//找出创建人在为userList的服务
		List<Integer> idOfUsers = new ArrayList<>();
		for (User user : userList) {
			idOfUsers.add( user.getId() );
		}
		ServiceExample example = new ServiceExample();
		ServiceExample.Criteria criteria = example.createCriteria();
		criteria.andCreatorIn(idOfUsers);
		
		PageHelper.startPage( page, rows);	
		List<Service> services = serviceMapper.selectByExample(example);

		//手动填充外键，性能过低
		for (Service se : services) {
			//填充每条记录的关联属性(即外键)
			Client client = clientMapper.selectByPrimaryKey( se.getClientId() );
//			ServiceType type = serviceTypeMapper.selectByPrimaryKey( se.getType() );
			User creatorUser = userMapper.selectByPrimaryKey( se.getCreator() );
			User handlerUser = userMapper.selectByPrimaryKey( se.getHandler() );
			
			se.setClient(client);
//			se.setServiceType(type);
			se.setCreatorUser(creatorUser);
			se.setHandlerUser(handlerUser);
		}
					
		PageInfo pager = new PageInfo(services);		
		return pager;
	}

	@Override
	public Map<String, Object> reqForAssignService(Service newService) {
		
		System.out.println("所改记录的id是: "+ newService.getId());		
		
		Service oldService = serviceMapper.selectByPrimaryKey( newService.getId() );
		
		//将分配者设置为服务创建者的上级
		Integer creatorId = oldService.getCreator();
		Integer higherUpId = userMapper.selectByPrimaryKey( creatorId ).getUserId();
		newService.setAssigner( higherUpId );		
		
		newService.setAssignTime( new Date() );		
		newService.setHandler(null);
		//设置服务状态为等待分配（1）
		newService.setStatus(1);
		
		//根据实例更新记录
		int result = serviceMapper.updateByPrimaryKeySelective( newService );
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

	@Override
	public Map<String, Object> assignService(Service newService) {
		System.out.println("服务分配， 服务记录的id是: "+ newService.getId() + ", 取得服务概要: " + newService.getContent());		
		
		newService.setAssignTime( new Date() );
		newService.setStatus( 2 );
		
		//根据实例更新记录
		int result = serviceMapper.updateByPrimaryKeySelective(newService);
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

	@Override
	public Map<String, Object> reAssignService( Integer userId, Service se) {
	
		System.out.println("目标记录的id是: "+ se.getId());		
		
		//a.根据id取得原记录对象theService
		Service targetService = serviceMapper.selectByPrimaryKey( se.getId() );

		//b.对theService的属性进行重新赋值
		targetService.setId(null);
		targetService.setHandle(null);
		targetService.setHandler(null);
		targetService.setHandleTime(null);
		targetService.setSatisfaction(null);
		targetService.setResult(null);
		targetService.setComment(null);
		//恢复到等待分配状态
		targetService.setStatus(1);
		//分配者设为当前主管而不一定是原来创建者的上级
		targetService.setAssigner(userId);
		
		//c.将改造后的theService存入数据库中
		int result = serviceMapper.insert( targetService );
		//d.对原记录进行软删除(设置状态为-1)
		Service oldService = serviceMapper.selectByPrimaryKey( se.getId() );
		oldService.setStatus(-1);
		int result1 = serviceMapper.updateByPrimaryKey(oldService);
		
		boolean msg = false;
		String info = null;
		if( result>0 && result1>0 ) {
			msg = true;
		} else {
			msg = false;
			info = "服务再分配失败";
		}		
		Map<String, Object> ret = new HashMap<>();
		ret.put("msg", msg);
		ret.put("info", info);
		
		return ret;
	}

	@Override
	public List<AmountOne> selectAllServiceTypeForm() {
		return serviceMapper.selectServiceTypeForm();
	}

	@Override
	public List<AmountTwo> selectAllServiceSatisfactionForm() {
		return serviceMapper.selectServiceSatisfactionForm();
	}

	@Override
	public List<AmountTwo> selectAllServiceStatusForm() {
		return serviceMapper.selectServiceStatusForm();
	}

}