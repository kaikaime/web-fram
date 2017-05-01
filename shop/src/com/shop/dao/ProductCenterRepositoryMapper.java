package com.shop.dao;

import com.shop.pojo.ShopRepositoryPojo;

public interface ProductCenterRepositoryMapper {

	void addProductCenterRepository(ShopRepositoryPojo shopRepositoryPojo);

	void deleteByIdProductCenterRepostory(int productId);

	ShopRepositoryPojo findRepositoryProductId(int productId);

}
