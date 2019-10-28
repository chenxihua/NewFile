package com.neuedu.crm.service;

import java.util.List;

import com.neuedu.crm.bean.Service;
import com.neuedu.crm.bean.ServiceType;

public interface ServiceTypeService {
	/**
	 * 查看所有服务类型, doing
	 */
	List<ServiceType> selectAll();
	
	/**
	 * 按主键查询服务类型, doing
	 */
	ServiceType selectById( Integer id );
}
