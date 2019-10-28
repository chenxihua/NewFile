package com.neuedu.crm.view;

import java.util.ArrayList;
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
import com.neuedu.crm.bean.OrderItem;
import com.neuedu.crm.service.OrderItemService;

/**
 * 
 * @author Xbai
 *
 */

@Controller
@RequestMapping("/orderItem")
public class OrderItemController {
	
	private Logger logger = Logger.getLogger(OrderItemController.class);
	
	@Autowired
	private OrderItemService orderItemService;

	/** 获取全部订单项 */
	@RequestMapping("/getOrderItem")
	@ResponseBody
	public Map<String, Object> orderItemList(@RequestParam(value="page",defaultValue="1") Integer pageNum,
			@RequestParam(value="pageSize",defaultValue="5") Integer limit,Integer id){
		PageHelper.startPage(pageNum, limit);
		List<OrderItem> list =new ArrayList<>();
		Map<String, Object> result = new HashMap<>();
		if(id==null) {
			list = orderItemService.selectAlls();
			PageInfo pageInfo = new PageInfo(list,5);
			result.put("count", pageInfo.getTotal());
			for(OrderItem orderItem : list) {
				logger.info(orderItem);
			}
		}else {
			OrderItem orderItem = orderItemService.selectById(id);
			list.add(orderItem);
			result.put("count", 1);
		}
		result.put("data",list);
		result.put("code", 0);
		result.put("msg", "");
		return result;
	}
	

	/** 通过订单id查找 */
	@RequestMapping("/getOrderItemById")
	@ResponseBody
	public Map<String, Object> findOrderItemById(Integer id){
		Map<String, Object> map = new HashMap<>();
		
		OrderItem orderItem = orderItemService.selectById(id);
		if(orderItem!=null) {
			String msg = "成功找到";
			map.put("msg",msg);
			map.put("result",orderItem);
		}else {
			String msg = "不存在该id的订单项";
			map.put("msg",msg);
		}
		return map;
	}

	/**  删除订单项表（把status设为-1状态表示已删除，前端判断决定显示与否）  */
	@RequestMapping("/deleteOrderItem/{id}")
	@ResponseBody
	public Map<String, Object> deleteOrders(@PathVariable int id) {
		OrderItem orderItem = new OrderItem();
		orderItem.setId(id);
		Map<String, Object> map = new HashMap<>();
		if (orderItemService.deleteOrderItem(orderItem)!=0) {
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
	
}
