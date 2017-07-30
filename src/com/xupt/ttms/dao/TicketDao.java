package com.xupt.ttms.dao;

import java.sql.SQLException;
import java.util.List;

import com.xupt.ttms.vo.SaleInfo;
import com.xupt.ttms.vo.TicketInfo;

/**
 * @author WangFeng 
 * @date 2017年6月5日 下午4:41:29 
 * @version 1.0 
 */
public interface TicketDao {

	/**
	 * @param condition
	 * @return 
	 */
	List<TicketInfo> searchTicket(Integer schedId) throws SQLException;

	/**
	 * @param saleInfo
	 * @return
	 */
	int createSale(SaleInfo saleInfo) throws SQLException;

	/**
	 * @param ticketList
	 * @return
	 */
	int createTicket(List<TicketInfo> ticketList) throws SQLException;

	/**
	 * @param saleId
	 * @return
	 */
	int backTicket(Integer saleId) throws SQLException;

	/**
	 * 修改订单状态
	 * @param saleId
	 * @return
	 */
	int backSale(Integer saleId) throws SQLException;
	
}
