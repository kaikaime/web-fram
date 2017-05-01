package com.shop.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.dao.UserMaMapper;
import com.shop.dao.UserMapper;
import com.shop.pojo.UserMaPojo;
import com.shop.pojo.UserPojo;
import com.shop.service.LoginService;
import com.shop.service.UserMaService;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private UserMaMapper userMaMapper;
	
	
	@Override
	public UserMaPojo findUser(String userName, String userPass) {
		UserMaPojo userMaPojo = new UserMaPojo();
		userMaPojo.setUserMaName(userName);
		userMaPojo.setUserMaPass(userPass);
		return userMaMapper.findUser(userMaPojo);
	}


	@Transactional
	@Override
	public void rigester(String userName, String userPass) {
		UserMaPojo userMaPojo = new UserMaPojo();
		userMaPojo.setUserMaName(userName);
		userMaPojo.setUserMaPass(userPass);
		userMaMapper.rigester(userMaPojo);
	}
	
}
