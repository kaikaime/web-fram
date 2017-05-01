package com.shop.service;

import com.shop.pojo.UserHeadImgPojo;

public interface UserHeadService {

	void addUserHeadImg(UserHeadImgPojo headImgPojo);

	void updateByIdUserHeadImg(UserHeadImgPojo headImgPojo);

	void deleteByIdUserHeadImg(int userId);

}
