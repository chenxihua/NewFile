package com.neuedu.crm.dao;

import com.neuedu.crm.bean.User;
import com.neuedu.crm.bean.UserExample;
import org.springframework.stereotype.Repository;

/**
 * UserMapper继承基类
 */
@Repository
public interface UserMapper extends MyBatisBaseDao<User, Integer, UserExample> {
	
	User selectUserByName(String username);
}