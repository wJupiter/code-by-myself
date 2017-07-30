package com.xupt.ttms.service;

import java.util.List;

import com.xupt.ttms.vo.SaleInfo;
import com.xupt.ttms.vo.TicketInfo;

/**
 * @author WangFeng 
 * @date 2017年6月5日 下午4:34:02 
 * @version 1.0 
 */
public interface TicketService {

	/**
	 * 根据演出计划编号，查看对应的售票情况
	 * @param scheId
	 * @param startTime
	 * @return
	 */
	List<TicketInfo> searchTicket(Integer scheId);

	/**
	 * 创建订单
	 * @param saleInfo
	 */
	int createSale(SaleInfo saleInfo);
	
	
	/**
	 * 生成票
	 * @param ticketList
	 * @return
	 */
	int createTicket(List<TicketInfo> ticketList);
	
	/**
	 * 退票
	 * @param scheId
	 * @param startTime
	 */
	int backTicket(Integer saleId);
	
	/**
	 * 退票是修改订单状态
	 * @param saleId
	 * @return
	 */
	int backSale(Integer saleId);
}

