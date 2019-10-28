package com.neuedu.crm.service;

import java.util.List;
import java.util.Set;

import com.neuedu.crm.bean.Authority;


public interface AuthorityService {
	
	/**
	 * 查询权限列表
	 * @return
	 */
	public List<Authority> findAllAutority();
	
	/**
	 * 根据权限id集合查找权限集合
	 * @param authorityIdList
	 * @return
	 */
	public List<Authority> findAuthorityByIdList(List<Integer> authorityIdList);
	
	/**
	 * 根据用户名查找权限集合
	 * @param username
	 * @return
	 */
    public Set<String> findPermissions(String username);
}

