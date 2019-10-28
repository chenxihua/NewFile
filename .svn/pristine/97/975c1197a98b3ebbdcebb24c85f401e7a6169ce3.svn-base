package com.neuedu.crm.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neuedu.crm.bean.Message;
import com.neuedu.crm.bean.MessageExample;
import com.neuedu.crm.bean.RoleExample;
import com.neuedu.crm.bean.User;
import com.neuedu.crm.bean.UserExample;
import com.neuedu.crm.bean.MessageExample.Criteria;
import com.neuedu.crm.bean.Role;
import com.neuedu.crm.dao.MessageMapper;
import com.neuedu.crm.dao.RoleMapper;
import com.neuedu.crm.dao.UserMapper;
import com.neuedu.crm.service.MessageService;

/**
 * 公告业务层
 * 
 * @author guokeng
 *
 */
@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageMapper messageMapper;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RoleMapper roleMapper;

	private Logger logger = Logger.getLogger(MessageServiceImpl.class);

	/**
	 * 多条件模糊查询公告带分页
	 * 
	 * @param param
	 * @param session
	 * @param page
	 * @param rows
	 * @return
	 * @throws ParseException
	 */
	@Override
	public PageInfo<Message> findAllMsgByPage(String param, HttpSession session, int page, int rows)
			throws ParseException {
		int userId = 0;
		int superiorId = 0;
		int roleId = 0;
		String publisher = null;
		String title = null;
		String beginTime = null;
		String endTime = null;
		int status = 0;
		Date beginDate = null;
		Date endDate = null;
		User user = null;
		
		List<Integer> userIdList = new ArrayList<>();
		
		/**
		 * 获取当前用户信息
		 */
		userId = (int) session.getAttribute("id");
		if ((null != session.getAttribute("userId")) && (!(("").equals(session.getAttribute("userId"))))) {
			superiorId = (int) session.getAttribute("userId");
		}

		roleId = (int) session.getAttribute("roleId");
		/**
		 * 查询参数解析
		 */
		if ((null != param) && (!(("").equals(param)))) {
			JsonParser parse = new JsonParser();
			JsonObject jsonParam = (JsonObject) parse.parse(param);
			publisher = jsonParam.get("publisher").getAsString();
			title = jsonParam.get("title").getAsString();
			beginTime = jsonParam.get("beginTime").getAsString();
			endTime = jsonParam.get("endTime").getAsString();
			status = jsonParam.get("status").getAsInt();

			/**
			 * 发布人参数不为空,根据查询的用户名，找出所有的用户id列表
			 */
			if(null != publisher) {
				UserExample userExample = new UserExample();
				userExample.createCriteria().andNameLike("%" + publisher + "%");
				List<User> users = userMapper.selectByExample(userExample);
				if(users.size() > 0) {
					for (User user2 : users) {
						userIdList.add(user2.getId());
					}
				}else {
					userIdList.add(0);
				}
			}
			

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

		/**
		 * 可见的公告有两种：发送给所有人；自己上级发送给所有的下级
		 */
		String groupForAll = "%/" + roleId + "/%";

		/**
		 * 当前用户所属的组（不同的主管带领不同的组），由/角色id*上级id/组成
		 */
		String groupForOne = "%/" + roleId + "*" + superiorId + "/%";

		List<String> groupList = new ArrayList<String>();
		groupList.add(groupForAll);
		groupList.add(groupForOne);
		logger.info("groupForOne=" + groupForOne);
		logger.info("groupForAll=" + groupForAll);

		MessageExample example = new MessageExample();
		Criteria criteria = example.createCriteria();

		if (null != title) {
			criteria.andTitleLike('%' + title + '%');
		}

		if((null != publisher) && (!("").equals(publisher))) {
			/**
			 * 发布人参数不为空
			 */
			criteria.andUserIdIn(userIdList);
		}


		/**
		 * 是否设置了查看自己发布的公告,管理员默认查看已发布的公告
		 */
		if ((status == 2) || (roleId == 1)) {
			/**
			 * 查看自己发布的公告
			 */
			criteria.andUserIdEqualTo(userId);
		} else {
			/**
			 * 查看接收的公告,包括别人群发(/roleId/)，或者发给自己组(/roleId*superior/)的公告
			 */
			criteria.andor(groupList.get(0), groupList.get(1));
		}

		logger.debug("beginDate" + beginDate);
		logger.debug("endDate" + endDate);
		if ((beginDate != null) && (endDate != null)) {
			/**
			 * 输入的时期范围有上限和下限
			 */
			criteria.andPublishTimeBetween(beginDate, endDate);
		} else if ((beginDate != null) && (endDate == null)) {
			/**
			 * 输入的时间范围没有下限
			 */
			criteria.andPublishTimeGreaterThanOrEqualTo(beginDate);
		} else if ((beginDate == null) && (endDate != null)) {
			/**
			 * 输入的时间范围没有上限
			 */
			criteria.andPublishTimeLessThanOrEqualTo(endDate);
		}

		PageHelper.startPage(page, rows);
		/*
		 * int offset = ((page - 1) * size); example.setOffset(offset);
		 * example.setLimit(size);
		 */
		/**
		 * 按时间倒序排序
		 */
		example.setOrderByClause("publish_Time desc");
		List<Message> msgList = messageMapper.selectByExample(example);
		PageInfo msgInfo = new PageInfo(msgList, 5);

		return msgInfo;
	}

	/**
	 * 根据公告id查询公告实体
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Message findMsgById(int id) {
		Message message = messageMapper.selectByPrimaryKey(id);
		return message;
	}

	/**
	 * 新增公告
	 * 
	 * @param message
	 * @param session
	 * @return
	 */
	@Override
	public int saveMessage(Message message, HttpSession session) {

		boolean hasLowerLever = true;
		int lowerRole = 0;
		String recipient = "/";
		String getRecipient = message.getRecipient();
		RoleExample roleExample = new RoleExample();
		/**
		 * 查询除了当前角色以外的所有角色
		 */
		roleExample.createCriteria().andIdNotEqualTo((int) session.getAttribute("roleId"));
		List<Role> roles = roleMapper.selectByExample(roleExample);

		/**
		 * 查询当前角色的下级角色id
		 */

		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserIdEqualTo(message.getUserId());
		List<User> lowerLevels = userMapper.selectByExample(userExample);
		logger.debug("----------------------");
		if (lowerLevels.size() > 0) {
			lowerRole = lowerLevels.get(0).getRoleId();
		} else {
			/**
			 * 没有下级(管理员)
			 */
			hasLowerLever = false;
		}

		/**
		 * 公告发送给所有人
		 */
		if (getRecipient.contains("all")) {
			for (Role role : roles) {
				recipient += role.getId() + "/";

			}
		} else {

			/**
			 * 公告发送给指定的下属
			 */
			if ((getRecipient.contains("directorForOne")) || (getRecipient.contains("managerForOne"))) {
				recipient += lowerRole + "*" + message.getUserId() + "/";
			}

			/**
			 * 发送给所有高管
			 */
			if (getRecipient.contains("seniors")) {
				if (hasLowerLever) {
					recipient += lowerRole + "/";
				} else {
					recipient += 4 + "/";
				}

			}
			/**
			 * 发送给所有主管
			 */
			if (getRecipient.contains("directors")) {
				if (hasLowerLever) {
					recipient += lowerRole + "/";
				} else {
					recipient += 2 + "/";
				}

			}
			/**
			 * 发送给所有客户经理
			 */
			if (getRecipient.contains("managers")) {
				if (hasLowerLever) {
					recipient += lowerRole + "/";
				} else {
					recipient += 3 + "/";
				}

			}
		}
		message.setRecipient(recipient);
		logger.debug("拼接完准备发布的公告:" + message.toString());
		int ret = messageMapper.insert(message);
		return ret;
	}

}
