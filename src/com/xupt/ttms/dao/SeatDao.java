package com.xupt.ttms.dao;

import java.sql.SQLException;
import java.util.List;

import com.xupt.ttms.vo.SeatInfo;

/**
 * @author WangFeng 
 * @date 2017��6��5�� ����1:16:58 
 * @version 1.0 
 */
public interface SeatDao {

	/**
	 * @param seatInfo
	 * @return
	 * @throws SQLException
	 */
	int addSeat(SeatInfo seatInfo) throws SQLException;
	
	/**
	 * @param seatInfo
	 * @return
	 * @throws SQLException
	 */
	int deleteSeat(SeatInfo seatInfo) throws SQLException;
	
	/**
	 * @param stdioId
	 * @return
	 * @throws SQLException
	 */
	List<SeatInfo> getSeatList(Integer stdioId) throws SQLException; 	
}
