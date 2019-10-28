package com.neuedu.crm.shiro;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.neuedu.crm.bean.User;
import com.neuedu.crm.service.AuthorityService;
import com.neuedu.crm.service.RoleService;
import com.neuedu.crm.service.UserService;

public class Realm extends AuthorizingRealm {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;
	
	@Autowired
	private AuthorityService authorityService;
	
	private Logger logger = Logger.getLogger(Realm.class);

	/**
	 * 进行授权操作（设置角色、权限）
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.setRoles(roleService.findRoles(username));
		authorizationInfo.setStringPermissions(authorityService.findPermissions(username));
		logger.info(authorityService.findPermissions(username));
		return authorizationInfo;
	}

	/**
	 * 用户验证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String username = (String) token.getPrincipal();
		User user = userService.selectUserByParam(username);
		if (null == user) {
			/**
			 * 没找到帐号
			 */
			throw new UnknownAccountException();
		}

		logger.info("数据库取出的用户名：" + user.getName());
		logger.info("数据库取出的hashcode：" + user.getHashCode());

		/**
		 * 验证用户名、密码
		 */
		return new SimpleAuthenticationInfo(user.getName(), user.getHashCode(), getName());
	}

	public Realm() {
		super();
	}

	public Realm(UserService userService, RoleService roleService, AuthorityService authorityService) {
		super();
		this.userService = userService;
		this.roleService = roleService;
		this.authorityService = authorityService;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public RoleService getRoleService() {
		return roleService;
	}

	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}

	public AuthorityService getAuthorityService() {
		return authorityService;
	}

	public void setAuthorityService(AuthorityService authorityService) {
		this.authorityService = authorityService;
	}

	
	
	
	
}