package com.neuedu.crm.service;

import java.util.List;

import com.neuedu.crm.bean.Linkman;

/***
 * 客户公司的联系人模块
 * @author Administrator
 *
 */

public interface LinkmanService {
	
	/**
	 * 根据客户公司的id，查询这个公司内部的员工联系人
	 * @return
	 */
	public List<Linkman> selectAllLinkmans(Integer page,Integer limit,Integer clientId);
	public int countLinkmans(Integer clientId);
	
	/**
	 * 新增一个客户公司联系人
	 * @param man
	 * @return
	 */
	public boolean saveLinkman(Linkman man);
	
	/**
	 * 删除一个公司的联系人
	 * @param id
	 * @return
	 */
	public boolean deleteLinkman(Integer id);
	
	/**
	 * 更新联系人的信息
	 * @param man
	 * @return
	 */
	public boolean updateLinkmanInfos(Linkman man);
	
	/**
	 * 根据联系人id，进行查询这个联系人所有信息，用于表单回显
	 * @param manId
	 * @return
	 */
	public Linkman showlinkman(Integer manId);
	
	
}
