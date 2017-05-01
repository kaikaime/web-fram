package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mysql.jdbc.StringUtils;
import com.shop.base.BaseAction;
import com.shop.pojo.TodaysDealPojo;
import com.shop.service.ShopIndexService;
import com.utils.StringUtil;

@Controller
public class ShopIndexAction extends BaseAction {
	
	@Autowired
	private ShopIndexService  shopIndexServiceImpl;
	
	
	//获取前台页面的信息
	public String todaysdealInfo(HttpServletRequest request,HttpServletResponse response){
		try {
			String todaysdeal =request.getParameter("todaysdeal").trim();
			//今日特价模块
			if("todaysdeal".equals(todaysdeal)){
				PrintWriter out = response.getWriter();
				List<TodaysDealPojo> allData = shopIndexServiceImpl.findTodaysDealService();
				String pojo = StringUtil.toJson(allData);
				out.println(pojo);
				closePrintWriter(out);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
}
