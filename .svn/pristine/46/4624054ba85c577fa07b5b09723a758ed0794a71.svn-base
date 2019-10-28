package com.neuedu.crm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.crm.bean.Client;
import com.neuedu.crm.bean.Orders;
import com.neuedu.crm.bean.OrdersExample;
import com.neuedu.crm.bean.Outflow;
import com.neuedu.crm.bean.OutflowExample;
import com.neuedu.crm.bean.Service;
import com.neuedu.crm.bean.ServiceExample;
import com.neuedu.crm.bean.ServiceType;
import com.neuedu.crm.bean.User;
import com.neuedu.crm.bean.UserExample;
import com.neuedu.crm.dao.ClientMapper;
import com.neuedu.crm.dao.OrdersMapper;
import com.neuedu.crm.dao.OutflowMapper;
import com.neuedu.crm.dao.ServiceMapper;
import com.neuedu.crm.dao.ServiceTypeMapper;
import com.neuedu.crm.dao.UserMapper;
import com.neuedu.crm.service.OutflowService;
import com.neuedu.crm.service.ServiceService;
import com.neuedu.crm.utils.DayCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service实现层：流失管理
 * @author Mechan
 */
@org.springframework.stereotype.Service
@Transactional(rollbackFor=Exception.class)
public class OutflowServiceImpl implements OutflowService{

	@Autowired
	private OutflowMapper outflowMapper;
	@Autowired
	private OrdersMapper ordersMapper;
	@Autowired
	private ClientMapper clientMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<Outflow> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Outflow selectById(Integer id) {
		Outflow ou = outflowMapper.selectByPrimaryKey(id);		
		
		//填充每条记录的关联属性(即外键)(注意要填充assignerUser)
		Client client = clientMapper.selectByPrimaryKey( ou.getClientId() );
		User handlerUser = userMapper.selectByPrimaryKey( ou.getHandler() );
		
		ou.setClient(client);
		ou.setHandlerUser(handlerUser);
		
		return ou;
	}

