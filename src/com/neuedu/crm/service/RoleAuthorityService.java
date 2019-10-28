package com.neuedu.crm.service;

import java.util.List;

import com.neuedu.crm.bean.RoleAuthority;

public interface RoleAuthorityService {

	/**
	 * 查询角色拥有的权限
	 * @param id
	 * @return
	 */
	public List<RoleAuthority> findRoleAuthority(Integer id);
	
	/**
	 * 删除某个角色下的权限
	 * @param roleId
	 * @return
	 */
	public int deleteRoleAuthyRoleId(Integer roleId);
	
	/**
	 * 根据权限id列表给某个角色插入权限信息
	 * @param ids
	 * @param roleId
	 * @return
	 */
	public int addRoleAuthsByRoleId(List<Integer> ids , Integer roleId);
}
