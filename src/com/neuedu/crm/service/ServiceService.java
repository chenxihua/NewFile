package com.neuedu.crm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.github.pagehelper.PageInfo;
import com.neuedu.crm.bean.AmountOne;
import com.neuedu.crm.bean.AmountTwo;
import com.neuedu.crm.bean.Service;
import com.neuedu.crm.bean.ServiceExample;
import com.neuedu.crm.bean.User;

/**
 * Service层：服务管理
 * @author Mechan
 *
 */
public interface ServiceService {
	
	/**
	 * 查看所有服务
	 * @return
	 */
	List<Service> selectAll();
	
	/**
	 * 查询所有未分配服务(主管操作)
	 * @param userList(主管负责的员工)
	 * @return
	 */
	List<Service> selectNotAssign( List<User> userList );
	
	/**
	 * 按主键查询服务
	 * @param id(服务记录id)
	 * @return
	 */
	Service selectById( Integer id );
	
	/**
	 * 实例查询，分页查询
	 * @param example(查询条件)
	 * @return
	 */
	List<Service> selectByExamplePager( ServiceExample example );
	
	/**
	 * 创建服务
	 * @param record(新服务记录)
	 * @return
	 */
	Map<String, Object> createService( Integer userId, Service newService );
	
	/**
	 * 更新记录
	 * @param record(新服务记录)
	 * @return
	 */
	int updateService( Service record );
	
	/**
	 * 分配服务
	 * @return
	 */
	void assignService();
	
	/**
	 * 处理服务
	 * @return
	 */
	void handleService();
	
	/**
	 * 经理操作：客户反馈
	 * @return
	 */
	Map<String, Object> feedbackService( Service newService );
	
	/**
	 * 服务归档
	 * @return
	 */
	void terminateService();	
	
	/**
	 * 经理操作：查看自己创建或处理的服务
	 * @param page(第几页)，rows(每页记录数)，userId(用户id)
	 * @return
	 */
	PageInfo<Service> employeesServices( Integer page, Integer rows, Integer userId );
	
	/**
	 * 经理操作：查看自己能处理的服务
	 */
	PageInfo<Service> handleList(  Integer page, Integer limit, HttpSession session, String param );

	/**
	 * 经理操作：查看自己能填写反馈的服务
	 */
	PageInfo<Service> feedbackList( Integer page, Integer limit, HttpSession session, String param );
	
	/**
	 * 经理操作：查看自己处理成功或失败的服务记录
	 */
	PageInfo<Service> archiveList( Integer page, Integer limit, HttpSession session, String param );

	/**
	 * 主管操作：查看自己能分配的服务
	 */
	PageInfo<Service> assignList( Integer page, Integer limit, HttpSession session, String param );

	/**
	 * 主管操作：查看自己的员工创建的服务
	 * @param page(第几页)，rows(每页记录数)，userList(员工列表)
	 * @return
	 */
	PageInfo<Service> directorsServices( Integer page, Integer rows, List<User> userList );
	
	/**
	 * 经理操作：请求将服务交给主管，由主管分配给其他经理
	 * @param Service newService
	 * @return
	 */
	Map<String, Object> reqForAssignService( Service newService );
		
	/**
	 * 主管操作：分配服务
	 * @return
	 */
	Map<String, Object> assignService( Service newService );
	
	
	/**
	 * 主管操作：对处理失败的服务进行再分配
	 * @param Service se
	 * @return
	 */
	Map<String, Object> reAssignService( Integer userId, Service se );
	
	/**
	 * 主管操作：查询服务类型占比
	 * @return
	 */
	public List<AmountOne> selectAllServiceTypeForm();
	
	/**
	 * 主管操作：查询服务类型占比
	 * @return
	 */
	public List<AmountTwo> selectAllServiceSatisfactionForm();
	
	/**
	 * 主管操作：查询状态占比
	 * @return
	 */
	public List<AmountTwo> selectAllServiceStatusForm();
}
