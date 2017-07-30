package com.xupt.ttms.service;

import java.util.List;

import com.xupt.ttms.vo.SaleInfo;
import com.xupt.ttms.vo.TicketInfo;

/**
 * @author WangFeng 
 * @date 2017��6��5�� ����4:34:02 
 * @version 1.0 
 */
public interface TicketService {

	/**
	 * �����ݳ��ƻ���ţ��鿴��Ӧ����Ʊ���
	 * @param scheId
	 * @param startTime
	 * @return
	 */
	List<TicketInfo> searchTicket(Integer scheId);

	/**
	 * ��������
	 * @param saleInfo
	 */
	int createSale(SaleInfo saleInfo);
	
	
	/**
	 * ����Ʊ
	 * @param ticketList
	 * @return
	 */
	int createTicket(List<TicketInfo> ticketList);
	
	/**
	 * ��Ʊ
	 * @param scheId
	 * @param startTime
	 */
	int backTicket(Integer saleId);
	
	/**
	 * ��Ʊ���޸Ķ���״̬
	 * @param saleId
	 * @return
	 */
	int backSale(Integer saleId);
}

