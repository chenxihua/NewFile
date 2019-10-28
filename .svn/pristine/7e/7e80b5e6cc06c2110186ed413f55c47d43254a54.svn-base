package com.neuedu.crm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.neuedu.crm.bean.AmountOne;
import com.neuedu.crm.bean.AmountThree;
import com.neuedu.crm.bean.AmountTwo;
import com.neuedu.crm.bean.Client;
import com.neuedu.crm.bean.ClientExample;

/**
 * ClientMapper继承基类
 */
@Repository
public interface ClientMapper extends MyBatisBaseDao<Client, Integer, ClientExample> {
	
	/**
	 * 查询客户信用构成
	 * @return
	 */
	public List<AmountOne> selectClientForm();
	
	/**
	 * 查询客户满意度构成
	 * @return
	 */
	public List<AmountTwo> selectClientSatisfact();
	
	/**
	 * 查询客户等级构成
	 * @return
	 */
	public List<AmountThree> selectClientClass();
	
	
	
}