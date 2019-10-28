package com.neuedu.crm.dao;

import com.neuedu.crm.bean.Outflow;
import com.neuedu.crm.bean.OutflowExample;
import org.springframework.stereotype.Repository;

/**
 * OutflowMapper继承基类
 */
@Repository
public interface OutflowMapper extends MyBatisBaseDao<Outflow, Integer, OutflowExample> {
}