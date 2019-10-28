package com.neuedu.crm.view;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.neuedu.crm.bean.Result;
import com.neuedu.crm.bean.User;
import com.neuedu.crm.service.UserService;
import com.neuedu.crm.utils.Operation;
import com.neuedu.crm.utils.vcode.Captcha;
import com.neuedu.crm.utils.vcode.GifCaptcha;

/**
 * 登陆控制器
 * 
 * @author guokeng
 *
 */
@Operation(name = "登录操作")
@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	private Logger logger = Logger.getLogger(LoginController.class);

	/**
	 * 生成验证码
	 * 
	 * @param response
	 * @param request
	 * @author
	 */
	//@Operation(name = "获取验证码")
	@RequestMapping(value = "getGifCode", method = RequestMethod.GET)
	public void getGifCode(HttpServletResponse response, HttpServletRequest request) {
		try {
			response.setHeader("Pragma", "No-cache");
			response.setHeader("Cache-Control", "no-cache");
			response.setDateHeader("Expires", 0);
			response.setContentType("image/gif");
			/**
			 * gif格式动画验证码 宽，高，位数。
			 */
			Captcha captcha = new GifCaptcha(146, 33, 4);

			/**
			 * 输出
			 */
			captcha.out(response.getOutputStream());
			HttpSession session = request.getSession(true);

			session.setAttribute("_code", captcha.text().toLowerCase());
			logger.debug(captcha.text());
		} catch (Exception e) {
		}
	}

	/**
	 * 验证码校验
	 * 
	 * @param response
	 * @param request
	 * @param validCode
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	//@Operation(name = "校验验证码")
	@RequestMapping(value = "checkvalidcode")
	@ResponseBody
	public String doCheckCode(HttpServletResponse response, HttpServletRequest request, String validCode)
			throws ServletException, IOException {
		Result result = null;
		String ret = null;
		try {
			logger.debug("接收到的验证码是：" + validCode);
			/**
			 * 获取session中的验证码，与输入的验证码比较
			 */
			HttpSession session = request.getSession();
			String sessionCode = (String) session.getAttribute("_code");
			if ((validCode.toLowerCase()).equals(sessionCode)) {
				result = new Result(true);
			} else {
				result = new Result(false);
			}
			/**
			 * 利用Gson把java对象转换成字符串
			 */
			ret = new Gson().toJson(result);

		} catch (Exception e) {
		}
		logger.debug("验证码比较返回的结果：" + ret);
		return ret;
	}

	/**
	 * 登陆验证
	 * 
	 * @param response
	 * @param request
	 * @param account
	 * @param password
	 * @param validCode
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@Operation(name = "进行登录操作")
	@RequestMapping(value = "index")
	public String login(HttpServletResponse response, HttpServletRequest request, String account, String password,
			String validCode) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		try {
			logger.debug("登陆传入的用户名：" + account);
			logger.debug("登陆传入的密码：" + password);
			String pswPart1 = password.substring(5, 8);
			String pswPart2 = password.substring(22, password.length());
			String psw = pswPart1 + pswPart2;

			User user = userService.selectUserByParam(account);

			if (null == user) {
				/**
				 * 根据用户名查找是否有该名用户，没有则返回到登陆页面，告知用户名或密码错误
				 */
				logger.debug("##############找不到这个用户");
				session.setAttribute("loginError", "用户名或密码错误");
				return "user/login";
			}else if(user.getStatus() == 0) {
				logger.debug("##############用户已被进制登陆");
				session.setAttribute("loginError", "该账号已被禁止登陆");
				return "user/login";
			} else {
				/**
				 * 如果存在该用户，则取出盐值，生成hashCode给token
				 */
				String hashCode = userService.getHashCode(account, psw);

				UsernamePasswordToken token = new UsernamePasswordToken(account, hashCode);

				/**
				 * shiro验证用户身份
				 */
				SecurityUtils.getSubject().login(token);

				/**
				 * 保存用户信息，包括用户ID，用户名，上级id，所有下级
				 */
				session.setAttribute("id", user.getId());
				session.setAttribute("name", user.getName());
				session.setAttribute("roleId", user.getRoleId());
				session.setAttribute("userId", user.getUserId());
				session.setAttribute("lowerUser", userService.selectDirectLower(user));

				/**
				 * 修改上次登录时间为当前系统时间
				 */
				User loginUser = new User();
				loginUser.setId(user.getId());
				loginUser.setLastLogin(new Date());
				userService.alterUserInfo(loginUser);

			}
		} catch (UnknownAccountException uae) {
			session.setAttribute("loginError", "用户名或密码错误");
			return "user/login";
		} catch (IncorrectCredentialsException ice) {
			session.setAttribute("loginError", "用户名或密码错误");
			return "user/login";
		} catch (NullPointerException exception) {
			if (null == session.getAttribute("id")) {
				return "user/login";
			}
		}
		return "public/common";
	}

	/**
	 * 退出登陆，销毁session
	 * 
	 * @param request
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	@Operation(name = "进行退出登录操作")
	@RequestMapping(value = "logoutcrm")
	public String logout(HttpServletRequest request) throws ServletException, IOException {

		logger.debug("-----------准备登出---------------");
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "user/login";
	}

}
