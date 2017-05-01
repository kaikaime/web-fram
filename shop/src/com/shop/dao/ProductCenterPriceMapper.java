package com.shop.dao;

import com.shop.pojo.PricePojo;
import com.shop.pojo.ShopPricePojo;
import com.shop.pojo.TodaysDealPojo;

public interface ProductCenterPriceMapper {

	void addProductCenterPrice(ShopPricePojo shopPricePojo);

	void deleteByIdProductCenterPrice(int productId);

	ShopPricePojo findPriceByProductId(int productId);

	void updateProductCenterPrice(ShopPricePojo spp);

	TodaysDealPojo findPriceByProduct(TodaysDealPojo todaysDealPojo);

}
