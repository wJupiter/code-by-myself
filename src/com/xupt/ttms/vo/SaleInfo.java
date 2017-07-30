package com.xupt.ttms.vo;

import java.util.Set;

/**
 * @author WangFeng
 * @date 2017年6月5日 下午1:27:40
 * @version 1.0
 */
public class SaleInfo {

	private Integer saleId;
	private Integer empId;
	private Float priceSum;
	private String saleTime;
	private Integer saleStatus;
	private Set<TicketInfo> ticketSet; 
	
	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Float getPriceSum() {
		return priceSum;
	}

	public void setPriceSum(Float priceSum) {
		this.priceSum = priceSum;
	}

	public String getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(String saleTime) {
		this.saleTime = saleTime;
	}

	public Integer getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(Integer saleStatus) {
		this.saleStatus = saleStatus;
	}

	public Set<TicketInfo> getTicketSet() {
		return ticketSet;
	}

	public void setTicketSet(Set<TicketInfo> ticketSet) {
		this.ticketSet = ticketSet;
	}
	
}
