package com.neuedu.crm.dao;

import com.neuedu.crm.bean.Accessory;
import com.neuedu.crm.bean.AccessoryExample;
import org.springframework.stereotype.Repository;

/**
 * AccessoryMapper继承基类
 */
@Repository
public interface AccessoryMapper extends MyBatisBaseDao<Accessory, Integer, AccessoryExample> {
}