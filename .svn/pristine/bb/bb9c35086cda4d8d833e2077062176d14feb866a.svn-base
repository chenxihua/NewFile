package com.neuedu.crm.view;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.neuedu.crm.bean.Authority;
import com.neuedu.crm.bean.RoleAuthority;
import com.neuedu.crm.service.AuthorityService;
import com.neuedu.crm.service.RoleAuthorityService;
import com.neuedu.crm.utils.Operation;

/**
 * 角色权限控制器
 * 
 * @author guokeng
 *
 */
@Operation(name = "角色权限操作")
@Controller
public class RoleAuthorityController {

	@Autowired
	private RoleAuthorityService roleAuthorityService;

	@Autowired
	private AuthorityService authorityService;

	private Logger logger = Logger.getLogger(RoleAuthorityController.class);

	/**
	 * 根据用户id查询拥有的权限
	 * 
	 * @param id
	 * @param model
	 * @param request
	 * @param response
	 * @throws ParseException
	 * @throws ServletException
	 * @throws IOException
	 */
	/*@Operation(name = "查询指定用户权限")*/
	@RequestMapping(value = "queryroleauthority/{id}", method = RequestMethod.GET)
	@ResponseBody
	public void queryRoleAuthority(@PathVariable(value = "id") Integer id, Model model, HttpServletRequest request,
			HttpServletResponse response) throws ParseException, ServletException, IOException {

		String permission = "";
		String authorityList = "";
		/**
		 * 查询角色权限列表
		 */
		List<RoleAuthority> roleAuthorities = roleAuthorityService.findRoleAuthority(id);

		List<Integer> authorityIdList = new ArrayList<>();
		/**
		 * 查询角色对应的权限集合
		 */
		for (RoleAuthority roleAuthority : roleAuthorities) {
			authorityIdList.add(roleAuthority.getAuthorityId());
		}
		List<Authority> authorities = authorityService.findAuthorityByIdList(authorityIdList);

		logger.debug("根据id列表查询权限列表成功");
		if ((null != authorities) && (authorities.size() > 0)) {
			for (Authority authority : authorities) {
				permission += (authority.getId() + ",");
			}
			authorityList = permission.substring(0, (permission.length() - 1));
		}

		logger.debug("authorityList" + authorityList);

		request.setAttribute("authorities", authorityList);
		request.setAttribute("authRoleId", id);
		request.getRequestDispatcher("/pages/user/authoritymanagement.jsp").forward(request, response);
	}

	/**
	 * 修改用户拥有的权限
	 * 
	 * @param request
	 * @param param
	 * @return
	 * @throws ParseException
	 */
	@Operation(name = "修改用户权限")
	@RequestMapping(value = "/alterroleauths", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> alterauthorities(HttpServletRequest request, @RequestBody String param)
			throws ParseException {

		int retForDelete = -1;
		int retForAdd = -1;

		JsonObject jsonObject = (JsonObject) new JsonParser().parse(param);

		JsonObject field = jsonObject.get("field").getAsJsonObject();

		/**
		 * 获取角色id,并删除其下所有权限
		 */
		int roleId = field.get("roleId").getAsInt();
		retForDelete = roleAuthorityService.deleteRoleAuthyRoleId(roleId);

		/**
		 * 获取更新后的权限id列表
		 */
		String authorityIdList = null;
		if ((null != field.get("description")) && (!("").equals(field.get("description")))) {
			authorityIdList = field.get("description").toString();

			String[] temp = authorityIdList.split("\"");

			List<Integer> authorityIds = new ArrayList<>();

			for (String authorityId : temp) {
				if (("[").equals(authorityId) || (",").equals(authorityId) || ("]").equals(authorityId)) {
					continue;
				} else {
					authorityIds.add(Integer.parseInt(authorityId));
				}
			}

			retForAdd = roleAuthorityService.addRoleAuthsByRoleId(authorityIds, roleId);
		} else {
			retForAdd = 0;
		}

		logger.debug("description:" + authorityIdList);

		Map<String, Object> result = new HashMap<>();

		logger.debug("retForAdd:" + retForAdd);
		logger.debug("retForDelete:" + retForDelete);

		if ((retForAdd >= 0) && (retForDelete >= 0)) {
			/**
			 * 更新成功
			 */
			result.put("success", true);
			result.put("message", "新增成功");
		} else {
			/**
			 * 更新失败
			 */
			result.put("success", false);
			result.put("message", "新增失败");
		}
		return result;
	}

}
