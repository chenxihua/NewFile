package com.neuedu.crm.view;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.crm.bean.SaleChance;
import com.neuedu.crm.bean.User;
import com.neuedu.crm.service.LinkmanService;
import com.neuedu.crm.service.SaleChanceService;
import com.neuedu.crm.service.UserService;

@RequestMapping("/saleChance")
@Controller
public class SaleChanceController {
	
	@Autowired
	private SaleChanceService saleService;
	@Autowired
	private UserService userService;

		
	/**
	 * 属于主管的动作
	 * 查询状态码为0的销售计划信息
	 * @return
	 */
	@RequestMapping("/selectAllStatusZero") 
	@ResponseBody
	public Map<String,Object> searchAllNotAssigned(@RequestParam(value="page",defaultValue="1")Integer page,
			@RequestParam(value="limit",defaultValue="10")Integer limit,SaleChance sale){
		Map<String,Object> map = new HashMap<>();		
		Integer count = saleService.countByExample(0);				
		List<SaleChance> saleInfos = saleService.selectAllsStatus(page,limit,0);
		map.put("code", 0);
		map.put("data",saleInfos);
		map.put("msg", "查询成功");
		map.put("count", count);
		return map;
	}	
	/**
	 * 属于主管动作
	 * 查询所有已经审核通过的销售机会（查询所有status为1的sale）
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/selectAllStatusOne")
	@ResponseBody
	public Map<String,Object> searchToPrepareSale(@RequestParam(value="page",defaultValue="1")Integer page,
			@RequestParam(value="limit",defaultValue="10")Integer limit){
		Map<String,Object> map = new HashMap<>();
		Integer count = saleService.countByExample(1);
		List<SaleChance> saleInfos = saleService.selectAllsStatus(page, limit, 1);
		map.put("code", 0);
		map.put("data", saleInfos);
		map.put("msg", "查询成功");
		map.put("count", count);
		return map;
	}	
	/**
	 * 属于主管动作
	 * 查询所有已经分配的销售机会（查询所有status为2和3的sale）(用于创建开发计划)
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/selectAllStatusTwo")
	@ResponseBody
	public Map<String,Object> searchToExploitSale(@RequestParam(value="page",defaultValue="1")Integer page,
			@RequestParam(value="limit",defaultValue="10")Integer limit){
		Map<String,Object> map = new HashMap<>();
		//Integer count = saleImpl.countByExample(2);
		//List<SaleChance> saleInfos = saleImpl.selectAllsStatus(page, limit, 2);
		List<SaleChance> saleInfos = saleService.selectSaleForTwoAndThree(page, limit, 2, 3);
		Integer count = saleInfos.size();
		map.put("code", 0);
		map.put("data", saleInfos);
		map.put("msg", "查询成功");
		map.put("count", count);
		return map;
	}	
	/**
	 * 属于主管动作	【判断超期，用于将销售机会status改为重新分配状态（及status更改为1）】
	 * 查询所有已经分配的销售机会（查询所有status为2的sale）
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/selectStatusTwoForOverTime")
	@ResponseBody
	public Map<String,Object> searchOverTimeSaleByDir(@RequestParam(value="page",defaultValue="1")Integer page,
			@RequestParam(value="limit",defaultValue="10")Integer limit){
		Map<String,Object> map = new HashMap<>();
		List<SaleChance> saleInfos = saleService.selectOverTimeSaleByDir(page, limit, 2);
		Integer count = saleInfos.size();
		map.put("code", 0);
		map.put("data", saleInfos);
		map.put("msg", "查询成功");
		map.put("count", count);
		return map;
	}
	/**
	 * 属于主管动作	
	 * 查询status为4的销售机会，（就是开发成功了，用户新建客户信息）
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/selectAllStatusFour")
	@ResponseBody
	public Map<String,Object> searchExploitSuccess(@RequestParam(value="page",defaultValue="1")Integer page,
			@RequestParam(value="limit",defaultValue="10")Integer limit){
		Map<String,Object> map = new HashMap<>();
		List<SaleChance> saleInfos = saleService.selectAllsStatus(page, limit, 4);
		Integer count = saleInfos.size();
		map.put("code", 0);
		map.put("data", saleInfos);
		map.put("msg", "查询成功");
		map.put("count", count);
		return map;
	}

	/**
	 * 点击"重新分配"按钮，即可把状态status改为1
	 * @return
	 */
	@RequestMapping("/auditSuccessBtn")
	@ResponseBody
	public Map<String,Object> auditSuccessBtn(@RequestParam("id")Integer id){
		Map<String,Object> map = new HashMap<>();
		saleService.updateAuditForStatus(id, 1);
		map.put("code", 0);
		map.put("success", true);
		map.put("msg", "更新成功");
		return map;		
	}
	
	
	/**                   2018/7/13             **/
	/**
	 * 保存一个销售机会（也是新增一个销售机会）
	 * @param sale
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveNewSaleChance")
	@ResponseBody
	public Map<String,Object> saveSaleChance(SaleChance sale,HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		sale.setStatus(0);
		sale.setCreateTime(new Date());
		saleService.saveNewSaleChance(sale);
		map.put("success", true);
		map.put("code",0);
		map.put("msg", "插入成功");
		return map;
	}
	
	/**
	 * 这是主管和经理共同的动作
	 * 点击"详细信息"按钮，把这个新建的销售机会的所有信息显示出来
	 * @return
	 */
	@RequestMapping(value="/showSaleInfos",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> showSaleInfos(@RequestParam("id")Integer id){
		Map<String,Object> map = new HashMap<>();
		SaleChance saleChance = saleService.selectSaleById(id);
		map.put("data", saleChance);
		map.put("code", 0);
		map.put("success", true);
		map.put("msg", "更新成功");
		return map;
	}
	
	
	/*** -------------------- 2018/7/14--------------------------- ***/
	/**
	 * 保存更新的销售机会信息,把审核通过的sale的status改为1，
	 * @param sale
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateSaleSuccess")
	@ResponseBody
	public Map<String,Object> updataSaleChanceToSuccess(SaleChance sale,HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		sale.setStatus(1);
		boolean flag = saleService.updateSaleChance(sale);
		map.put("success", true);
		map.put("code",0);
		map.put("msg", "审核成功");
		return map;
	}
	/**
	 * 保存更新的销售机会信息，把审核不通过的sale的status改为-1；
	 * @param sale
	 * @param request
	 * @return
	 */
	@RequestMapping("/updateSaleFaild")
	@ResponseBody
	public Map<String,Object> updataSaleChanceToFaild(SaleChance sale,HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		sale.setStatus(-1);
		boolean flag = saleService.updateSaleChance(sale);
		map.put("success", true);
		map.put("code",0);
		map.put("msg", "审核失败");
		return map;
	}
	
	/**   ----------------    2018/7/16   ----------------  **/
	
	/**
	 * 开发成功，则把sale的 status更新成4；
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/exploitSuccess")
	@ResponseBody
	public Map<String,Object> updateExploitStatusSuccess(Integer id,HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		saleService.updateAuditForStatus(id, 4);
		map.put("code", 0);
		map.put("success", true);
		map.put("msg", "开发成功");
		return map;
	}
	
	/**
	 * 开发失败，则把sale的 status更新成-1；
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/exploitFail")
	@ResponseBody
	public Map<String,Object> updateExploitStatusFail(Integer id,HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		saleService.updateAuditForStatus(id, -1);
		map.put("code", 0);
		map.put("success", true);
		map.put("msg", "开发失败");
		return map;
	}
	
	/**
	 * 查询所有经理，把它显示到添加表单中
	 * @return
	 */
	@RequestMapping("/showAllManager")
	@ResponseBody
	public Map<String,Object> selectManagers(){
		Map<String,Object> map = new HashMap<>();
		List<User> userInfos = userService.selectManagers();
		map.put("code", 0);
		map.put("data", userInfos); 
		map.put("success", true);
		map.put("msg", "所有经理信息");
		return map;
	}
	
	/**
	 * 查询所有主管，把它显示到添加表单中
	 * @return
	 */
	@RequestMapping("/showAllDirs")
	@ResponseBody
	public Map<String,Object> selectDirs(){
		Map<String,Object> map = new HashMap<>();
		List<User> userInfos = userService.selectDirs();
		map.put("code", 0);
		map.put("data", userInfos);
		map.put("success", true);
		map.put("msg", "所有主管信息");
		return map;
	}
	
	
	/**
	 * 显示能创建的所有人名字
	 * @return
	 */
	@RequestMapping("/showCreateres")
	@ResponseBody
	public Map<String,Object> searchAllCreators(){
		Map<String,Object> map = new HashMap<>();
		List<User> userInfos = userService.selectAllCreator();
		map.put("code", 0);
		map.put("data", userInfos);
		map.put("success", true);
		map.put("msg", "所有能创建人信息");
		return map;
	}
	
	/**
	 * 主管动作，销售机会进行分配
	 * @param id
	 * @param request
	 * @return
	 */
	@RequestMapping("/assignToManager")
	@ResponseBody
	public Map<String,Object> editAssignToManager(@RequestParam("id")Integer id,HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("name");
		User user = userService.selectByName(username);
		SaleChance salePojo = saleService.selectSaleById(id);
		salePojo.setAssignTime(new Date());
		salePojo.setStatus(2);
		salePojo.setAssignee(user.getId());
		saleService.updateSaleChance(salePojo);
		map.put("code", 0);
		map.put("success", true);
		map.put("msg", "分配任务完成");
		return map;
	}
	
	
	
	/**
	 * 根据creatorId选择一个登录用户实体，用户显示用户名
	 * @param creatId
	 * @return
	 */
	@RequestMapping("/selectCreatorName/{creatId}")
	@ResponseBody
	public Map<String,Object> selectCreatorName(@PathVariable("creatId")Integer creatId){
		Map<String,Object> map = new HashMap<>();
		User user = userService.selectById(creatId);
		map.put("code", 0);
		map.put("data", user);
		map.put("success", true);
		map.put("msg", "查使用者成功");
		return map;
	}

	
	

}



