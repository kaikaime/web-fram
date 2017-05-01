package com.shop.service;

import com.shop.pojo.UserMaPojo;

public interface LoginService {

	UserMaPojo findUser(String userName, String userPass);

	void rigester(String userName, String userPass);
	
	

}
