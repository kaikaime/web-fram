package com.shop.action;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.oreilly.servlet.MultipartRequest;
import com.shop.base.BaseAction;
import com.shop.pojo.PagePojo;
import com.shop.pojo.UserHeadImgPojo;
import com.shop.pojo.UserPojo;
import com.shop.service.UserHeadService;
import com.shop.service.UserMaService;
import com.utils.FileUploadUtil;
import com.utils.MD5Utils;
import com.utils.StringUtil;

@SuppressWarnings("serial")
@Controller
public class UserMaAction extends BaseAction {
	@Autowired
	private UserMaService userMaServiceImpl;
	
	@Autowired
	private UserHeadService userHeadServiceImpl;
	
	private MultipartRequest multipartRequest;
	
	private FileUploadUtil fileUploadUtil;
	
	//删除用户
	public String deleteByIdUser(HttpServletRequest request,HttpServletResponse response){
		String deleteUserId = request.getParameter("userId");
		log("deleteUserId: "+deleteUserId);
		if(deleteUserId==null||"".equals(deleteUserId)){
			return findAll(request,response);
		}
		int userId = Integer.parseInt(deleteUserId);
		userHeadServiceImpl.deleteByIdUserHeadImg(userId);
		userMaServiceImpl.deleteByIdUser(userId);
		return findAll(request,response);
	}
	
	
	//更新用户
	public String updateByIdUser(HttpServletRequest request,HttpServletResponse response){
		UserPojo userPojo = getPackgeUser(request,response);
		String modifyUserId = multipartRequest.getParameter("userId");
		int userId = Integer.parseInt(modifyUserId);
		userPojo.setUserId(userId);
		//获取到用户的Id编号
		userMaServiceImpl.updateByIdUser(userPojo);
		//获取用户头像
		UserHeadImgPojo headImgPojo = getPackgeUserHeadImg(userPojo.getUserId());
		userHeadServiceImpl.updateByIdUserHeadImg(headImgPojo);
		findAll(request,response);
		return "redirect:/manage/user";
	}
	
	
	//获取某一个用户
	public String findByIdUser(HttpServletRequest request,HttpServletResponse response){
		String userId = request.getParameter("userId");
		if(userId==null||"".equals(userId)){
			return "/manage/user";
		}
		UserPojo userPojo = userMaServiceImpl.findByIdUser(Integer.parseInt(userId));
		request.getSession().setAttribute("userPojo",userPojo);
		return "redirect:/manage/user-modify";
	}
	
	public String findAllUser(HttpServletRequest request,HttpServletResponse response){
		findAll(request,response);
		return "redirect:/manage/user";
	}
	
	
	//分页查询
	public String findAll(HttpServletRequest request,HttpServletResponse response){
		//每一页条目大小
		int pageSize=10;
		String pageId=request.getParameter("pageId");
		pageId=pageId==null||"".equals(pageId)?"1":pageId;
		int currentPage = StringUtil.regCurrentPage(pageId);
		PagePojo<UserPojo> allData = userMaServiceImpl.findAll(currentPage,pageSize);
		request.getSession().setAttribute("all", allData);
		return "/manage/user";
	}
	
	

	//添加用户
	public String addUser(HttpServletRequest request,HttpServletResponse response){
		UserPojo userPojo = getPackgeUser(request,response);
		//获取到用户的Id编号
		int userId = userMaServiceImpl.addUser(userPojo);
		//获取用户图像
		UserHeadImgPojo headImgPojo = getPackgeUserHeadImg(userId);
		userHeadServiceImpl.addUserHeadImg(headImgPojo);
		findAll(request,response);
		return "redirect:/manage/user";
	}

	//添加用户图像
	private UserHeadImgPojo getPackgeUserHeadImg(int userId) {
		UserHeadImgPojo headImgPojo = new UserHeadImgPojo();
		headImgPojo.setUserHeadImgPath(fileUploadUtil.getImgPath());
		log("userHeadImg: "+fileUploadUtil.getImgPath());
		headImgPojo.setUserId(userId);
		return headImgPojo;
	}

	//添加用户
	private UserPojo getPackgeUser(HttpServletRequest request,HttpServletResponse response) {
		try {
			//文件上传
			this.fileUploadUtil = new FileUploadUtil();
			this.multipartRequest = fileUploadUtil.upload(request, response);
			String userName = multipartRequest.getParameter("userName");
			String name = multipartRequest.getParameter("name");
			String passWord =multipartRequest.getParameter("passWord");
			String sex = multipartRequest.getParameter("sex");
			String birthyear = multipartRequest.getParameter("birthyear");
			String birthmonth = multipartRequest.getParameter("birthmonth");
			String birthday = multipartRequest.getParameter("birthday");
			String mobile = multipartRequest.getParameter("mobile");
			String userEmail = multipartRequest.getParameter("userEmail");
			
			//密码使用md5加密
			UserPojo userPojo = new UserPojo();
			userPojo.setUserName(userName);
			userPojo.setName(name);
			userPojo.setUserPass(MD5Utils.MD5(passWord));
			userPojo.setUserSex(sex);
			userPojo.setUserTel(mobile);
			userPojo.setUserEmail(userEmail);
			userPojo.setUserBithday(new SimpleDateFormat("yyyy-MM-dd").parse(birthyear+"-"+birthmonth+"-"+birthday));
			userPojo.setHeadImgPath(fileUploadUtil.getImgPath());
			return userPojo;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
