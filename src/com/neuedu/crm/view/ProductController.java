package com.neuedu.crm.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.neuedu.crm.bean.Product;
import com.neuedu.crm.service.ProductService;

/**
 * 
 * @author Xbai
 *
 */

@Controller
@RequestMapping("/product")
public class ProductController {
	
	private Logger logger = Logger.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	/** 查看产品列表 */
	@RequestMapping("/getProducts")
	@ResponseBody
	public Map<String, Object> productList(@RequestParam(value="page",defaultValue="1") Integer pageNum,
				@RequestParam(value="limit",defaultValue="5") Integer limit,String name) {
		PageHelper.startPage(pageNum, limit);
		List<Product> list ;
		if(name==null) {
			list = productService.selectAlls();
		}
		else { 
			list = productService.selectByName(name);
		}
		for (Product product : list) {
			logger.info(product);
		}
		PageInfo pageInfo = new PageInfo(list,5);
		Map<String, Object> result = new HashMap<>();
		result.put("code", 0);
		result.put("msg", "");
		result.put("count", pageInfo.getTotal());
		result.put("data",list);
		return result;
	}
	
	
	/** 查看产品列表 */
	@RequestMapping("/getProducts2")
	@ResponseBody
	public Map<String, Object> productList(@RequestParam(value="page",defaultValue="1") Integer pageNum,
			@RequestParam(value="limit",defaultValue="5") Integer limit,String name,Integer priceMin,Integer priceMax) {
		PageHelper.startPage(pageNum, limit);
		List<Product> list ;
		list = productService.selectByExample(name, priceMin, priceMax);
		for (Product product2 : list) {
			logger.info(product2);
		}
		PageInfo pageInfo = new PageInfo(list,5);
		Map<String, Object> result = new HashMap<>();
		result.put("code", 0);
		result.put("msg", "");
		result.put("count", pageInfo.getTotal());
		result.put("data",list);
		return result;
	}
	/** 以上为2018/07/11/16：23更新，分割线以下未更新=========== */

	/** 名字模糊查询 */
	@RequestMapping("selectByName")
	@ResponseBody
	public ModelAndView selectByName(@RequestParam(value="pageNum",defaultValue="1") Integer  pageNum,
			@RequestParam(value="pageSize",defaultValue="5") Integer pageSize ,@RequestParam(value="productName",defaultValue="") String productName){
		ModelAndView modelAndView = new ModelAndView("productPage");
		PageHelper.startPage(1, 5);
		List<Product> list =  productService.selectByName(productName);
		for (Product product : list) {
			logger.info(product);
		}
		PageInfo pageInfo = new PageInfo(list,5);
		modelAndView.addObject("pageInfo", pageInfo);
		return modelAndView;
	}
	
	/** 根据id删除 */
	@RequestMapping("/deleteProducts/{id}")
	@ResponseBody
	public Map<String, Object> deleteProduct(@PathVariable int id) {
		Product product = new Product();
		product.setId(id);
		Map<String, Object> map = new HashMap<>();
		if (productService.deleteProduct(product)!=0) {
			String msg = "商品删除成功！";
			map.put("msg", msg);
			map.put("result", true);
			return map;
		}else {
			String msg = "商品删除失败！";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
	}

	/** 新增商品 */
	@RequestMapping("/addProducts")
	@ResponseBody
	public Map<String, Object> addProduct(Product product){
		System.out.println("进入controller"+product.getName()+" "+product.getPrice()+" "+
				product.getStatus()+" "+product.getStock());
		Map<String, Object> map = new HashMap<>();
		if (productService.addProduct(product)!=0) {
			String msg = "商品新增成功";
			map.put("msg", msg);
			map.put("result",true);
			return map;
		}else {
			String msg = "商品新增失败";
			map.put("msg", msg);
			map.put("result",false);
			return map;
		}
	}
	
	/** 更新商品 */
	@RequestMapping("/updateProducts")
	@ResponseBody
	public Map<String, Object> updateProduct(Product product){
		Map<String, Object> map = new HashMap<>();
		if (productService.updateProduct(product)!=0) {
			String msg = "商品修改成功";
			map.put("msg", msg);
			map.put("result",true);
			return map;
		}else {
			String msg = "商品修改失败";
			map.put("msg", msg);
			map.put("result",false);
			return map;
		}
	}
	
}
