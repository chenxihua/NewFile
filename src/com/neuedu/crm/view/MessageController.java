package com.neuedu.crm.view;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.neuedu.crm.bean.Message;
import com.neuedu.crm.bean.User;
import com.neuedu.crm.bean.UserExample;
import com.neuedu.crm.dao.UserMapper;
import com.neuedu.crm.service.MessageService;
import com.neuedu.crm.utils.Operation;

/**
 * 公告控制器
 * 
 * @author guokeng
 *
 */
@Operation(name = "公告操作")
@Controller
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@Autowired
	private UserMapper userMapper;

	private Logger logger = Logger.getLogger(MessageController.class);

	/**
	 * 多条件模糊分页查询公告
	 * 
	 * @param page
	 * @param limit
	 * @param request
	 * @param param
	 * @return
	 * @throws ParseException
	 */
	/*@Operation(name = "查询公告列表")*/
	@RequestMapping(value = "/accepted")
	@ResponseBody
	public String findMsgByPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "limit", defaultValue = "10") Integer limit, HttpServletRequest request, String param)
			throws ParseException {

		logger.debug("进入了公告查询控制器");
		HttpSession session = request.getSession(true);

		PageInfo<Message> msgList = messageService.findAllMsgByPage(param, session, page, limit);

		logger.debug("pageNum:" + msgList.getPageNum());
		logger.debug("startRow:" + msgList.getStartRow());
		logger.debug("pageSize:" + msgList.getPageSize());

		List<Integer> idList = new ArrayList<>();
		List<Message> messageList = msgList.getList();
		for (Message message : messageList) {
			idList.add(message.getUserId());
		}

		UserExample userExample = new UserExample();
		if (messageList.size() > 0) {
			userExample.createCriteria().andIdIn(idList);
		}
		List<User> users = userMapper.selectByExample(userExample);

		int id = limit * (page - 1);
		logger.debug("开始id=" + id);
		logger.debug("当前页公告数量：" + messageList.size());

		for (int i = 0; i < messageList.size(); i++, id++) {
			Message message = messageList.get(i);
			message.setStatus(message.getId());
			message.setId(id + 1);
			for (User user : users) {
				if (message.getUserId().equals(user.getId())) {
					message.setPublisher(user.getName());
				}
			}
			logger.debug("准备返回展示的公告： " + message.toString());
		}

		logger.debug("公告列表：当前页记录数：" + msgList.getList().size() + ", 总记录数：" + msgList.getTotal());

		/**
		 * 用google json来传值 (用hashmap会有时间格式错误)
		 */
		JsonArray json = new Gson().toJsonTree(msgList.getList(), new TypeToken<List<Message>>() {
		}.getType()).getAsJsonArray();
		String js = json.toString();
		String jso = "{\"code\":0,\"msg\":\"\",\"count\":" + msgList.getTotal() + ",\"data\":" + js + "}";
		return jso;
	}

	/**
	 * 根据公告id查询公告详情
	 * 
	 * @param model
	 * @param id
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws ServletException
	 */
	/*@Operation(name = "查看公告详情")*/
	@RequestMapping(value = "/msgdetails/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void showMsgDetails(Model model, @PathVariable(value = "id") int id, HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {

		logger.debug("准备查询详情的公告id" + id);
		Message message = messageService.findMsgById(id);

		/**
		 * 把message的发布人id转换成发布人姓名
		 */
		User user = userMapper.selectByPrimaryKey(message.getUserId());
		message.setPublisher(user.getName());
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		/**
		 * 转换日期格式
		 */
		String publishTime = simpleDateFormat.format(message.getPublishTime());
		request.setAttribute("message", message);
		request.setAttribute("publishTime", publishTime);

		logger.debug("准备展示的公告详情：" + message.toString());
		request.getRequestDispatcher("/pages/user/msgdetails.jsp").forward(request, response);

	}

	/**
	 * 发布公告
	 * 
	 * @param request
	 * @param message
	 * @return
	 * @throws ParseException
	 */
	/*@Operation(name = "发布公告")*/
	@RequestMapping(value = "/savemsg", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> saveMessage(HttpServletRequest request, Message message) throws ParseException {

		message.setUserId((int) request.getSession().getAttribute("id"));
		message.setPublishTime(new Date());
		message.setStatus(1);

		logger.debug("准备保存的公告 :" + message.toString());

		int ret = messageService.saveMessage(message, request.getSession());

		Map<String, Object> result = new HashMap<>();
		if (ret > 0) {
			/**
			 * 更新成功
			 */
			result.put("success", true);
			result.put("message", "新增成功");
		} else {
			/**
			 * 更新失败
			 */
			result.put("success", false);
			result.put("message", "新增失败");
		}
		return result;
	}
}
