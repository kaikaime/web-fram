package com.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.UserHeadImgMapper;
import com.shop.pojo.UserHeadImgPojo;
import com.shop.service.UserHeadService;
@Service
public class UserHeadServiceImpl implements UserHeadService{
	@Autowired
	private UserHeadImgMapper userHeadImgMapper;
	
	@Transactional
	@Override
	public void addUserHeadImg(UserHeadImgPojo headImgPojo) {
		userHeadImgMapper.addUserHeadImg(headImgPojo);
	}

	@Transactional
	@Override
	public void updateByIdUserHeadImg(UserHeadImgPojo headImgPojo) {
		userHeadImgMapper.updateUserHeadImg(headImgPojo);
	}

	@Transactional
	@Override
	public void deleteByIdUserHeadImg(int userId) {
		userHeadImgMapper.deleteByIdUserHeadImg(userId);
	}
}
