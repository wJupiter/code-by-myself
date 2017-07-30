package com.xupt.ttms.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.xupt.ttms.common.Constants;
import com.xupt.ttms.common.Utils;
import com.xupt.ttms.service.PlayService;
import com.xupt.ttms.vo.PlayInfo;

/**
 * @author WangFeng
 * @date 2017��6��1�� ����2:13:32
 * @version 1.0
 */

@RequestMapping(value = "/play")
@Controller
public class PlayController {

	@Resource
	private PlayService playService;

	@RequestMapping(value = "/addPlay", method = RequestMethod.POST)
	public String addPlay(HttpServletRequest request, PlayInfo playInfo, ModelMap model) {
		// �����ļ��������ʱ·��
		File dir = new File(request.getServletContext().getRealPath("/playImage"));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		int count = 0;
		// �жϵ�ǰ�����ǲ��Ƕಿ�ֱ�������������������ת������ȡ�ϴ����ļ�
		if (request instanceof MultipartRequest) {
			MultipartRequest mr = (MultipartRequest) request;
			// ��ȡ�ϴ����ļ�
			MultipartFile mfile = mr.getFile("Image");
			// ���ļ�������ʱId
			String fileId = Utils.getFileId(mfile.getOriginalFilename());
			// Ŀ���ļ�
			File dest = new File(dir, fileId);
			// �ѵ�ǰ�ļ�ת��(�洢)��Ŀ���ļ�
			try {
				mfile.transferTo(dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String fileName = mfile.getOriginalFilename();
			String path = "/playImage/" + fileId;
			playInfo.setPlayImage(path);
			// �����ļ�Id��·�������ݿ���
			count = this.playService.savePlay(playInfo);
			if (count > 0) {
				model.put("msg", "��ӳɹ�!");
			} else {
				model.put("msg", "���ʧ��!");
			}
		}
		return "redirect:/play/playList";
	}

	@RequestMapping(value = "/updatePlay", method = RequestMethod.POST)
	public String updatePlay(HttpServletRequest request, PlayInfo playInfo, ModelMap model) {
		File dir = new File(request.getServletContext().getRealPath("/playImage"));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		int count = 0;
		// �жϵ�ǰ�����ǲ��Ƕಿ�ֱ�������������������ת������ȡ�ϴ����ļ�
		if (request instanceof MultipartRequest) {
			MultipartRequest mr = (MultipartRequest) request;
			// ��ȡ�ϴ����ļ�
			MultipartFile mfile = mr.getFile("Image");
			// ���ļ�������ʱId
			String fileId = Utils.getFileId(mfile.getOriginalFilename());
			// Ŀ���ļ�
			File dest = new File(dir, fileId);
			// �ѵ�ǰ�ļ�ת��(�洢)��Ŀ���ļ�
			try {
				mfile.transferTo(dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String path = "/playImage/" + fileId;
			playInfo.setPlayImage(path);
			// �����ļ�Id��·�������ݿ���
			count = this.playService.updatePlay(playInfo);
			if (count > 0) {
				model.put("msg", "�޸ĳɹ���");
			} else {
				model.put("msg", "�޸�ʧ�ܣ�");
			}
		}
		return "redirect:/play/playList";
	}

	@RequestMapping(value = "/playList", method = RequestMethod.GET)
	public String list(ModelMap model) {
		List<PlayInfo> playList = this.playService.getPlayList();
		model.put("playList", playList);
		return "manager/mMovie";
	}

	@RequestMapping(value = "deletePlay/{Id}", method = RequestMethod.GET)
	public String deletePlay(@PathVariable(name = "Id") Integer playId) {
		this.playService.deletePlay(playId);
		return "redirect:/play/playList";
	}

	@RequestMapping(value = "/getPlayById/{Id}", method = RequestMethod.GET)
	public String getPlayById(@PathVariable(name = "Id") Integer playId, HttpSession session, ModelMap model) {
		PlayInfo info = this.playService.getPlayById(playId);
		model.put("info", info);
		return "manager/editPlay";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/searchPlay", method = RequestMethod.GET)
	public String searchPlay(Integer current, String dir, HttpSession session, ModelMap model) {
		Map<String, Object> condition = new HashMap<String, Object>();
		if(session.getAttribute(Constants.SESSION_PLAY_SEARCH_CONDITION) != null){
			condition = (Map<String, Object>) session.getAttribute(Constants.SESSION_PLAY_SEARCH_CONDITION);
		} else {
			condition = new HashMap<String, Object>();
		}
		int pageNum = 1;
		// ��ȡ����������ѯ����ҳ��
		int pageCount = this.playService.getPageCount(condition);
		// ���������ж�
		if (current != null) {
			pageNum = current;
			if (dir != null && dir.equals("pre")) {
				pageNum--;
			} else {
				pageNum++;
			}
			if (pageNum <= 1) {
				pageNum = 1;
			}
			if (pageNum >= pageCount) {
				pageNum = pageCount;
			}
		}
		List<PlayInfo> playList = this.playService.searchPlay(condition, pageNum);
		model.put("playList", playList);
		model.put("current", pageNum);
		model.put("pageCount", pageCount);
		return "play/searchPlay";
	}

	@RequestMapping(value = "/searchPlay", method = RequestMethod.POST)
	public String searchPlay(String playName, String playType, String playLanguage, Float lowGrade, Float highGrade,
			HttpSession session, ModelMap model) {
		Map<String, Object> condition = new HashMap<String, Object>();
		if (playName != null && playName.trim().length() > 0) {
			condition.put("playName", playName);
		}
		if (playType != null && playType.trim().length() > 0) {
			condition.put("playType", playType);
		}
		if (playLanguage != null && playLanguage.trim().length() > 0) {
			condition.put("playLanguage", playLanguage);
		}
		if (lowGrade != null) {
			condition.put("lowGrade", lowGrade);
		}
		if (highGrade != null) {
			condition.put("highGrade", highGrade);
		}
		// ����ѯ��������Map
		session.setAttribute(Constants.SESSION_PLAY_SEARCH_CONDITION, condition);
		// ��ѯ��һҳ
		List<PlayInfo> playList = this.playService.searchPlay(condition, 1);
		// ��ѯ��ҳ��
		int pageCount = this.playService.getPageCount(condition);

		model.put("playList", playList);
		model.put("current", 1);
		model.put("pageCount", pageCount);

		return "/play/searchPlay";
	}

	/*@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadPlayImage(HttpServletRequest request, ModelMap model) {
		// �����ļ��������ʱ·��
		File dir = new File(request.getServletContext().getRealPath("/playImage"));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		int count = 0;
		// �жϵ�ǰ�����ǲ��Ƕಿ�ֱ�������������������ת������ȡ�ϴ����ļ�
		if (request instanceof MultipartRequest) {
			MultipartRequest mr = (MultipartRequest) request;
			// ��ȡ�ϴ����ļ�
			MultipartFile mfile = mr.getFile("playImage");
			// ���ļ�������ʱId
			String fileId = Utils.getFileId(mfile.getOriginalFilename());
			// Ŀ���ļ�
			File dest = new File(dir, fileId);
			// �ѵ�ǰ�ļ�ת��(�洢)��Ŀ���ļ�
			try {
				mfile.transferTo(dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String fileName = mfile.getOriginalFilename();
			String path = "/playImage/" + fileId;
			// �����ļ�Id��·�������ݿ���
			count = this.playService.savaImagePath(path);
			if (count > 0) {
				model.put("msg", "�ϴ��ɹ�!");
			} else {
				model.put("msg", "�ϴ�ʧ��!");
			}
			model.put("fileUrl", path);
		}
		return "play/fileupload";
	}*/
}
