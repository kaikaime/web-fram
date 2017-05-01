package com.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.AddressMapper;
import com.shop.dao.CustomerMapper;
import com.shop.dao.RaddressMapper;
import com.shop.dao.UserMaMapper;
import com.shop.dao.UserMapper;
import com.shop.pojo.CustomerPojo;
import com.shop.pojo.RaddressPojo;
import com.shop.pojo.UserPojo;
import com.shop.service.RaddressService;
@Service
public class RaddressServiceImpl implements RaddressService{
	@Autowired
	private RaddressMapper raddressMapper;
	
	@Autowired
	private CustomerMapper customerMapper;

	@Override
	public List<RaddressPojo> findUserOrderAddress(int userId) {
		return raddressMapper.findUserOrderAddress(userId);
	}

	@Override
	public void saveOrderAdd(CustomerPojo cst) {
		//先添加地址
		RaddressPojo rad = cst.getReRaddress();
		raddressMapper.addOrderAdd(rad);
		//添加收货人
		CustomerPojo cus = cst;
		cus.setReRaddress(rad);
		customerMapper.addOrderCustomer(cus);
	}

	@Override
	public void updateOrderAdd(CustomerPojo cus) {
		//修改用户
		customerMapper.updateOrderCustom(cus);
		
		//修改地址
		raddressMapper.updateOrderRadd(cus.getReRaddress());
		
	}
	
	

}
