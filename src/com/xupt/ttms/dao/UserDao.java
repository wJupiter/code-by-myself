package com.xupt.ttms.dao;

import java.sql.SQLException;

import com.xupt.ttms.vo.EmployeeInfo;
/**
 * @desc  
 * @author WangFeng 
 * @date 2017��5��26�� ����10:08:33 
 * @version 1.0 
 */

public interface UserDao {
	
	/**
	 * @param account
	 * @return 
	 */
	EmployeeInfo getInfoByAccount(String account) throws SQLException;
	
}
