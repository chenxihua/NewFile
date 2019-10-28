package com.neuedu.crm.shiro;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

/**
 * 创建自定义过滤器，实现自定义跳转
 * 
 * @author guokeng
 *
 */
public class CrmFormAuthenticationFilter extends FormAuthenticationFilter {

	private Logger logger = Logger.getLogger(CrmFormAuthenticationFilter.class);

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {

		/**
		 * 清除登录前请求路径
		 */
		WebUtils.getAndClearSavedRequest(request);
		String fallbackUrl = null;

		/**
		 * 自定义跳转界面
		 */
		fallbackUrl = "/pages/public/common.jsp";
		WebUtils.redirectToSavedRequest(request, response, fallbackUrl);
		return false;
	}

}
