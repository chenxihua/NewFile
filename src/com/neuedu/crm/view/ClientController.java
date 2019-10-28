package com.neuedu.crm.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.crm.bean.AmountOne;
import com.neuedu.crm.bean.AmountThree;
import com.neuedu.crm.bean.AmountTwo;
import com.neuedu.crm.bean.Client;
import com.neuedu.crm.bean.ClientClass;
import com.neuedu.crm.service.ClientClassService;
import com.neuedu.crm.service.ClientService;
import com.neuedu.crm.service.SaleChanceService;

/**
 * 这是客户信息管理模块
 * @author Administrator
 *
 */

@RequestMapping("/client")
@Controller
public class ClientController {
	
	@Autowired
	private ClientClassService classServer;
	@Autowired
	private ClientService clientServer;
	@Autowired
	private SaleChanceService saleChanceServer;
	
	//private Logger logger = Logger.getLogger(ClientController.class);
	
	/**
	 * 把所有的客户等级（在客户等级表中）查询出来
	 * @return
	 */
	@RequestMapping("/clientClasses")
	@ResponseBody
	public Map<String,Object> searchAllClientClass(){
		Map<String,Object> map = new HashMap<>();
		List<ClientClass> classInfos = classServer.selectAllsClass();
		map.put("code", 0);
		map.put("data", classInfos);
		map.put("success", true); 
		map.put("msg", "显示所有客户等级");
		return map;
	}
	
	/**
	 * 保存一个客户，记录客户信息
	 * @param client
	 * @param saleId
	 * @param request
	 * @return
	 */
	@RequestMapping("/saveClient/{saleId}")
	@ResponseBody
	public Map<String,Object> saveNewClient(Client client,@PathVariable("saleId")Integer saleId,
			HttpServletRequest request){
		Map<String,Object> map = new HashMap<>();
		client.setStatus(0);
		clientServer.saveNewClient(client);
		boolean flag = saleChanceServer.updateAuditForStatus(saleId, 5);
		map.put("code", 0);
		map.put("success", true);
		map.put("msg", "新增客户成功");
		return map;
	}
	
	/**
	 * 带条件查询client表中status=0 的客户
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/showClientInfos")
	@ResponseBody
	public Map<String,Object> selectAllClientsByPager(@RequestParam(value="page",defaultValue="1")Integer page,
			@RequestParam(value="limit",defaultValue="10")Integer limit){
		Map<String,Object> map = new HashMap<>();
		int count = clientServer.selectCountForStatus(0);
		List<Client> clientInfos = clientServer.selectAllClientsByPager(page, limit, 0);
		map.put("code", 0);
		map.put("data", clientInfos);
		map.put("count", count);
		map.put("success", true);
		map.put("msg", "查询客户表成功");
		return map;
	}
	
	/**
	 * 根据client的id，查询一个client实体，用于表单回显
	 * @param id
	 * @return
	 */
	@RequestMapping("/showClientById")
	@ResponseBody
	public Map<String,Object> selectClientById(@RequestParam("id")Integer id){
		Map<String,Object> map = new HashMap<>();
		Client client = clientServer.selectClientById(id);
		map.put("code", 0);
		map.put("data", client);
		map.put("success", true);
		map.put("msg", "一条记录");
		return map;
	}
	
	
	/** ------------------    2018/7/19  ----------------  **/
	/**
	 * 根据客户等级，把不同等级的各个数据查询出来
	 * @return
	 */
	@RequestMapping("/showClientCredit")
	@ResponseBody
	public Map<String,Object> showCreditForClient(){
		Map<String,Object> map = new HashMap<>();
		List<AmountOne> amounts = clientServer.selectAllClientForm();
		map.put("code", 0);
		map.put("data", amounts);
		map.put("success", true);
		map.put("msg", "等级显示成功");
		return map;
	}
	
	/**
	 * 客户满意度
	 * @return
	 */
	@RequestMapping("/showSatisfaction")
	@ResponseBody
	public Map<String,Object> showSatisfact(){
		Map<String,Object> map = new HashMap<>();
		List<AmountTwo> satisfacts = clientServer.selectAllSatisfact();
		map.put("code", 0);
		map.put("data", satisfacts);
		map.put("success", true);
		map.put("msg", "等级显示成功");
		return map;
	}
	
	/**
	 * 客户等级
	 * @return
	 */
	@RequestMapping("/showClientClasses")
	@ResponseBody
	public Map<String,Object> showClientClass(){
		Map<String,Object> map = new HashMap<>();
		List<AmountThree> clientclasses = clientServer.selectClientClasses();
		map.put("code", 0);
		map.put("data", clientclasses);
		map.put("success", true);
		map.put("msg", "等级显示成功");
		return map;
	}
	
	/** ---------  2018/7/21  -------------  **/
	
	@RequestMapping("/selectClientClassById/{classId}")
	@ResponseBody
	public Map<String,Object> showClassInfoById(@PathVariable("classId")Integer classId){
		Map<String,Object> map = new HashMap<>();
		ClientClass classPojo = classServer.selectClassById(classId);
		map.put("code", 0);
		map.put("data", classPojo);
		map.put("success", true);
		map.put("msg", "等级显示成功");
		return map;
	}
	

}



