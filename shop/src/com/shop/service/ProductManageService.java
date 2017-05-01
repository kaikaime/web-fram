package com.shop.service;

import java.util.List;

import com.shop.pojo.PagePojo;
import com.shop.pojo.ProductInfoPojo;
import com.shop.pojo.ShopCategoryPojo;
import com.shop.pojo.ShopChildCategoryPojo;
import com.shop.pojo.ShopPojo;

public interface ProductManageService {

	List<ShopCategoryPojo> findAllProductCategoryService();

	List<ShopChildCategoryPojo> findAllProductChildCategoryService(
			String findProdcutNick);

	void addProductManageService(ProductInfoPojo productInfoPojo);

	PagePojo<ShopPojo> findAll(int currentPage, int pageSize);

	void deleteByIdProductService(int parseInt);

	ProductInfoPojo findByIdProdcutService(int parseInt);

	void updateByIdProductService(ProductInfoPojo productInfoPojo);

}
