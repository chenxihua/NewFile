package com.neuedu.crm.service;

import java.util.List;

import com.neuedu.crm.bean.LoggingEvent;
import com.neuedu.crm.bean.LoggingEventExample;

public interface LoggingEventServer {
	
	
	public long countByLoggingEventExample();
	
	
	public List<LoggingEvent> selectByLoggingEventExample(Integer page,Integer limit);
	
	
	// 这个是删除日志记录
	public boolean deleteLoggingById(Long id);
	
	
}
