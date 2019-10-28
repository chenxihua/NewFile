package com.neuedu.crm.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.crm.bean.Product;
import com.neuedu.crm.bean.ProductExample;
import com.neuedu.crm.dao.ProductMapper;
import com.neuedu.crm.service.ProductService;
import com.neuedu.crm.service.impl.ProductServiceImpl;

public class ProductTest {
	
	private ApplicationContext context;
	private ProductService productService;
	@Autowired
	private ProductServiceImpl productImpl;
	@Autowired
	private ProductMapper productMapper;
	private Logger logger = Logger.getLogger(ProductTest.class); 
	
	@Before
	public void init() {
		String configLocation = "classpath:applicationContext.xml";
		context = new ClassPathXmlApplicationContext( configLocation );
		productImpl = context.getBean( ProductServiceImpl.class  );
		productService = context.getBean( ProductService.class  );
		productMapper = context.getBean( ProductMapper.class  );
	}
	
	@Test
	public void testProductByName(){
		String productName = "";
		List<Product> list = productImpl.selectByName(productName);
		for (Product product : list) {
			logger.info(product.getPrice());
		}
	}
	@Test
	public void testSelectAlls(){
		List<Product> list = productImpl.selectAlls();
		for (Product product : list) {
			logger.info(product);
		}
	}
	
	
	
	
	

	@Test
	public void testSelectByConfident3() {
		
		List<Product> list = productService.selectByPrice(18, null);
		
		if( list != null ) {
			for (Product product : list) {
				System.out.println("查出来的产品有："+product.getName()+"\n价格是："+product.getPrice());
			}
		}
		else
			System.out.println("1jrkl23jrkl");
	}
	@Test
	public void testSelectByConfident2() {
		Product p = new Product();
		p.setName("i");
		List<Product> list = productImpl.selectByConfident(p,7000, 14000);
		for (Product product : list) {
			System.out.println("查出来的产品有："+product.getName()+"\n价格是："+product.getPrice());
		}
	}
}
