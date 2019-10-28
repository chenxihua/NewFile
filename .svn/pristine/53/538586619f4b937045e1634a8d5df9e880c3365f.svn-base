package com.neuedu.crm.service.impl;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.crm.bean.Role;
import com.neuedu.crm.bean.RoleExample;
import com.neuedu.crm.bean.User;
import com.neuedu.crm.bean.RoleExample.Criteria;
import com.neuedu.crm.dao.RoleMapper;
import com.neuedu.crm.dao.UserMapper;
import com.neuedu.crm.service.RoleService;

/**
 * 角色业务层
 * 
 * @author guokeng
 *
 */
@Service(value = "RoleServiceImpl")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	private UserMapper userMapper;
	
	/** guokeng **/
	/**
	 * 根据用户名查找角色集合
	 */
	@Override
	public Set<String> findRoles(String username) {

		User user = userMapper.selectUserByName(username);
		RoleExample roleExample = new RoleExample();
		roleExample.createCriteria().andIdEqualTo(user.getRoleId());
		List<Role> roleList = roleMapper.selectByExample(roleExample);
		Role role = roleList.get(0);
		Set<String> roles = new HashSet<>();
		roles.add(role.getName());
		return roles;
	}
	
	
	/**
	 * 查询所有角色
	 */
	@Override
	public List<Role> findAllRoles() {

		RoleExample roleExample = new RoleExample();
		List<Role> roleList = roleMapper.selectByExample(roleExample);
		return roleList;
	}

	/**
	 * 查询除了管理员角色列表
	 */
	@Override
	public List<Role> findAllRolesExceptAdmin() {
		RoleExample roleExample = new RoleExample();
		roleExample.createCriteria().andIdNotEqualTo(1);
		List<Role> roles = roleMapper.selectByExample(roleExample);
		return roles;
	}

	/**
	 * 查询除了管理员角色列表带分页
	 */
	@Override
	public PageInfo<Role> findAllRolesByPage(int page, int rows) throws ParseException {

		RoleExample roleExample = new RoleExample();
		Criteria criteria = roleExample.createCriteria();

		criteria.andNameNotEqualTo("管理员");
		PageHelper.startPage(page, rows);
		List<Role> roleList = roleMapper.selectByExample(roleExample);
		PageInfo<Role> roles = new PageInfo<Role>(roleList);

		return roles;
	}

	/**
	 * 添加角色
	 */
	@Override
	public int saveRole(Role role) {
		role.setStatus(1);
		int ret = roleMapper.insert(role);
		return ret;
	}

}
