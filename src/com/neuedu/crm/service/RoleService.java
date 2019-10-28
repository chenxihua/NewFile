package com.neuedu.crm.service;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import com.neuedu.crm.bean.Role;
import com.neuedu.crm.bean.User;

public interface RoleService {
	

	/**
	 * 根据用户名查找角色名称集合
	 * @param username
	 * @return
	 */
    public Set<String> findRoles(String username);

    /**
     * 查找角色列表
     * @return
     */
	public List<Role> findAllRoles();
	
	/**
	 * 查找除了管理员以外的所有角色
	 * @return
	 */
	public List<Role> findAllRolesExceptAdmin();
	
	/**
	 * 带分页的角色列表
	 * @param page
	 * @param rows
	 * @return
	 * @throws ParseException
	 */
	public PageInfo<Role> findAllRolesByPage(int page , int rows) throws ParseException;
	
	/**
	 * 创建角色
	 * @param role
	 * @return
	 */
	public int saveRole(Role role);
}
