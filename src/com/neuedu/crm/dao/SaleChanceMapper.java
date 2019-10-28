package com.neuedu.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.neuedu.crm.bean.SaleChance;
import com.neuedu.crm.bean.SaleChanceExample;

/**
 * SaleChanceMapper继承基类
 */
@Repository
public interface SaleChanceMapper extends MyBatisBaseDao<SaleChance, Integer, SaleChanceExample> {
	
	
}