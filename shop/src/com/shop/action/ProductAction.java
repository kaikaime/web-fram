package com.shop.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;
import com.shop.base.BaseAction;
import com.shop.pojo.ImgShopPojo;
import com.shop.pojo.PagePojo;
import com.shop.pojo.PricePojo;
import com.shop.pojo.ProductInfoPojo;
import com.shop.pojo.RepositoryPojo;
import com.shop.pojo.ShopCategoryPojo;
import com.shop.pojo.ShopChildCategoryPojo;
import com.shop.pojo.ShopPojo;
import com.shop.service.ProductManageService;
import com.utils.FileUploadUtil;
import com.utils.StringUtil;

@SuppressWarnings("serial")
@Controller
public class ProductAction extends BaseAction{
	@Autowired
	private ProductManageService productManageServiceImpl;
	private FileUploadUtil fileUploadUtil;
	private MultipartRequest multipartRequest;
	//获取商品类别信息
	@SuppressWarnings("unused")
	public String findProductCategoryInfo(HttpServletRequest request,HttpServletResponse response){
		PrintWriter out = null;
		try {
			String findProduct = request.getParameter("category");
			String findProdcutNick =request.getParameter("categoryNick");//分类名称
			//获取大类别
			if("parentCategory".equals(findProduct)){
				List<ShopCategoryPojo> allProductCategory =
				productManageServiceImpl.findAllProductCategoryService();
				out = response.getWriter();
				out.println(new Gson().toJson(allProductCategory));
			}else if("childCategory".equals(findProduct)){
				System.out.println("findProdcutNick "+new String(findProdcutNick.getBytes("ISO-8859-1"),"utf-8"));
				List<ShopChildCategoryPojo> allProductCategory =
				productManageServiceImpl.findAllProductChildCategoryService(findProdcutNick);
				out = response.getWriter();
				out.println(new Gson().toJson(allProductCategory));
			}
			closePrintWriter(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return json;
	}
	
	//删除该商品
	public String deleteByIdProduct(HttpServletRequest request,HttpServletResponse response){
		String productId = request.getParameter("productId");
		if(productId==null||"".equals(productId)){
			return findAll(request,response);
		}
		productManageServiceImpl.deleteByIdProductService(Integer.parseInt(productId));
		findAll(request,response);
		return "redirect:/manage/product";
	}
	
	//添加商品
	public String addProductManage(HttpServletRequest request,HttpServletResponse response){
		ProductInfoPojo productInfoPojo = findProduct(request, response);
		productManageServiceImpl.addProductManageService(productInfoPojo);
		findAll(request,response);
		return "redirect:/manage/product";
	}

	public String findAllUser(HttpServletRequest request,HttpServletResponse response){
		findAll(request,response);
		return "redirect:/manage/product";
	}

	//分页
	public String findAll(HttpServletRequest request,HttpServletResponse response){
		//每一页条目大小
		int pageSize=10;
		String pageId = request.getParameter("pageId");
		pageId=(pageId==null||"".equals(pageId)?"1":pageId);
		int currentPage = StringUtil.regCurrentPage(pageId);
		PagePojo<ShopPojo> allData = productManageServiceImpl.findAll(currentPage,pageSize);
		request.getSession().setAttribute("all", allData);		
		return "/manage/product";
	}
	
	
	//获取单个商品,将所有的商品信息全部查询出来
	public String findByIdProduct(HttpServletRequest request,HttpServletResponse response){
		String productId = request.getParameter("productId");
		ProductInfoPojo pojo = productManageServiceImpl.findByIdProdcutService(Integer.parseInt(productId));
		//如果没有要修改的，就直接返回到商品信息界面
		if(pojo==null){
			return findAll(request,response);
		}
		request.getSession().setAttribute("pojo", pojo);
		return "redirect:/manage/product-modify";
	}
	
	//修改某一个商品
	public String updateByIdProduct(HttpServletRequest request,HttpServletResponse response){
		ProductInfoPojo productInfoPojo = findProduct(request, response);
		//获取商品的Id
		productInfoPojo.setProductId(Integer.parseInt(multipartRequest.getParameter("productId")));
		productManageServiceImpl.updateByIdProductService(productInfoPojo);
		findAll(request,response);
		return "redirect:/manage/product";
	}

	private ProductInfoPojo findProduct(HttpServletRequest request,
			HttpServletResponse response) {
			ProductInfoPojo productInfoPojo = null;
		try {
			fileUploadUtil = new FileUploadUtil();
			multipartRequest = fileUploadUtil.upload(request, response);
			productInfoPojo = new ProductInfoPojo();
			productInfoPojo.setImgUrl(fileUploadUtil.getImgPath());
			productInfoPojo.setProductChild(multipartRequest.getParameter("childId"));
			productInfoPojo.setProductParent(multipartRequest.getParameter("parentId"));
			productInfoPojo.setProductName(multipartRequest.getParameter("productName"));
			productInfoPojo.setProductPingpaiName(multipartRequest.getParameter("productPingpaiName"));
			productInfoPojo.setProductPrice(multipartRequest.getParameter("productPrice"));
			productInfoPojo.setProductRepo(multipartRequest.getParameter("productRepo"));
			productInfoPojo.setTiaoxingma(multipartRequest.getParameter("tiaoxingma"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productInfoPojo;
	}
}
