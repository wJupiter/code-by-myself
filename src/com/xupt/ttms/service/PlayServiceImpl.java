package com.xupt.ttms.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.xupt.ttms.common.Constants;
import com.xupt.ttms.dao.PlayDao;
import com.xupt.ttms.vo.PlayInfo;

/**
 * @author WangFeng 
 * @date 2017年6月1日 下午2:53:25 
 * @version 1.0 
 */
public class PlayServiceImpl implements PlayService {

	@Resource
	private PlayDao playDao;
	
	@Override
	public int savePlay(PlayInfo playInfo) {
		int count = 0;
		try {
			count = this.playDao.savePlay(playInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<PlayInfo> getPlayList() {
		List<PlayInfo> list = null;
		try {
			list = this.playDao.getPlayList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public PlayInfo getPlayById(Integer playId) {
		PlayInfo info = null;
		try {
			info = this.playDao.getPlayById(playId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public int updatePlay(PlayInfo playInfo) {
		int count = 0;
		try {
			count = this.playDao.updatePlay(playInfo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deletePlay(Integer playId) {
		int count = 0;
		try {
			count = this.playDao.deletePlay(playId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int getPageCount(Map<String, Object> condition) {
		int count = 0;
		try {
			count = this.playDao.getPlayCount(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (count + Constants.PLAY_PAGE_SIZE - 1) / Constants.PLAY_PAGE_SIZE;
	}

	@Override
	public List<PlayInfo> searchPlay(Map<String, Object> condition, int pageNum) {
		
		int startRow = (pageNum - 1) * Constants.PLAY_PAGE_SIZE;
		int pageSize = Constants.PLAY_PAGE_SIZE;
		condition.put("startRow", startRow);
		condition.put("pageSize", pageSize);
		
		List<PlayInfo> playList = null;
		try {
			playList = this.playDao.searchPlayByPage(condition);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playList;
	}
	
	@Override
	public int savaImagePath(String path) {
		int count = 0;
		try {
			count = this.playDao.updateAllImage(path);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	
}
