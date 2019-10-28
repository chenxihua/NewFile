package com.neuedu.crm.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neuedu.crm.bean.User;
import com.neuedu.crm.bean.UserExample;
import com.neuedu.crm.bean.UserExample.Criteria;
import com.neuedu.crm.dao.UserMapper;
import com.neuedu.crm.service.UserService;
import com.neuedu.crm.utils.SHAEncrypt;

/**
 * 用户业务层
 * 
 * @author 见下面方法注释
 *
 */
@Service(value = "UserServiceImpl")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	private SHAEncrypt encryptor;

	private Logger logger = Logger.getLogger(UserServiceImpl.class);

	/** guokeng **/
	/**
	 * 注册用户
	 */
	@Override
	public int registerUser(User user) {
		String psw = user.getHashCode();
		String pswPart1 = psw.substring(5, 8);
		String pswPart2 = psw.substring(22, psw.length());
		String password = pswPart1 + pswPart2;

		encryptor = new SHAEncrypt();

		String hash = encryptor.SHA512(password);
		String salt = UUID.randomUUID().toString();
		/**
		 * 设置盐值
		 */
		user.setSalt(salt);
		String hashCode = encryptor.SHA256(hash + salt);
		/**
		 * 设置hashCode
		 */
		user.setHashCode(hashCode);
		/**
		 * 设置帐号状态
		 */
		user.setStatus(1);

		/**
		 * 设置上级
		 */
		if ((0 == user.getUserId()) || ("0".equals(user.getUserId()))) {
			user.setUserId(null);
		}

		int ret = userMapper.insert(user);
		return ret;
	}

	/** guokeng **/
	/**
	 * 根据用户名获取用户信息，利用传进的密码与取出的盐值进行计算hashCode 成功则返回用户对象，失败返回空
	 */
	@Override
	public User loginValidate(String account, String password) {
		encryptor = new SHAEncrypt();
		User user = userMapper.selectUserByName(account);
		if (null == user) {
			/**
			 * 用户不存在
			 */
			return null;
		} else {
			/**
			 * 用户存在，检验密码
			 */
			String hash = encryptor.SHA512(password);
			String salt = user.getSalt();
			String hashCode = encryptor.SHA256(hash + salt);
			/**
			 * 避免用户存在、密码为空的情况抛出空指针异常
			 */
			if (("").equals(user.getHashCode()) || (null == user.getHashCode())) {
				return null;
			} else {
				if (!(user.getHashCode().equals(hashCode))) {
					/**
					 * 密码不正确，返回空
					 */
					return null;
				} else {
					/**
					 * 密码正确，返回用户对象
					 */
					return user;
				}
			}

		}
	}

	/** chen **/
	/**
	 * 用户登录,查询是否存在这个用户，如果list>0;这登录成功； example表示及可以是用户名，也可以是邮箱； String password
	 * 这个参数还不能确定，是 int 还是 String 类型 sql语句就是：select * from user where ( id = '帐号' or
	 * phone_num = '帐号' or email = '帐号' ) and password = '密码';
	 */
	@Override
	public List<User> selectUser(String example, String password) {
		UserExample userexample = new UserExample();
		Criteria criteria = userexample.createCriteria();
		criteria.andNameEqualTo(example);
		criteria.andEmailEqualTo(example);
		List<User> userList = userMapper.selectByExample(userexample);
		return userList;
	}

	/** chen **/
	/**
	 * 根据用户名，精确查询这个实体，用于获取到他的id,以及roleId;
	 */
	@Override
	public User selectByName(String username) {
		return userMapper.selectUserByName(username);
	}

	/** guokeng **/
	/**
	 * 不带条件，查询所有用户
	 */
	@Override
	public List<User> selectAllsUser() {
		return userMapper.selectByExample(null);
	}

	/** guokeng **/
	/**
	 * 根据用户ID查询用户实体
	 */
	@Override
	public User selectById(Integer id) {
		return userMapper.selectByPrimaryKey(id);
	}

	/** chen **/
	/**
	 * 根据用户查找下级
	 */
	@Override
	public List<User> selectDirectLower(User user) {

		UserExample userexample = new UserExample();
		UserExample.Criteria criteria = userexample.createCriteria();
		criteria.andUserIdEqualTo(user.getId());
		List<User> userList = userMapper.selectByExample(userexample);
		return userList;
	}

	/** chen **/
	/**
	 * 根据用户ID查找下级
	 */
	@Override
	public List<User> selectDirectLowerById(Integer userId) {

		UserExample userexample = new UserExample();
		UserExample.Criteria criteria = userexample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<User> userList = userMapper.selectByExample(userexample);
		return userList;
	}

	/** guokeng **/
	/**
	 * 根据登陆的用户名、密码，计算出hashCode
	 */
	@Override
	public String getHashCode(String account, String password) {
		encryptor = new SHAEncrypt();

		User user = selectUserByParam(account);
		if (null == user) {
			/**
			 * 用户不存在
			 */
			return null;
		} else {
			/**
			 * 用户存在，计算hashCode
			 */
			String hash = encryptor.SHA512(password);
			String salt = user.getSalt();
			String hashCode = encryptor.SHA256(hash + salt);
			return hashCode;
		}
	}

	

	

	/** guokeng **/
	/**
	 * 修改用户个人信息
	 */
	@Override
	public int alterUserInfo(User user) {

		User userOriginal = userMapper.selectByPrimaryKey(user.getId());

		if (null != user.getGender()) {
			userOriginal.setGender(user.getGender());
		}
		if (null != user.getPhoneNum()) {
			userOriginal.setPhoneNum(user.getPhoneNum());
		}
		if (null != user.getEmail()) {
			userOriginal.setEmail(user.getEmail());
		}
		if (null != user.getLastLogin()) {
			userOriginal.setLastLogin(user.getLastLogin());
		}
		int ret = userMapper.updateByPrimaryKey(userOriginal);
		return ret;
	}

	/** guokeng **/
	/**
	 * 用户列表的多条件模糊查询分页
	 */
	@Override
	public PageInfo<User> findAllUsersByPages(String param, int page, int rows) throws ParseException {

		String userId = null;
		int roleId = 0;
		int status = 2;

		String beginTime = null;
		String endTime = null;

		Date beginDate = null;
		Date endDate = null;

		UserExample userExample = new UserExample();
		Criteria criteria = userExample.createCriteria();

		/**
		 * 参数解析
		 */
		if ((null != param) && (!(("").equals(param)))) {
			JsonParser parse = new JsonParser();
			JsonObject jsonParam = (JsonObject) parse.parse(param);

			userId = jsonParam.get("id").getAsString();
			roleId = jsonParam.get("roleId").getAsInt();
			status = jsonParam.get("status").getAsInt();

			beginTime = jsonParam.get("beginTime").getAsString();
			endTime = jsonParam.get("endTime").getAsString();

			/**
			 * 普通日期格式转换成数据库日期格式
			 */
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			/**
			 * 查询条项：开始日期、结束日期
			 */
			if ((null != beginTime) && (!(("").equals(beginTime)))) {
				beginDate = simpleDateFormat.parse(beginTime);
			}
			if ((null != endTime) && (!(("").equals(endTime)))) {
				endDate = simpleDateFormat.parse(endTime);
			}

		}

		if ((null != userId) && (!(("").equals(userId)))) {
			criteria.andIdEqualTo(Integer.parseInt(userId));
		}

		if (0 != roleId) {
			criteria.andRoleIdEqualTo(roleId);
		}

		if (2 != status) {
			criteria.andStatusEqualTo(status);
		}

		if ((beginDate != null) && (endDate != null)) {
			/**
			 * 输入的时期范围有上限和下限
			 */
			criteria.andLastLoginBetween(beginDate, endDate);
		} else if ((beginDate != null) && (endDate == null)) {
			/**
			 * 输入的时间范围没有下限
			 */
			criteria.andLastLoginGreaterThanOrEqualTo(beginDate);
		} else if ((beginDate == null) && (endDate != null)) {
			/**
			 * 输入的时间范围没有上限
			 */
			criteria.andLastLoginLessThanOrEqualTo(endDate);
		}

		criteria.andNameNotEqualTo("管理员");
		PageHelper.startPage(page, rows);

		/**
		 * 按最后登录时间倒序排序
		 */
		userExample.setOrderByClause("last_login desc");
		List<User> userList = userMapper.selectByExample(userExample);
		PageInfo userInfo = new PageInfo(userList);

		return userInfo;
	}

	/** chen **/
	/**
	 * 查询所有经理
	 */
	@Override
	public List<User> selectManagers() {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(3);
		return userMapper.selectByExample(example);
	}

	/** chen **/
	/**
	 * 查询所有的主管
	 */
	@Override
	public List<User> selectDirs() {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		criteria.andRoleIdEqualTo(2);
		return userMapper.selectByExample(example);
	}

	/** chen **/
	/**
	 * 显示所有创建者
	 */
	@Override
	public List<User> selectAllCreator() {
		UserExample example = new UserExample();
		Criteria criteria = example.createCriteria();
		List<Integer> userClass = new ArrayList<>();
		userClass.add(2);
		userClass.add(3);
		criteria.andRoleIdIn(userClass);
		return userMapper.selectByExample(example);
	}

	/** guokeng **/
	/**
	 * 管理员修改用户帐号信息
	 */
	@Override
	public int updataUserInfo(User user) {

		User userOriginal = userMapper.selectByPrimaryKey(user.getId());

		/**
		 * 判断角色是否有更新
		 */
		if (userOriginal.getRoleId() != user.getRoleId()) {
			userOriginal.setRoleId(user.getRoleId());
		}

		/**
		 * 判断上级是否有更新
		 */
		if ((0 == user.getUserId()) || (("0").equals(user.getUserId()))) {
			userOriginal.setUserId(null);
		} else {
			userOriginal.setUserId(user.getUserId());
		}

		/**
		 * 判断帐号状态是否有更新
		 */
		if (userOriginal.getStatus() != user.getStatus()) {
			userOriginal.setStatus(user.getStatus());
		}

		int ret = userMapper.updateByPrimaryKey(userOriginal);
		return ret;
	}

	/** guokeng **/
	/**
	 * 修改用户密码
	 */
	@Override
	public int alterPassword(User user) {

		int ret = userMapper.updateByPrimaryKey(user);

		return ret;
	}

	/** guokeng **/
	/**
	 * 根据输入的帐号（用户名/邮箱/手机号）查询用户对象
	 */
	@Override
	public User selectUserByParam(String Param) {

		UserExample userExample = new UserExample();

		Criteria criteriaAccount = userExample.createCriteria();
		Criteria criteriaPhone = userExample.createCriteria();
		Criteria criteriaEmail = userExample.createCriteria();

		criteriaAccount.andNameEqualTo(Param);
		criteriaPhone.andPhoneNumEqualTo(Param);
		criteriaEmail.andEmailEqualTo(Param);

		userExample.or(criteriaPhone);
		userExample.or(criteriaEmail);

		List<User> userList = userMapper.selectByExample(userExample);
		if (userList.size() > 0) {
			return userList.get(0);
		} else {
			return null;
		}
 
	}

}
