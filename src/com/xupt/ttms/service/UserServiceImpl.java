package com.xupt.ttms.service;

import java.sql.SQLException;
import javax.annotation.Resource;
import com.xupt.ttms.dao.UserDao;
import com.xupt.ttms.vo.EmployeeInfo;

/**
 * @desc  
 * @author WangFeng 
 * @date 2017年5月26日 下午9:52:12 
 * @version 1.0 
 */

public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;
	
	@Override
	public EmployeeInfo getInfoByAccount(String account) {
		EmployeeInfo info = null;
		try {
			info = this.userDao.getInfoByAccount(account);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}
}
