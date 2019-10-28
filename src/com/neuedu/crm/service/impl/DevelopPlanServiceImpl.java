package com.neuedu.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.crm.bean.DevelopPlan;
import com.neuedu.crm.bean.DevelopPlanExample;
import com.neuedu.crm.bean.DevelopPlanExample.Criteria;
import com.neuedu.crm.dao.DevelopPlanMapper;
import com.neuedu.crm.service.DevelopPlanService;


@Service
public class DevelopPlanServiceImpl implements DevelopPlanService {

	@Autowired
	private DevelopPlanMapper planMapper;
	
	
	/**
	 * 根据新建销售机会的id，进行新建一个开发计划
	 * 把销售机会的status改为3，表示销售计划正在开发中
	 * 新建的开发计划的status为0，开发完成则是1，开发失败，则是-1；
	 */
	@Override
	public boolean saveDevelopPlan(DevelopPlan plan) {
		plan.setStatus(0);
		Integer flag = planMapper.insertSelective(plan);
		if(flag>0){
			return true;
		}else{
			return false;
		}
	}


	/**
	 * 如果销售机会的status为3，则可以进行更新操作（因为status为3，则说明已经创建开发计划）
	 * 先进行销售机会status判断，如果是3，则可操作。
	 * **重点：更新之前，把开发计划的id给记录下来.**
	 * 对于开发计划，我的设计是，①：在新增按钮弹出框里加plan（计划）字段，
	 * ②：在“更新开发计划”按钮里，加effect字段，这个字段包括：开发成功原因，开发失败原因.
	 * ③：后面加"开发成功"，销售机会的status更新为4；开发计划的status更新为1
	 * ④：后面加“开发失败”，销售机会的status更新为-1；开发计划的status更新为-1（就是把销售机会删除）.
	 */
	@Override
	public boolean updateDevelopPlan(DevelopPlan plan) {
		Integer flag = planMapper.updateByPrimaryKeySelective(plan);
		if(flag>0){
			return true;
		}else{
			return false;
		}		
	}

	/**
	 * 根据id，显示这个开发计划已保存的信息,用于后续编辑开发计划
	 */
	@Override
	public DevelopPlan searchPlanById(Integer id) {
		return planMapper.selectByPrimaryKey(id);
	}
	
	
	/**
	 * 根据销售机会的saleId，把这个销售的所有开发计划查询出来
	 */
	@Override
	public List<DevelopPlan> selectAllsPlan(Integer page,Integer limit,Integer saleId) {
		DevelopPlanExample planExample = new DevelopPlanExample();
		Criteria criteria = planExample.createCriteria();
		criteria.andSaleChanceIdEqualTo(saleId);
		
		Long offset = new Long((page-1)*limit);
		planExample.setLimit(limit);
		planExample.setOffset(offset);
		return planMapper.selectByExample(planExample);
	}
	
	
	
	

}
