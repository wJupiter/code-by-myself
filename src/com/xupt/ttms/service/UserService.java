package com.xupt.ttms.service;

import com.xupt.ttms.vo.EmployeeInfo;

/**
 * @desc �û�ҵ���߼��ӿ�  
 * @author WangFeng 
 * @date 2017��5��26�� ����9:50:33 
 * @version 1.0 
 */
public interface UserService {

	/**
	 * �����û�����ѯ�û�
	 * @param account
	 * @return UserInfo
	 */
	EmployeeInfo getInfoByAccount(String account);
	
}
