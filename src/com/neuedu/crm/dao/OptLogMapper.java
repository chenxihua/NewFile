package com.neuedu.crm.dao;

import com.neuedu.crm.bean.OptLog;
import com.neuedu.crm.bean.OptLogExample;
import org.springframework.stereotype.Repository;

/**
 * OptLogMapper继承基类
 */
@Repository
public interface OptLogMapper extends MyBatisBaseDao<OptLog, Integer, OptLogExample> {
}