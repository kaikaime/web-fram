package com.shop.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.OrderMapper;
import com.shop.dao.OrderXqMapper;
import com.shop.dao.ProductCenterPriceMapper;
import com.shop.dao.ProductCenterRepositoryMapper;
import com.shop.dao.ProductMapper;
import com.shop.enums.OrderStateImpl;
import com.shop.pojo.CustomerPojo;
import com.shop.pojo.OrderPojo;
import com.shop.pojo.OrderXqPojo;
import com.shop.pojo.PagePojo;
import com.shop.pojo.ProductInfoPojo;
import com.shop.pojo.RaddressPojo;
import com.shop.pojo.ShopPojo;
import com.shop.pojo.ShopPricePojo;
import com.shop.pojo.UserPojo;
import com.shop.service.GoShopService;
import com.shop.service.ProductManageService;

@Service
public class GoShopServiceImpl implements GoShopService {
	@Autowired
	private ProductManageService productManageServiceImpl;

	@Autowired
	private OrderXqMapper orderXqMapper;

	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private ProductMapper productMapper;

	@Autowired
	private ProductCenterRepositoryMapper repositoryMapper;

	@Autowired
	private ProductCenterPriceMapper priceMapper;

	// 根据商品的Id去找
	@Override
	public ProductInfoPojo queryGoShopProduct(int productId) {
		return productManageServiceImpl.findByIdProdcutService(productId);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT)
	// 保存订单
	@Override
	public void saveOrder(String[] orderInfo) {
		// 获取商品的信息
		int proId = Integer.parseInt(orderInfo[0]);
		ShopPojo sp = productMapper.findByIdProduct(proId);
		// 获取商品的价格
		ShopPricePojo sop = priceMapper.findPriceByProductId(proId);
		double pi = Double.valueOf(sop.getPrice().getPrice());
		// 保存订单详情
		OrderXqPojo odx = new OrderXqPojo();
		// 下单时间
		odx.setInfoTime(new Date());
		// 订单收货人
		int customerId = Integer.parseInt(orderInfo[2]);
		CustomerPojo cus = new CustomerPojo();
		cus.setCustomerId(customerId);
		odx.setCustomerPojo(cus);
		// 订单发货地址
		int radId = Integer.parseInt(orderInfo[1]);
		RaddressPojo rad = new RaddressPojo();
		rad.setRadId(radId);
		odx.setRaddressPojo(rad);
		// 订单状态,等待付款
		odx.setOrderStatus(OrderStateImpl.WAITPAYMENT);
		// 订单描述
		odx.setOrderdesc("");
		// 订单总价
		int number = Integer.parseInt(orderInfo[3]);
		double totalPrice = number * pi;
		odx.setOrderPrice(totalPrice + "");
		// 订单详情添加
		orderXqMapper.saveOrderXq(odx);
		// 订单添加
		OrderPojo od = new OrderPojo();
		od.setNumber(number + "");// 数量
		od.setOrderXqPojo(odx);
		od.setShopPojo(sp);
		UserPojo user = new UserPojo();
		user.setUserId(Integer.valueOf(orderInfo[4]));
		od.setUserPojo(user);
		orderMapper.saveOrder(od);
		// 单订单保存后，仓库数量要减少，
		// repositoryMapper.deleteByIdProductCenterRepostory(proId);
		// 支付宝减少钱的金额

	}

	
	
	// 获取所有的订单
	@SuppressWarnings("rawtypes")
	@Override
	public PagePojo findAllOrder(int currentPage, int pageSize) {
		// 获取数据总数
		PagePojo<OrderPojo> pagePojo = orderMapper.findAllUserCount();
		return findAllOrder(currentPage, pageSize, pagePojo);
	}

	
	
	@SuppressWarnings("unchecked")
	@Override
	public PagePojo<OrderPojo> findOrderById(Integer orderId, int currentPage,
			int pageSize) {
		// 获取数据总数
		PagePojo<OrderPojo> pagePojo = orderMapper.findOrderCountById(orderId);
		pagePojo.setWith(""+orderId);
		return findAllOrder(currentPage, pageSize, pagePojo);
	}

	
	
	@Override
	public PagePojo<OrderPojo> findOrderByUser(String name,
			int currentPage, int pageSize) {
		// 获取数据总数
		PagePojo<OrderPojo> pagePojo = orderMapper.findOrderByUser(name);
		pagePojo.setNick(name);
		return findAllOrder(currentPage, pageSize, pagePojo);
	}
	
	
	
	@SuppressWarnings("rawtypes")
	private PagePojo findAllOrder(int currentPage, int pageSize,
			PagePojo<OrderPojo> pagePojo) {
		// 设置页面的条目数和当前的页面
		pagePojo.setPageSizeAndCurrentPage(pageSize, currentPage);
		// 开始进行分页计算
		pagePojo.jiSuanFenYe();
		// 获取所有的数据
		List<OrderPojo> allOrder = orderMapper.findAllOrderList(pagePojo);
		// 存放数据
		pagePojo.setList(allOrder);
		return pagePojo;
	}

	
}
