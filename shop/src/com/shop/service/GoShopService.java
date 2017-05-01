package com.shop.service;

import java.util.List;

import com.shop.pojo.OrderPojo;
import com.shop.pojo.PagePojo;
import com.shop.pojo.ProductInfoPojo;
import com.shop.pojo.RaddressPojo;

public interface GoShopService {

	ProductInfoPojo queryGoShopProduct(int i);

	void saveOrder(String[] orderInfo);

	PagePojo findAllOrder(int currentPage, int pageSize);

	PagePojo<OrderPojo> findOrderById(Integer valueOf, int currentPage, int pageSize);

	PagePojo<OrderPojo> findOrderByUser(String userName, int currentPage,
			int pageSize);

}
