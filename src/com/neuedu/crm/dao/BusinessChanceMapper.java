package com.neuedu.crm.dao;

import com.neuedu.crm.bean.BusinessChance;
import com.neuedu.crm.bean.BusinessChanceExample;
import org.springframework.stereotype.Repository;

/**
 * BusinessChanceMapper继承基类
 */
@Repository
public interface BusinessChanceMapper extends MyBatisBaseDao<BusinessChance, Integer, BusinessChanceExample> {
}