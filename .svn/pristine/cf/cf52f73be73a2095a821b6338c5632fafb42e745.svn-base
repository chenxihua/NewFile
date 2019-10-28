package com.neuedu.crm.service;

import java.util.List;

import com.neuedu.crm.bean.SaleChance;
import com.neuedu.crm.bean.SaleChanceExample;

/**
 * 用于 营销管理 模块
 * @author Administrator
 *
 */
public interface SaleChanceService {
	
	
	
	/**
	 * 这个方法，结合的就是根据某个用户查询，某个自己新建的sale的某个状态之下的所有信息
	 * @param creator
	 * @param status
	 * @return
	 */
	public List<SaleChance> selectStatusById(Integer creator,Integer status);
		
	/**
	 * 这是主管用的方法，查看所有各个状态下的所有数据为的（即新建的）销售机会
	 * @return
	 */
	public List<SaleChance> selectAllsStatus(Integer page,Integer limit,Integer status);
	
	/**
	 * 更新操作：（根据销售机会的id进行更新其状态）
	 * 新建的销售机会或没有指派的，就要审核，(显示审核按钮'审核通过'状态改为1，'审核失败'状态改为-1)
	 * 状态还有 2，3, 4(点击销售机会的新建开发计划时，如果点击“开发计划”保存按钮，则把状态更新为3；)
	 * @return
	 */
	public boolean updateAuditForStatus(int id,int status);
		
	/**
	 * 根据主键id值，进行查询这个销售机会的实体
	 * @param id
	 * @return
	 */
	public SaleChance selectSaleById(Integer id);
	
	/*            2018/7/9              */ 
	
	/**
	 * 对销售机会任务进行指派给经理，更新销售机会的经理名字
	 * id:销售机会的id，username：是经理的名字（在这里是更换成id）
	 * 在这里，就可以把状态改成2，表示以分配
	 * @return
	 */
	public boolean updateAssignedMan(SaleChance saleChance);
	
	/**
	 * 新增一个销售机会
	 * @param record
	 * @return
	 */
	public boolean saveNewSaleChance(SaleChance record);
	
	/**
	 * 用于查询正在开发的销售机会,根据status是否为3，判断其是否已经创建开发计划
	 * @param id
	 */
	public Integer selectForStatus(Integer id);
	
	/**
	 * 按客户名称，以及要查询的状态（status），模糊查询符合条件的销售机会
	 * @param client
	 * @param status
	 * @return
	 */
	public List<SaleChance> selectSaleChanceByStatus(String client,Integer status);
	
	
	/**
	 * 根据Exampel统计条数
	 * @param chanceExample
	 * @return
	 */
	public Integer countByExample(Integer status);
	
	/**
	 * 属于经理的动作
	 * 查询出超过10天的任何状态的销售机会
	 * @param assigner
	 * @return
	 */
	public List<SaleChance> selectOverTimeSales(Integer page,Integer limit,Integer assigner,Integer status);

	
	/**
	 * 属于主管的动作：
	 * 查询出超过10天的任何状态的销售机会
	 * @param status
	 * @return
	 */
	public List<SaleChance> selectOverTimeSaleByDir(Integer page,Integer limit,Integer status);
	
	/**    --------------  2018/7/14  -----------------     **/
	/**
	 * 更新一个saleChance实体
	 * @param sale
	 * @return
	 */
	public boolean updateSaleChance(SaleChance sale);
	
	/** -------------    2017/7/16    --------------- **/
	/**
	 * 查询status下为2和3的销售机会
	 * @param page
	 * @param limit
	 * @param two
	 * @param three
	 * @return
	 */
	public List<SaleChance> selectSaleForTwoAndThree(Integer page,Integer limit,Integer two,Integer three);

}
