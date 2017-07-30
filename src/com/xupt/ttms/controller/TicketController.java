package com.xupt.ttms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xupt.ttms.service.TicketService;
import com.xupt.ttms.vo.SaleInfo;
import com.xupt.ttms.vo.TicketInfo;

/**
 * @author WangFeng 
 * @date 2017年6月5日 下午4:22:39 
 * @version 1.0 
 */

@RequestMapping(value="/ticket")
@Controller
public class TicketController {

	@Resource
	private TicketService ticketService;
	
	/**
	 * 生成订单
	 * @param priceSum
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/createSale", method = RequestMethod.POST)
	public String  createSale(HttpSession session, HttpServletRequest request, HttpServletResponse response){
		String msg = "";
		SaleInfo saleInfo = new SaleInfo();
		String money = request.getParameter("money");
		Float priceSum = Float.parseFloat(money);
		Integer empId = (Integer)session.getAttribute("empId");
		saleInfo.setEmpId(empId);
		saleInfo.setPriceSum(priceSum);
		int count = this.ticketService.createSale(saleInfo);
		//获取订单号
		int saleId = saleInfo.getSaleId();
		if(count > 0){
			msg += createTicket(session, request, saleId);
		} else {
			msg = "购票失败!";
		}
		return msg;
	}
	
	/**
	 * 生成票
	 * @return
	 */
	@RequestMapping(value="/createTicket", method = RequestMethod.POST)
	private String createTicket(HttpSession session, HttpServletRequest request, Integer saleId){
		int count = 0;
		String msg = "";
		List<TicketInfo> ticketList = new ArrayList<TicketInfo>();
		TicketInfo ticketInfo = null;
		
		String Rows = request.getParameter("row");
		String Cols = request.getParameter("col");
		
		String[] seatRows = Rows.trim().split(",");
		String[] seatCols = Cols.trim().split(",");
		
		Integer scheId = (Integer) session.getAttribute("scheId");
		Float ticketPrice = (Float) session.getAttribute("ticketPrice");
		
		for(int i = 0; i < seatRows.length; i++ ){
			ticketInfo = new TicketInfo();
			ticketInfo.setScheId(scheId);
			ticketInfo.setSeatRow(Integer.parseInt(seatRows[i]));
			ticketInfo.setSeatCol(Integer.parseInt(seatCols[i]));
			ticketInfo.setTicketPrice(ticketPrice);
			ticketInfo.setSaleId(saleId);
			ticketList.add(ticketInfo);
		}
		count =	this.ticketService.createTicket(ticketList);
		if(count > 0){
			msg = "成功购票" + count + "张！";
		} else {
			msg = "购票失败！";
		}
		return msg; 
	}
	
	/**
	 * 查询售票选座情况
	 * @param scheId
	 * @return
	 */
	@RequestMapping(value="/searchTicket", method = RequestMethod.GET)
	public ResponseEntity<List<TicketInfo>> searchTicket(Integer scheId){
		List<TicketInfo> ticketList = this.ticketService.searchTicket(scheId);
		for (TicketInfo ticketInfo : ticketList) {
			System.out.println(ticketInfo.getSeatRow() + "   " + ticketInfo.getSeatCol() + "     " + ticketInfo.getTicketStatus());
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		ResponseEntity<List<TicketInfo>> resp = new ResponseEntity<List<TicketInfo>>(ticketList, headers, HttpStatus.OK);
		return resp;
	}
	
	@RequestMapping(value = "/backTicket", method = RequestMethod.POST)
	public String backTicket(Integer saleId){
		String msg = null;
		int count = ticketService.backTicket(saleId);
		if(count > 0){
			int count2 = ticketService.backSale(saleId);
			if(count2 > 0){
				msg = saleId + "号订单成功退票，退票" + count + "张！";
			}
		}
		return msg;
	}
}
