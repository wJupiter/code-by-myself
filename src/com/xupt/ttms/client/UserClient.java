package com.xupt.ttms.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xupt.ttms.service.EmployeeService;
import com.xupt.ttms.service.UserService;
import com.xupt.ttms.vo.EmployeeInfo;

/**
 * @author WangFeng
 * @date 2017锟斤拷锟斤拷锟斤拷5锟斤拷锟斤拷锟斤拷26锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷9:32:32
 * @version 1.0
 */
@RequestMapping(value = "/userclient")
@Controller
public class UserClient {

	@Resource
	private UserService userService;
	
	@Resource
	private EmployeeService employeeService;

	@RequestMapping(value = "/login")
	public void login(String account, String pwd, HttpSession session, HttpServletResponse response, HttpServletRequest request) {
		String result = null;

		try {
			EmployeeInfo info = this.userService.getInfoByAccount(account);

			if (info == null)
				result = "-1";
			else if (!info.getEmpPwd().equals(pwd))
				result = "0";
			else {
				if (info.getEmpPosition().equals("绠＄悊鍛�"))
					result = "1";
				else
					result = "2";
				System.out.println("result-------"+result);
			}
			// 浼犻�佺粰瀹夊崜
			OutputStream os = null;
			os = response.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osw);

			bw.write(result);
			bw.flush();
			bw.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}


	@RequestMapping(value="/userList")
	public void userList(HttpServletResponse response, HttpServletRequest request){
		try {
			List<EmployeeInfo> employeeInfos = employeeService.getEmployeeList();
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = null;
			for(int i=0; i<employeeInfos.size(); i++){
				jsonObject = new JSONObject();
				try {
					jsonObject.put("employeeId",employeeInfos.get(i).getEmpId());
					jsonObject.put("employeeName", employeeInfos.get(i).getEmpName());
					jsonObject.put("empNo", employeeInfos.get(i).getEmpNo());
					jsonObject.put("empPosition", employeeInfos.get(i).getEmpPosition());
					jsonObject.put("empTel",employeeInfos.get(i).getEmpTel());
					jsonObject.put("empEmail",employeeInfos.get(i).getEmpEmail());
					jsonObject.put("empSex",employeeInfos.get(i).getSex());
					jsonObject.put("empAddress",employeeInfos.get(i).getEmpAddress());
				} catch (JSONException e) {
					e.printStackTrace();
				}
				jsonArray.put(jsonObject);
			}	
			
			// 浼犻�佺粰瀹夊崜
			OutputStream os = null;
			os = response.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os,"utf-8");
			BufferedWriter bw = new BufferedWriter(osw);

			bw.write(jsonArray.toString());
			bw.flush();
			bw.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	
	@RequestMapping(value = "/updateuser")
	public void UpdateUser(String set_id, String set_no,String set_name,String set_phone,String set_email,String set_address,HttpServletResponse response, HttpServletRequest request) {
		System.out.println("set_name----------->"+set_name);
		EmployeeInfo info = new EmployeeInfo();
		info.setEmpNo(set_no);
		info.setEmpId(Integer.parseInt(set_id));
		info.setEmpAddress(set_address);
		info.setEmpName(set_name);
		info.setEmpEmail(set_email);
		info.setEmpTel(set_phone);
		int update = employeeService.updateInfo1(info);
		try {
			OutputStream os = null;
			os = response.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os,"utf-8");
			BufferedWriter bw = new BufferedWriter(osw);

			bw.write(update+"");
			bw.flush();
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}

	
	@RequestMapping(value = "/clearuser")
	public void clearuser(String userid,HttpServletResponse response, HttpServletRequest request) {
		int delete = -1; 
		delete = employeeService.deleteEmp(Integer.parseInt(userid));
		
		try {
			OutputStream os = null;
			os = response.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os,"utf-8");
			BufferedWriter bw = new BufferedWriter(osw);

			bw.write(delete+"");
			bw.flush();
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
}
