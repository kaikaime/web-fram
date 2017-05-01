package com.shop.action;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.shop.base.BaseAction;
import com.shop.bean.MsgBean;
import com.shop.pojo.UserMaPojo;
import com.shop.pojo.UserPojo;
import com.shop.service.LoginService;
import com.shop.service.UserMaService;
import com.utils.MD5Utils;
/**
 * 应该很好理解。因为Spring默认产生的bean是单例的，
 * 假如我不想使用单例怎么办，xml文件里面可以在bean里面配置scope属性。
 * 注解也是一样，配置@Scope即可，默认是"singleton"即单例，
 * "prototype"表示原型即每次都会new一个新的出来。
 * @author Administrator
 *@Scope("prototype")
 */
@Controller
public class LoginAction extends BaseAction {
	@Autowired
	private LoginService userMaServiceImpl;
	
	
	
	/**
	 * 用户登录
	 * @param request
	 * @param response
	 * @return
	 */
	public String login(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String userName = request.getParameter("userName");
		String userPass = request.getParameter("passWord");
		String veryCode = request.getParameter("veryCode");
		HttpSession session = 	request.getSession();
		if(userName!=null&&!"".equals(userName)&&userPass!=null&&!"".equals(userPass)){
			//先判断验证码是否正确
			if(veryCode!=null&&!"".equals(veryCode)){
				String veryCodeValue = (String) session.getAttribute("veryCode");
				//验证码正确,进行账号密码登录
				if(veryCodeValue!=null&&veryCode.equals(veryCodeValue)){
					log("验证码输入正确，允许跳转到主界面");
					//验证码输入正确以后，开始在数据库中查看用户的账号和密码是否正确
					String pass = MD5Utils.MD5(userPass);
					UserMaPojo userMaPojo = userMaServiceImpl.findUser(userName, pass);
					//如果数据库中没有匹配到用户的账号和密码
					if(userMaPojo==null){
						 String msg = "用户名或者密码有误!";
						 session.setAttribute("msg", msg);
						 return "redirect:/manage/login";
					}
					//将用户的账号和密码保存到session中
					session.setAttribute("userPojo",userMaPojo);
					return "redirect:/manage/index";
				}else{
					 String msg = "验证码输入不正确!";
					 session.setAttribute("msg", msg);
					//验证码不正确，返回给客户端
					log("验证码输入不正确，直接跳转到登录界面");
					return "redirect:/manage/login";
				}
			}else{
				 String msg = "验证码输入不正确!";
				 session.setAttribute("msg", msg);
				//验证码不正确，返回给客户端
				log("验证码输入不正确，直接跳转到登录界面");
				return "redirect:/manage/login";
			}
		}else{
			 log("用户名，密码，验证码输入的都不正确!");
			 String msg = "用户名或者密码输入有误!";
			 session.setAttribute("msg", msg);
			 return "redirect:/manage/login";
		}
	}
	
	
	/**
	 * 用户注册
	 */
	public String register(HttpServletRequest request,HttpServletResponse response){
			String veryCode = request.getParameter("veryCode");
			String userName = request.getParameter("userName");
			String userPass = request.getParameter("rePassWord");
			HttpSession session = 	request.getSession();
			if(userName !=null &&!"".equals(userName)&&userPass !=null &&!"".equals(userPass)){
				if(veryCode!=null&&!"".equals(veryCode)){
					HttpSession httpSession = request.getSession();
					String veryCodeValue = (String) httpSession.getAttribute("veryCode");
					if(veryCodeValue.equals(veryCode)){
						log("验证码输入正确，开始注册用户名!");
						//进行注册
						//用户密码使用MD5加密
						String pass = MD5Utils.MD5(userPass);
						userMaServiceImpl.rigester(userName, pass);
						session.setAttribute("msg", "用户名或者密码有误!");
						return "redirect:/manage/reg-result";
					}else{
						log("验证码输入错误，返回注册界面!");
						//验证码校验失败
						String msg = "验证码输入不正确!";
						session.setAttribute("msg", msg);
						return "redirect:/manage/register";
					}
				}else{
					//验证码校验失败
					String msg = "验证码输入不正确!";
					session.setAttribute("msg", msg);
					log("验证码输入错误，返回注册界面!");
					return "redirect:/manage/register";
				}
			}else{
				//用户没有填写用户名和密码
				String msg = "用户名或者密码输入有误!";
				session.setAttribute("msg", "用户名或者密码有误!");
				log("用户名或者密码输入有误!");
				return "redirect:/manage/register";
			}
	}
}
