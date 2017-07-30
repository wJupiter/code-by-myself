package com.xupt.ttms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xupt.ttms.service.StdioService;
import com.xupt.ttms.vo.StdioInfo;

/**
 * @author WangFeng 
 * @date 2017��5��31�� ����2:05:05 
 * @version 1.0 
 */

@RequestMapping(value = "/stdio")
@Controller
public class StdioController {
	
	@Resource
	private StdioService stdService;
	
	@RequestMapping(value="add")
	public String add(StdioInfo info, ModelMap model){
		
		StdioInfo stdioInfo = info; 
		if(info.getStdioType().equals("1")){
			stdioInfo.setStdioType("3DӰ��");
		}
		if(info.getStdioType().equals("2")){
			stdioInfo.setStdioType("2DӰ��");
		}
		if(info.getStdioType().equals("3")){
			stdioInfo.setStdioType("��ͨӰ��");
		}
		//���Ӱ��
		int count = this.stdService.addStdio(stdioInfo);
		if(count > 0){
			model.put("msg", "��ӳɹ���");
		} else {
			model.put("msg", "���ʧ�ܣ�");
		}
		return "redirect:/stdio/list";
	}
	
	@RequestMapping(value = "/list")
	public String list(ModelMap model){
		
		List<StdioInfo> stdList = null; 
		
		stdList = this.stdService.getStdioList();
		
		model.put("stdList", stdList);
		return "manager/mIndex";
	}
	
	@RequestMapping(value="/getInfoById/{stdId}")
	public String getStdioById(@PathVariable(name = "stdId") Integer stdId, ModelMap model){
		StdioInfo stdInfo = null;
		stdInfo = this.stdService.getStdioInfoById(stdId);
		model.put("stdInfo", stdInfo);
		return "manager/mIndex";
	}
	
	@RequestMapping(value="/update")
	public String update(StdioInfo info, ModelMap model){
		System.out.println(info.toString());
		
		StdioInfo stdioInfo = info; 
		if(info.getStdioType().equals("1")){
			stdioInfo.setStdioType("3DӰ��");
		}
		if(info.getStdioType().equals("2")){
			stdioInfo.setStdioType("2DӰ��");
		}
		if(info.getStdioType().equals("3")){
			stdioInfo.setStdioType("��ͨӰ��");
		}
		System.out.println(stdioInfo.toString());
		//���Ӱ��
		int count = this.stdService.updateStdio(stdioInfo);
		if(count > 0){
			model.put("msg", "�޸ĳɹ���");
		} else {
			model.put("msg", "�޸�ʧ�ܣ�");
		}
		return "redirect:/stdio/list"; 
	}
	
	@RequestMapping(value="deleteStdio/{stdId}")
	public String delete(@PathVariable(name = "stdId") Integer stdId, ModelMap model){
		int count = 0;
		count = this.stdService.deleteStdio(stdId);
		return "redirect:/stdio/list";
	}
}
