package com.shop.dao;

import java.util.List;

import com.shop.pojo.OrderPojo;
import com.shop.pojo.PagePojo;
import com.shop.pojo.ShopPojo;

public interface OrderMapper {

	void deleteByIdProdcut(Integer proId);

	void saveOrder(OrderPojo od);

	PagePojo<OrderPojo> findAllUserCount();

	List<OrderPojo> findAllOrderList(PagePojo<OrderPojo> pagePojo);

	PagePojo<OrderPojo> findOrderCountById(Integer orderId);

	List<OrderPojo> findAllOrderListById(PagePojo<OrderPojo> pagePojo);

	PagePojo<OrderPojo> findOrderByUser(String nick);

	

}
