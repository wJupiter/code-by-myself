package com.xupt.ttms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xupt.ttms.service.SaleService;
import com.xupt.ttms.vo.SaleInfo;

/**
 * @author WangFeng
 * @date 2017年6月9日 下午1:50:29 
 * @version 1.0 
 */

@Controller
public class SaleController {
	
	@Resource
	private SaleService saleService;
	
	@RequestMapping("/saleList")
	public String getSaleList(ModelMap model){
		List<SaleInfo> saleList = this.saleService.getSaleList();
		return "";
	}
}
