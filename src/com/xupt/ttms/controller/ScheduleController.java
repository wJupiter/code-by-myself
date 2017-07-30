package com.xupt.ttms.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xupt.ttms.common.Utils;
import com.xupt.ttms.service.PlayService;
import com.xupt.ttms.service.ScheduleService;
import com.xupt.ttms.service.StdioService;
import com.xupt.ttms.vo.PlayInfo;
import com.xupt.ttms.vo.ScheduleInfo;
import com.xupt.ttms.vo.StdioInfo;

/**
 * @author WangFeng 
 * @date 2017年6月3日 下午4:09:11 
 * @version 1.0 
 */
@RequestMapping(value="/sche")
@Controller
public class ScheduleController {
	
	@Resource
	private PlayService playService;
	
	@Resource
	private StdioService stdService;
	
	@Resource
	private ScheduleService scheService;
	
	/**
	 * 获取所有演出厅的信息,并以Json形式返回数据
	 * @return
	 */
	@RequestMapping(value="/getStdioList", method = RequestMethod.GET)
	public ResponseEntity<List<StdioInfo>> getStdioList( ){
		List<StdioInfo> stdList = this.stdService.getStdioList();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		ResponseEntity<List<StdioInfo>> resp = new ResponseEntity<List<StdioInfo>>(stdList, headers,HttpStatus.OK);
		return resp; 
	}
	
	/**
	 * 获取所有的影片
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/getPlayList", method = RequestMethod.GET)
	public ResponseEntity<List<PlayInfo>> list(){
		List<PlayInfo> playList = this.playService.getPlayList();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		ResponseEntity<List<PlayInfo>> resp = new ResponseEntity<List<PlayInfo>>(playList, headers, HttpStatus.OK);
		return resp;
	}
	
	/**
	 * 添加一条演出计划
	 * @param startTime
	 * @param schedule
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/addSche", method = RequestMethod.POST)
	public String addSchedule(Integer startTime, ScheduleInfo schedule, ModelMap model){
		schedule.setScheStartTime(Utils.START_TIME[startTime-1]);
		schedule.setScheEndTime(Utils.END_TIME[startTime-1]);
		System.out.println(schedule.toString());
		int count = 0;
		count = this.scheService.addSchedule(schedule);
		if(count > 0){
			model.put("msg", "添加成功！" + schedule.getScheId());
		} else {
			model.put("msg", "添加失败" + schedule.getScheId());
		}
		return "redirect:/sche/getScheduleList";
	}
	
	/**
	 * 修改演出计划
	 * @param startTime
	 * @param schedule
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/updateSche", method = RequestMethod.POST)
	public String updateSchedule(Integer startTime, ScheduleInfo schedule, ModelMap model){
		schedule.setScheStartTime(Utils.START_TIME[startTime-1]);
		schedule.setScheEndTime(Utils.END_TIME[startTime-1]);
		System.out.println(schedule.toString());
		int count = 0;
		count = this.scheService.updateSchedule(schedule);
		if(count > 0){
			model.put("msg", "修改成功！");
		} else {
			model.put("msg", "修改失败！");
		}
		return "redirect:/sche/getScheduleList";
	}
	
	/**
	 * 获取演出计划列表
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/getScheduleList", method = RequestMethod.GET)
	public String getScheduleList(ModelMap model){
		List<ScheduleInfo> scheList = this.scheService.getScheduleList();
		model.put("scheList", scheList);
		return "manager/mPlan";
	}
	/**
	 * 删除演出计划
	 * @param scheId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteSchedule/{Id}", method = RequestMethod.GET)
	public String deleteSchedule(@PathVariable(name = "Id")Integer scheId, ModelMap model){
		this.scheService.deleteSchedule(scheId);
		return "redirect:/sche/getScheduleList";
	}
	
	/**
	 * 根据影片检索演出计划
	 * @param playId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/searchSchedule", method = RequestMethod.POST)
	public String searchSchedule(Integer playId, ModelMap model){
		List<ScheduleInfo> scheList = this.scheService.searchSchedule(playId);
		model.put("scheList", scheList);
		return "schedule/searchSchedule";
	}
	
	/**
	 * 根据检索检索所有演出计划
	 * @param playId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/searchSchedule2", method = RequestMethod.GET)
	public String searchSchedule(ModelMap model){
		List<ScheduleInfo> scheList = this.scheService.searchSchedule2();
		model.put("scheList", scheList);
		return "seller/ticket";
	}
	
	/**
	 * 根据演出计划Id查询演出计划详细信息
	 * @param scheId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/getScheduleById/{Id}")
	public String getScheduleById(@PathVariable(name="Id") Integer scheId, HttpSession session){
		ScheduleInfo scheInfo = this.scheService.getScheduleById(scheId);
		System.out.println(scheInfo.getPlayInfo().getPlayTicketPrice() + "=================================================");
		//把当前数据放到session中
		session.setAttribute("scheId", scheInfo.getScheId());
		session.setAttribute("ticketPrice", scheInfo.getPlayInfo().getPlayTicketPrice());
		session.setAttribute("scheInfo", scheInfo);
		return "redirect:/seller/saleTicket.jsp";
	}
	
	
}
