package com.xupt.ttms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.net.httpserver.Headers;
import com.xupt.ttms.service.SeatService;
import com.xupt.ttms.vo.SeatInfo;

/**
 * @author WangFeng
 * @date 2017��6��5�� ����1:07:30
 * @version 1.0
 */

@RequestMapping(value = "/seat")
@Controller
public class SeatController {

	@Resource
	private SeatService seatService;

	/**
	 * �����λ
	 * @param seatInfo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addSeat", method = RequestMethod.POST)
	public String addSeat(SeatInfo seatInfo, ModelMap model) {
		int count = 0;
		count = this.seatService.addSeat(seatInfo);
		if (count > 0) {
			model.put("msg", "��ӳɹ���");
		} else {
			model.put("msg", "���ʧ�ܣ�");
		}
		return "seat/addSeat";
	}

	/**
	 * ɾ����λ
	 * @param seatInfo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteSeat", method = RequestMethod.POST)
	public String deleteSeat(SeatInfo seatInfo, ModelMap model) {
		int count = 0;
		count = this.seatService.deleteSeat(seatInfo);
		if (count > 0) {
			model.put("msg", "ɾ���ɹ���");
		} else {
			model.put("msg", "ɾ��ʧ�ܣ�");
		}
		return "seat/deleteSeat";
	}
	
	/**
	 * �����ݳ���id��ѯ��λ
	 * @param stdioId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/searchSeat", method = RequestMethod.GET)
	public ResponseEntity<List<SeatInfo>> searchSeat(@RequestParam(name="stdId") Integer stdioId, ModelMap model) {
		List<SeatInfo> seatList = this.seatService.getSeatList(stdioId);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
		ResponseEntity<List<SeatInfo>> resp = new ResponseEntity<List<SeatInfo>>(seatList, headers, HttpStatus.OK);
		return resp;
	}

}
