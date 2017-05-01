package com.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.system.bean.ExcellentBean;
import com.system.callback.FenYeAllDataCallBack;
import com.system.dao.ExcellentDAO;
import com.system.dao.RidgepoleDAO;
import com.system.dao.RoomDAO;
import com.system.hqldao.impl.HqlFenYeDAOImpl;
import com.system.pojos.Excellent;
import com.system.service.RoomExcellentService;
import com.system.utils.Constant;
import com.system.utils.FormatUtils;
import com.system.utils.StringUtils;

@Service("roomExcellentServiceImpl")
public class RoomExcellentServiceImpl implements RoomExcellentService{
	@Autowired
	private ExcellentDAO excellentDAO;
	
	@Autowired
	private RoomDAO roomDAO;
	
	@Autowired
	private RidgepoleDAO reRidgepoleDAO;
	
	@Autowired
	private HqlFenYeDAOImpl hqlFenYeDAOImpl;
	
	
		@Transactional(propagation=Propagation.REQUIRED)
		@Override
		public String deleteById(String findById,final FenYeAllDataCallBack<Excellent> fenye){
			int deleteId = StringUtils.formatDeleteId(findById);
			//删除之前先查询当前对象是否还存在数据库中，如果存在就删除如果不存在就不用删除
			Excellent excellent = excellentDAO.findById(deleteId);
			StringUtils.log(this,"数据对象打印");
			if(excellent!=null){
				//检查数据库中是否存在当前的数据对象
				excellentDAO.delete(excellent);
			}
			//删除数据以后，恢复到第一页
			return this.findAllService(StringUtils.formatDefaultPageId(), fenye);
		}


		@Override
		public String findAllService(String pageId,
				FenYeAllDataCallBack<Excellent> fenye) {
				List<Excellent> findRoomAllDao = hqlFenYeDAOImpl.findRoomAllDao( pageId);
				for (Excellent excellent : findRoomAllDao) {
					System.out.println(excellent.toString());
				}
				
				fenye.allObjCount(hqlFenYeDAOImpl.getPageCount(),
					hqlFenYeDAOImpl.getAllCountObj(),
					hqlFenYeDAOImpl.getCurrentPageId(), findRoomAllDao);
			return fenye.getJumpUrl();
		}

}
