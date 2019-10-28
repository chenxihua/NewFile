package com.neuedu.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.crm.bean.AmountOne;
import com.neuedu.crm.bean.AmountThree;
import com.neuedu.crm.bean.AmountTwo;
import com.neuedu.crm.bean.Client;
import com.neuedu.crm.bean.ClientExample;
import com.neuedu.crm.bean.ClientExample.Criteria;
import com.neuedu.crm.dao.ClientMapper;
import com.neuedu.crm.service.ClientService;
import com.neuedu.crm.service.SaleChanceService;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientMapper clientMapper;
	@Autowired
	private SaleChanceService saleImpl;

	/**
	 * 不按分页和条件，查询所有客户
	 */
	@Override
	public List<Client> selectAllClients() {
		return clientMapper.selectByExample(null);
	}
	
	/**
	 * 按分页条件，查询所有的客户
	 */
	@Override
	public List<Client> selectAllClientsByPager(Integer page,Integer limit,Integer status){
		ClientExample example = new ClientExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(status);
		
		Long offset = new Long((page-1)*limit);
		example.setLimit(limit);
		example.setOffset(offset);
		return clientMapper.selectByExample(example);
	}

	/**      ---------      2018/7/17     -----------        **/
	/**
	 * 保存一个新的客户信息
	 */
	@Override
	public boolean saveNewClient(Client client) {
		Integer flag = clientMapper.insertSelective(client);
		if(flag>0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 根据status条件，查询这个条件下单有多少条数据
	 */
	@Override
	public Integer selectCountForStatus(Integer status) {
		ClientExample example = new ClientExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(status);
		return (int) clientMapper.countByExample(example);
	}

	/**
	 * 根据一个client的id，查询这个客户的所有信息，用于更新，和显示这个实体
	 */
	@Override
	public Client selectClientById(Integer id) {
		return clientMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<AmountOne> selectAllClientForm() {
		return clientMapper.selectClientForm();
	}

	@Override
	public List<AmountTwo> selectAllSatisfact() {
		return clientMapper.selectClientSatisfact();
	}

	@Override
	public List<AmountThree> selectClientClasses() {
		return clientMapper.selectClientClass();
	}
	
	
	
	
	
	
	
	
	

}
