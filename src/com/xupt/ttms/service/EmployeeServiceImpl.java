package com.xupt.ttms.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.xupt.ttms.common.Constants;
import com.xupt.ttms.dao.EmployeeDao;
import com.xupt.ttms.vo.EmployeeInfo;

/**
 * @author WangFeng 
 * @date 2017年5月27日 下午3:54:59 
 * @version 1.0 
 */
public class EmployeeServiceImpl implements EmployeeService {
	
	@Resource
	private EmployeeDao employeeDao;
	
	@Override
	public List<EmployeeInfo> getEmployeeList() {
		List<EmployeeInfo> list = null;
		try {
			list = this.employeeDao.getEmployeeList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public EmployeeInfo getInfoById(Integer empId) {
		EmployeeInfo info = null;
		try {
			info = this.employeeDao.getInfoById(empId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public int saveInfo(EmployeeInfo info) {
		int count = 0;
		try {
			count = this.employeeDao.saveInfo(info);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateInfo(EmployeeInfo info) {
		int count = 0;
		try {
			count = this.employeeDao.updateInfo(info);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public int updateInfo1(EmployeeInfo info) {
		int count = 0;
		try {
			count = this.employeeDao.updateInfo1(info);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int batchDelete(List empIds) {
		int count = 0;
		try {
			count = this.employeeDao.batchDelete(empIds);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<EmployeeInfo> search(Map<String, Object> condation, int pageNum) {
		List<EmployeeInfo> empList = null;
		// 分页查询的起始行和当前页要显示的行数
		condation.put("startRowNum", (pageNum - 1) * Constants.EMP_PAGE_SIZE);
		condation.put("PageSize", Constants.EMP_PAGE_SIZE);
		
		try {
			empList = (List<EmployeeInfo>) this.employeeDao.search(condation);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}

	@Override
	public int getPageCount(Map<String, Object> condation) {
		int recordCount = 0;
		try {
			recordCount = this.employeeDao.getPageCount(condation);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (recordCount + Constants.EMP_PAGE_SIZE - 1) / Constants.EMP_PAGE_SIZE;
	}

	@Override
	public int savaFileName(String fileName) {
		int count = 0;
		try {
			count = this.employeeDao.savefileName(fileName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteEmp(Integer empId) {
		int count = 0;
		try {
			count = this.employeeDao.deleteEmp(empId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
}
