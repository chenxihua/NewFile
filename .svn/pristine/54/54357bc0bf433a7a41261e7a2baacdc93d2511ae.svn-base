package com.neuedu.crm.test;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.crm.service.MessageService;

public class MessageTest {

	private Logger logger = Logger.getLogger(UserTest.class);

	private MessageService messageService;

	@Before
	public void init() {
		String configLocation = "classpath:applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		messageService = (MessageService) context.getBean("MessageServiceImpl");
	}

	/*
	 * @Test public void testFindAllMsgByPage() { String username = "张三";
	 * messageService.findAllMsgByPage(message, null, null, null, page, rows);
	 * Set<String> roles = userService.findRoles(username); for (String role :
	 * roles) { logger.debug(role); } }
	 */

}
