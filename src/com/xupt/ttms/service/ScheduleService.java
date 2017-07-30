package com.xupt.ttms.service;

import java.util.List;

import com.xupt.ttms.vo.ScheduleInfo;

/**
 * @author WangFeng 
 * @date 2017年6月3日 下午10:13:23 
 * @version 1.0 
 */
public interface ScheduleService {

	/**
	 * @param schedule
	 */
	int addSchedule(ScheduleInfo schedule);

	/**
	 * @return
	 */
	List<ScheduleInfo> getScheduleList();

	/**
	 * @param schedule
	 * @return
	 */
	int updateSchedule(ScheduleInfo schedule);

	/**
	 * @param scheId
	 * @return
	 */
	int deleteSchedule(int scheId);

	/**
	 * @param playId
	 * @return
	 */
	List<ScheduleInfo> searchSchedule(Integer playId);

	/**
	 * @param scheId
	 * @return
	 */
	ScheduleInfo getScheduleById(Integer scheId);

	/**
	 * @return
	 */
	List<ScheduleInfo> searchSchedule2();
	
}
