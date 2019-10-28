package com.neuedu.crm.dao;

import com.neuedu.crm.bean.ClientClass;
import com.neuedu.crm.bean.ClientClassExample;
import org.springframework.stereotype.Repository;

/**
 * ClientClassMapper继承基类
 */
@Repository
public interface ClientClassMapper extends MyBatisBaseDao<ClientClass, Integer, ClientClassExample> {
}