package com.neuedu.crm.dao;

import com.neuedu.crm.bean.AmountOne;
import com.neuedu.crm.bean.AmountTwo;
import com.neuedu.crm.bean.Service;
import com.neuedu.crm.bean.ServiceExample;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * ServiceMapper继承基类
 */
@Repository
public interface ServiceMapper extends MyBatisBaseDao<Service, Integer, ServiceExample> {
	
	/**
	 * 查询服务类型占比
	 * @return
	 */
	public List<AmountOne> selectServiceTypeForm();
	
	/**
	 * 查询满意度占比
	 * @return
	 */
	public List<AmountTwo> selectServiceSatisfactionForm();
	
	/**
	 * 查询状态占比
	 * @return
	 */
	public List<AmountTwo> selectServiceStatusForm();
}