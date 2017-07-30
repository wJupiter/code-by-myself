package com.xupt.ttms.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xupt.ttms.vo.EmployeeInfo;

/**
 * @author WangFeng 
 * @date 2017年5月27日 下午3:53:09 
 * @version 1.0 
 */
public interface EmployeeService {
	
	/**
	 * 获取所有员工信息
	 * @return 
	 * @throws SQLException
	 */
	List<EmployeeInfo> getEmployeeList();
	
	/**
	 * 根据员工Id查询员工信息
	 * @param empId
	 * @return
	 * @throws SQLException
	 */
	EmployeeInfo getInfoById(Integer empId);
	
	/**
	 * 添加员工信息
	 * @param info
	 * @return
	 * @throws SQLException
	 */
	int saveInfo(EmployeeInfo info);
	
	/**
	 * 修改员工信息
	 * @param info
	 * @return
	 * @throws SQLException
	 */
	int updateInfo(EmployeeInfo info); 
	int updateInfo1(EmployeeInfo info); 
	/**
	 * 批量删除员工信息
	 * @param empIds
	 * @return
	 */
	int batchDelete(List empIds);

	/**
	 * 分页查询
	 * @param condation
	 * @param i
	 * @return
	 */
	List<EmployeeInfo> search(Map<String, Object> condation, int pageNum);

	/**
	 * 获取总页数
	 * @param condation 
	 * @return
	 */
	int getPageCount(Map<String, Object> condation);

	/**
	 * @param fileName
	 */
	int savaFileName(String fileName);
	
	/**
	 * @param empId
	 * @return
	 */
	int deleteEmp(Integer empId);
	
}
