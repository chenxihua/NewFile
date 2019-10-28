package com.neuedu.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.crm.bean.ServiceType;
import com.neuedu.crm.dao.ServiceTypeMapper;
import com.neuedu.crm.service.ServiceTypeService;

/**
 * Service实现层：服务管理
 * @author Mechan
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class ServiceTypeServiceImpl implements ServiceTypeService {

	@Autowired
	ServiceTypeMapper serviceTypeMapper;
	
	@Override
	public List<ServiceType> selectAll() {
		return serviceTypeMapper.selectByExample(null);
	}

	@Override
	public ServiceType selectById(Integer id) {
		return serviceTypeMapper.selectByPrimaryKey(id);
	}

}
