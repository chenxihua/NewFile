package com.neuedu.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.crm.bean.RoleAuthority;
import com.neuedu.crm.bean.RoleAuthorityExample;
import com.neuedu.crm.dao.RoleAuthorityMapper;
import com.neuedu.crm.service.RoleAuthorityService;

/**
 * 角色权限业务层
 * 
 * @author guokeng
 *
 */
@Service(value = "RoleAuthorityServiceImpl")
@Transactional
public class RoleAuthorityServiceImpl implements RoleAuthorityService {

	@Autowired
	private RoleAuthorityMapper roleAuthorityMapper;

	/**
	 * 根据角色id，查询拥有的所有权限
	 */
	@Override
	public List<RoleAuthority> findRoleAuthority(Integer id) {

		RoleAuthorityExample roleAuthorityExample = new RoleAuthorityExample();
		roleAuthorityExample.createCriteria().andRoleIdEqualTo(id);

		List<RoleAuthority> roleAuthorities = roleAuthorityMapper.selectByExample(roleAuthorityExample);

		return roleAuthorities;
	}

	/**
	 * 根据给定角色id，删除拥有的权限s
	 */
	@Override
	public int deleteRoleAuthyRoleId(Integer roleId) {

		RoleAuthorityExample roleAuthorityExample = new RoleAuthorityExample();
		roleAuthorityExample.createCriteria().andRoleIdEqualTo(roleId);
		int ret = roleAuthorityMapper.deleteByExample(roleAuthorityExample);
		return ret;
	}

	/**
	 * 根据给定角色id，添加权限
	 */
	@Override
	public int addRoleAuthsByRoleId(List<Integer> ids, Integer roleId) {
		int ret = 0;
		int count = -1;
		RoleAuthority roleAuthority = new RoleAuthority();
		roleAuthority.setRoleId(roleId);
		roleAuthority.setStatus(1);
		for (Integer id : ids) {
			roleAuthority.setAuthorityId(id);
			ret = roleAuthorityMapper.insert(roleAuthority);
			if (ret > 0) {
				count++;
			}
		}
		return count;
	}
}
