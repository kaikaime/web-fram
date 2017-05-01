package com.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.system.bean.HealthBean;
import com.system.bean.VactionBean;
import com.system.callback.FenYeAllDataCallBack;
import com.system.pojos.Vaction;
import com.system.service.IVactionService;
import com.system.utils.Constant;

@Controller
@RequestMapping("/vaction")
public class VactionController{
	
	@Autowired
	private IVactionService iViolationServiceImpl;
	
	
	@RequestMapping(value="/findAll",params={"method=findAll"})
	public String findAll(@RequestParam(value="findAll",required=false,defaultValue="1") String pageId,final ModelMap modelMap){
		
		return iViolationServiceImpl.findAllService(pageId, new FenYeAllDataCallBack<Vaction>() {
			@Override
			public String getJumpUrl() {
				return "/vaction";
			}
			
			@Override
			public void allObjCount(int pageCount, int allObjCount, int pageId,
					List<Vaction> list) {
					modelMap.addAttribute("pageCount", pageCount);
					modelMap.addAttribute("allObjCount", allObjCount);
					modelMap.addAttribute("pageId", pageId);
					modelMap.addAttribute("itemlist", list);
			}
		});
	}
	
	//通过Id查询数据
	@RequestMapping(value="/findById",params={"method=findById"})
	public String findById(@RequestParam("findById")String findById,final ModelMap modelMap){
		Vaction vaction = iViolationServiceImpl.findById(findById);
		modelMap.addAttribute("vaction", vaction);
		return "/add/addvication";
		
	}
	
	//通过Id修改Vaction对象
	@RequestMapping(value="/update",params={"method=update"})
	public String update(VactionBean vactionBean,final ModelMap modelMap){
		return iViolationServiceImpl.update(vactionBean, new FenYeAllDataCallBack<Vaction>() {

			@Override
			public void allObjCount(int pageCount, int allObjCount, int pageId,
					List<Vaction> list) {
					modelMap.addAttribute("pageCount", pageCount);
					modelMap.addAttribute("allObjCount", allObjCount);
					modelMap.addAttribute("pageId", pageId);
					modelMap.addAttribute("itemlist", list);
				
			}

			@Override
			public String getJumpUrl() {
				return "/vaction";
			}
		});
	}
	
	@RequestMapping(value="/delete",params={"method=delete"})
	public String delete(@RequestParam("findById") String findById,final ModelMap modelMap){
		
		return iViolationServiceImpl.delete(findById, new FenYeAllDataCallBack<Vaction>() {

			@Override
			public void allObjCount(int pageCount, int allObjCount, int pageId,
					List<Vaction> list) {
					modelMap.addAttribute("pageCount", pageCount);
					modelMap.addAttribute("allObjCount", allObjCount);
					modelMap.addAttribute("pageId", pageId);
					modelMap.addAttribute("itemlist", list);
			}

			@Override
			public String getJumpUrl() {
				return "/vaction";
			}
		});
	}

}
