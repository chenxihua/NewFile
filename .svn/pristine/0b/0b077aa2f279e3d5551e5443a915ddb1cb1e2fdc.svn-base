package com.neuedu.crm.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.crm.bean.LoggingEvent;
import com.neuedu.crm.service.LoggingEventServer;


/**
 * 测试日志
 * @author Administrator
 *
 */

public class LogbackTest {
	
	@Autowired
	private LoggingEventServer logServer;
	
	private Logger logger = Logger.getLogger(LogbackTest.class); 
	
	@Before
	public void init() {
		String configLocation = "classpath:applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext( configLocation );
		logServer = context.getBean(LoggingEventServer.class);
	}
	
	@Test
	public void testLogger(){
		List<LoggingEvent> list = logServer.selectByLoggingEventExample(15, 10);
		for (LoggingEvent log : list) {
			//logger.info(log);
			//System.out.println(log);
		}
	}
	
	
	
}
