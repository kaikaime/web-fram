package com.system.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.system.bean.ExcellentBean;
import com.system.callback.FenYeAllDataCallBack;
import com.system.dao.ExcellentDAO;
import com.system.dao.RidgepoleDAO;
import com.system.dao.RoomDAO;
import com.system.pojos.Excellent;
import com.system.pojos.Ridgepole;
import com.system.utils.FormatUtils;
import com.system.utils.StringUtils;

public interface RoomExcellentService {
	
	 String findAllService(String pageId, FenYeAllDataCallBack<Excellent> fenye);
	
	
	 String deleteById(String findById, FenYeAllDataCallBack<Excellent> fenye);
	
	}
