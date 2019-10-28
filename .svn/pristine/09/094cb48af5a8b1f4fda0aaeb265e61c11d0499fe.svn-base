package com.neuedu.crm.service;

import java.util.List;

import com.neuedu.crm.bean.AmountOne;
import com.neuedu.crm.bean.AmountThree;
import com.neuedu.crm.bean.AmountTwo;
import com.neuedu.crm.bean.Client;
import com.neuedu.crm.bean.SaleChance;

public interface ClientService {
	
	/**
	 * 不带分页查询所有客户
	 * @return
	 */
	public List<Client> selectAllClients();
	
	/**
	 * 按client的status来分页查询所有的客户信息
	 * @param page
	 * @param limit
	 * @param status
	 * @return
	 */
	public List<Client> selectAllClientsByPager(Integer page,Integer limit,Integer status);
	
	
	/**
	 * 保存一个新的客户信息
	 * @return
	 */
	public boolean saveNewClient(Client client);
	
	/**
	 * 根据status条件，查询这个条件下单有多少条数据
	 * @param status
	 * @return
	 */
	public Integer selectCountForStatus(Integer status);
	
	
	/**
	 * 根据一个client的id，查询这个客户的所有信息，用于更新，和显示这个实体
	 * @param id
	 * @return
	 */
	public Client selectClientById(Integer id);
	
	
	/**
	 * 查询客户信用等级的构成
	 * @return
	 */
	public List<AmountOne> selectAllClientForm();
	
	/**
	 * 查询客户满意度等级构成
	 * @return
	 */
	public List<AmountTwo> selectAllSatisfact();
	
	/**
	 * 查询客户等级构成
	 * @return
	 */
	public List<AmountThree> selectClientClasses();
	
	

}



