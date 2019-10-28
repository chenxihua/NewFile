package com.neuedu.crm.service;

import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageInfo;
import com.neuedu.crm.bean.Outflow;
import com.neuedu.crm.bean.OutflowExample;
import com.neuedu.crm.bean.Service;
import com.neuedu.crm.bean.User;

/**
 * Service层：流失管理
 * @author Mechan
 *
 */
public interface OutflowService {
	
	/**
	 * 查看所有记录
	 * @return
	 */
	List<Outflow> selectAll();
		
	/**
	 * 按主键查询记录
	 * @param id(记录id)
	 * @return
	 */
	Outflow selectById( Integer id );
	
	/**
	 * 实例查询，分页查询
	 * @param example(查询条件)
	 * @return
	 */
	List<Outflow> selectByExamplePager( OutflowExample example );	
	
	/**
	 * 更新
	 * @param record(新记录)
	 * @return
	 */
	int updateOutflow( Outflow record );
	
	/**
	 * 扫描订单表，给流失表删除数据
	 */
	int CheckOutflow();
	
	/**
	 * 扫描订单表，给流失表添加数据
	 */
	int CheckOrders();
	
	/**
	 * 主管操作：显示流失列表 
	 * @param page(第几页)，rows(每页记录数)，userId(主管id)
	 * 
	 */
	PageInfo<Outflow> outflowList( Integer page, Integer rows, Integer userId );
		
	/**
	 * 经理操作：显示流失列表 
	 * @param page(第几页)，rows(每页记录数)，userId(经理id)
	 * 
	 */
	PageInfo<Outflow> handleOutflowList( Integer page, Integer rows, Integer userId );
	
	/**
	 * 经理操作：暂缓流失
	 * @return
	 */
	Map<String, Object> deferOutflow( Outflow newOutflow );
	
	/**
	 * 经理操作：确认流失
	 * @return
	 */
	Map<String, Object> confirmOutflow( Outflow newOutflow );
}
