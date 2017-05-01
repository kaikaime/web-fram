package com.shop.action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.shop.base.BaseAction;
import com.shop.pojo.PagePojo;
import com.shop.pojo.ShopCategoryPojo;
import com.shop.pojo.ShopChildCategoryPojo;
import com.shop.pojo.UserPojo;
import com.shop.service.ShopCategoryService;
import com.utils.StringUtil;
@SuppressWarnings("serial")
@Controller
public class CategoryAction extends BaseAction {
	
	@Autowired
	private ShopCategoryService shopCategoryServiceImpl;
	
	//删除某一个小类
	public String deleteShopChildCategory(HttpServletRequest request,HttpServletResponse response){
		String shopChildCategoryId = request.getParameter("productCateChilCategoryId");
		shopCategoryServiceImpl.deleteShopChildCategoryIdService(Integer.parseInt(shopChildCategoryId));
		findAll(request,response);
		return "redirect:/manage/productClass";
	}
	
	//删除某一个大类
	public String deleteShopParentCategory(HttpServletRequest request,HttpServletResponse response){
		log("删除大类");
		String shopParentCategoryId = request.getParameter("productParentCateChilCategoryId");
		shopCategoryServiceImpl.deleteShopParentCategoryIdService(Integer.parseInt(shopParentCategoryId));
		findAll(request,response);
		return "redirect:/manage/productClass";
	}
	
	
	//添加商品类别管理
	public String addShopCategory(HttpServletRequest request,HttpServletResponse response){
		String shopCategoryNick = request.getParameter("parentId").trim();//父分类
		String shopChildCategoryNick = request.getParameter("className").trim();//分类名称
		//商品大类
		ShopCategoryPojo shopCategoryPojo = new ShopCategoryPojo();
		shopCategoryPojo.setShopCategoryNick(shopCategoryNick);
		//商品小类
		ShopChildCategoryPojo shopChildCategoryPojo = new ShopChildCategoryPojo();
		shopChildCategoryPojo.setShopChildCategoryNick(shopChildCategoryNick);
		shopChildCategoryPojo.setShopCategoryPojo(shopCategoryPojo);
		shopCategoryServiceImpl.addShopCategoryService(shopChildCategoryPojo);
		findAll(request,response);
		return "redirect:/manage/productClass";
	}

	//获取单个商品类
	public String findByIdShopCategory(HttpServletRequest request,HttpServletResponse response){
		String productCatChilCategoryId = request.getParameter("productCateChilCategoryId");//小类别Id
		//如果是修改大类，将小类全部查询出来。如果是修改小类，无需查询出大类
		if(productCatChilCategoryId!=null&&!"".equals(productCatChilCategoryId)){
			//指明小类别
			ShopChildCategoryPojo shopChildCategoryPojo = shopCategoryServiceImpl.findByIdShopChildCategoryService(Integer.parseInt(productCatChilCategoryId));
			request.getSession().setAttribute("shopCategoryPojo", shopChildCategoryPojo);
		}else {
			   //如果没有指明小类别和大类别，直接跳转到productClass.jsp界面上
			 	return "redirect:/resource/not-find-resource";
		}
		return "redirect:/manage/productClass-modify";
	}
	
	
	//更新数据
	public String updateByShopCategoryChildId(HttpServletRequest request,HttpServletResponse response){
		String shopCategoryParentId = request.getParameter("shopparentcategory").trim();
		String shopCategoryChildId = request.getParameter("shopchildcategory").trim();
		String shopCategoryNick = request.getParameter("parentId").trim();
		String shopCategoryChildNick = request.getParameter("className").trim();
		
		ShopCategoryPojo shopCategoryPojo = new ShopCategoryPojo();
		shopCategoryPojo.setShopCategoryId(Integer.parseInt(shopCategoryParentId));
		shopCategoryPojo.setShopCategoryNick(shopCategoryNick);
		
		ShopChildCategoryPojo shopChildCategoryPojo = new ShopChildCategoryPojo();
		shopChildCategoryPojo.setShopChildCategoryId(Integer.parseInt(shopCategoryChildId));
		shopChildCategoryPojo.setShopChildCategoryNick(shopCategoryChildNick);
		shopChildCategoryPojo.setShopCategoryPojo(shopCategoryPojo);
		shopCategoryServiceImpl.updateByCategoryChildIdService(shopChildCategoryPojo);
		findAll(request,response);
		return "redirect:/manage/productClass";
	}
	
	//分页查询
	public String findAll(HttpServletRequest request,HttpServletResponse response){
		//每一页条目大小
		int pageSize=10;
		String pageId=request.getParameter("pageId");
		pageId=pageId==null||"".equals(pageId)?"1":pageId;
		int currentPage = StringUtil.regCurrentPage(pageId);
		PagePojo<ShopCategoryPojo> allData = shopCategoryServiceImpl.findAll(currentPage,pageSize);
		request.getSession().setAttribute("all", allData);		
		return "/manage/productClass";
	}
	
	public String findAllUser(HttpServletRequest request,HttpServletResponse response){
		findAll(request,response);
		return "redirect:/manage/productClass";
	}
}
