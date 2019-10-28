package com.neuedu.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.crm.bean.Area;
import com.neuedu.crm.dao.AreaMapper;
import com.neuedu.crm.service.AreaService;
@Service
public class AreaServiceImpl implements AreaService{

	@Autowired
	private AreaMapper areaMapper;
	
	/**
	 * 2018/07/19 15:05
	 * 新增
	 * */
	@Override
	public Area selectById(Integer id) {
		return areaMapper.selectByPrimaryKey(id);
	}
	
}
