package com.neuedu.crm.dao;

import com.neuedu.crm.bean.ContactRecord;
import com.neuedu.crm.bean.ContactRecordExample;
import org.springframework.stereotype.Repository;

/**
 * ContactRecordMapper继承基类
 */
@Repository
public interface ContactRecordMapper extends MyBatisBaseDao<ContactRecord, Integer, ContactRecordExample> {
}