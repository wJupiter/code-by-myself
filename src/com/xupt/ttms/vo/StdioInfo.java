package com.xupt.ttms.vo;

/**
 * @author WangFeng
 * @date 2017年5月31日 下午1:17:16
 * @version 1.0
 */

public class StdioInfo {

	private Integer stdioId;
	private String stdioName;
	private Integer stdioRows;
	private Integer stdioCols;
	private String stdioType;
	private String stdioDesc;

	public Integer getStdioId() {
		return stdioId;
	}

	public void setStdioId(Integer stdioId) {
		this.stdioId = stdioId;
	}

	public String getStdioName() {
		return stdioName;
	}

	public void setStdioName(String stdioName) {
		this.stdioName = stdioName;
	}

	public Integer getStdioRows() {
		return stdioRows;
	}

	public void setStdioRows(Integer stdioRows) {
		this.stdioRows = stdioRows;
	}

	public Integer getStdioCols() {
		return stdioCols;
	}

	public void setStdioCols(Integer stdioCols) {
		this.stdioCols = stdioCols;
	}

	public String getStdioType() {
		return stdioType;
	}

	public void setStdioType(String stdioType) {
		this.stdioType = stdioType;
	}

	public String getStdioDesc() {
		return stdioDesc;
	}

	public void setStdioDesc(String stdioDesc) {
		this.stdioDesc = stdioDesc;
	}

	@Override
	public String toString() {
		return "StdioInfo [stdioId=" + stdioId + ", stdioName=" + stdioName + ", stdioRows=" + stdioRows
				+ ", stdioCols=" + stdioCols + ", stdioType=" + stdioType + ", stdioDesc=" + stdioDesc + "]";
	}
}
