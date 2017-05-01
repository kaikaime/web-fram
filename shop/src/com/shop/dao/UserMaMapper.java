package com.shop.dao;

import java.util.List;

import com.shop.pojo.UserMaPojo;
import com.shop.pojo.UserPojo;

public interface UserMaMapper {
	//用户登录
	 UserMaPojo findUser(UserMaPojo userMaPojo);

	void rigester(UserMaPojo userMaPojo);

	UserPojo findAllUserAdd(int userId);
}
