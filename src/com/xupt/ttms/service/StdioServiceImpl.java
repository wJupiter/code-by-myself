package com.xupt.ttms.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import com.xupt.ttms.dao.StdioDao;
import com.xupt.ttms.vo.StdioInfo;

/**
 * @author WangFeng 
 * @date 2017年5月31日 下午2:20:03 
 * @version 1.0 
 */

public class StdioServiceImpl implements StdioService {
	
	@Resource
	private StdioDao stdioDao;
		
	@Override
	public int addStdio(StdioInfo stdioInfo) {
		int count = 0;
		try {
			count = this.stdioDao.addStdio(stdioInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<StdioInfo> getStdioList() {
		List<StdioInfo> stdList = null;
		try {
			stdList = this.stdioDao.getStdioList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stdList;
	}

	@Override
	public StdioInfo getStdioInfoById(Integer stdId) {
		StdioInfo info = null;
		try {
			info = this.stdioDao.getStdioInfoById(stdId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public int updateStdio(StdioInfo stdioInfo) {
		int count = 0;
		try {
			count = this.stdioDao.updateStdio(stdioInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteStdio(Integer stdId) {
		int count = 0;
		try {
			count = this.stdioDao.deleteStdio(stdId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

}
