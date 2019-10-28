package com.neuedu.crm.view;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuedu.crm.utils.EmailUtils;

/**
 * 邮箱contrllor类
 * @author Administrator
 *
 */

@RequestMapping("/send")
@Controller
public class EmailController {
	
	
	@RequestMapping("/sendEmails")
	@ResponseBody
	public Map<String,Object> sendEmailToOut(@RequestParam("to")String to,
			@RequestParam("titles")String titles,@RequestParam("contents")String contents) throws MessagingException{
		Map<String,Object> map = new HashMap<>();
		boolean flag = EmailUtils.sendEmailCode(to, titles, contents);
		map.put("code", 0);
		map.put("data", flag);
		map.put("msg", "发送邮件成功");
		return map;
	}

}
