package com.neuedu.crm.dao;

import com.neuedu.crm.bean.BusinessPlan;
import com.neuedu.crm.bean.BusinessPlanExample;
import org.springframework.stereotype.Repository;

/**
 * BusinessPlanMapper继承基类
 */
@Repository
public interface BusinessPlanMapper extends MyBatisBaseDao<BusinessPlan, Integer, BusinessPlanExample> {
}