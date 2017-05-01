package com.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.shop.pojo.PagePojo;
import com.shop.pojo.ShopPojo;
import com.shop.pojo.TodaysDealPojo;

public interface ProductMapper {

	void addProduct(ShopPojo shopPojo);

	List<com.shop.pojo.ShopPojo> findAllUserList(PagePojo<ShopPojo> pagePojo);

	PagePojo<ShopPojo> findAllUserCount();

	void deleteByIdProduct(int productId);

	ShopPojo findByIdProduct(int productId);

	void updateShop(ShopPojo shopPojo);

	List<TodaysDealPojo> findAllProductInfo();

	List<Integer> findAllProdcutId(Integer chiId);

}
