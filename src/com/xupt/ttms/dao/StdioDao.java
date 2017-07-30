package com.xupt.ttms.dao;

import java.sql.SQLException;
import java.util.List;

import com.xupt.ttms.vo.StdioInfo;

/**
 * @author WangFeng 
 * @date 2017年5月31日 下午2:22:29 
 * @version 1.0 
 */

public interface StdioDao {

	/**
	 * 添加演出厅
	 * @param stdioInfo
	 * @return
	 */
	int addStdio(StdioInfo stdioInfo) throws SQLException;

	/**
	 * 获取演出厅列表
	 * @return
	 */
	List<StdioInfo> getStdioList() throws SQLException;

	/**
	 * 根据Id演出厅
	 * @param stdId
	 * @return
	 */
	StdioInfo getStdioInfoById(Integer stdId) throws SQLException;

	/**
	 * 修改演出厅信息
	 * @param stdioInfo
	 * @return
	 */
	int updateStdio(StdioInfo stdioInfo) throws SQLException;

	/**
	 * 删除演出厅
	 * @param stdId
	 * @return
	 */
	int deleteStdio(Integer stdId) throws SQLException;

}
