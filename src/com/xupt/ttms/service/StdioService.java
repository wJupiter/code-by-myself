package com.xupt.ttms.service;

import java.util.List;

import com.xupt.ttms.vo.StdioInfo;

/**
 * @author WangFeng 
 * @date 2017年5月31日 下午2:19:10 
 * @version 1.0 
 */
public interface StdioService {

	/**
	 * 添加演出厅
	 * @param stdioInfo
	 * @return
	 */
	int addStdio(StdioInfo stdioInfo);

	/**
	 * 获取演出厅列表
	 * @return
	 */
	List<StdioInfo> getStdioList();

	/**
	 * 根据演出厅Id获取演出厅
	 * @param stdId
	 * @return
	 */
	StdioInfo getStdioInfoById(Integer stdId);
	
	/**
	 * 修改演出厅
	 * @param stdioInfo
	 * @return
	 */
	int updateStdio(StdioInfo stdioInfo);
	
	/**
	 * 删除演出厅
	 * @param stdId
	 * @return
	 */
	int deleteStdio(Integer stdId);
	
}
