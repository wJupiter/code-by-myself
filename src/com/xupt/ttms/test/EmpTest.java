package com.xupt.ttms.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xupt.ttms.service.EmployeeService;
import com.xupt.ttms.service.UserService;
import com.xupt.ttms.vo.EmployeeInfo;

/**
 * @author WangFeng 
 * @date 2017年5月27日 下午3:50:14 
 * @version 1.0 
 */
// 接口测试类
public class EmpTest {
	
	private static ApplicationContext ctx = null;
	private static EmployeeService empService = null;
	static {
		ctx = new ClassPathXmlApplicationContext("classpath:applicationContext-*.xml");
		empService = (EmployeeService) ctx.getBean("employeeService");
	}
	
	@Test
	public void testQuery(){
		List<EmployeeInfo> list = empService.getEmployeeList();
		for (EmployeeInfo employeeInfo : list) {
			System.out.println(employeeInfo.toString());
		}
		EmployeeInfo info = empService.getInfoById(1);
		System.out.println(info.toString());
	}
	
	@Test
	public void testInsertAndUpdate(){
		EmployeeInfo info = new EmployeeInfo();
//		info.setEmpId(3);
		info.setEmpNo("test001");
//		info.setEmpPwd("1234567");
		info.setEmpName("千月");
		info.setSex("男");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date dob = null;
		try {
			dob = sdf.parse("1997-03-15");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		info.setDob(dob);
		info.setEmpTel("15829349867");
		info.setEmpAddress("西安邮电大学！");
		info.setEmpEmail("15829349846@163.com");
		System.out.println(info.toString());
		empService.saveInfo(info);
	}
	
	@Test
	public void testDelete(){
		List<Integer> empIds = new ArrayList<Integer>();
		empIds.add(3);
		empIds.add(4);
		empService.batchDelete(empIds);
	}
	
	@Test
	public void testUser(){
		UserService userService = (UserService) ctx.getBean("userService");
		EmployeeInfo  empInfo = userService.getInfoByAccount("admin");
		System.out.println(empInfo.toString());
	}
	
}
