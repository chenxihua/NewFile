package com.neuedu.crm.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.crm.bean.ContactRecord;
import com.neuedu.crm.service.ContactRecordService;

/**
 * 与客户交往记录的模块
 * @author Administrator
 *
 */

@RequestMapping("/record")
@Controller
public class RecordController {
	
	@Autowired
	private ContactRecordService recordServer;
	
	/**
	 * 根据client的id，分页查询与这个客户的历史交往记录 
	 * @param page
	 * @param limit
	 * @param clientId
	 * @return
	 */
	@RequestMapping("/selectRecordByIdInfos/{clientId}")
	@ResponseBody
	public Map<String,Object> selectContactRecordByPager(Integer page,Integer limit,
			@PathVariable("clientId")Integer clientId){
		Map<String,Object> map = new HashMap<>();
		int count = recordServer.countRecordById(clientId);
		List<ContactRecord> recordInfos = recordServer.selectAllRecords(page, limit, clientId);
		map.put("code", 0);
		map.put("data", recordInfos);
		map.put("count", count);
		map.put("success", true);
		map.put("msg", "历史记录查询成功");
		return map;
	}
	
	
	/**
	 * 查询单个历史交往记录，用于表单回显,查看单个历史记录
	 * @param RecordId
	 * @return
	 */
	@RequestMapping("/selectOneRecord")
	@ResponseBody
	public Map<String,Object> selectOneRecordById(Integer RecordId){
		Map<String,Object> map = new HashMap<>();
		ContactRecord record = recordServer.selectForRecords(RecordId);
		map.put("code", 0);
		map.put("data", record);
		map.put("success", true);
		map.put("msg", "查询单个历史记录成功");
		return map;
	}
	
	/**
	 * 删除单个历史记录
	 * @param RecordId
	 * @return
	 */
	@RequestMapping(value="/deleteRecordById/{RecordId}",method=RequestMethod.DELETE)
	@ResponseBody
	public Map<String,Object> deleteContactRecord(@PathVariable("RecordId")Integer RecordId){
		Map<String,Object> map = new HashMap<>();
		boolean flag = recordServer.deleteForRecord(RecordId);
		map.put("code", 0);
		map.put("success", true);
		map.put("msg", "删除单个历史记录成功");
		return map;
	}
	
	
	/**
	 * 新增一个与客户（client）的历史交往记录
	 * @return
	 */
	@RequestMapping("/saveRecord/{clientId}")
	@ResponseBody
	public Map<String,Object> saveContactRecord(ContactRecord record,
			@PathVariable("clientId")Integer clientId){
		Map<String,Object> map = new HashMap<>();
		record.setClientId(clientId);
		record.setStatus(0);
		recordServer.saveForRecord(record);
		map.put("code", 0);
		map.put("success", true);
		map.put("msg", "新增单个历史记录成功");
		return map;
	}
	
	
}




