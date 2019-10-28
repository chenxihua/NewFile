package com.neuedu.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neuedu.crm.bean.Product;
import com.neuedu.crm.bean.ProductExample;
import com.neuedu.crm.bean.ProductExample.Criteria;
import com.neuedu.crm.dao.ProductMapper;
import com.neuedu.crm.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> selectByName(String productName){
		ProductExample example = new ProductExample();
		Criteria criteia = example.createCriteria();
		criteia.andNameLike("%"+productName+"%");
		return productMapper.selectByExample(example);
	}
	
	//根据产品id查找产品
	public Product selectbyId(Integer id) {
		Product product = productMapper.selectByPrimaryKey(id);
		return product;
	}
	
	//根据价格区间查找产品(没用到)
	public List<Product> selectByPrice(Integer lowprice,Integer highprice){
		ProductExample example = new ProductExample();
		Criteria criteia = example.createCriteria();
		criteia.andPriceBetween(lowprice, highprice);
		List<Product> list = productMapper.selectByExample(example);
		return list;
	}
	

	//根据产品信息和区间查找产品(没用到)
	public List<Product> selectByConfident( Product object, Integer lowprice,Integer highprice){
		ProductExample example = new ProductExample();
		Criteria criteia = example.createCriteria();
		criteia.andNameLike("%"+object.getName()+"%");
		criteia.andPriceBetween(lowprice, highprice);
		List<Product> list = productMapper.selectByExample(example);
		return list;
	}
	
	/**
	 * 
	 * 增删查改
	 * 
	 **/
	//不传参数默认查全部
	@Override
	public List<Product> selectAlls() {		
		return productMapper.selectByExample(null);
	}

	//删除产品，把状态status改为-1
	@Override
	public int deleteProduct(Product product) {
		product.setStatus(-1);
		if (productMapper.updateByPrimaryKeySelective(product)!=0) {
			return 1;
		}
		return 0;
	}

	//增加产品
	@Override
	public int addProduct(Product product) {
		if (productMapper.insert(product)!=0) {
			return 1;
		}
		return 0;
	}
	
	//更新产品
	@Override
	public int updateProduct(Product product) {
		if (productMapper.updateByPrimaryKey(product)!=0) {
			return 1;
		}
		return 0;
	}

	//模糊多条件查询
	@Override
	public List<Product> selectByExample(String name,Integer priceMin,Integer priceMax){
		ProductExample example = new ProductExample();
		Criteria criteria = example.createCriteria();
		//如果3个条件都为空则默认查全部
		if(name==null&&priceMin==null&&priceMax==null) {
			return productMapper.selectByExample(null);
		}
		//满足if则添加criteria条件，最后再执行查询（此处设计不够合理，可以优化）
		else{ 
			if(name!=null) {
				criteria.andNameLike("%"+name+"%");
			}
			if(priceMin!=null&&priceMax!=null) {
				criteria.andPriceBetween(priceMin, priceMax);
			}
			else if(priceMin==null&&priceMax!=null) {
				criteria.andPriceLessThanOrEqualTo(priceMax);
			}
			else if(priceMin!=null&&priceMax==null) {
				criteria.andPriceGreaterThanOrEqualTo(priceMin);
			}
			return productMapper.selectByExample(example);
		}
	}

	
}
