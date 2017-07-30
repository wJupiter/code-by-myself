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
 * @date 2017��6��3�� ����4:09:11 
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
	 * ��ȡ�����ݳ�������Ϣ,����Json��ʽ��������
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
	 * ��ȡ���е�ӰƬ
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
	 * ���һ���ݳ��ƻ�
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
			model.put("msg", "��ӳɹ���" + schedule.getScheId());
		} else {
			model.put("msg", "���ʧ��" + schedule.getScheId());
		}
		return "redirect:/sche/getScheduleList";
	}
	
	/**
	 * �޸��ݳ��ƻ�
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
			model.put("msg", "�޸ĳɹ���");
		} else {
			model.put("msg", "�޸�ʧ�ܣ�");
		}
		return "redirect:/sche/getScheduleList";
	}
	
	/**
	 * ��ȡ�ݳ��ƻ��б�
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
	 * ɾ���ݳ��ƻ�
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
	 * ����ӰƬ�����ݳ��ƻ�
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
	 * ���ݼ������������ݳ��ƻ�
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
	 * �����ݳ��ƻ�Id��ѯ�ݳ��ƻ���ϸ��Ϣ
	 * @param scheId
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/getScheduleById/{Id}")
	public String getScheduleById(@PathVariable(name="Id") Integer scheId, HttpSession session){
		ScheduleInfo scheInfo = this.scheService.getScheduleById(scheId);
		System.out.println(scheInfo.getPlayInfo().getPlayTicketPrice() + "=================================================");
		//�ѵ�ǰ���ݷŵ�session��
		session.setAttribute("scheId", scheInfo.getScheId());
		session.setAttribute("ticketPrice", scheInfo.getPlayInfo().getPlayTicketPrice());
		session.setAttribute("scheInfo", scheInfo);
		return "redirect:/seller/saleTicket.jsp";
	}
	
	
}
