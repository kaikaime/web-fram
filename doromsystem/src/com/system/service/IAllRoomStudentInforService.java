package com.system.service;

import java.util.List;

import com.system.callback.FenYeAllDataCallBack;
import com.system.pojos.Room;

public interface IAllRoomStudentInforService {

	String findAllRoomStudentSerice(String pageId,
			FenYeAllDataCallBack<Room> fenYeAllDataCallBack);

}
