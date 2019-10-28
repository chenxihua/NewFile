package com.neuedu.crm.utils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.neuedu.crm.service.OutflowService;

/**
 * 
 * 类名称：TimerTask   
 * 类描述：定时任务
 * 创建人：Mechan
 *
 */
@Component
public class TimerTask {
	
	@Autowired
	private OutflowService outflowService;
	
	/**
	 * 每天10点30启动任务
	 */
	//@Scheduled(cron = "0 30 10 ? * *")
    @Scheduled(cron = "0/30 * * * * ?")//每隔10秒执行一次
	public void test2()
	{
		//定时对订单表进行扫描，生成流失记录
		//outflowService.CheckOutflow();
		outflowService.CheckOrders();
		//System.out.println("流失检查完毕");
	} 
}