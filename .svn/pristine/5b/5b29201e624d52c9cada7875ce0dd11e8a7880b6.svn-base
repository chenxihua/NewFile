package com.neuedu.crm.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.crm.bean.Linkman;
import com.neuedu.crm.service.LinkmanService;

/**
 * 联系人管理模块
 * @author Administrator
 *
 */

@RequestMapping("/linkman")
@Controller
public class LinkmanController {
	
	@Autowired
	private LinkmanService linkmanImpl;
	
	/**
	 * 查询所有联系人
	 * @param page
	 * @param limit
	 * @param clientId
	 * @return
	 */
	@RequestMapping("/selectAllsLinkmanInfos/{clientId}")
	@ResponseBody
	public Map<String,Object> selectAllsLinkman(@RequestParam(value="page",defaultValue="1")Integer page,
			@RequestParam(value="limit",defaultValue="10")Integer limit,@PathVariable("clientId")Integer clientId){
		Map<String,Object> map = new HashMap<>();
		int count = linkmanImpl.countLinkmans(clientId);
		List<Linkman> manInfos = linkmanImpl.selectAllLinkmans(page, limit, clientId);
		map.put("code", 0);
		map.put("data", manInfos);
		map.put("count", count);
		map.put("success", true);
		map.put("msg", "联系人查询成功");
		return map;
	}
	
	/**
	 * 根据联系人的id，显示联系人信息，用于表单回显，以及后来的更新
	 * @return
	 */
	@RequestMapping("/showLinkmanInfos")
	@ResponseBody
	public Map<String,Object> showOneLinkmanInfo(Integer manId){
		Map<String,Object> map = new HashMap<>();
		Linkman man = linkmanImpl.showlinkman(manId);
		map.put("code", 0);
		map.put("data", man);
		map.put("success", true);
		map.put("msg", "查询个人信息成功");
		return map;
	}
	
	/**
	 * 更新联系人信息
	 * @return
	 */
	@RequestMapping("/updateLinkmanInfos")
	@ResponseBody
	public Map<String,Object> updateLinkman(Linkman linkman){
		Map<String,Object> map = new HashMap<>();
		linkmanImpl.updateLinkmanInfos(linkman);
		map.put("code", 0);
		map.put("success", true);
		map.put("msg", "更新个人信息成功");
		return map;
	}
	
	
	/**
	 * 根据联系人id，进行删除联系人
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/deletelinkmanById/{linkmanId}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteLinkmanById(@PathVariable("linkmanId")Integer linkmanId){
		Map<String,Object> map = new HashMap<>();
		linkmanImpl.deleteLinkman(linkmanId);
		map.put("code", 0);
		map.put("success", true);
		map.put("msg", "删除一个联系人信息成功");
		return map;
	}
	
	/**
	 * 新增一个客户公司的联系人
	 * @param man
	 * @param clientId
	 * @return
	 */
	@RequestMapping("/saveLinkman/{clientId}")
	@ResponseBody
	public Map<String,Object> saveNewLinkman(Linkman man,@PathVariable("clientId")Integer clientId){
		Map<String,Object> map = new HashMap<>();
		man.setClientId(clientId);
		man.setStatus(1);
		linkmanImpl.saveLinkman(man);
		map.put("code", 0);
		map.put("success", true);
		map.put("msg", "新增个人信息成功");
		return map;
	}
	
	
}
