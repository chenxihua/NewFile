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
import com.neuedu.crm.service.ServiceService;

/**
 * Test类：服务管理
 * @author Mechan
 */
public class ServiceTest {
	
	private ApplicationContext context;
	@Autowired
	private ServiceMapper serviceMapper;
	@Autowired
	private ServiceService serviceService; 
	private Logger logger = Logger.getLogger( ServiceTest.class ); 
	
	@Before
	public void init() {
		String configLocation = "classpath:applicationContext.xml";
		context = new ClassPathXmlApplicationContext( configLocation );
		serviceMapper = context.getBean( ServiceMapper.class  );
		serviceService =context.getBean( ServiceService.class );
	}
	
	@Test
	public void findById() {
		Integer id = 2;
		Service s = serviceMapper.selectByPrimaryKey(id);
		System.out.println( s.getContent() );
	}
	
	/**
	 * 字符串模糊查询
	 */
	@Test
	public void findByExample() {

		ServiceExample example = new ServiceExample();
		ServiceExample.Criteria criteria = example.createCriteria();
		criteria.andContentLike( "%" + "查" + "%");
		List<Service> list = serviceMapper.selectByExample(example);		
		for (Service s : list) {
			logger.info( s.getId() + "," + s.getContent() );
//			System.out.println( s.getId() + "," + s.getContent());
		}
	}
	
	/**
	 * 测试Service层的employeesServices方法
	 */
	@Test
	public void selectByPager() {	
		int page=2;
		int rows=10;
		int userId=5;
		
		PageInfo<Service> pager = serviceService.employeesServices(page, rows, userId);
		
		System.out.println("总记录数：" + pager.getTotal() );
		List<Service> services = pager.getList();		
		for (Service service : services) {
			System.out.println( service.getId() + ", " + service.getContent() + ", "
					+ service.getClient().getName());
		}
	}
	
	@Test
	public void insert() {
		Service record = new Service();
		record.setContent("详情查阅");		
		int t = serviceMapper.insert(record);
		logger.info( t );
//		System.out.println("已插入记录： " + t);		
	}
	
	@Test
	public void reqForAssignServiceTest() {
		Integer id = 57;
		Service newService = new Service();
		newService.setId(id);
		Map<String, Object> ret = serviceService.reqForAssignService(newService);
	}
	
	@Test
	public void createService() {
		Service newService = new Service();
		newService.setContent("想看看吗");		
		Map<String, Object> ret = serviceService.createService( 5, newService);

	}
		
	@Test
	public void feedbackService() {
		Integer id = 18;
		Service newService = new Service();
		newService.setId(id);
		newService.setSatisfaction(3);
		newService.setResult("这就是处理结果");
		Map<String, Object> ret = serviceService.feedbackService(newService);
	}
		
//	@Test
//	public void List() {
//		Integer userId = 4;		
//		PageInfo<Service> pager = serviceService.assignList( 1, 10, userId);
//		
//		System.out.println("可分配服务数：" + pager.getTotal() );
//		List<Service> services = pager.getList();		
//		for (Service service : services) {
//			System.out.println( service.getId() + ", " + service.getClient().getName() + ", "
//					+ service.getContent() + ", " + service.getCreator() + ", " + service.getStatus());
//		}
//	}
	
	@Test
	public void List2() {
		ServiceExample serviceExample = new ServiceExample();
		ServiceExample.Criteria serviceCriteria = serviceExample.createCriteria();
		serviceCriteria.andContentLike("李%");
		List<Service> services = serviceMapper.selectByExample(serviceExample);
		
		System.out.println("查询结果");
		for (Service service : services) {
			System.out.println("编号：" + service.getId() +", 概要：" + service.getContent());
		}
	}
}
