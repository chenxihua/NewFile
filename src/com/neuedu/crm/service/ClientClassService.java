package com.neuedu.crm.service;

import java.util.List;

import com.neuedu.crm.bean.ClientClass;

/**
 * 这是客户等级模块
 * @author Administrator
 *
 */


public interface ClientClassService {
	
	/**
	 * 查询所有的客户等级
	 * @return
	 */
	public List<ClientClass> selectAllsClass();
	
	/**
	 * 根据等级id，查询这个等级实体
	 * @param classId
	 * @return
	 */
	public ClientClass selectClassById(Integer classId);

}
