package com.neuedu.crm.dao;

import com.neuedu.crm.bean.Orders;
import com.neuedu.crm.bean.OrdersExample;
import org.springframework.stereotype.Repository;

/**
 * OrdersMapper继承基类
 */
@Repository
public interface OrdersMapper extends MyBatisBaseDao<Orders, Integer, OrdersExample> {
}