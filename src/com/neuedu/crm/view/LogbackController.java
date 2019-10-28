package com.neuedu.crm.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.crm.bean.LoggingEvent;
import com.neuedu.crm.service.LoggingEventServer;

/**
 * 日志管理的controller
 * @author Administrator
 *
 */

@RequestMapping("/log")
@Controller
public class LogbackController {
	
	@Autowired
	private LoggingEventServer logServer;
	
	@RequestMapping("/findLoggings")
	@ResponseBody
	public Map<String, Object> findLogging(Integer limit, Integer page) {
		Map<String,Object> map = new HashMap<>();
		Long count = logServer.countByLoggingEventExample();
		List<LoggingEvent> loggingEvents = logServer.selectByLoggingEventExample(page, limit);
		map.put("code", 0); // 状态码 正常为0
		map.put("count", count); // 返回的数据总数
		map.put("data", loggingEvents); // 返回的数据
		map.put("msg", "查询所有");
		return map;
	}
	
	/**
	 * 删除单个日志记录
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteLogById/{id}")
	@ResponseBody
	public Map<String,Object> delectLoggingById(@PathVariable("id")Integer id){
		Map<String,Object> map = new HashMap<>();
		boolean flag = logServer.deleteLoggingById(id.longValue());
		map.put("code", 0);
		map.put("success", true);
		map.put("msg", "删除单个成功");
		return map;
	}
	
}
