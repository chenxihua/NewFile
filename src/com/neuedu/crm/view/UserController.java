package com.neuedu.crm.view;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.neuedu.crm.bean.Result;
import com.neuedu.crm.bean.Role;
import com.neuedu.crm.bean.User;
import com.neuedu.crm.service.RoleService;
import com.neuedu.crm.service.UserService;
import com.neuedu.crm.utils.EmailUtils;
import com.neuedu.crm.utils.Operation;
import com.neuedu.crm.utils.SHAEncrypt;

/**
 * 用户控制器
 * 
 * @author guokeng
 *
 */
@Operation(name = "用户操作")
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	private Logger logger = Logger.getLogger(UserController.class);

	/**
	 * 用户查询个人资料
	 * 
	 * @param model
	 * @param request
	 * @return
	 */
	/*@Operation(name = "查询个人资料")*/
	@RequestMapping(value = "queryuserinfo")
	public String getUserInfo(Model model, HttpServletRequest request) {
		int userId = (int) request.getSession().getAttribute("id");
		User user = userService.selectById(userId);

		if (null != user.getUserId()) {
			int superiorId = user.getUserId();
			/**
			 * 获取上级姓名
			 */
			String superiro = userService.selectById(superiorId).getName();
			model.addAttribute("superior", superiro);
		} else {
			/**
			 * 没有上级（管理员、高管）
			 */
			model.addAttribute("superior", "无");
		}

		/**
		 * 获取上次的登录时间
		 */
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lastLogin = simpleDateFormat.format(user.getLastLogin());
		model.addAttribute("user", user);

		model.addAttribute("lastLogin", lastLogin);

		return "user/personalinfo";
	}

	/**
	 * 用户修改个人资料
	 * 
	 * @param user
	 * @return
	 */
	@Operation(name = "修改个人资料")
	@RequestMapping(value = "alteruserinfo")
	@ResponseBody
	public String alterUserInfo(User user) {
		Result result = null;
		int ret = userService.alterUserInfo(user);
		if (ret > 0) {
			/**
			 * 更新成功
			 */
			result = new Result(true);
		} else {
			/**
			 * 更新失败
			 */
			result = new Result(false);
		}
		return new Gson().toJson(result);
	}

	/**
	 * 多条件模糊分页查询用户列表
	 * 
	 * @param page
	 * @param limit
	 * @param request
	 * @param param
	 * @return
	 * @throws ParseException
	 */
	/*@Operation(name = "查询用户")*/
	@RequestMapping(value = "queryusers")
	@ResponseBody
	public String findAllUsersByPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "limit", defaultValue = "10") Integer limit,
			HttpServletRequest request, String param)
			throws ParseException {

		PageInfo<User> userList = userService.findAllUsersByPages(param, page, limit);

		List<User> users = userList.getList();

		List<User> superiorUsers = userService.selectAllsUser();

		List<Role> roleList = roleService.findAllRoles();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		for (User user : users) {
			/**
			 * 设置角色名称
			 */
			for (Role role : roleList) {
				if (user.getRoleId() == role.getId()) {
					user.setRoleName(role.getName());
				}
			}
			/**
			 * 设置状态
			 */
			if (user.getStatus() == 0) {
				user.setAccountStatus("禁止登录");
			} else {
				user.setAccountStatus("正常");
			}
			/**
			 * 设置上次登录时间
			 */
			if (null != user.getLastLogin()) {
				user.setLastLoginTime(simpleDateFormat.format(user.getLastLogin()));
			} else {
				user.setLastLoginTime("无");
			}

			/**
			 * 设置上级名称
			 */
			for (User user2 : superiorUsers) {
				if (user.getUserId() == user2.getId()) {
					user.setSuperior(user2.getName());
				}
			}
			if (null == user.getSuperior()) {
				user.setSuperior("无");
			}

		}

		/**
		 * 设置num
		 */
		int id = limit * (page - 1);

		for (int i = 0; i < users.size(); i++, id++) {
			User user = users.get(i);
			user.setNum(id + 1);
		}

		/**
		 * 用google json来传值 (用hashmap会有时间格式错误)
		 */
		JsonArray json = new Gson().toJsonTree(userList.getList(), new TypeToken<List<User>>() {
		}.getType()).getAsJsonArray();
		String js = json.toString();
		String jso = "{\"code\":0,\"msg\":\"\",\"count\":" + userList.getTotal() + ",\"data\":" + js + "}";

		return jso;

	}

	/**
	 * 管理员查询账号的详细信息
	 * 
	 * @param id
	 * @param param
	 * @param model
	 * @param request
	 * @param response
	 * @throws ParseException
	 * @throws ServletException
	 * @throws IOException
	 */
	/*@Operation(name = "展示用户详细信息")*/
	@RequestMapping(value = "toupdateuserinfo/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void toUpdateUserInfo(@PathVariable(value = "id") Integer id, String param, Model model,
			HttpServletRequest request, HttpServletResponse response)
			throws ParseException, ServletException, IOException {

		User user = userService.selectById(id);

		/**
		 * 获取角色列表（除管理员）,设置角色名
		 */
		List<Role> roles = roleService.findAllRolesExceptAdmin();
		for (Role role : roles) {
			if (role.getId() == user.getRoleId()) {
				user.setRoleName(role.getName());
			}
		}

		if ((("").equals(user.getUserId())) || (null == user.getUserId())) {
			user.setUserId(0);
		}
		request.setAttribute("userDetails", user);
		request.setAttribute("roles", roles);
		request.getRequestDispatcher("/pages/user/userdetails.jsp").forward(request, response);
	}

	/**
	 * 管理员修改用户的账号信息
	 * 
	 * @param user
	 * @return
	 */
	@Operation(name = "修改用户信息")
	@RequestMapping(value = "updateuserinfo", method = RequestMethod.POST)
	@ResponseBody
	public String updateUserInfo(User user) {
		logger.debug("修改用户信息，接收到的参数：" + user.toString());
		Result result = null;
		int ret = userService.updataUserInfo(user);
		if (ret > 0) {
			/**
			 * 更新成功
			 */
			result = new Result(true);
		} else {
			/**
			 * 更新失败
			 */
			result = new Result(false);
		}
		return new Gson().toJson(result);
	}

	/**
	 * 准备新建用户操作，回显角色列表提供选择
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	/*@Operation(name = "新建用户")*/
	@RequestMapping(value = "toadduser", method = RequestMethod.GET)
	@ResponseBody
	public void toAddUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/**
		 * 获取角色列表（除管理员）,设置角色名
		 */
		List<Role> roleList = roleService.findAllRolesExceptAdmin();

		request.setAttribute("roleList", roleList);
		request.getRequestDispatcher("/pages/user/register.jsp").forward(request, response);
	}

	/**
	 * 注册用户
	 * 
	 * @param request
	 * @param user
	 * @return
	 * @throws ParseException
	 */
	@Operation(name = "保存新建用户")
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addUser(HttpServletRequest request, User user) throws ParseException {

		int ret = userService.registerUser(user);

		Map<String, Object> result = new HashMap<>();
		if (ret > 0) {
			/**
			 * 更新成功
			 */
			result.put("success", true);
			result.put("message", "新增用户成功");
		} else {
			/**
			 * 更新失败
			 */
			result.put("success", false);
			result.put("message", "新增用户失败");
		}
		return result;
	}

	/**
	 * 根据输入的账号找出用户邮箱，并保存用户信息
	 * 
	 * @param request
	 * @param user
	 * @return
	 * @throws ParseException
	 */
	@Operation(name = "查询用户邮箱")
	@RequestMapping(value = "/queryemail", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryEmailByAccount(HttpServletRequest request, User user) throws ParseException {

		HttpSession session = request.getSession(true);
		User userForPsw = userService.selectUserByParam(user.getName());

		Map<String, Object> result = new HashMap<>();

		if (null != userForPsw) {

			/**
			 * 存在该用户，保存对象
			 */
			session.setAttribute("userForPsw", userForPsw);
			/**
			 * 邮箱加密
			 */

			String[] email = userForPsw.getEmail().split("@");

			StringBuilder emailNumber = new StringBuilder(email[0]);

			emailNumber.replace(3, 5, "***");

			String showEmail = emailNumber.toString() + "@" + email[1];

			result.put("showEmail", showEmail);
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		return result;
	}

	/**
	 * 生成邮箱验证码，并发送邮件
	 * 
	 * @param request
	 * @return
	 * @throws ParseException
	 * @throws MessagingException
	 */
	@Operation(name = "发送邮件")
	@RequestMapping(value = "/sendemail", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> sendEmail(HttpServletRequest request) throws ParseException, MessagingException {

		HttpSession sesison = request.getSession();
		/**
		 * 生成验证码，保存到session
		 */
		String emailCheckCode = UUID.randomUUID().toString().substring(2, 8);
		logger.debug("邮箱验证码：" + emailCheckCode);
		sesison.setAttribute("emailCheckCode", emailCheckCode);

		/**
		 * 调用发送邮件接口，发送验证码邮件给指定邮箱
		 */
		User user = (User) sesison.getAttribute("userForPsw");

		/**
		 * 参数设置
		 */
		String target = user.getEmail();
		String title = "【CRM客户关系管理系统】";
		String contents = "CRM客户关系管理系统：您目前正在进行找回密码操作，本次的验证码是："
						+ emailCheckCode + 
						",请勿向他人泄露，如不是本人操作，请尽快修改密码！";

		/**
		 * 发送邮件
		 */
		boolean ret = EmailUtils.sendEmailCode(target, title, contents);

		Map<String, Object> result = new HashMap<>();

		if (ret) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}
		return result;
	}

	/**
	 * 检验用户输入的邮箱验证码
	 * 
	 * @param request
	 * @param emailCode
	 * @return
	 * @throws ParseException
	 * @throws MessagingException
	 */
	@Operation(name = "检验邮箱验证码")
	@RequestMapping(value = "/checkemailcode", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> checkEmailCode(HttpServletRequest request, @RequestBody String emailCode)
			throws ParseException, MessagingException {

		HttpSession sesison = request.getSession();
		/**
		 * 把输入的邮箱验证码与session中的邮箱验证码校验，返回结果
		 */

		String emailCodeInSession = (String) sesison.getAttribute("emailCheckCode");
		String emailCodeAccepted = emailCode.split("=")[1];

		Map<String, Object> result = new HashMap<>();

		if (emailCodeInSession.equals(emailCodeAccepted)) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}

		return result;
	}

	/**
	 * 修改用户密码
	 * 
	 * @param request
	 * @param password
	 * @return
	 * @throws ParseException
	 * @throws MessagingException
	 */
	@Operation(name = "修改用户密码")
	@RequestMapping(value = "/alterpassword", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> alterPassword(HttpServletRequest request, @RequestBody String password)
			throws ParseException, MessagingException {

		String newPassword = password.split("=")[1];
		String pswPart1 = newPassword.substring(5, 8);
		String pswPart2 = newPassword.substring(22, newPassword.length());
		String psw = pswPart1 + pswPart2;

		SHAEncrypt encryptor = new SHAEncrypt();

		HttpSession session = request.getSession();
		/**
		 * 生成新的盐值和哈希吗
		 */
		String hash = encryptor.SHA512(psw);
		String salt = UUID.randomUUID().toString();

		String hashCode = encryptor.SHA256(hash + salt);

		/**
		 * 修改用户的盐值和密码
		 */
		User user = (User) session.getAttribute("userForPsw");
		user.setHashCode(hashCode);
		user.setSalt(salt);

		int ret = userService.alterPassword(user);

		Map<String, Object> result = new HashMap<>();

		if (ret > 0) {
			result.put("success", true);
		} else {
			result.put("success", false);
		}

		return result;
	}
}
