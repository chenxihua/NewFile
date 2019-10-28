package com.neuedu.crm.service;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageInfo;
import com.neuedu.crm.bean.Message;

public interface MessageService {

	/**
	 * 多条件模糊查找公告带分页
	 * @param param
	 * @param session
	 * @param page
	 * @param rows
	 * @return
	 * @throws ParseException
	 */
	public PageInfo<Message> findAllMsgByPage(String param, HttpSession session,int page , int rows) throws ParseException;


	/**
	 * 根据公告表主键（id）查询公告实体
	 * @param id
	 * @return
	 */
	public Message findMsgById(int id);
	

	/**
	 * 发布公告
	 * @param message
	 * @param session
	 * @return
	 */
	public int saveMessage(Message message,HttpSession session);
}
