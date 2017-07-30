package com.xupt.ttms.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import com.xupt.ttms.dao.SeatDao;
import com.xupt.ttms.vo.SeatInfo;

/**
 * @author WangFeng 
 * @date 2017年6月5日 上午1:14:21 
 * @version 1.0 
 */
public class SeatServiceImpl implements SeatService{

	@Resource
	private SeatDao seatDao;
	
	@Override
	public int addSeat(SeatInfo seatInfo) {
		int count = 0; 
		try {
			count =	this.seatDao.addSeat(seatInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteSeat(SeatInfo seatInfo) {
		int count = 0; 
		try {
			count =	this.seatDao.deleteSeat(seatInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<SeatInfo> getSeatList(Integer stdioId) {
		List<SeatInfo> seatInfo = null;
		try {
			seatInfo = this.seatDao.getSeatList(stdioId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return seatInfo;
	}

}
