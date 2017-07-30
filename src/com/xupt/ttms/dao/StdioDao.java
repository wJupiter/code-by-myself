package com.xupt.ttms.dao;

import java.sql.SQLException;
import java.util.List;

import com.xupt.ttms.vo.StdioInfo;

/**
 * @author WangFeng 
 * @date 2017��5��31�� ����2:22:29 
 * @version 1.0 
 */

public interface StdioDao {

	/**
	 * ����ݳ���
	 * @param stdioInfo
	 * @return
	 */
	int addStdio(StdioInfo stdioInfo) throws SQLException;

	/**
	 * ��ȡ�ݳ����б�
	 * @return
	 */
	List<StdioInfo> getStdioList() throws SQLException;

	/**
	 * ����Id�ݳ���
	 * @param stdId
	 * @return
	 */
	StdioInfo getStdioInfoById(Integer stdId) throws SQLException;

	/**
	 * �޸��ݳ�����Ϣ
	 * @param stdioInfo
	 * @return
	 */
	int updateStdio(StdioInfo stdioInfo) throws SQLException;

	/**
	 * ɾ���ݳ���
	 * @param stdId
	 * @return
	 */
	int deleteStdio(Integer stdId) throws SQLException;

}
