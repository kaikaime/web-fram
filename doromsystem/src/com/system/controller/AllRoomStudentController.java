package com.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.system.callback.FenYeAllDataCallBack;
import com.system.hqldao.impl.HqlFenYeDAOImpl;
import com.system.service.IAllRoomStudentInforService;
import com.system.pojos.*;


@Controller
@RequestMapping("/student")
public class AllRoomStudentController {
	@Autowired
	private IAllRoomStudentInforService iAllRoomStudentInforServiceImpl;
	
	
	
	
	/**
	 * 获取所有宿舍的学生信息
	 */
	@RequestMapping(value="/findAll",params={"method=findAll"})
	public String findAllStudentInfor(@RequestParam(value="pageId",defaultValue="1")String pageId,final ModelMap modelMap){
		return iAllRoomStudentInforServiceImpl.findAllRoomStudentSerice(pageId,new FenYeAllDataCallBack<Room>() {

			@Override
			public void allObjCount(int pageCount, int allObjCount, int pageId,
					List<Room> list) {
					modelMap.addAttribute("pageCount", pageCount);
					modelMap.addAttribute("allObjCount", allObjCount);
					modelMap.addAttribute("pageId", pageId);
					modelMap.addAttribute("list", list);
			}

			@Override
			public String getJumpUrl() {
				return "/student";
			}
		});
		
	
	}

}
