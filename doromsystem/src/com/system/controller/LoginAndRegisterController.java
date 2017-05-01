package com.system.controller;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.system.bean.UserBean;
import com.system.pojos.Acct;
import com.system.pojos.Man;
import com.system.service.ILoginAndRegisterService;
import com.system.utils.Constant;
import com.system.utils.FormatUtils;
import com.system.utils.MD5Utils;


@Controller
public class LoginAndRegisterController {
	
	@Autowired
	private  ILoginAndRegisterService iLoginAndRegisterServiceImpl;
	
	
	
	/**
	 * 用户登录
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/login.do",params={"method=login"})
	public  String login(Acct acct,HttpServletRequest request){
		 String userName = acct.getAccNumber();
		 String userPass =  acct.getAccPass();
		if(userName ==null||"".equals(userName)||
				userPass==null||"".equals(userPass)){
			request.setAttribute("loAndRegisterBean", "用户名或者密码有误!");
			return "redirect:/login.jsp";
		}
		//数据库检查当前的用户名和密码是否正确,使用md5对用户密码进行加密
		String md5Pass = MD5Utils.MD5(userPass);
		Acct isLogin = iLoginAndRegisterServiceImpl.login(userName,md5Pass);
		if(isLogin==null){
			request.setAttribute("loAndRegisterBean", "用户名或者密码有误!");
			return "redirect:/login.jsp";
		}
		 
			//表示允许登录,将用户名保存到session中
			HttpSession session = request.getSession();
			session.setAttribute("acct", acct);
			//session的最大生命期限
			int interval = Constant.maxInactiveInterval;
			session.setMaxInactiveInterval(interval);
			//用户登录成功直接跳转到主界面
			return "redirect:/index.jsp";
		
	}
	
	/**
	 * 用户注销
	 * @param request
	 * @return
	 */
	@RequestMapping(value="/logout.do",params={"method=logout"})
	public @ResponseBody String logout(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession();
		if(session!=null){
			session.invalidate();
		}		
		//跳转到登录界面
		return "true";
	}
	
	@RequestMapping(value="/register.do",params={"method=register"})
	public String register(UserBean userBean,ModelMap maModelMap){
		try {
			if(userBean.getAccNumber()==null||"".equals(userBean.getAccNumber())){
				return "redirect:/register.jsp";
			}
			//账号密码
			Acct acct = new Acct();
			String userPass = userBean.getAccPass();
			userPass = MD5Utils.MD5(userPass);
			acct.setAccNumber(userBean.getAccNumber());
			acct.setAccPass(userPass);
			Man man = new Man();
			man.setManNick(userBean.getManNick());
			man.setManshen(userBean.getManShen());
			man.setShi(userBean.getShi());
			man.setXian(userBean.getXian());
			man.setXiangzheng(userBean.getXiangzheng());
			man.setManTime(FormatUtils.formatDate(userBean.getRegiterTime()));
			man.setManTel(userBean.getManTel());
			man.setManSex(userBean.getManSex());
			man.setManIdCard(userBean.getManIdCard());
			boolean isRegisterPass = iLoginAndRegisterServiceImpl.registerPass(acct);
			boolean isRegisterSucess=iLoginAndRegisterServiceImpl.register(man);
		
			if(isRegisterPass&&isRegisterSucess){
				//注册成功跳转到登录界面，
				return "redirect:/login.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/register";
	}
}
