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
 * @date 2017年6月1日 下午2:13:32
 * @version 1.0
 */

@RequestMapping(value = "/play")
@Controller
public class PlayController {

	@Resource
	private PlayService playService;

	@RequestMapping(value = "/addPlay", method = RequestMethod.POST)
	public String addPlay(HttpServletRequest request, PlayInfo playInfo, ModelMap model) {
		// 设置文件保存的临时路径
		File dir = new File(request.getServletContext().getRealPath("/playImage"));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		int count = 0;
		// 判断当前请求是不是多部分表单请求，如果是则进行类型转换并获取上传的文件
		if (request instanceof MultipartRequest) {
			MultipartRequest mr = (MultipartRequest) request;
			// 提取上传的文件
			MultipartFile mfile = mr.getFile("Image");
			// 给文件设置临时Id
			String fileId = Utils.getFileId(mfile.getOriginalFilename());
			// 目标文件
			File dest = new File(dir, fileId);
			// 把当前文件转换(存储)到目标文件
			try {
				mfile.transferTo(dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String fileName = mfile.getOriginalFilename();
			String path = "/playImage/" + fileId;
			playInfo.setPlayImage(path);
			// 保存文件Id和路径在数据库中
			count = this.playService.savePlay(playInfo);
			if (count > 0) {
				model.put("msg", "添加成功!");
			} else {
				model.put("msg", "添加失敗!");
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
		// 判断当前请求是不是多部分表单请求，如果是则进行类型转换并获取上传的文件
		if (request instanceof MultipartRequest) {
			MultipartRequest mr = (MultipartRequest) request;
			// 提取上传的文件
			MultipartFile mfile = mr.getFile("Image");
			// 给文件设置临时Id
			String fileId = Utils.getFileId(mfile.getOriginalFilename());
			// 目标文件
			File dest = new File(dir, fileId);
			// 把当前文件转换(存储)到目标文件
			try {
				mfile.transferTo(dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String path = "/playImage/" + fileId;
			playInfo.setPlayImage(path);
			// 保存文件Id和路径在数据库中
			count = this.playService.updatePlay(playInfo);
			if (count > 0) {
				model.put("msg", "修改成功！");
			} else {
				model.put("msg", "修改失败！");
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
		// 获取根据条件查询的总页数
		int pageCount = this.playService.getPageCount(condition);
		// 进行条件判断
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
		// 将查询条件存入Map
		session.setAttribute(Constants.SESSION_PLAY_SEARCH_CONDITION, condition);
		// 查询第一页
		List<PlayInfo> playList = this.playService.searchPlay(condition, 1);
		// 查询总页数
		int pageCount = this.playService.getPageCount(condition);

		model.put("playList", playList);
		model.put("current", 1);
		model.put("pageCount", pageCount);

		return "/play/searchPlay";
	}

	/*@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadPlayImage(HttpServletRequest request, ModelMap model) {
		// 设置文件保存的临时路径
		File dir = new File(request.getServletContext().getRealPath("/playImage"));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		int count = 0;
		// 判断当前请求是不是多部分表单请求，如果是则进行类型转换并获取上传的文件
		if (request instanceof MultipartRequest) {
			MultipartRequest mr = (MultipartRequest) request;
			// 提取上传的文件
			MultipartFile mfile = mr.getFile("playImage");
			// 给文件设置临时Id
			String fileId = Utils.getFileId(mfile.getOriginalFilename());
			// 目标文件
			File dest = new File(dir, fileId);
			// 把当前文件转换(存储)到目标文件
			try {
				mfile.transferTo(dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String fileName = mfile.getOriginalFilename();
			String path = "/playImage/" + fileId;
			// 保存文件Id和路径在数据库中
			count = this.playService.savaImagePath(path);
			if (count > 0) {
				model.put("msg", "上传成功!");
			} else {
				model.put("msg", "上传失败!");
			}
			model.put("fileUrl", path);
		}
		return "play/fileupload";
	}*/
}
