package com.neuedu.crm.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.crm.bean.DevelopPlan;
import com.neuedu.crm.service.DevelopPlanService;
import com.neuedu.crm.service.SaleChanceService;

/**
 * 这是销售机会的开发计划模块
 * @author Administrator
 */


@RequestMapping("/exploit")
@Controller
public class ExploitController {
	
	@Autowired
	private DevelopPlanService exploitImpl;
	@Autowired
	private SaleChanceService saleImpl;
	
	private Logger logger = Logger.getLogger(ExploitController.class);
	
	/**
	 * 保存一个开发计划
	 * @param exploitPlan
	 * @return
	 */
	@RequestMapping("/saveDevelopPlan")
	@ResponseBody
	public Map<String,Object> saveNewDevelopPlan(DevelopPlan exploitPlan){
		Map<String, Object> map = new HashMap<>();
		Integer saleId = exploitPlan.getSaleChanceId();
		saleImpl.updateAuditForStatus(saleId, 3);
		exploitImpl.saveDevelopPlan(exploitPlan);
		map.put("code", 0);
		map.put("success", true);
		map.put("msg", "保存计划成功");
		return map;
	}
	
	/**
	 * 根据销售机会id，查询这个销售机会的所有开发计划
	 * @param page
	 * @param limit
	 * @param id
	 * @return
	 */
	@RequestMapping("/showPlanInfos")
	@ResponseBody
	public Map<String,Object> selectAllDevelopPlans(@RequestParam(value="page",defaultValue="1")Integer page,
			@RequestParam(value="limit",defaultValue="10")Integer limit,@RequestParam("id")Integer id){
		Map<String,Object> map = new HashMap<>();
		List<DevelopPlan> planList = exploitImpl.selectAllsPlan(page,limit,id);
		Integer count = planList.size();
		map.put("code", 0);
		map.put("data", planList);
		map.put("success", true);
		map.put("count", count);
		map.put("msg", "查询所有成功"); 
		return map;
	}
	
	/**
	 * 根据开发计划的id，查询这个开发计划实体，然后显示到表单，用于更新.
	 * @param id
	 * @return
	 */
	@RequestMapping("/showOneInfos")
	@ResponseBody
	public Map<String,Object> selectPlanById(@RequestParam("id")Integer id){
		Map<String,Object> map = new HashMap<>();
		DevelopPlan plan = exploitImpl.searchPlanById(id);
		map.put("code", 0);
		map.put("success", true);
		map.put("data", plan);
		map.put("msg", "显示一条数据");
		return map;
	}
	
	/**
	 * 保存一条开发计划的表单数据（就是更新开发过程）
	 * @param plan
	 * @return
	 */
	@RequestMapping("/updateDevelopProcess")
	@ResponseBody
	public Map<String,Object> updateDevelop(DevelopPlan plan){
		Map<String,Object> map = new HashMap<>();
		exploitImpl.updateDevelopPlan(plan);
		map.put("code", 0);
		map.put("success", true);
		map.put("msg","更新开发过程");
		return map;
	}
	
	
	
	
	
	
	
}
