package com.neuedu.crm.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuedu.crm.bean.SaleChance;
import com.neuedu.crm.bean.SaleChanceExample;
import com.neuedu.crm.bean.SaleChanceExample.Criteria;
import com.neuedu.crm.dao.SaleChanceMapper;
import com.neuedu.crm.service.SaleChanceService;


@Service
public class SaleChanceServiceImpl implements SaleChanceService {
	
	private Logger logger = Logger.getLogger(SaleChanceServiceImpl.class );
	
	@Autowired
	private SaleChanceMapper saleChanceMapper;
	
	/**
	 * ①：查询所有没有指派（新建的销售机会，状态为0）的销售机会      //（根据用户名）
	 * @return（有审核通过，审核不通过按钮）
	 * ②：查询所有正在审核的（如果审核通过，状态为1）的销售机会（审核不通过，状态为-1 //(根据用户名)
	 * @return（有指派按钮）
	 * ③：查询所有已经指派的(如果以指派，状态为2)的销售机会     //（根据用户名）
	 * @return （有创建计划开发的按钮）
	 * @param creator
	 * @param status
	 * @return
	 */
	@Override
	public List<SaleChance> selectStatusById(Integer creator,Integer status){
		SaleChanceExample saleExample = new SaleChanceExample();
		Criteria criteria = saleExample.createCriteria();
		criteria.andCreatorEqualTo(creator);
		criteria.andStatusEqualTo(status);
		return saleChanceMapper.selectByExample(saleExample);
	}

	/**
	 * 更新操作： （根据销售机会的id进行操作）
	 * 审核成功，状态为1; 审核失败，状态为-1，(即删除)
	 * 除了审核状态，还有2,3,4,的状态
	 */
	@Override
	public boolean updateAuditForStatus(int id,int status) {
		SaleChance record = new SaleChance();
		record.setId(id); 
		record.setStatus(status);
		Integer flag = saleChanceMapper.updateByPrimaryKeySelective(record);		
		if(flag>0){
			return true;
		}else{
			return false;
		}		
	}

	/**
	 * 这是主管用的方法，查看所有各个状态下的所有数据为的（包括新建，已审核，已分配，已开发完成）销售机会
	 */
	@Override
	public List<SaleChance> selectAllsStatus(Integer page,Integer limit,Integer status) {
		SaleChanceExample saleExample = new SaleChanceExample();
		Criteria criteria = saleExample.createCriteria();
		criteria.andStatusEqualTo(status);
		
		Long offset = new Long((page-1)*limit);
		saleExample.setLimit(limit);
		saleExample.setOffset(offset);
		
		return saleChanceMapper.selectByExample(saleExample);
	}

	/**
	 * 根据主键id值，进行查询这个销售机会的实体(用于按钮“查看详细信息”)
	 */
	@Override
	public SaleChance selectSaleById(Integer id) {		
		return saleChanceMapper.selectByPrimaryKey(id);
	}

	/**         ===============  2018/7/9  ==================              **/
	/**
	 * 对销售机会任务进行指派给经理，更新销售机会的经理名字
	 * id:销售机会的id，username：是经理的名字（在这里是更换成id）
	 * 在这里，就可以把状态改成2，表示以分配
	 * @param saleChance
	 * @return
	 */
	@Override
	public boolean updateAssignedMan(SaleChance saleChance) {
		Integer saleId = saleChance.getId();
		updateAuditForStatus(saleId,2);
		Integer flag = saleChanceMapper.updateByPrimaryKeySelective(saleChance);
		if(flag>0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 新增一个销售机会
	 * @param record
	 * @return
	 */
	@Override
	public boolean saveNewSaleChance(SaleChance record) {
		Integer flag = saleChanceMapper.insertSelective(record);
		if(flag>0){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 用于查询正在开发的销售机会,根据status是否为3，判断其是否已经创建开发计划
	 * @param id
	 * @return
	 */
	@Override
	public Integer selectForStatus(Integer id) {
		SaleChance sale = saleChanceMapper.selectByPrimaryKey(id);
		return sale.getStatus();
	}

	/**
	 * 按客户名称，以及要查询的状态（status），模糊查询符合条件的销售机会
	 */
	@Override
	public List<SaleChance> selectSaleChanceByStatus(String client, Integer status) {
		SaleChanceExample example = new SaleChanceExample();
		Criteria criteria = example.createCriteria();
		criteria.andClientLike("%"+client+"%");
		criteria.andStatusEqualTo(status);
		return saleChanceMapper.selectByExample(example);
	}

	/**
	 * 
	 */
	@Override
	public Integer countByExample(Integer status) {
		SaleChanceExample example = new SaleChanceExample();
		Criteria criteria = example.createCriteria();
		criteria.andStatusEqualTo(status);
		return (int) saleChanceMapper.countByExample(example);
	}

	
	/**
	 * 这是主管的动作
	 * 查询出超过10天的任何状态的销售机会
	 */
	@Override
	public List<SaleChance> selectOverTimeSaleByDir(Integer page,Integer limit,Integer status) {
		SaleChanceExample example = new SaleChanceExample();
		Criteria criteria = example.createCriteria();
		Date newDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(newDate);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)-10);
		Date overTime = calendar.getTime();
		criteria.andCreateTimeLessThanOrEqualTo(overTime);
		criteria.andStatusEqualTo(status);
		
		Long offset = new Long((page-1)*limit);
		example.setLimit(limit);
		example.setOffset(offset);
		return saleChanceMapper.selectByExample(example);
	}
	
	/**
	 * 这是经理的动作
	 * 查询出超过10天的任何状态的销售机会
	 */
	@Override
	public List<SaleChance> selectOverTimeSales(Integer page,Integer limit,Integer assigner,Integer status) {
		SaleChanceExample example = new SaleChanceExample();
		Criteria criteria = example.createCriteria();
		Date newDate = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(newDate);
		calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)-10);
		Date overTime = calendar.getTime();
		criteria.andCreateTimeLessThanOrEqualTo(overTime);
		criteria.andAssignerEqualTo(assigner);
		criteria.andStatusEqualTo(status);
		
		Long offset = new Long((page-1)*limit);
		example.setLimit(limit);
		example.setOffset(offset);
		return saleChanceMapper.selectByExample(example);
	}

	/**    --------------  2018/7/14  -----------------     **/
	/**
	 * 更新一个saleChance实体
	 */
	@Override
	public boolean updateSaleChance(SaleChance sale) {
		Integer flag = saleChanceMapper.updateByPrimaryKeySelective(sale);
		if(flag>0){
			return true;
		}else{
			return false;
		}
	}

	/** -------------    2017/7/16    --------------- **/
	/**
	 * 查询status下为2和3的销售机会
	 */
	@Override
	public List<SaleChance> selectSaleForTwoAndThree(Integer page, Integer limit, Integer two, Integer three) {
		SaleChanceExample saleExample = new SaleChanceExample();
		Criteria criteria = saleExample.createCriteria();
		List<Integer> itlist = new ArrayList<>();
		itlist.add(two); itlist.add(three);
		criteria.andStatusIn(itlist);
		Long offset = new Long((page-1)*limit);
		saleExample.setLimit(limit);
		saleExample.setOffset(offset);
		
		return saleChanceMapper.selectByExample(saleExample);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}










