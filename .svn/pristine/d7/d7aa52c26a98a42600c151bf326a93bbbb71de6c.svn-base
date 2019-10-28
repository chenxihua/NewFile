package com.neuedu.crm.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neuedu.crm.bean.Authority;
import com.neuedu.crm.bean.AuthorityExample;
import com.neuedu.crm.bean.Role;
import com.neuedu.crm.bean.RoleAuthority;
import com.neuedu.crm.bean.RoleAuthorityExample;
import com.neuedu.crm.bean.RoleExample;
import com.neuedu.crm.bean.User;
import com.neuedu.crm.dao.AuthorityMapper;
import com.neuedu.crm.dao.RoleAuthorityMapper;
import com.neuedu.crm.dao.RoleMapper;
import com.neuedu.crm.dao.UserMapper;
import com.neuedu.crm.service.AuthorityService;

/**
 * 权限业务层
 * 
 * @author guokeng
 *
 */
@Service(value = "AuthorityServiceImpl")
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

	@Autowired
	private AuthorityMapper authorityMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private RoleAuthorityMapper roleAuthorityMapper;
	
	/**
	 * 查找所有的权限
	 */
	@Override
	public List<Authority> findAllAutority() {
		
		AuthorityExample authorityExample = new AuthorityExample();
		
		authorityExample.createCriteria().andStatusNotEqualTo(0);
		
		List<Authority> authorities = authorityMapper.selectByExample(authorityExample);
		
		return authorities;
	}

	/**
	 * 根据权限id列表查找所有权限
	 */
	@Override
	public List<Authority> findAuthorityByIdList(List<Integer> authorityIdList) {
		
		AuthorityExample authorityExample = new AuthorityExample();
		
		List<Authority> authorities = null;
		if(authorityIdList.size() > 0) {
			authorityExample.createCriteria().andIdIn(authorityIdList);
			authorities = authorityMapper.selectByExample(authorityExample);
		}

		return authorities;
	}

	/** guokeng **/
	/**
	 * 根据用户名查找权限集合
	 */
	@Override
	public Set<String> findPermissions(String username) {
		/**
		 * 根据用户名查出角色
		 */
		User user = userMapper.selectUserByName(username);
		RoleExample roleExample = new RoleExample();
		roleExample.createCriteria().andIdEqualTo(user.getRoleId());
		Role role = roleMapper.selectByExample(roleExample).get(0);

		/**
		 * 根据角色查出权限id列表(角色权限表)
		 */
		RoleAuthorityExample roleAuthorityExample = new RoleAuthorityExample();
		roleAuthorityExample.createCriteria().andRoleIdEqualTo(role.getId());

		List<RoleAuthority> roleAuthorities = roleAuthorityMapper.selectByExample(roleAuthorityExample);

		List<Integer> permissionsId = new ArrayList<>();

		if (roleAuthorities.size() > 0) {
			for (RoleAuthority roleAuthority : roleAuthorities) {
				permissionsId.add(roleAuthority.getAuthorityId());
			}
		}

		Set<String> permissions = null;
		/**
		 * 根据权限id列表获取权限名称列表
		 */
		AuthorityExample authorityExample = new AuthorityExample();
		if (permissionsId.size() > 0) {
			authorityExample.createCriteria().andIdIn(permissionsId);
			List<Authority> authorities = authorityMapper.selectByExample(authorityExample);

			permissions = new HashSet<>();
			for (Authority authority : authorities) {
				permissions.add(authority.getName());
			}
		}

		return permissions;
	}

}
