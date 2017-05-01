package com.shop.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.base.BaseAction;
import com.shop.pojo.ProductInfoPojo;
import com.shop.service.GoShopService;

@SuppressWarnings("serial")
@Controller
public class GoShopAction  extends BaseAction{
	@Autowired
	private GoShopService goShopServiceImpl;
	
	
	//当用户点击商品直接获取商品到商品展示界面
	public String goShopCar(HttpServletRequest request,HttpServletResponse response){
		String productId = request.getParameter("productId");
		if(productId==null||"".equals(productId)){
			//如果没有商品就直接返回到主界面
			return "/index";
		}
		ProductInfoPojo pdif = 
				goShopServiceImpl.queryGoShopProduct(Integer.parseInt(productId));
		if(pdif==null){
			//没有数据直接返回主界面
			return "/index";
		}
		request.getSession().setAttribute("pdif", pdif);
		return "redirect:/product-view";
	}
	
	//购物车
	@SuppressWarnings("unchecked")
	public String addShopCar(HttpServletRequest request,HttpServletResponse response){
		String productId = request.getParameter("productId");
		String prodcutNumber = request.getParameter("prodcutNumber");
		if(productId==null){
			return "/index";
		}
		
		int proId = Integer.parseInt(productId);
		int proNumber = Integer.parseInt(prodcutNumber);
		ProductInfoPojo pdif = 
				goShopServiceImpl.queryGoShopProduct(proId);
		if(pdif==null){
			return "/index";
		}
		HttpSession session = request.getSession();
		Map<ProductInfoPojo,Integer> shopCar =
				(Map<ProductInfoPojo, Integer>) session.getAttribute("shopCar");
		if(shopCar == null){
			shopCar= new HashMap<ProductInfoPojo,Integer>();
		}
		//从购物车获取的
		Integer number = shopCar.get(pdif);
		//购物车中没有保存该商品
		if(number == null){
			//设置总价钱
			shopCar.put(pdif, proNumber);
		}else{
			int totalNumber = number+proNumber;
			shopCar.put(pdif,totalNumber);
		}
		session.setAttribute("shopCar", shopCar);
		return "redirect:/shopping";
		
	}
	
	//购物车中删除商品
	@SuppressWarnings("unchecked")
	public String deleteShopCarProduct(HttpServletRequest request,HttpServletResponse response){
		String productId = request.getParameter("productId");
		if(productId!=null){
			Integer proId = Integer.parseInt(productId);
			HttpSession session = request.getSession();
			Map<ProductInfoPojo,Integer> shopCar =
					(Map<ProductInfoPojo, Integer>) session.getAttribute("shopCar");
			Set<Entry<ProductInfoPojo, Integer>> entrySet = shopCar.entrySet();
			Iterator<Entry<ProductInfoPojo, Integer>> iterator = entrySet.iterator();
			while(iterator.hasNext()){
				Entry<ProductInfoPojo, Integer> next = iterator.next();
				ProductInfoPojo key = next.getKey();
				if(key.getProductId()==proId){
					shopCar.remove(key);
					session.setAttribute("shopCar", shopCar);
				}
			}
		}
		return "redirect:/shopping";
	}
	
	
	
	
	
	
	
	
	

}
