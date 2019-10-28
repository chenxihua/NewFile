package com.neuedu.crm.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.crm.bean.Authority;
import com.neuedu.crm.service.AuthorityService;

public class AuthorityTest {

	private Logger logger = Logger.getLogger(AuthorityTest.class);

	private AuthorityService authorityService;

	@Before
	public void init() {
		String configLocation = "classpath:applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		authorityService = (AuthorityService) context.getBean("AuthorityServiceImpl");
	}

	@Test
	public void testFindAllAuth() {

		List<Authority> authorities = authorityService.findAllAutority();
		for (Authority authority : authorities) {
			logger.debug(authority);
		}
	}

}
