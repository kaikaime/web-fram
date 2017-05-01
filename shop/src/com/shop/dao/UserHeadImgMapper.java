package com.shop.dao;

import com.shop.pojo.UserHeadImgPojo;

public interface UserHeadImgMapper {

	void addUserHeadImg(UserHeadImgPojo headImgPojo);

	void updateUserHeadImg(UserHeadImgPojo headImgPojo);

	void deleteByIdUserHeadImg(int userId);

}
