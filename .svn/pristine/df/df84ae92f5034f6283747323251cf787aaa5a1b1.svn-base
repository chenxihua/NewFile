package com.neuedu.crm.utils;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮箱发送的工具类
 * @author Administrator
 *
 */


public class EmailUtils {
	
	private static Properties props = new Properties();
	private static String MyEmailAccount = "2642446787@qq.com";
	private static String myEamilPassword = "iwpcxpyiuilpdija";
	private static String MyEmailSMTPHost = "smtp.qq.com";
	private static String SMTP = "smtp";
	private static int port = 587;
	private static String defaultEncoding = "UTF-8";
	
	static{
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", MyEmailSMTPHost);
		props.put("mail.user", MyEmailAccount); 
		props.put("mail.password", myEamilPassword);		
	}
	static Authenticator authenticator = new Authenticator() {  
        @Override  
        protected PasswordAuthentication getPasswordAuthentication() {  
        	// 用户名、密码  
            String userName = props.getProperty("mail.user");  
            String password = props.getProperty("mail.password");  
            return new PasswordAuthentication(userName, password);  
        }  
	};
	
	/**
	 * 
	 * @param to 是发送给某人
	 * @param titles  是标题
	 * @param html  是发送内容
	 * @return
	 * @throws MessagingException
	 */
	public static boolean sendEmailCode(String to,String titles,String html) throws MessagingException{
		boolean flag = true;
		Session mailSession = Session.getInstance(props, authenticator);
		MimeMessage message = new MimeMessage(mailSession);
		// 设置发件人
		InternetAddress form = new InternetAddress(props.getProperty("mail.user"));  
		// 设置自定义发件人昵称
		message.setFrom(form);
		// 设置收件人  
		InternetAddress toUser = new InternetAddress(to);  
		message.setRecipient(RecipientType.TO, toUser);
		// 设置邮件标题  
		message.setSubject(titles);    
		// 设置邮件的内容体  
		message.setContent(html, "text/html;charset=UTF-8");    
		// 发送邮件  
		Transport.send(message); 
		return flag;
	}
	


}
