package com.xupt.ttms.service;

import java.util.List;
import java.util.Map;

import com.xupt.ttms.vo.PlayInfo;

/**
 * @author WangFeng 
 * @date 2017年6月1日 下午2:46:23 
 * @version 1.0 
 */
public interface PlayService {

	/**
	 * @param playInfo
	 */
	int savePlay(PlayInfo playInfo);

	/**
	 * @return
	 */
	List<PlayInfo> getPlayList();

	/**
	 * @param playId
	 * @return
	 */
	PlayInfo getPlayById(Integer playId);

	/**
	 * @param playInfo
	 * @return
	 */
	int updatePlay(PlayInfo playInfo);

	/**
	 * @param playId
	 */
	int deletePlay(Integer playId);

	/**
	 * @param condition
	 * @return
	 */
	int getPageCount(Map<String, Object> condition);

	/**
	 * @param condition
	 * @param pageNum
	 * @return
	 */
	List<PlayInfo> searchPlay(Map<String, Object> condition, int pageNum);

	/**
	 * @param path
	 * @return
	 */
	int savaImagePath(String path);

}
