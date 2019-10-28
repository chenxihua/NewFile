package com.neuedu.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.crm.bean.ClientClass;
import com.neuedu.crm.dao.ClientClassMapper;
import com.neuedu.crm.service.ClientClassService;

@Service
public class ClientClassServiceImpl implements ClientClassService {

	@Autowired
	private ClientClassMapper clientClassMapper;
	
	/**
	 * 查询所有客户等级
	 */
	@Override
	public List<ClientClass> selectAllsClass() {		
		return clientClassMapper.selectByExample(null);
	}

	/**
	 * 根据等级id，查询这个等级实体
	 */
	@Override
	public ClientClass selectClassById(Integer classId) {
		return clientClassMapper.selectByPrimaryKey(classId);
	}

}
