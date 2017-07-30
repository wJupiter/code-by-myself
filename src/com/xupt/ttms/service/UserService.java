package com.xupt.ttms.service;

import com.xupt.ttms.vo.EmployeeInfo;

/**
 * @desc 用户业务逻辑接口  
 * @author WangFeng 
 * @date 2017年5月26日 下午9:50:33 
 * @version 1.0 
 */
public interface UserService {

	/**
	 * 根据用户名查询用户
	 * @param account
	 * @return UserInfo
	 */
	EmployeeInfo getInfoByAccount(String account);
	
}
