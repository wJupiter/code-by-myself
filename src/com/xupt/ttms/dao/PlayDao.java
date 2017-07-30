package com.xupt.ttms.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xupt.ttms.vo.PlayInfo;

/**
 * @author WangFeng 
 * @date 2017��6��1�� ����2:55:06 
 * @version 1.0 
 */
public interface PlayDao {

	/**
	 * ���ӰƬ
	 * @param playInfo
	 * @return
	 */
	int savePlay(PlayInfo playInfo) throws SQLException;
	
	/**
	 * �޸�ӰƬ��Ϣ
	 * @param playInfo
	 * @return
	 * @throws SQLException
	 */
	int updatePlay(PlayInfo playInfo) throws SQLException;
	
	/**
	 * ��ʼ��ӰƬ����
	 * @param map
	 * @return int
	 * @throws SQLException
	 */
	int updateAllImage(String imagePath) throws SQLException;
	
	/**
	 * �޸Ķ�ӦӰƬ�ĺ���
	 * @param playId
	 * @return int
	 * @throws SQLException
	 */
	int updatePlayImageById(Integer playId) throws SQLException;
	
	/**
	 * �������ӰƬ��Ϣ
	 * @return List<PlayInfo>
	 * @throws SQLException
	 */
	List<PlayInfo> getPlayList() throws SQLException;
	
	/**
	 * ����ӰƬ��Ų�ѯӰƬ��Ϣ 
	 * @param playId
	 * @return PlayInfo
	 * @throws SQLException
	 */
	PlayInfo getPlayById(Integer playId) throws SQLException;
	
	/**
	 * ӰƬ�����¼�
	 * @param playIds
	 * @return int
	 * @throws SQLException
	 */
	int deleteBatch(List<Integer> playIds) throws SQLException;
	
	/**
	 * ����������ҳ����
	 * @param condition
	 * @return List<PlayInfo>
	 * @throws SQLException
	 */
	List<PlayInfo> searchPlayByPage(Map<String, Object> condition) throws SQLException;
	
	/**
	 * ���ض�Ӧ�����µ�����
	 * @param condition
	 * @return int
	 * @throws SQLException
	 */
	int getPlayCount(Map<String, Object> condition) throws SQLException;

	/**
	 * ӰƬ�¼�
	 * @param playId
	 * @return
	 */
	int deletePlay(Integer playId) throws SQLException;
}
