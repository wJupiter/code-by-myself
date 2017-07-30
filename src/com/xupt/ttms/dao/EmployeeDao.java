package com.xupt.ttms.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xupt.ttms.vo.EmployeeInfo;

/**
 * @author WangFeng 
 * @date 2017年5月27日 上午10:21:30 
 * @version 1.0 
 */

public interface EmployeeDao {
	
	/**
	 * 获取所有员工信息
	 * @return 
	 * @throws SQLException
	 */
	List<EmployeeInfo> getEmployeeList() throws SQLException;
	
	/**
	 * 根据员工Id查询员工信息
	 * @param empId
	 * @return
	 * @throws SQLException
	 */
	EmployeeInfo getInfoById(Integer empId) throws SQLException;
	
	/**
	 * 添加员工信息
	 * @param info
	 * @return
	 * @throws SQLException
	 */
	int saveInfo(EmployeeInfo info) throws SQLException;
	
	/**
	 * 修改员工信息
	 * @param info
	 * @return
	 * @throws SQLException
	 */
	int updateInfo(EmployeeInfo info) throws SQLException; 
	int updateInfo1(EmployeeInfo info) throws SQLException; 
	/**
	 * 批量删除员工信息
	 * @param empIds
	 * @return
	 */
	int batchDelete(List<Integer> empIds) throws SQLException;

	/**
	 * 分页检索
	 * @param condation
	 * @return
	 */
	List<EmployeeInfo> search(Map<String, Object> condition) throws SQLException;

	/**
	 * @return
	 */
	int getPageCount(Map<String, Object> condition) throws SQLException;

	/**
	 * 上传文件，初始化用户头像
	 * @param fileName
	 * @return
	 */
	int savefileName(String fileName) throws SQLException;
	
	/**
	 * 员工自己修改头像
	 */
	int updateEmpPhoto(Map<String, Object> condition) throws SQLException;

	/**
	 * @param empId
	 * @return 
	 */
	int deleteEmp(Integer empId) throws SQLException;
}
