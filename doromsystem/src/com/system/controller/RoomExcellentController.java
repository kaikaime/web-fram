package com.system.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.system.bean.ExcellentBean;
import com.system.callback.FenYeAllDataCallBack;
import com.system.pojos.Excellent;
import com.system.service.RoomExcellentService;
import com.system.service.impl.RoomExcellentServiceImpl;
import com.system.utils.StringUtils;

@Controller
@RequestMapping("/excell")
public class RoomExcellentController {
	@Autowired
	@Qualifier("roomExcellentServiceImpl")
	private RoomExcellentService roomExcellentService;
	
	
	/**
	 * 分页查询
	 * @param pageId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/findAll",params={"method=findAll"})
	public String findAll(@RequestParam(value="pageId",defaultValue="1")String pageId,final ModelMap modelMap){
			return roomExcellentService.findAllService(pageId, new FenYeAllDataCallBack<Excellent>() {
			@Override
			public String getJumpUrl() {
				return "/excellent";
			}
			@SuppressWarnings("unchecked")
			@Override
			public void allObjCount(int pageCount, int allObjCount, int pageId,
					List<Excellent> list) {
					modelMap.addAttribute("pageCount", pageCount);
					modelMap.addAttribute("allObjCount", allObjCount);
					modelMap.addAttribute("pageId", pageId);
					modelMap.addAttribute("list", list);
			}
		});
	}
	
	@RequestMapping(value="/delete")
	public String delete(@RequestParam("id") String id,final ModelMap modelMap){
			//删除数据以后，重新从数据库中查询出来,并设置当前的页面为第一页
			return roomExcellentService.deleteById(id, new FenYeAllDataCallBack<Excellent>() {
			@Override
			public void allObjCount(int pageCount, int allObjCount, int pageId,
					List<Excellent> list) {
					modelMap.addAttribute("pageCount", pageCount);
					modelMap.addAttribute("allObjCount", allObjCount);
					modelMap.addAttribute("pageId", pageId);
					modelMap.addAttribute("list", list);
			}
			@Override
			public String getJumpUrl() {
				return "/excellent";
			}
		});
	}
	
	
	
	
}
