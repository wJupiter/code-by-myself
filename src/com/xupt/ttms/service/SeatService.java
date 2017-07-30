package com.xupt.ttms.service;

import java.util.List;

import com.xupt.ttms.vo.SeatInfo;

/**
 * @author WangFeng 
 * @date 2017年6月5日 上午1:13:51 
 * @version 1.0 
 */
public interface SeatService {

	/**
	 * @param seatInfo
	 * @return
	 */
	int addSeat(SeatInfo seatInfo);
	
	/**
	 * @param seatInfo
	 * @return
	 */
	int deleteSeat(SeatInfo seatInfo);
		
	/**
	 * @param stdioId
	 * @return
	 */
	List<SeatInfo> getSeatList(Integer stdioId);

}
