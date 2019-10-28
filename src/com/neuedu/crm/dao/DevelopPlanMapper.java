package com.neuedu.crm.dao;

import com.neuedu.crm.bean.DevelopPlan;
import com.neuedu.crm.bean.DevelopPlanExample;
import org.springframework.stereotype.Repository;

/**
 * DevelopPlanMapper继承基类
 */
@Repository
public interface DevelopPlanMapper extends MyBatisBaseDao<DevelopPlan, Integer, DevelopPlanExample> {
}