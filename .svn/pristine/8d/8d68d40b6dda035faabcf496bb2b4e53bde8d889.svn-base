package com.neuedu.crm.test;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.crm.bean.Service;
import com.neuedu.crm.bean.ServiceExample;
import com.neuedu.crm.bean.ServiceExample.Criteria;
import com.neuedu.crm.dao.ServiceMapper;
import com.neuedu.crm.service.OutflowService;
import com.neuedu.crm.service.ServiceService;

/**
 * Test类：流失管理
 * @author Mechan
 */
public class OutflowTest {
	
	private ApplicationContext context;
	@Autowired
	private OutflowService outflowService; 	
	private Logger logger = Logger.getLogger( ServiceTest.class ); 
	
	@Before
	public void init() {
		String configLocation = "classpath:applicationContext.xml";
		context = new ClassPathXmlApplicationContext( configLocation );
		outflowService =context.getBean( OutflowService.class );
	}
	
	@Test
	public void checkOrdersTest() {
		int intserted = outflowService.CheckOrders();
		System.out.println( "已插入流失记录数目：" + intserted );
	}
	

}

