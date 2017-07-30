package com.xupt.ttms.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.xupt.ttms.dao.TicketDao;
import com.xupt.ttms.vo.SaleInfo;
import com.xupt.ttms.vo.TicketInfo;

/**
 * @author WangFeng
 * @date 2017年6月5日 下午4:40:06
 * @version 1.0
 */
public class TicketServiceImpl implements TicketService {

	@Resource
	private TicketDao ticketDao;

	@Override
	public List<TicketInfo> searchTicket(Integer scheId) {
		List<TicketInfo> ticketInfo = null;
		try {
			ticketInfo = this.ticketDao.searchTicket(scheId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ticketInfo;
	}
	
	@Override
	public int createSale(SaleInfo saleInfo) {
		int count = 0;
		try {
			count = this.ticketDao.createSale(saleInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public int createTicket(List<TicketInfo> ticketList) {
		int count = 0;
		try {
			count =	this.ticketDao.createTicket(ticketList);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int backTicket(Integer saleId) {
		int count = 0;
		try {
			count = this.ticketDao.backTicket(saleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public int backSale(Integer saleId) {
		int count = 0;
		try {
			count = this.ticketDao.backSale(saleId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
