package com.shop.dao;

import java.util.List;

import com.shop.pojo.PagePojo;
import com.shop.pojo.ShopCategoryPojo;

public interface ShopCategoryMapper {

	void addShopCategory(ShopCategoryPojo categoryPojo);

	PagePojo findAllUserCount();

	List<ShopCategoryPojo> findAllUserList(PagePojo pagePojo);

	void updateShopCategoryParent(ShopCategoryPojo shopCategoryPojo);

	Integer queryShopCategoryId(String shopCategoryNick);

	void deleteShopParentCategory(int shopCategoryId);
}
