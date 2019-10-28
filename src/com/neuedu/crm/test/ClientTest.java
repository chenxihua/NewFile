package com.neuedu.crm.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.crm.bean.AmountOne;
import com.neuedu.crm.bean.AmountThree;
import com.neuedu.crm.bean.AmountTwo;
import com.neuedu.crm.bean.Client;
import com.neuedu.crm.bean.ClientClass;
import com.neuedu.crm.bean.Linkman;
import com.neuedu.crm.service.ClientClassService;
import com.neuedu.crm.service.LinkmanService;
import com.neuedu.crm.service.impl.ClientServiceImpl;

public class ClientTest {
	
	private ClientServiceImpl clientImpl;
	private ClientClassService clientClassImpl;
	private LinkmanService linkmanImpl;
	private Logger logger = Logger.getLogger(ClientTest.class); 
	
	@Before
	public void init() {
		String configLocation = "classpath:applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext( configLocation );
		clientImpl = context.getBean(ClientServiceImpl.class  );
		clientClassImpl = context.getBean(ClientClassService.class);
		linkmanImpl = context.getBean(LinkmanService.class);		
	}
	
	@Test
	public void testClientAlls(){
		List<Client> list = clientImpl.selectAllClients();
		for (Client client : list) {
			logger.info(client);
		}
	}
//	@Test
//	public void testSaveClient(){
//		boolean flag = clientImpl.insertClientById(10);
//		logger.info(flag);
//	}
	
	@Test
	public void testSelectAllsClass(){
		List<ClientClass> classList = clientClassImpl.selectAllsClass();
		for (ClientClass clientClass : classList) {
			logger.info(clientClass);
		}
	}
	
//	@Test
//	public void testSelectLinkmans(){
//		List<Linkman> list = linkmanImpl.selectAllLinkmans(1);
//		for (Linkman linkman : list) {
//			logger.info(linkman);
//		}
//	}
	
	@Test
	public void testClientForm(){
		List<AmountOne> list = clientImpl.selectAllClientForm();
		for (AmountOne amount : list) {
			logger.info(amount);
		}
	}
	
	
	@Test
	public void testSatisfact(){
		List<AmountTwo> list = clientImpl.selectAllSatisfact();
		for (AmountTwo satisfact : list) {
			logger.info(satisfact);
		}
	}
	
	@Test
	public void testClientClasses(){
		List<AmountThree> list = clientImpl.selectClientClasses();
		for (AmountThree amountThree : list) {
			logger.info(amountThree);
		}
	}
	
	
	
	
	
	
	
	
	

}




