package com.neuedu.crm.dao;

import com.neuedu.crm.bean.RoleAuthority;
import com.neuedu.crm.bean.RoleAuthorityExample;
import org.springframework.stereotype.Repository;

/**
 * RoleAuthorityMapper继承基类
 */
@Repository
public interface RoleAuthorityMapper extends MyBatisBaseDao<RoleAuthority, Integer, RoleAuthorityExample> {
}