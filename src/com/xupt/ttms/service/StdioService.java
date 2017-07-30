package com.xupt.ttms.service;

import java.util.List;

import com.xupt.ttms.vo.StdioInfo;

/**
 * @author WangFeng 
 * @date 2017��5��31�� ����2:19:10 
 * @version 1.0 
 */
public interface StdioService {

	/**
	 * ����ݳ���
	 * @param stdioInfo
	 * @return
	 */
	int addStdio(StdioInfo stdioInfo);

	/**
	 * ��ȡ�ݳ����б�
	 * @return
	 */
	List<StdioInfo> getStdioList();

	/**
	 * �����ݳ���Id��ȡ�ݳ���
	 * @param stdId
	 * @return
	 */
	StdioInfo getStdioInfoById(Integer stdId);
	
	/**
	 * �޸��ݳ���
	 * @param stdioInfo
	 * @return
	 */
	int updateStdio(StdioInfo stdioInfo);
	
	/**
	 * ɾ���ݳ���
	 * @param stdId
	 * @return
	 */
	int deleteStdio(Integer stdId);
	
}
