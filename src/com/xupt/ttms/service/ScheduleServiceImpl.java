package com.xupt.ttms.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import com.xupt.ttms.dao.ScheduleDao;
import com.xupt.ttms.vo.ScheduleInfo;

/**
 * @author WangFeng 
 * @date 2017年6月3日 下午10:20:12 
 * @version 1.0 
 */
public class ScheduleServiceImpl implements ScheduleService {
	
	@Resource
	private ScheduleDao scheduleDao; 
	
	@Override
	public int addSchedule(ScheduleInfo schedule) {
		int count = 0; 
		try {
			count = this.scheduleDao.addSchedule(schedule);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public List<ScheduleInfo> getScheduleList() {
		List<ScheduleInfo> scheList = null;
		try {
			scheList = this.scheduleDao.getScheduleList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scheList;
	}
	
	@Override
	public int updateSchedule(ScheduleInfo schedule) {
		int count = 0;
		try {
			count = this.scheduleDao.updateSchedule(schedule);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public int deleteSchedule(int scheId) {
		int count = 0;
		try {
			count = this.scheduleDao.deleteSchedule(scheId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<ScheduleInfo> searchSchedule(Integer playId) {
		List<ScheduleInfo> scheList = null;
		try {
			scheList = this.scheduleDao.searchSchedule(playId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scheList;
	}

	@Override
	public ScheduleInfo getScheduleById(Integer scheId) {
		ScheduleInfo scheInfo = null; 
		try {
			scheInfo = this.scheduleDao.getScheduleById(scheId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scheInfo;
	}

	@Override
	public List<ScheduleInfo> searchSchedule2() {
		List<ScheduleInfo> scheList = null;
		try {
			scheList = this.scheduleDao.searchSchedule2();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scheList;
	}
}
