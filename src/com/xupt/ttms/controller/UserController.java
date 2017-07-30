package com.xupt.ttms.controller;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xupt.ttms.service.UserService;
import com.xupt.ttms.vo.EmployeeInfo;

/**
 * @author WangFeng 
 * @date 2017��5��26�� ����9:32:32 
 * @version 1.0 
 */
@RequestMapping(value = "/user")
@Controller
public class UserController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String account, String pwd, ModelMap model, HttpSession session){
		EmployeeInfo info = this.userService.getInfoByAccount(account);
		if(info == null){
			model.put("msg", "��������˺Ų����ڣ�");
			return "login";
		} else {
			if(!info.getEmpPwd().equals(pwd)){
				model.put("msg", "�������");
				return "login";
			} else {
				session.setAttribute("empId", info.getEmpId());
				System.out.println("======" + info.getEmpId());
				session.setAttribute("userInfo", info);
				if(info.getEmpPosition().equals("����Ա")){
					return "redirect:/stdio/list";
				} else {
					return "redirect:/sche/searchSchedule2";
				}
			}
		}
	}
	
//	@RequestMapping(value="/updateUser")
//	public String updateUser(EmployeeInfo emp, ModelMap model){
//		
//	}
}
