package com.xupt.ttms.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xupt.ttms.service.TicketService;
import com.xupt.ttms.vo.SaleInfo;
import com.xupt.ttms.vo.TicketInfo;

/**
 * @author WangFeng
 * @date 2017年6月6日 下午8:56:03
 * @version 1.0
 */
public class TicketTest {

	private static ApplicationContext ctx = null;

	static {
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext-*.xml");
	}

	@Test
	public void testCreateTicket2() {

		TicketService ticketService = (TicketService) ctx.getBean("ticketService");
		SaleInfo saleInfo = new SaleInfo();
		saleInfo.setEmpId(2);
		saleInfo.setPriceSum((float) 119.2);
		int count = ticketService.createSale(saleInfo);
		// 订单生成成功，生成票
		if (count > 0) {
			System.out.println("订单生成成功！" + "编号为：" + saleInfo.getSaleId());
			List<TicketInfo> ticketList = new ArrayList<TicketInfo>();
			Integer seatRow[] = new Integer[] { 7, 7, 7 };
			Integer seatCol[] = new Integer[] { 4, 5, 6 };
			for (int i = 0; i < seatCol.length; i++) {
				TicketInfo ticketInfo = new TicketInfo();
				ticketInfo.setScheId(10);
				ticketInfo.setSeatRow(seatRow[i]);
				ticketInfo.setSeatCol(seatCol[i]);
				ticketInfo.setTicketPrice((float) 29.8);
				ticketInfo.setSaleId(saleInfo.getSaleId());
				ticketList.add(ticketInfo);
			}
			int count2 = ticketService.createTicket(ticketList);
			System.out.println(count2 + "===========================");
			if (count2 > 0) {
				System.out.println("生成" + count2 + "张票成功！并关联了订单！");
			}
		}
	}

	@Test
	public void testCreateSale() {
		TicketService ticketService = (TicketService) ctx.getBean("ticketService");
		SaleInfo saleInfo = new SaleInfo();
		saleInfo.setEmpId(2);
		saleInfo.setPriceSum((float) 119.2);
		int count = ticketService.createSale(saleInfo);
		if (count > 0) {
			System.out.println("订单生成成功！" + "编号为：" + saleInfo.getSaleId());
		}
	}

	@Test
	public void testSearchTicket() {
		TicketService ticketService = (TicketService) ctx.getBean("ticketService");
		List<TicketInfo> ticketList = ticketService.searchTicket(10);
		for (TicketInfo ticketInfo : ticketList) {
			System.out.println(ticketInfo.getSeatRow() + "行," + ticketInfo.getSeatCol() + ",列");
		}
	}

	@Test
	public void testbackTicket() {
		TicketService ticketService = (TicketService) ctx.getBean("ticketService");
		int saleId = 1;
		int count = ticketService.backTicket(saleId);
		if(count > 0){
			System.out.println(saleId + "号订单成功退票，退票" + count + "张！");
			count = ticketService.backSale(saleId);
			if(count > 0){
				System.out.println(saleId + "号订单被退票！");
			}
		}
	}
}
