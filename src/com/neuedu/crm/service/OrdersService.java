package com.neuedu.crm.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.neuedu.crm.bean.Orders;

public interface OrdersService {
	//查全部
	public List<Orders> selectAlls();
	//通过id查询
	public Orders selectById(Integer id);
	//软删除
	public int deleteOrders(Orders orders);
	
	//贡献度
	public List<Orders> idAndMoney();
	
	//日期
	public List<Orders> selectByDate(Date dateMin,Date dateMax);

}