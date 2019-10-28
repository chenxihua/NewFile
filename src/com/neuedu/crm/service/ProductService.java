package com.neuedu.crm.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.neuedu.crm.bean.Product;

/**
 * 用于 产品 模块
 * @author Administrator
 *
 */
public interface ProductService {
	
	/***
	 * 根据产品名称，可以做模糊，也可以做等值查询
	 * @param productName
	 * @return
	 */	
	public List<Product> selectByName(String productName);
	
	/**
	 * 不带条件查询所有
	 * @return
	 */
	
	//查询所有
	public List<Product> selectAlls();
	
	//通过id查询
	public Product selectbyId(Integer id);
	
	//通过价格区间查询
	public List<Product> selectByPrice(Integer lowprice, Integer highprice);

	//通过价格区间和名字查询
	public List<Product> selectByConfident( Product object, Integer lowprice,Integer highprice);

	//软删除
	public int deleteProduct(Product product);

	//增加
	public int addProduct(Product product);
	
	//更新
	public int updateProduct(Product product);
	
	public List<Product> selectByExample(String name,Integer priceMin,Integer priceMax);

}
