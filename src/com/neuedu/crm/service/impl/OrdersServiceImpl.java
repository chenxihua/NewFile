package com.neuedu.crm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.crm.bean.Orders;
import com.neuedu.crm.bean.OrdersExample;
import com.neuedu.crm.bean.OrdersExample.Criteria;
import com.neuedu.crm.dao.AreaMapper;
import com.neuedu.crm.dao.ClientMapper;
import com.neuedu.crm.dao.OrdersMapper;
import com.neuedu.crm.dao.UserMapper;
import com.neuedu.crm.service.OrdersService;
@Service
public class OrdersServiceImpl implements OrdersService{

	@Autowired
	private OrdersMapper ordersMapper;
	
	@Autowired
	private ClientMapper clientMapper;
	
	@Autowired
	private AreaMapper areaMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	//查看所有历史订单
	@Override
	public List<Orders> selectAlls() {
		List<Orders> finalList = new ArrayList<>();
		int clientId;
		int areaId;
		int userId;
		String clientName;
		String areaName;
		String userName;
		List<Orders> ordersList= ordersMapper.selectByExample(null);
		for (int i = 0; i < ordersList.size(); i++) {
			Orders orders = ordersList.get(i);
			//拿到areaId，clientId，userId
			areaId = orders.getAreaId();
			clientId = orders.getClientId();
			userId = orders.getUserId();
			//通过调用各个mapper的方法传入id查找到实体并拿到各自的name
			areaName = areaMapper.selectByPrimaryKey(areaId).getName();
			clientName = clientMapper.selectByPrimaryKey(clientId).getName();
			userName = userMapper.selectByPrimaryKey(userId).getName();
			//把各自的name放入orders，最后把orders压入list，返回
			orders.setAreaName(areaName);
			orders.setClientName(clientName);
			orders.setUserName(userName);
			finalList.add(orders);
		}
		return finalList;
	}
	
	//通过历史订单编号查找
	@Override
	public Orders selectById(Integer id) {
		String clientName;
		String areaName;
		String userName;
		Orders orders = ordersMapper.selectByPrimaryKey(id);
		areaName = areaMapper.selectByPrimaryKey(id).getName();
		clientName = clientMapper.selectByPrimaryKey(id).getName();
		userName = userMapper.selectByPrimaryKey(id).getName();
		orders.setAreaName(areaName);
		orders.setClientName(clientName);
		orders.setUserName(userName);
		return orders;
	}
	
	//软删除历史订单（没有使用）
	@Override
	public int deleteOrders(Orders orders) {
		orders.setStatus(-1);
		if (ordersMapper.updateByPrimaryKey(orders)!=0) {
			return 1;
		}
		return 0;
	}
	/**
		返回贡献度的值，总金额和客户名称
	*/
	
	@Override
	public List<Orders> idAndMoney() {
		int clientId;
		String clientName;
		//list为全部历史订单
		List<Orders> list = ordersMapper.selectByExample(null);
		//clientlist接受某个客户的所有历史订单表
		List<Orders> clientlist = new ArrayList<>();
		//finallist为最后处理后压入的list
		List<Orders> finallist = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) 
		{
			OrdersExample ordersExample = new OrdersExample();
			Criteria criteria = ordersExample.createCriteria();
			Orders orders = new Orders();
			long sum = 0;
			//获取该订单编号所对应的客户id
			clientId = list.get(i).getClientId();
			criteria.andClientIdEqualTo(clientId);
			//查出该客户的所有历史订单表
			clientlist = ordersMapper.selectByExample(ordersExample);
			//查出该客户的名称
			clientName = clientMapper.selectByPrimaryKey(clientId).getName();
			
			System.out.println(clientlist.size());
			//对所有查出的订单进行金额相加处理
			for (int j = 0; j < clientlist.size(); j++) 
				{
					sum += clientlist.get(j).getMoney(); 
				}
			orders.setMoney(sum);
			orders.setClientId(clientId);
			orders.setClientName(clientName);
			//判断该客户id是否已经在finallist中
			if(finallist.contains(orders)) {
			}else {
				finallist.add(orders);
			}
		}
		return finallist;

	}
	
	//根据时间区间查找历史订单列表
		@Override
		public List<Orders> selectByDate(Date dateMin,Date dateMax) {
			OrdersExample ordersExample = new OrdersExample();
			Criteria criteria = ordersExample.createCriteria();
			criteria.andRecordTimeBetween(dateMin, dateMax);
			List<Orders> list = ordersMapper.selectByExample(ordersExample);
			return list;
		}
	
}