package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.OrderMapper;
import com.shop.dao.ProductCenterPriceMapper;
import com.shop.dao.ProductCenterRepositoryMapper;
import com.shop.dao.ProductImgMapper;
import com.shop.dao.ProductMapper;
import com.shop.dao.ShopCategoryChildMapper;
import com.shop.dao.ShopCategoryMapper;
import com.shop.pojo.ImgShopPojo;
import com.shop.pojo.PagePojo;
import com.shop.pojo.ShopCategoryPojo;
import com.shop.pojo.ShopChildCategoryPojo;
import com.shop.pojo.UserPojo;
import com.shop.service.ShopCategoryService;

@Service
public class ShopCategoryServiceImpl implements ShopCategoryService{
	//商品大分类
	@Autowired
	private ShopCategoryMapper shopCategoryMapper;
	
	//商品小分类
	@Autowired
	private ShopCategoryChildMapper shopCategoryChildMapper; 
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProductImgMapper productImgMapper;
	
	@Autowired
	private ProductCenterPriceMapper productCenterPriceMapper;
	
	@Autowired
	private ProductCenterRepositoryMapper productCenterRepositoryMapper;

	@Autowired
	private OrderMapper orderMapper;
	
	
	
	/**
	 * 添加商品分类
	 */
	@Transactional
	@Override
	public void addShopCategoryService(ShopChildCategoryPojo shopChildCategoryPojo) {
		ShopCategoryPojo shopCategoryPojo = shopChildCategoryPojo.getShopCategoryPojo();
		//添加之前检查当前的大类是否存在，如果存在就不让再次添加
		Integer shopCategoryId = shopCategoryMapper.queryShopCategoryId(shopCategoryPojo.getShopCategoryNick());
		if(shopCategoryId==null){
			shopCategoryMapper.addShopCategory(shopCategoryPojo);
		}else{
			//重新设置ShopCategoryPojo的主键值
			shopCategoryPojo.setShopCategoryId(shopCategoryId);
		}
		//重新给ShopChildCategoryPojo的shopChildCategoryPojo属性赋值
		shopChildCategoryPojo.setShopCategoryPojo(shopCategoryPojo);
		Integer shopChildCategoryId = shopCategoryChildMapper.queryShopChildCategoryId(shopChildCategoryPojo);
		if(shopChildCategoryId==null){
			shopCategoryChildMapper.addShopCategoryChild(shopChildCategoryPojo);
		}
		return;
	}


	/**
	 * 分页查询
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public PagePojo<ShopCategoryPojo> findAll(int currentPage, int pageSize) {
		//获取数据总数
		PagePojo<ShopCategoryPojo> pagePojo = shopCategoryMapper.findAllUserCount();	
		//设置页面的条目数和当前的页面
		pagePojo.setPageSizeAndCurrentPage(pageSize, currentPage);
		//开始进行分页计算
		pagePojo.jiSuanFenYe();
		//获取所有的数据
		List<ShopCategoryPojo> shopCategoryPojos = shopCategoryMapper.findAllUserList(pagePojo);
		//存放数据
		pagePojo.setList(shopCategoryPojos);
		return pagePojo;
	}


	@Override
	public ShopChildCategoryPojo findByIdShopChildCategoryService(
			int productCatChilCategoryId) {
		ShopChildCategoryPojo shopChildCategoryPojo = 
				shopCategoryChildMapper.findByIdChildShopCategory(productCatChilCategoryId);
		return shopChildCategoryPojo;
	}


	@Transactional
	@Override
	public void updateByCategoryChildIdService(ShopChildCategoryPojo shopChildCategoryPojo) {
		shopCategoryChildMapper.updateShopCategoryChild(shopChildCategoryPojo);
		shopCategoryMapper.updateShopCategoryParent(shopChildCategoryPojo.getShopCategoryPojo());
	}


	@Transactional
	@Override
	public void deleteShopChildCategoryIdService(int childCateId) {
		deleteProductInfo(childCateId);
	}


	@Transactional
	@Override
	public void deleteShopParentCategoryIdService(int shopCategoryId) {	
		//先获取商品的Id
		List<Integer> childCateIds = shopCategoryChildMapper.findAllCateChildId(shopCategoryId);
		if(childCateIds!=null&&childCateIds.size()>0){
			for (Integer childCateId : childCateIds) {
				deleteProductInfo(childCateId);
			}
		}
		//删除大类表
		shopCategoryMapper.deleteShopParentCategory(shopCategoryId);
	}


	private void deleteProductInfo(Integer childCateId) {
		System.out.println("小类Id"+childCateId);
		//根据小类Id查找商品
		List<Integer> proIds = productMapper.findAllProdcutId(childCateId);
		if(proIds!=null&&proIds.size()>0){
			for (Integer proId : proIds) {
				System.out.println("商品Id"+proId);
				//根据商品的Id删除商品的图片
				productImgMapper.deleteByIdProductImg(proId);
				//根据商品的Id删除价格中间表
				productCenterPriceMapper.deleteByIdProductCenterPrice(proId);
				//根据商品的Id删除仓库中间表
				productCenterRepositoryMapper.deleteByIdProductCenterRepostory(proId);
				//删除订单中间表
				orderMapper.deleteByIdProdcut(proId);
				//删除商品表
				productMapper.deleteByIdProduct(proId);
			}
		}
		//删除小类表
		shopCategoryChildMapper.deleteShopChildCategory(childCateId);
	}
}
