package com.neuedu.crm.service;

import java.util.List;

import com.neuedu.crm.bean.ContactRecord;

public interface ContactRecordService {
	
	/**
	 * 按client的id条件，分页查询查询这个client的所有交往记录
	 * @return
	 */
	public List<ContactRecord> selectAllRecords(Integer page,Integer limit,Integer clientId);
	public Integer countRecordById(Integer clientId);
	
	/**
	 * 根据历史订单的id，查询单个信息，用于显示
	 * @param id
	 * @return
	 */
	public ContactRecord selectForRecords(Integer id);
	
	/**
	 * 新增一个与客户的交往记录
	 * @param record
	 * @return
	 */
	public boolean saveForRecord(ContactRecord record);
	
	
	/**
	 * 根据历史交往记录的id，可以删除
	 * @param id
	 * @return
	 */
	public boolean deleteForRecord(Integer id);

}
