package com.neuedu.crm.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.crm.bean.Orders;
import com.neuedu.crm.dao.OrdersMapper;
import com.neuedu.crm.service.OrdersService;

public class OrdersTest {
	
	private OrdersService ordersService;
	private ApplicationContext context;
	
	@Autowired
	private OrdersMapper ordersMapper;
	
	@Before
	public void init() {
		String configLocation = "classpath:applicationContext.xml";
		context = new ClassPathXmlApplicationContext( configLocation );
		ordersMapper = context.getBean(OrdersMapper.class);
		ordersService = context.getBean(OrdersService.class);
	}
	
	//时间区间查找测试
	@Test
	public void testOrders() throws ParseException {
		List<Orders> list = new ArrayList<>();
//		String string = "2018-01-01 10:38:20";
//		String string2 = "2018-02-13 13:57:22";
		String string = "2018-01-01";
		String string2 = "2018-02-14";
//      SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.parse(string)+"\n\n");
		System.out.println(ordersService.selectByDate(sdf.parse(string), sdf.parse(string2)));
	}
	
}
