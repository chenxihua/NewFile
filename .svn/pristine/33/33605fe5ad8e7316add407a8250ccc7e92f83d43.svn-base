package com.neuedu.crm.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.crm.bean.OrderItem;
import com.neuedu.crm.bean.Product;
import com.neuedu.crm.dao.OrderItemMapper;
import com.neuedu.crm.dao.ProductMapper;
import com.neuedu.crm.service.OrderItemService;
@Service
public class OrderItemServiceImpl implements OrderItemService{

	@Autowired
	private OrderItemMapper orderItemMapper;
	
	@Autowired
	private ProductMapper productMapper;

	//查找全部订单项
	@Override
	public List<OrderItem> selectAlls() {
		int productId;
		String productName;
		List<OrderItem> finalList = new ArrayList<>();
		List<OrderItem> orderItemList = orderItemMapper.selectByExample(null);
		for (int i = 0; i < orderItemList.size(); i++) {
			OrderItem orderItem = orderItemList.get(i);
			productName = productMapper.selectByPrimaryKey(orderItem.getProductId()).getName();
			orderItem.setProductName(productName);
			finalList.add(orderItem);
		}
		return finalList;
	}

	//根据id查找订单项
	@Override
	public OrderItem selectById(int id) {
		String productName;
		OrderItem orderItem = orderItemMapper.selectByPrimaryKey(id);
		System.out.println(orderItem);
		productName = productMapper.selectByPrimaryKey(orderItem.getProductId()).getName();
		orderItem.setProductName(productName);
		return orderItem;
	}

	//对订单项进行软删除
	@Override
	public int deleteOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		if(orderItemMapper.updateByPrimaryKey(orderItem)!=0) {
			return 1;
		}
		return 0;
	}

}
