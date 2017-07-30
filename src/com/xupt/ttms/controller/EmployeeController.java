package com.xupt.ttms.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import com.xupt.ttms.service.EmployeeService;
import com.xupt.ttms.vo.EmployeeInfo;

/**
 * @author WangFeng
 * @date 2017年5月28日 下午4:37:30
 * @version 1.0
 */

@RequestMapping(value = "/emp")
@Controller
public class EmployeeController {

	@Resource
	private EmployeeService empService;
	
	/**
	 * 添加用户信息
	 * @param request
	 * @param empInfo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addEmp", method = RequestMethod.POST)
	public String addEmp(HttpServletRequest request, EmployeeInfo empInfo, ModelMap model) {
		System.out.println(empInfo.toString());

		// 设置文件保存的临时路径
		File dir = new File(request.getServletContext().getRealPath("/upload"));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		int count = 0;
		// 判断当前请求是不是多部分表单请求，如果是则进行类型转换并获取上传的文件
		if (request instanceof MultipartRequest) {
			MultipartRequest mr = (MultipartRequest) request;
			// 提取上传的文件
			MultipartFile mfile = mr.getFile("photo");
			if(mfile.getOriginalFilename() != null && mfile.getOriginalFilename().trim().length() > 0){
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
				String path = "/upload/" + fileId;
				empInfo.setEmpPhoto(path);
				// 保存文件Id和路径在数据库中
			}
			count = this.empService.saveInfo(empInfo);
		}
		if (count > 0) {
			model.put("msg", "添加成功！");
		} else {
			model.put("msg", "添加失败！");
		}
		return "redirect:/emp/list";
	}
	
	/**
	 * 管理员修改员工的信息
	 * @param request
	 * @param empInfo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateEmp", method = RequestMethod.POST)
	public String updateEmp(HttpServletRequest request, EmployeeInfo empInfo, ModelMap model) {
		// 设置文件保存的临时路径
		File dir = new File(request.getServletContext().getRealPath("/upload"));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		int count = 0;
		// 判断当前请求是不是多部分表单请求，如果是则进行类型转换并获取上传的文件
		if (request instanceof MultipartRequest) {
			MultipartRequest mr = (MultipartRequest) request;
			// 提取上传的文件
			MultipartFile mfile = mr.getFile("photo");
			if(mfile.getOriginalFilename() != null && mfile.getOriginalFilename().trim().length() > 0){
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
				String path = "/upload/" + fileId;
				empInfo.setEmpPhoto(path);
				// 保存文件Id和路径在数据库中
			}
			count = this.empService.updateInfo(empInfo);
		}
		if (count > 0) {
			model.put("msg", "修改成功！");
		} else {
			model.put("msg", "修改失败！");
		}
		return "redirect:/emp/list";
	}

	/**
	 * 管理员修改自己的信息
	 * @param request
	 * @param empInfo
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateMgrEmp", method = RequestMethod.POST)
	public String updateEmployee(HttpServletRequest request, EmployeeInfo empInfo, ModelMap model) {
		// 设置文件保存的临时路径
		File dir = new File(request.getServletContext().getRealPath("/upload"));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		int count = 0;
		// 判断当前请求是不是多部分表单请求，如果是则进行类型转换并获取上传的文件
		if (request instanceof MultipartRequest) {
			MultipartRequest mr = (MultipartRequest) request;
			// 提取上传的文件
			MultipartFile mfile = mr.getFile("photo");
			if(mfile.getOriginalFilename() != null && mfile.getOriginalFilename().trim().length() > 0){
				String fileId = Utils.getFileId(mfile.getOriginalFilename());
				// 给文件设置临时Id
				// 目标文件
				File dest = new File(dir, fileId);
				// 把当前文件转换(存储)到目标文件
				try {
					mfile.transferTo(dest);
				} catch (IOException e) {
					e.printStackTrace();
				}
				String path = "/upload/" + fileId;
				empInfo.setEmpPhoto(path);
			}
			// 保存文件Id和路径在数据库中
			count = this.empService.updateInfo(empInfo);
		}
		if (count > 0) {
			model.put("msg", "修改成功！");
		} else {
			model.put("msg", "修改失败！");
		}
		return "redirect:/emp/getInfoById/" + empInfo.getEmpId();
	}
	
	@RequestMapping(value = "/updateSaleEmp", method = RequestMethod.POST)
	public String updateEmployee2(HttpServletRequest request, EmployeeInfo empInfo, ModelMap model) {
		// 设置文件保存的临时路径
		File dir = new File(request.getServletContext().getRealPath("/upload"));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		int count = 0;
		// 判断当前请求是不是多部分表单请求，如果是则进行类型转换并获取上传的文件
		if (request instanceof MultipartRequest) {
			MultipartRequest mr = (MultipartRequest) request;
			// 提取上传的文件
			MultipartFile mfile = mr.getFile("photo");
			if(mfile.getOriginalFilename() != null && mfile.getOriginalFilename().trim().length() > 0){
				String fileId = Utils.getFileId(mfile.getOriginalFilename());
				// 给文件设置临时Id
				// 目标文件
				File dest = new File(dir, fileId);
				// 把当前文件转换(存储)到目标文件
				try {
					mfile.transferTo(dest);
				} catch (IOException e) {
					e.printStackTrace();
				}
				String path = "/upload/" + fileId;
				empInfo.setEmpPhoto(path);
			}
			// 保存文件Id和路径在数据库中
			count = this.empService.updateInfo(empInfo);
		}
		if (count > 0) {
			model.put("msg", "修改成功！");
		} else {
			model.put("msg", "修改失败！");
		}
		return "redirect:/emp/getSaleInfoById/" + empInfo.getEmpId();
	}
	
	@RequestMapping(value = "/deleteBatch", method = RequestMethod.POST)
	public String deleteEmp(String[] empId, ModelMap model) {
		List<Integer> empIds = new ArrayList<Integer>();
		for (int i = 0; i < empId.length; i++) {
			empIds.add(Integer.parseInt(empId[i]));
		}
		this.empService.batchDelete(empIds);
		return "redirect:/emp/list";
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(String condation, ModelMap model) {
		List<EmployeeInfo> empList = this.empService.getEmployeeList();
		for (EmployeeInfo empInfo : empList) {
			empInfo.setTempDob(Utils.FormatDate(empInfo.getDob()));
		}
		model.put("empList", empList);
		return "manager/mPerson";
	}

	@RequestMapping(value = "/getInfoById/{Id}", method = RequestMethod.GET)
	public String getInfoById(@PathVariable(name = "Id") Integer empId, ModelMap model) {
		EmployeeInfo empInfo = this.empService.getInfoById(empId);
		model.put("empInfo", empInfo);
		return "manager/mPersonal";
	}
	
	@RequestMapping(value = "/getSaleInfoById/{Id}", method = RequestMethod.GET)
	public String getSaleInfoById(@PathVariable(name = "Id") Integer empId, ModelMap model) {
		EmployeeInfo empInfo = this.empService.getInfoById(empId);
		model.put("empInfo", empInfo);
		return "seller/personal";
	}

	@RequestMapping(value = "/deleteEmp/{Id}", method = RequestMethod.GET)
	public String deleteEmp(@PathVariable(name = "Id") Integer empId, ModelMap model) {
		this.empService.deleteEmp(empId);
		return "redirect:/emp/list";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String pageList(Integer current, String dir, HttpSession session, ModelMap model) {
		Map<String, Object> condition = null;
		if (session.getAttribute(Constants.SESSION_EMP_SEARCH_CONDITION) != null) {
			condition = (Map<String, Object>) session.getAttribute(Constants.SESSION_EMP_SEARCH_CONDITION);
		} else {
			condition = new HashMap<String, Object>();
		}
		int pageNum = 1;
		// 获取根据条件查询的总页数
		int pageCount = this.empService.getPageCount(condition);
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
		List<EmployeeInfo> empList = this.empService.search(condition, pageNum);
		model.put("empList", empList);
		model.put("current", pageNum);
		model.put("pageCount", pageCount);
		return "employee/empList";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String pageList(String name, String position, HttpSession session, ModelMap model) {
		Map<String, Object> condition = new HashMap<String, Object>();
		if (name != null && name.trim().length() > 0) {
			condition.put("empName", name);
		}
		if (position != null && position.trim().length() > 0) {
			condition.put("empPosition", position);
		}
		// 将查询条件存入Map
		session.setAttribute(Constants.SESSION_EMP_SEARCH_CONDITION, condition);
		// 查询第一页
		List<EmployeeInfo> empList = this.empService.search(condition, 1);
		// 查询总页数
		int pageCount = this.empService.getPageCount(condition);

		model.put("empList", empList);
		model.put("current", 1);
		model.put("pageCount", pageCount);
		return "employee/empList";
	}

	/*@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public String uploadEmpPhoto(HttpServletRequest request, ModelMap model) {
		// 设置文件保存的临时路径
		File dir = new File(request.getServletContext().getRealPath("/upload"));
		if (!dir.exists()) {
			dir.mkdirs();
		}
		int count = 0;
		// 判断当前请求是不是多部分表单请求，如果是则进行类型转换并获取上传的文件
		if (request instanceof MultipartRequest) {
			MultipartRequest mr = (MultipartRequest) request;
			// 提取上传的文件
			MultipartFile mfile = mr.getFile("empPhoto");
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
			String path = "/upload/" + fileId;
			// 保存文件Id和路径在数据库中
			count = this.empService.savaFileName(path);
			model.put("msg", "上传成功!");
			model.put("fileUrl", path);
		}
		return "employee/fileupload";
	}*/

}