	@Override
	public List<Outflow> selectByExamplePager(OutflowExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateOutflow(Outflow record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int CheckOutflow() {
		
		DayCalculator dayCalculator = new DayCalculator();
		int deleted = 0; 
		
		//找出所有的客户id
		List<Client> clients = clientMapper.selectByExample(null);
		List<Integer> clientIds = new ArrayList<>();
		for (Client client : clients) {
			clientIds.add( client.getId() );
		}
		
		//找出某客户的所有订单（如果客户没有订单，程序结束）	
		for (Integer cid : clientIds) {
			
			//System.out.println("进入某客户的订单检查, 客户编号: " + cid );				
			OrdersExample ordersExample = new OrdersExample();
			OrdersExample.Criteria ordersCriteria = ordersExample.createCriteria(); 
			ordersCriteria.andClientIdEqualTo(cid);
			List<Orders> cidOrders = ordersMapper.selectByExample(ordersExample);
			
			//查看此客户是否已在流失记录中
			OutflowExample outflowExample = new OutflowExample();
			OutflowExample.Criteria outflowCriteria = outflowExample.createCriteria(); 
			outflowCriteria.andClientIdEqualTo(cid);
			outflowCriteria.andStatusNotEqualTo(-1);
			List<Outflow> cidOutflows = outflowMapper.selectByExample(outflowExample);
			
			//找出某客户订单中下单时间最近的一条订单
			if( cidOrders.size()>0 && cidOutflows.size()==0 ) {		
				
				Date recentOrdersDate = cidOrders.get(0).getRecordTime();	
				Orders recentOrder = cidOrders.get(0);
				for (Orders o : cidOrders) {
					if( o.getRecordTime().after(recentOrdersDate) ) {
						recentOrdersDate = o.getRecordTime();
						recentOrder = o;
					}
				}
				
				//计算下单时间与当前时间相差的天数
				long days =  dayCalculator.calcDays( recentOrdersDate );
				//System.out.println("最近订单编号：" + recentOrder.getId() + ", 相差天数: " + days );
				
				if( days<=90 ) {
					//如果某客户的最近下单时间在3个月内，不能将客户视为流失
					OutflowExample outflowExample2 = new OutflowExample();
					OutflowExample.Criteria outflowCriteria2 = outflowExample.createCriteria(); 
					outflowCriteria2.andClientIdEqualTo( recentOrder.getClientId() );
					List<Outflow> outflows = outflowMapper.selectByExample(outflowExample2);				
					if( outflows != null && outflows.get(0) != null)
						if( outflows.get(0).getStatus() != -1 ) {
							Outflow newOutflow = outflows.get(0);
							newOutflow.setStatus(-1);
							deleted = deleted + outflowMapper.updateByPrimaryKeySelective(newOutflow);							
							System.out.println("被删除的流失记录数id" + recentOrder.getClientId() );
						}
				}
			}
		}
		
		return deleted;
	}
	
	@Override
	public int CheckOrders() {
		
		DayCalculator dayCalculator = new DayCalculator();
		int inserted = 0; 
		
		//找出所有的客户id
		List<Client> clients = clientMapper.selectByExample(null);
		List<Integer> clientIds = new ArrayList<>();
		for (Client client : clients) {
			clientIds.add( client.getId() );
		}
		
		//找出某客户的所有订单（如果客户没有订单，程序结束）	
		for (Integer cid : clientIds) {
			
			//System.out.println("进入某客户的订单检查, 客户编号: " + cid );				
			OrdersExample ordersExample = new OrdersExample();
			OrdersExample.Criteria ordersCriteria = ordersExample.createCriteria(); 
			ordersCriteria.andClientIdEqualTo(cid);
			List<Orders> cidOrders = ordersMapper.selectByExample(ordersExample);
			
			//查看此客户是否已在流失记录中
			OutflowExample outflowExample = new OutflowExample();
			OutflowExample.Criteria outflowCriteria = outflowExample.createCriteria(); 
			outflowCriteria.andClientIdEqualTo(cid);
			outflowCriteria.andStatusNotEqualTo(-1);
			List<Outflow> cidOutflows = outflowMapper.selectByExample(outflowExample);
			
			//找出某客户订单中下单时间最近的一条订单
			if( cidOrders.size()>0 && cidOutflows.size()==0 ) {		
				
				Date recentOrdersDate = cidOrders.get(0).getRecordTime();	
				Orders recentOrder = cidOrders.get(0);
				for (Orders o : cidOrders) {
					if( o.getRecordTime().after(recentOrdersDate) ) {
						recentOrdersDate = o.getRecordTime();
						recentOrder = o;
					}
				}
				
				//计算下单时间与当前时间相差的天数
				long days =  dayCalculator.calcDays( recentOrdersDate );
				//System.out.println("最近订单编号：" + recentOrder.getId() + ", 相差天数: " + days );
				
				if( days>90 ) {
					//如果某客户的最近下单时间已经是3个月前，将此订单转化为流失记录并添加到数据库
					Outflow outflow = new Outflow();
					outflow.setClientId( recentOrder.getClientId() );
					//设置流失处理者为负责此订单的经理
					outflow.setHandler( recentOrder.getUserId() );
					outflow.setLastOrderTime(recentOrdersDate);
					//设置状态为流失预警
					outflow.setStatus(0);
					inserted = inserted + outflowMapper.insert(outflow);
					//System.out.println("已添加到流失记录，相关订单编号：" + recentOrder.getId() );
				}
			}
		}
		
		return inserted;
	}

	@Override
	public PageInfo<Outflow> outflowList(Integer page, Integer rows, Integer userId) {
		
		OutflowExample outflowExample = new OutflowExample();
		UserExample userExample = new UserExample();

		OutflowExample.Criteria outflowCriteria = outflowExample.createCriteria();
		UserExample.Criteria userCriteria = userExample.createCriteria();

		//主管操作，查看所有的流失记录
//		userCriteria.andUserIdEqualTo( userId );
//		List<User> myEmployees = userMapper.selectByExample(userExample);
//		List<Integer> myEmployeeIds = new ArrayList<>();
//		for (User user : myEmployees) {
//			myEmployeeIds.add( user.getId() );
//		}
//		
//		outflowCriteria.andHandlerIn(myEmployeeIds);
		outflowCriteria.andStatusNotEqualTo(-1);

		PageHelper.startPage( page, rows);	
		List<Outflow> outflows = outflowMapper.selectByExample(outflowExample);

		//性能过低
		for (Outflow ou : outflows) {
			//填充每条记录的关联属性(即外键)
			Client client = clientMapper.selectByPrimaryKey( ou.getClientId() );
			User handlerUser = userMapper.selectByPrimaryKey( ou.getHandler() );
			
			ou.setClient(client);
			ou.setHandlerUser(handlerUser);
		}
		
		PageInfo pager = new PageInfo(outflows);
		
		return pager;
	}

	@Override
	public PageInfo<Outflow> handleOutflowList(Integer page, Integer rows, Integer userId) {
		
		OutflowExample outflowExample = new OutflowExample();
		UserExample userExample = new UserExample();

		OutflowExample.Criteria outflowCriteria = outflowExample.createCriteria();
		UserExample.Criteria userCriteria = userExample.createCriteria();

		//经理操作: 查看自己能处理的流失记录(处理人是自己)		
		outflowCriteria.andHandlerEqualTo(userId);
		outflowCriteria.andStatusNotEqualTo(-1);

		PageHelper.startPage( page, rows);	
		List<Outflow> outflows = outflowMapper.selectByExample(outflowExample);

		//性能过低
		for (Outflow ou : outflows) {
			//填充每条记录的关联属性(即外键)
			Client client = clientMapper.selectByPrimaryKey( ou.getClientId() );
			User handlerUser = userMapper.selectByPrimaryKey( ou.getHandler() );
			
			ou.setClient(client);
			ou.setHandlerUser(handlerUser);
		}
		
		PageInfo pager = new PageInfo(outflows);
		
		return pager;
	}

	@Override
	public Map<String, Object> deferOutflow(Outflow newOutflow) {
		System.out.println("暂缓流失， 流失记录的id是: "+ newOutflow.getId() + ", 取得暂缓流失措施: " + newOutflow.getDeferMeasure());		
		
		//设置处理时间为当前时间，状态为暂缓流失
		newOutflow.setHandleTime( new Date() );
		newOutflow.setStatus(1);
		int result = outflowMapper.updateByPrimaryKeySelective(newOutflow);
		System.out.println("更新流失表的记录数：" + result);
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
	public Map<String, Object> confirmOutflow(Outflow newOutflow) {
		System.out.println("确认流失， 流失记录的id是: "+ newOutflow.getId() + ", 取得流失原因： " + newOutflow.getReason());		
		
		//设置处理时间为当前时间，状态为确认流失
		newOutflow.setOutflowTime( new Date() );
		newOutflow.setStatus(2);
		int result = outflowMapper.updateByPrimaryKeySelective(newOutflow);
		System.out.println("更新流失表的记录数：" + result);
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
	
}