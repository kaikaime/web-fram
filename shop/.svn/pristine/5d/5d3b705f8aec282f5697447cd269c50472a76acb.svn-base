package com.shop.service;

import com.shop.pojo.PagePojo;
import com.shop.pojo.ShopCategoryPojo;
import com.shop.pojo.ShopChildCategoryPojo;
import com.shop.pojo.UserPojo;

public interface ShopCategoryService {

	void addShopCategoryService(ShopChildCategoryPojo shopChildCategoryPojo);

	PagePojo<ShopCategoryPojo> findAll(int currentPage, int pageSize);

	ShopChildCategoryPojo findByIdShopChildCategoryService(
			int i);

	void updateByCategoryChildIdService(
			ShopChildCategoryPojo shopChildCategoryPojo);

	void deleteShopChildCategoryIdService(int shopChildCategoryId);

	void deleteShopParentCategoryIdService(int shopParentCategoryId);

}
