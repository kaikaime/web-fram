package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.ProductCenterPriceMapper;
import com.shop.dao.ProductCenterRepositoryMapper;
import com.shop.dao.ProductMapper;
import com.shop.pojo.TodaysDealPojo;
import com.shop.service.ShopIndexService;

@Service
public class ShopIndexServiceImpl implements ShopIndexService{
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private ProductCenterRepositoryMapper pcr;
	
	@Autowired
	private ProductCenterPriceMapper pcp;
	
	
	@Override
	public List<TodaysDealPojo> findTodaysDealService() {
		//查询商品表
		List<TodaysDealPojo> todaysDeal = productMapper.findAllProductInfo();
		//查询商品图片表
		//查询商品价格表
		TodaysDealPojo tdp = null;
		for(int i = 0;i<todaysDeal.size();i++){
			 tdp = todaysDeal.get(i);
			 TodaysDealPojo  dls = pcp.findPriceByProduct(tdp);
			 tdp.setPrice(dls.getPrice());
			 tdp.setPriceId(dls.getPriceId());
			 todaysDeal.set(i,tdp);
		}
		return todaysDeal;
	}

}
