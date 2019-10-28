package com.neuedu.crm.view;

import java.text.ParseException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.crm.bean.Authority;
import com.neuedu.crm.service.AuthorityService;
import com.neuedu.crm.utils.Operation;

/**
 * 权限控制器
 * 
 * @author guokeng
 *
 */
@Operation(name = "权限操作")
@Controller
public class AuthorityController {

	@Autowired
	private AuthorityService authorityService;

	private Logger logger = Logger.getLogger(AuthorityController.class);

	/**
	 * 查找所有权限
	 * 
	 * @return
	 * @throws ParseException
	 */
	/*@Operation(name = "查询权限列表")*/
	@RequestMapping(value = "queryauthorities")
	@ResponseBody
	public String findAllAuthority() throws ParseException {

		String code = "code";
		String value = "value";
		String authList = "";
		String authJson = "";
		List<Authority> authorityList = authorityService.findAllAutority();

		/**
		 * 拼接自定义格式json
		 */
		for (Authority authority : authorityList) {
			authList += "{" + '"' + code + '"' + ":" + '"' + authority.getId() + '"' + ",";
			authList += '"' + value + '"' + ":" + '"' + authority.getName() + "【" + authority.getDescription() + "】"
					+ '"' + "}" + ",";
		}
		authJson += authList.substring(0, authList.length() - 1);

		String jso = "{\"code\":0," + "\"data\":" + "[" + authJson + "]" + "}";

		logger.debug("jso：" + jso);

		return jso;
	}

}
