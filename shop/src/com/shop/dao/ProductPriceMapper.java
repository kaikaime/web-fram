package com.shop.dao;

import com.shop.pojo.PricePojo;
import com.shop.pojo.ShopPricePojo;

public interface ProductPriceMapper {

	void addProductPrice(PricePojo pricePojo);

	Integer queryProductPrice(String productPrice);


}
