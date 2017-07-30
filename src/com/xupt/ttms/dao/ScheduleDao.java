package com.xupt.ttms.dao;

import java.sql.SQLException;
import java.util.List;

import com.xupt.ttms.vo.ScheduleInfo;

/**
 * @author WangFeng 
 * @date 2017年6月3日 下午10:30:25 
 * @version 1.0 
 */

public interface ScheduleDao {

	/**
	 * 添加演出计划
	 * @param schedule
	 * @return
	 */
	int addSchedule(ScheduleInfo schedule) throws SQLException;

	/**
	 * 获取演出计划列表
	 * @return
	 */
	List<ScheduleInfo> getScheduleList() throws SQLException;

	/**
	 * 修改演出计划
	 * @param schedule
	 * @return
	 */
	int updateSchedule(ScheduleInfo schedule) throws SQLException;

	/**
	 * @param scheId
	 * @return
	 */
	int deleteSchedule(int scheId) throws SQLException;

	/**
	 * @param playId
	 * @return
	 */
	List<ScheduleInfo> searchSchedule(Integer playId) throws SQLException;

	/**
	 * @param scheId
	 * @return
	 */
	ScheduleInfo getScheduleById(Integer scheId) throws SQLException;

	/**
	 * @return
	 */
	List<ScheduleInfo> searchSchedule2() throws SQLException;

}
