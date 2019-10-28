package com.neuedu.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.crm.bean.LoggingEvent;
import com.neuedu.crm.bean.LoggingEventExample;
import com.neuedu.crm.bean.LoggingEventExample.Criteria;
import com.neuedu.crm.dao.LoggingEventMapper;
import com.neuedu.crm.service.LoggingEventServer;

//import sun.util.logging.resources.logging;

@Service
public class LoggingEventServerImpl implements LoggingEventServer {

	@Autowired
	private LoggingEventMapper logMapper;

	/**
	 * 查询日志总记录数
	 */
	@Override
	public long countByLoggingEventExample() {
		return logMapper.countByExample(null);
	}

	/**
	 * 带条件查询所有
	 */
	@Override
	public List<LoggingEvent> selectByLoggingEventExample(Integer page, Integer limit) {
		LoggingEventExample example = new LoggingEventExample();
		Criteria criteria = example.createCriteria();
		
		Long offset = new Long((page-1)*limit);
		example.setLimit(limit);
		example.setOffset(offset);
		return logMapper.selectByExample(example);
	}

	/**
	 * 删除单个日志记录
	 */
	@Override
	public boolean deleteLoggingById(Long id) {
		LoggingEventExample example = new LoggingEventExample();
		Criteria criteria = example.createCriteria();
		criteria.andEventIdEqualTo(id);
		Integer flag = logMapper.deleteByExample(example);
		if(flag>0){
			return true;
		}else{
			return false;
		}
	}



	
	

}
