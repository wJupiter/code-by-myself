package com.xupt.ttms.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.xupt.ttms.vo.PlayInfo;

/**
 * @author WangFeng 
 * @date 2017年6月1日 下午2:55:06 
 * @version 1.0 
 */
public interface PlayDao {

	/**
	 * 添加影片
	 * @param playInfo
	 * @return
	 */
	int savePlay(PlayInfo playInfo) throws SQLException;
	
	/**
	 * 修改影片信息
	 * @param playInfo
	 * @return
	 * @throws SQLException
	 */
	int updatePlay(PlayInfo playInfo) throws SQLException;
	
	/**
	 * 初始化影片海报
	 * @param map
	 * @return int
	 * @throws SQLException
	 */
	int updateAllImage(String imagePath) throws SQLException;
	
	/**
	 * 修改对应影片的海报
	 * @param playId
	 * @return int
	 * @throws SQLException
	 */
	int updatePlayImageById(Integer playId) throws SQLException;
	
	/**
	 * 获得所有影片信息
	 * @return List<PlayInfo>
	 * @throws SQLException
	 */
	List<PlayInfo> getPlayList() throws SQLException;
	
	/**
	 * 根据影片编号查询影片信息 
	 * @param playId
	 * @return PlayInfo
	 * @throws SQLException
	 */
	PlayInfo getPlayById(Integer playId) throws SQLException;
	
	/**
	 * 影片批量下架
	 * @param playIds
	 * @return int
	 * @throws SQLException
	 */
	int deleteBatch(List<Integer> playIds) throws SQLException;
	
	/**
	 * 根据条件分页检索
	 * @param condition
	 * @return List<PlayInfo>
	 * @throws SQLException
	 */
	List<PlayInfo> searchPlayByPage(Map<String, Object> condition) throws SQLException;
	
	/**
	 * 返回对应条件下的总数
	 * @param condition
	 * @return int
	 * @throws SQLException
	 */
	int getPlayCount(Map<String, Object> condition) throws SQLException;

	/**
	 * 影片下架
	 * @param playId
	 * @return
	 */
	int deletePlay(Integer playId) throws SQLException;
}
