package com.neuedu.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.crm.bean.Linkman;
import com.neuedu.crm.bean.LinkmanExample;
import com.neuedu.crm.bean.LinkmanExample.Criteria;
import com.neuedu.crm.dao.LinkmanMapper;
import com.neuedu.crm.service.LinkmanService;

@Service
public class LinkmanServiceImpl implements LinkmanService {

	@Autowired
	private LinkmanMapper linkmanMapper;
	
	/**
	 * 根据客户公司的id，查询这个公司内部的员工联系人
	 */
	@Override
	public List<Linkman> selectAllLinkmans(Integer page,Integer limit,Integer clientId) {
		LinkmanExample example = new LinkmanExample();
		Criteria criteria = example.createCriteria();
		criteria.andClientIdEqualTo(clientId);
		
		Long offset = new Long((page-1)*limit);
		example.setLimit(limit);
		example.setOffset(offset);
		return linkmanMapper.selectByExample(example);
	}

	/**
	 * 根据客户id值，查询这个客户的所有联系人总数
	 */
	@Override
	public int countLinkmans(Integer clientId) {
		LinkmanExample example = new LinkmanExample();
		Criteria criteria = example.createCriteria();
		criteria.andClientIdEqualTo(clientId);
		return (int) linkmanMapper.countByExample(example);
	}
	
	
	/**
	 * 新增一个客户公司的联系人
	 */
	@Override
	public boolean saveLinkman(Linkman man) {
		Integer flag = linkmanMapper.insertSelective(man);
		if(flag>0){
			return true;
		}else{
			return false;
		}		
	}

	/**
	 * 删除一个公司的联系人
	 */
	@Override
	public boolean deleteLinkman(Integer id) {
		Integer flag = linkmanMapper.deleteByPrimaryKey(id);
		if(flag>0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 更新联系人的信息
	 */
	@Override
	public boolean updateLinkmanInfos(Linkman man) {
		Integer flag = linkmanMapper.updateByPrimaryKeySelective(man);
		if(flag>0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 根据联系人id，进行查询这个联系人所有信息，用于表单回显
	 */
	@Override
	public Linkman showlinkman(Integer manId) {
		return linkmanMapper.selectByPrimaryKey(manId);
	}

	

}
