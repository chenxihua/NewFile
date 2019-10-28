package com.neuedu.crm.view;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.reflect.TypeToken;
import com.neuedu.crm.bean.Role;
import com.neuedu.crm.service.RoleService;
import com.neuedu.crm.utils.Operation;

/**
 * 角色控制器
 * 
 * @author guokeng
 *
 */
@Operation(name = "角色操作")
@Controller
public class RoleController {

	@Autowired
	private RoleService roleService;

	private Logger logger = Logger.getLogger(RoleController.class);

	/**
	 * 分页查询角色列表
	 * 
	 * @param page
	 * @param limit
	 * @param request
	 * @return
	 * @throws ParseException
	 */
	/*@Operation(name = "查询角色列表")*/
	@RequestMapping(value = "queryroles")
	@ResponseBody
	public String findAllRolesByPage(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "limit", defaultValue = "10") Integer limit, HttpServletRequest request)
			throws ParseException {

		PageInfo<Role> roleList = roleService.findAllRolesByPage(page, limit);

		List<Role> roles = roleList.getList();

		/**
		 * 设置num
		 */
		int id = limit * (page - 1);

		for (int i = 0; i < roles.size(); i++, id++) {
			Role role = roles.get(i);
			role.setNum(id + 1);
		}

		/**
		 * 用google json来传值 (用hashmap会有时间格式错误)
		 */
		JsonArray json = new Gson().toJsonTree(roleList.getList(), new TypeToken<List<Role>>() {
		}.getType()).getAsJsonArray();
		String js = json.toString();
		String jso = "{\"code\":0,\"msg\":\"\",\"count\":" + roleList.getTotal() + ",\"data\":" + js + "}";

		return jso;
	}

	/**
	 * 添加角色
	 * 
	 * @param request
	 * @param role
	 * @return
	 * @throws ParseException
	 */
	/*@Operation(name = "添加角色")*/
	@RequestMapping(value = "/addRole", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addRole(HttpServletRequest request, Role role) throws ParseException {

		logger.debug("准备添加的角色：" + role.toString());

		int ret = roleService.saveRole(role);

		Map<String, Object> result = new HashMap<>();
		if (ret > 0) {
			/**
			 * 更新成功
			 */
			result.put("success", true);
			result.put("message", "角色创建成功");
		} else {
			/**
			 * 更新失败
			 */
			result.put("success", false);
			result.put("message", "角色创建失败");
		}
		return result;
	}

}
