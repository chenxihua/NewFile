package com.neuedu.crm.dao;

import com.neuedu.crm.bean.Authority;
import com.neuedu.crm.bean.AuthorityExample;
import org.springframework.stereotype.Repository;

/**
 * AuthorityMapper继承基类
 */
@Repository
public interface AuthorityMapper extends MyBatisBaseDao<Authority, Integer, AuthorityExample> {
}