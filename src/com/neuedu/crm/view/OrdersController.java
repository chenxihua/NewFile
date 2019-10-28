
package com.neuedu.crm.view;

import java.util.ArrayList;
import java.util.Date;
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

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neuedu.crm.bean.Orders;
import com.neuedu.crm.service.OrdersService;

/**
 * 
 * @author Xbai
 *
 */

@Controller
@RequestMapping("/orders")
public class OrdersController {
	private Logger logger = Logger.getLogger(OrdersController.class);
	
	@Autowired
	private OrdersService ordersService;
	/** 查看orders列表  */
	@RequestMapping("/getOrders")
	@ResponseBody
	public Map<String, Object> ordersList(@RequestParam(value="page",defaultValue="1") Integer pageNum,
			@RequestParam(value="limit",defaultValue="10") Integer limit,Integer id){
		PageHelper.startPage(pageNum, limit);
		List<Orders> list = new ArrayList<>();
		Map<String, Object> result = new HashMap<>();
		if(id==null) {
			list = ordersService.selectAlls();
			PageInfo pageInfo = new PageInfo(list,5);
			result.put("count", pageInfo.getTotal());
			for (Orders orders : list) {
				logger.info(orders);
			}
		}
		else { 
			Orders orders = ordersService.selectById(id);
			list.add(orders);
			result.put("count", 1);
		}
		result.put("code", 0);
		result.put("msg", "");
		result.put("data",list);
		return result;
	}

	/**可视化部分*/
	@RequestMapping("/echarts")
	@ResponseBody
	public Map<String, Object> findContribute(){
		Map<String, Object> result = new HashMap<>();
		List<Orders>  list = ordersService.idAndMoney();
			result.put("data", list); 
		return result;
	}
	
	/**通过id查找 */
	@RequestMapping("/getOrdersById")
	@ResponseBody
	public Map<String , Object> findOrdersById(Integer id) {
		Map<String, Object> map = new HashMap<>();
		Orders orders = ordersService.selectById(id);
		if(orders!=null) {
			String msg = "成功找到";
 			map.put("msg",msg);
 			map.put("result", orders);
		}else {
			String msg = "不存在该id的历史订单";
		}
		return map;
	}
	
	/** 删除历史订单表（把status设为-1状态表示已删除，前端判断决定显示与否）  */
	@RequestMapping("/deleteOrders/{id}")
	@ResponseBody
	public Map<String, Object> deleteOrders(@PathVariable int id) {
		Orders orders = new Orders();
		orders.setId(id);
		Map<String, Object> map = new HashMap<>();
		if (ordersService.deleteOrders(orders)!=0) {
			String msg = "删除成功！";
			map.put("msg", msg);
			map.put("result", true);
			return map;
		}else {
			String msg = "删除失败！";
			map.put("msg", msg);
			map.put("result", false);
			return map;
		}
	}
	
	/** 根据时间区间查找orders列表  */
	@RequestMapping("/getOrdersByDate")
	@ResponseBody
	public Map<String, Object> ordersList(@RequestParam(value="page",defaultValue="1") Integer pageNum,
			@RequestParam(value="limit",defaultValue="10") Integer limit,Date dateMin,Date dateMax){
		PageHelper.startPage(pageNum, limit);
		List<Orders> list = new ArrayList<>();
		Map<String, Object> result = new HashMap<>();
		list = ordersService.selectByDate(dateMin, dateMax);
		PageInfo pageInfo = new PageInfo(list,5);
		for (Orders orders : list) {
			logger.info(orders);
		}
		result.put("count", pageInfo.getTotal());
		result.put("code", 0);
		result.put("msg", "");
		result.put("data",list);
		return result;
	}

}
