package com.xupt.ttms.vo;

/**
 * @author WangFeng
 * @date 2017年6月5日 下午1:27:26
 * @version 1.0
 */
public class TicketInfo {

	private Integer ticketId;
	private Integer scheId;
	private Integer seatRow;
	private Integer seatCol;
	private Float ticketPrice;
	private Integer ticketStatus;
	private Integer saleId;
	
	private ScheduleInfo sechduleInfo;
	private SaleInfo saleInfo;

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public Integer getScheId() {
		return scheId;
	}

	public void setScheId(Integer schedId) {
		this.scheId = schedId;
	}

	public Integer getSeatRow() {
		return seatRow;
	}

	public void setSeatRow(Integer seatRow) {
		this.seatRow = seatRow;
	}

	public Integer getSeatCol() {
		return seatCol;
	}

	public void setSeatCol(Integer seatCol) {
		this.seatCol = seatCol;
	}

	public void setTicketPrice(Float ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Float getTicketPrice() {
		return ticketPrice;
	}

	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	public Integer getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(Integer ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public ScheduleInfo getSechduleInfo() {
		return sechduleInfo;
	}

	public void setSechduleInfo(ScheduleInfo sechduleInfo) {
		this.sechduleInfo = sechduleInfo;
	}

	public SaleInfo getSaleInfo() {
		return saleInfo;
	}

	public void setSaleInfo(SaleInfo saleInfo) {
		this.saleInfo = saleInfo;
	}
	 
}
