package com.neuedu.crm.dao;

import com.neuedu.crm.bean.Product;
import com.neuedu.crm.bean.ProductExample;
import org.springframework.stereotype.Repository;

/**
 * ProductMapper继承基类
 */
@Repository
public interface ProductMapper extends MyBatisBaseDao<Product, Integer, ProductExample> {
}