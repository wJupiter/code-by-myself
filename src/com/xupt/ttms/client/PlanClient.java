package com.xupt.ttms.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xupt.ttms.service.ScheduleService;
import com.xupt.ttms.vo.ScheduleInfo;

/**
 * @author WangFeng
 * @date 2017锟斤拷锟斤拷锟斤拷5锟斤拷锟斤拷锟斤拷26锟斤拷锟斤拷锟斤拷 锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷9:32:32
 * @version 1.0
 */
@RequestMapping(value = "/planclient")
@Controller
public class PlanClient {

	@Resource
	private ScheduleService planService;

	@RequestMapping(value = "/plan")
	public void findPlayAll(HttpServletResponse response, HttpServletRequest request) {
		try {
			List<ScheduleInfo> plans = planService.getScheduleList();
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = null;
			for(int i=0; i<plans.size(); i++){
				jsonObject = new JSONObject();
				try {
					jsonObject.put("ScheId",plans.get(i).getScheId());
					jsonObject.put("StdioName", plans.get(i).getStdioInfo().getStdioName());
					jsonObject.put("PlayName", plans.get(i).getPlayInfo().getPlayName());
					jsonObject.put("ScheStartTime", plans.get(i).getScheStartTime());
					jsonObject.put("ScheEndTime",plans.get(i).getScheEndTime());
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
			System.out.println("plans ----->"+jsonArray.toString());
			bw.write(jsonArray.toString());
			bw.flush();
			bw.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}


