package com.neuedu.crm.service;

import java.text.ParseException;
import java.util.List;
import java.util.Set;

import com.github.pagehelper.PageInfo;
import com.neuedu.crm.bean.User;

/**
 * 
 * @author Administrator
 *
 */
public interface UserService {
	
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	public int registerUser(User user);
	
	/**
	 * 用户登录,查询是否存在这个用户，如果list>0;这登录成功；
	 * example表示及可以是用户名，也可以是邮箱；
	 * @return
	 */
	public List<User> selectUser(String example,String password);
	
	/**
	 * 登陆检验，查找用户是否存在
	 * @param account
	 * @param password
	 * @return
	 */
	public User loginValidate(String account , String password);
	/**
	 * 根据用户名，精确查询这个实体，用于获取到他的id
	 * @return
	 */
	public User selectByName(String username);
	
	/**
	 * 不带条件查询所有用户
	 * @return
	 */
	public List<User> selectAllsUser();
	
	/**
	 * 根据主键查询用户
	 */
	public User selectById( Integer id );
	
	/**
	 * 查询用户的直接下级
	 */
	public List<User> selectDirectLower( User user );
	
	/**
	 * 查询用户的直接下级(使用上级Id)
	 */
	public List<User> selectDirectLowerById( Integer userId );
	

    


    /**
     * 计算用户登陆时的hashCode
     * @param account
     * @param password
     * @return
     */
	String getHashCode(String account, String password);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	public int alterUserInfo(User user);
	
	/**
	 * 管理员修改用户信息
	 * @param user
	 * @return
	 */
	public int updataUserInfo(User user);
    
	/**
	 * 用户列表的多条件模糊查询分页
	 * @param param
	 * @param page
	 * @param rows
	 * @return
	 * @throws ParseException
	 */
	public PageInfo<User> findAllUsersByPages(String param, int page , int rows) throws ParseException;
	
	/**  ------     chen     ------  **/
	/**
	 * 查出所有经理
	 * @return
	 */
	public List<User> selectManagers();
	
	/**
	 * 查询所有主管
	 * @return
	 */
	public List<User> selectDirs();
	
	/**
	 * 显示所有创建者
	 * @return
	 */
	public List<User> selectAllCreator();
	
	/**
	 * 修改密码
	 * @return
	 */
	public int alterPassword(User user);
	
	/**
	 * 根据用户名或邮箱或手机查找用户
	 * @param Param
	 * @return
	 */
	public User selectUserByParam(String Param);
	
	
}
