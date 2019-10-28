package com.neuedu.crm.dao;

import com.neuedu.crm.bean.Message;
import com.neuedu.crm.bean.MessageExample;
import org.springframework.stereotype.Repository;

/**
 * MessageMapper继承基类
 */
@Repository
public interface MessageMapper extends MyBatisBaseDao<Message, Integer, MessageExample> {
}