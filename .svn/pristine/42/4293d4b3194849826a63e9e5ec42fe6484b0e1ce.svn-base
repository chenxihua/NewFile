package com.neuedu.crm.test;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.neuedu.crm.bean.ContactRecord;
import com.neuedu.crm.service.ContactRecordService;

public class HistoryRecordTest {
	
	
	private ContactRecordService recordImpl;
	private Logger logger = Logger.getLogger(HistoryRecordTest.class);
	
	@Before
	public void init() {
		String configLocation = "classpath:applicationContext.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext( configLocation );
		recordImpl = context.getBean(ContactRecordService.class);		
	}
	
//	@Test
//	public void testSelectRecord(){
//		List<ContactRecord> records = recordImpl.selectAllRecords();
//		for (ContactRecord contactRecord : records) {
//			logger.info(contactRecord);
//		}
//	}
	
//	@Test
//	public void testNewSaveRecord(){
//		ContactRecord record = new ContactRecord(null,8,new Date(),"杭州","咨询1","服务1",null,6,1);
//		boolean flag = recordImpl.saveForRecord(record);
//		logger.info(flag);
//	}
	
	@Test
	public void testDeleteRecord(){
		boolean flag = recordImpl.deleteForRecord(4);
		logger.info(flag);
	}
	
	
	
	
	
	

}





