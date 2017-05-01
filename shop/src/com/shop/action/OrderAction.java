package com.shop.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.shop.base.BaseAction;
import com.shop.pojo.CustomerPojo;
import com.shop.pojo.OrderPojo;
import com.shop.pojo.PagePojo;
import com.shop.pojo.ProductInfoPojo;
import com.shop.pojo.RaddressPojo;
import com.shop.pojo.ShopPojo;
import com.shop.pojo.UserPojo;
import com.shop.service.GoShopService;
import com.shop.service.RaddressService;
import com.utils.StringUtil;

@Controller
public class OrderAction extends BaseAction {
	@Autowired
	private GoShopService goShopServiceImpl;
	
	@Autowired
	private RaddressService addressServiceImpl;
	int userId = 2;
	
	
	//商品订单
	public String findOrder(HttpServletRequest request,HttpServletResponse response){
		String productId = request.getParameter("productId");
		String number = request.getParameter("number");
		if(productId==null){
			return "redirect:/index";
		}
		ProductInfoPojo pd = goShopServiceImpl.queryGoShopProduct(Integer.parseInt(productId));
		pd.setShopNumber(Integer.parseInt(number));
		HttpSession session = request.getSession();
		session.setAttribute("order", pd);
		//获取的地址
		//UserPojo userPojo = (UserPojo) request.getSession().getAttribute("");
		List<RaddressPojo> radList = addressServiceImpl.findUserOrderAddress(userId);
		if(radList!=null&&radList.size()>0){
			session.setAttribute("radList", radList);
		}
		return "redirect:/order";
	}

	//订单付款
	public String submitOrder(HttpServletRequest request,HttpServletResponse response){
		String productId = request.getParameter("productId");//商品Id
		String addRessId =request.getParameter("radId");//地址Id
		String cusId = request.getParameter("cusId");//收货人Id
		String number = request.getParameter("number");//商品数量
		//用户Id
		String [] orderInfo = {productId,addRessId,cusId,number,userId+""};
		goShopServiceImpl.saveOrder(orderInfo);
		return "redirect:/shopping-result";
	}
	
	//用户订单地址操作
	public String submitOrderAdd(HttpServletRequest request,HttpServletResponse response){
		String method = request.getParameter("methods").trim();
		String add =request.getParameter("add");//用户地址
		String radxq = request.getParameter("radxq");
		String tel = request.getParameter("tel");
		String customer = request.getParameter("customer");//收货人
		String addRessId =request.getParameter("radId");//地址Id
		String cusId = request.getParameter("cusId");//收货人Id
		//UserPojo userPojo = (UserPojo) request.getSession().getAttribute("");
		if("save".equals(method)){
			//地址保存
			UserPojo userPojo = new UserPojo();
			userPojo.setUserId(userId);
			RaddressPojo rdr = new RaddressPojo();
			rdr.setRad(add);
			rdr.setRadxq(radxq);
			rdr.setUserPojo(userPojo);
			CustomerPojo cst = new CustomerPojo();
			cst.setCustomerNick(customer);
			cst.setCustomerTel(tel);
			cst.setReRaddress(rdr);
			addressServiceImpl.saveOrderAdd(cst);
		}else if("update".equals(method)&&addRessId!=null){
			RaddressPojo rdr = new RaddressPojo();
			rdr.setRadId(Integer.parseInt(addRessId));
			rdr.setRad(add);
			rdr.setRadxq(radxq);
			rdr.setRadId(Integer.parseInt(addRessId));
			CustomerPojo cst = new CustomerPojo();
			cst.setCustomerId(Integer.parseInt(cusId));
			cst.setCustomerNick(customer);
			cst.setCustomerTel(tel);
			cst.setReRaddress(rdr);
			addressServiceImpl.updateOrderAdd(cst);
		}
		return findOrder(request,response);
	}
	
	//查询所有的订单
	@SuppressWarnings("unchecked")
	public String findAllOrder(HttpServletRequest request,HttpServletResponse response){
		int pageSize=10;
		String pageId = request.getParameter("pageId");
		pageId=(pageId==null||"".equals(pageId)?"1":pageId);
		int currentPage = StringUtil.regCurrentPage(pageId);
		PagePojo<OrderPojo> pagePojo = goShopServiceImpl.findAllOrder(currentPage,pageSize);
		request.getSession().setAttribute("allOrder", pagePojo);
		return "redirect:/manage/order";
	}
	
	//条件查询订单
	public String findWithOrder(HttpServletRequest request,HttpServletResponse response){
		int pageSize=10;
		int currentPage = 1;
		String orderId = request.getParameter("orderId");
		String userName = request.getParameter("userName");
		log("orderId: "+orderId+" userName: "+userName);
		if(!StringUtil.isNull(orderId)&&!StringUtil.isNull(userName)){
			//按订单编号查询
			//findOrderById(request, pageSize, currentPage, orderId);
		}else if(!StringUtil.isNull(orderId)&&StringUtil.isNull(userName)){
			//按订单编号查询
			PagePojo<OrderPojo> pagePojo = goShopServiceImpl.findOrderById(Integer.valueOf(orderId),currentPage,pageSize);
			findWithOrder(request, pagePojo);
		}else if(StringUtil.isNull(orderId)&&!StringUtil.isNull(userName)){
			//按订货人查询
			PagePojo<OrderPojo> pagePojo = goShopServiceImpl.findOrderByUser(userName,currentPage,pageSize);
			findWithOrder(request, pagePojo);
		}
		return "redirect:/manage/order";
	}

	@SuppressWarnings("unchecked")
	private void findWithOrder(HttpServletRequest request,
			PagePojo<OrderPojo> pagePojo) {
		HttpSession session = request.getSession();
		if((PagePojo<OrderPojo>) session.getAttribute("allOrder")!=null){
			session.removeAttribute("allOrder");
		}
		session.setAttribute("allOrder", pagePojo);
	}

	
	
}
