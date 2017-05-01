package com.shop.action;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.shop.base.BaseAction;
import com.shop.bean.DateBean;

@SuppressWarnings("serial")
@Controller
public class HeadInfoAction extends BaseAction {
	//获取头部信息,使用ajax
	public String findHeadInfo(HttpServletRequest request,HttpServletResponse response){
		PrintWriter out = null;
		SimpleDateFormat sp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			String headInfo=request.getParameter("info");
			out = response.getWriter();
			DateBean dateBean = new DateBean();
			dateBean.setDate(sp.format(new Date()));
			dateBean.setTime(sp.format(new Date()));
			out.println(new Gson().toJson(dateBean));
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			closePrintWriter(out);
		}
		return json;
	}

	
}
