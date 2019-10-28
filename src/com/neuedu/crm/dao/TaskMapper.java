package com.neuedu.crm.dao;

import com.neuedu.crm.bean.Task;
import com.neuedu.crm.bean.TaskExample;
import org.springframework.stereotype.Repository;

/**
 * TaskMapper继承基类
 */
@Repository
public interface TaskMapper extends MyBatisBaseDao<Task, Integer, TaskExample> {
}