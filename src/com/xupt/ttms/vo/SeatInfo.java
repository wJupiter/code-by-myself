package com.xupt.ttms.vo;

/**
 * @author WangFeng
 * @date 2017年6月5日 上午12:47:13
 * @version 1.0
 */
public class SeatInfo {
	
	private Integer seatId;
	private Integer seatRow;
	private Integer seatCol;
	private Integer seatStatus;
	private Integer stdioId;
	private StdioInfo stdioInfo;

	public Integer getSeatId() {
		return seatId;
	}

	public void setSeatId(Integer seatId) {
		this.seatId = seatId;
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

	public Integer getSeatStatus() {
		return seatStatus;
	}

	public void setSeatStatus(Integer seatStatus) {
		this.seatStatus = seatStatus;
	}

	public Integer getStdioId() {
		return stdioId;
	}

	public void setStdioId(Integer stdioId) {
		this.stdioId = stdioId;
	}

	public StdioInfo getStdioInfo() {
		return stdioInfo;
	}

	public void setStdioInfo(StdioInfo stdioInfo) {
		this.stdioInfo = stdioInfo;
	}

}
