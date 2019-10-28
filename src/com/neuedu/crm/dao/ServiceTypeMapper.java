package com.neuedu.crm.dao;

import com.neuedu.crm.bean.ServiceType;
import com.neuedu.crm.bean.ServiceTypeExample;
import org.springframework.stereotype.Repository;

/**
 * ServiceTypeMapper继承基类
 */
@Repository
public interface ServiceTypeMapper extends MyBatisBaseDao<ServiceType, Integer, ServiceTypeExample> {
}