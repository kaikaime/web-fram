package com.system.controller;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.system.bean.ViolationBean;
import com.system.callback.FenYeAllDataCallBack;
import com.system.pojos.Violation;
import com.system.service.IViolationService;

@Controller
@RequestMapping("/violation")
public class ViolationController {
	
	@Autowired
	private IViolationService iViolationServiceImpl;
	
	
	//分页查询
	@RequestMapping(value="/findAll",params={"method=findAll"})
	public String findAll(@RequestParam(value="pageId",defaultValue="1") String pageId,final ModelMap modelMap){
		return iViolationServiceImpl.findAllService(pageId, new FenYeAllDataCallBack<Violation>() {

			@Override
			public void allObjCount(int pageCount, int allObjCount, int pageId,
					List<Violation> list) {
					modelMap.addAttribute("pageCount", pageCount);
					modelMap.addAttribute("allObjCount", allObjCount);
					modelMap.addAttribute("pageId", pageId);
					modelMap.addAttribute("bean", list);
			}

			@Override
			public String getJumpUrl() {
				return "/violation";
			}
		});
	}
	
	/**
	 * 在修改之前先查询出所有的数据
	 * @param request
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/findById",params={"method=findById"})
	public String findById(@RequestParam("vioId")String vioId,final ModelMap modelMap){
		Violation violation  = iViolationServiceImpl.findByIdServcie(vioId);
		modelMap.put("violation", violation);
		return "/add/addviolation";
	}
	
	
	@RequestMapping(value="/update")
	public String update(ViolationBean violationBean,final ModelMap modelMap){
		return iViolationServiceImpl.update(violationBean, new FenYeAllDataCallBack<Violation>() {

			@Override
			public void allObjCount(int pageCount, int allObjCount, int pageId,
					List<Violation> list) {
					modelMap.addAttribute("pageCount", pageCount);
					modelMap.addAttribute("allObjCount", allObjCount);
					modelMap.addAttribute("pageId", pageId);
					modelMap.addAttribute("bean", list);
			}
			@Override
			public String getJumpUrl() {
				return "/violation";
			}
		});
	}
	
	/**\
	 *删除数据
	 */
	@RequestMapping(value="/delete",params={"method=delete"})
	public String delete(@RequestParam("deleteId") String deleteId,final ModelMap modelMap){
		System.out.println("==============="+deleteId);
		return iViolationServiceImpl.delete(deleteId,new FenYeAllDataCallBack<Violation>() {

			@Override
			public void allObjCount(int pageCount, int allObjCount, int pageId,
					List<Violation> list) {
					modelMap.addAttribute("pageCount", pageCount);
					modelMap.addAttribute("allObjCount", allObjCount);
					modelMap.addAttribute("pageId", pageId);
					modelMap.addAttribute("bean", list);
			}
			@Override
			public String getJumpUrl() {
				return "/violation";
			}
		});
	}
	
	/**
	 * 根據學生名字查詢數據
	 */
	@RequestMapping(value="/findByNick",params={"method=findByNick"})
	public String findByNick(@RequestParam("findByNick") String findByNick,ModelMap modelMap){
		List<Violation> list= iViolationServiceImpl.findByNick(findByNick);
		modelMap.addAttribute("pageCount", "1");
		modelMap.addAttribute("allObjCount", list.size());
		modelMap.addAttribute("pageId", "1");
		modelMap.addAttribute("bean", list);
		return "/violation";
	}
	

}
