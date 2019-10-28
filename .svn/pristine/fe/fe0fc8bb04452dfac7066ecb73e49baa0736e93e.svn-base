package com.neuedu.crm.test;

import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.crm.bean.User;
import com.neuedu.crm.service.AuthorityService;
import com.neuedu.crm.service.RoleService;
import com.neuedu.crm.service.UserService;

public class UserTest {

	private Logger logger = Logger.getLogger(UserTest.class);

	private UserService userService;

	private RoleService roleService;

	private AuthorityService authorityService;

	@Before
	public void init() {
		String configLocation = "classpath:applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		userService = (UserService) context.getBean("UserServiceImpl");
	}

	@Test
	public void testFindRoleByName() {
		String username = "张三";
		Set<String> roles = roleService.findRoles(username);
		for (String role : roles) {
			logger.info(role);
		}
	}

	@Test
	public void testFindPermissionByName() {
		String username = "张三";
		Set<String> permissions = authorityService.findPermissions(username);
		for (String permission : permissions) {
			logger.info(permission);
		}
	}

	@Test
	public void testSelectUserByParam() {
		String param = "15813151317";
		User user = userService.selectUserByParam(param);
		if (null != user) {
			logger.debug("根据帐号查找出的用户" + user.toString());
		} else {
			logger.debug("查找不到该用户");
		}
	}
}
