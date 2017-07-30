package com.xupt.ttms.vo;

/**
 * @author WangFeng
 * @date 2017年6月3日 下午12:22:51
 * @version 1.0
 */

public class ScheduleInfo {
	
	private Integer scheId;
	private Integer stdioId;
	private Integer playId;
	private String scheStartTime;
	private String scheEndTime;

	private Integer scheStatus;
	private StdioInfo stdioInfo;
	private PlayInfo playInfo;

	public Integer getScheId() {
		return scheId;
	}

	public void setScheId(Integer scheId) {
		this.scheId = scheId;
	}

	public Integer getStdioId() {
		return stdioId;
	}

	public void setStdioId(Integer stdioId) {
		this.stdioId = stdioId;
	}

	public Integer getPlayId() {
		return playId;
	}

	public void setPlayId(Integer playId) {
		this.playId = playId;
	}

	public String getScheStartTime() {
		return scheStartTime;
	}

	public void setScheStartTime(String scheStartTime) {
		this.scheStartTime = scheStartTime;
	}

	public String getScheEndTime() {
		return scheEndTime;
	}

	public void setScheEndTime(String scheEndTime) {
		this.scheEndTime = scheEndTime;
	}

	public Integer getScheStatus() {
		return scheStatus;
	}

	public void setScheStatus(Integer scheStatus) {
		this.scheStatus = scheStatus;
	}

	public StdioInfo getStdioInfo() {
		return stdioInfo;
	}

	public void setStdioInfo(StdioInfo stdioInfo) {
		this.stdioInfo = stdioInfo;
	}

	public PlayInfo getPlayInfo() {
		return playInfo;
	}

	public void setPlayInfo(PlayInfo playInfo) {
		this.playInfo = playInfo;
	}

	@Override
	public String toString() {
		return "ScheduleInfo [scheId=" + scheId + ", stdioId=" + stdioId + ", playId=" + playId + ", scheStartTime="
				+ scheStartTime + ", scheEndTime=" + scheEndTime + ", scheStatus=" + scheStatus + ", stdInfo=" + stdioInfo
				+ ", playInfo=" + playInfo + "]";
	}
}
