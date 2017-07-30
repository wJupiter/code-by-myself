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

import com.xupt.ttms.service.PlayService;
import com.xupt.ttms.vo.PlayInfo;

/**
 * @author WangFeng
 * @date 2017������5������26������ ������������9:32:32
 * @version 1.0
 */
@RequestMapping(value = "/playclient")
@Controller
public class PlayClient {

	@Resource
	private PlayService playService;

	@RequestMapping(value = "/play")
	public void findPlayAll(HttpServletResponse response, HttpServletRequest request) {
		try {
			List<PlayInfo> plays = playService.getPlayList();
			JSONArray jsonArray = new JSONArray();
			JSONObject jsonObject = null;
			for(int i=0; i<plays.size(); i++){
				jsonObject = new JSONObject();
				try {
					jsonObject.put("playId",plays.get(i).getPlayId());
					jsonObject.put("playName", plays.get(i).getPlayName());
					jsonObject.put("playType", plays.get(i).getPlayType());
					jsonObject.put("playDesc", plays.get(i).getPlayDesc());
					jsonObject.put("playLanguage", plays.get(i).getPlayLanguage());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				jsonArray.put(jsonObject);
			}	
			
			// 传送给安卓
			OutputStream os = null;
			os = response.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os,"utf-8");
			BufferedWriter bw = new BufferedWriter(osw);
			System.out.println(jsonArray.toString());
			bw.write(jsonArray.toString());
			bw.flush();
			bw.close();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}


