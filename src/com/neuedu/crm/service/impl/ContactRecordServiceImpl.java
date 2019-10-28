package com.neuedu.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.neuedu.crm.bean.ContactRecord;
import com.neuedu.crm.bean.ContactRecordExample;
import com.neuedu.crm.bean.ContactRecordExample.Criteria;
import com.neuedu.crm.dao.ContactRecordMapper;
import com.neuedu.crm.service.ContactRecordService;

@Service
public class ContactRecordServiceImpl implements ContactRecordService {

	@Autowired
	private ContactRecordMapper recordMapper;
	
	/**
	 * 按client的id条件，分页查询查询这个client的所有交往记录
	 */
	@Override
	public List<ContactRecord> selectAllRecords(Integer page,Integer limit,Integer clientId) {
		ContactRecordExample example = new ContactRecordExample();
		Criteria criteria = example.createCriteria();
		criteria.andClientIdEqualTo(clientId);
		
		Long offset = new Long((page-1)*limit);
		example.setLimit(limit);
		example.setOffset(offset);
		return recordMapper.selectByExample(example);
	}
	
	@Override
	public Integer countRecordById(Integer clientId) {
		ContactRecordExample example = new ContactRecordExample();
		Criteria criteria = example.createCriteria();
		criteria.andClientIdEqualTo(clientId);
		return (int) recordMapper.countByExample(example);
	}

	/**
	 * 根据历史交往记录的id，查询单个信息，用于显示
	 */
	@Override
	public ContactRecord selectForRecords(Integer id) {
		return recordMapper.selectByPrimaryKey(id);
	}

	/**
	 * 新增一个与客户的交往记录
	 */
	@Override
	public boolean saveForRecord(ContactRecord record) {
		Integer flag = recordMapper.insertSelective(record);
		if(flag>0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 根据历史交往记录的id，可以删除
	 */
	@Override
	public boolean deleteForRecord(Integer id) {
		Integer flag = recordMapper.deleteByPrimaryKey(id);
		if(flag>0){
			return true;
		}else{
			return false;
		}
	}



}
