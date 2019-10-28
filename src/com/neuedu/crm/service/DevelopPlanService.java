package com.neuedu.crm.service;

import java.util.List;

import com.neuedu.crm.bean.DevelopPlan;

/**
 * 这是执行销售机会开发计划的模块
 * @author Administrator
 *
 */



public interface DevelopPlanService {
	
	
	/**
	 * 根据新建销售机会的id，进行新建一个开发计划
	 * 把销售机会的status改为3，表示销售计划正在开发中
	 * @param plan
	 * @return
	 */
	public boolean saveDevelopPlan(DevelopPlan plan);
		
	/**
	 * 根据id，显示这个开发计划已保存的信息,可以作为更新的下一步
	 * @param id
	 * @return
	 */
	public DevelopPlan searchPlanById(Integer id);
	
	/**
	 * 如果销售机会的status为3，则可以进行更新操作（因为status为3，则说明已经创建开发计划）
	 * @return
	 */
	public boolean updateDevelopPlan(DevelopPlan plan);
	
	
	/**
	 * 根据销售机会的saleId，把这个销售的所有开发计划查询出来
	 * @return
	 */
	public List<DevelopPlan> selectAllsPlan(Integer page,Integer limit,Integer saleId);
	
	
	
	
	
	
	
	
	

}
