package com.system.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.bean.ExcellentBean;
import com.system.bean.HealthBean;
import com.system.callback.FenYeAllDataCallBack;
import com.system.dao.HealthDAO;
import com.system.dao.HealthstateDAO;
import com.system.dao.MarkDAO;
import com.system.dao.RidgepoleDAO;
import com.system.dao.RoomDAO;
import com.system.daos.IHealthDAO;
import com.system.daos.IMarkDAO;
import com.system.hqldao.impl.HqlFenYeDAOImpl;
import com.system.pojos.Health;
import com.system.pojos.Healthstate;
import com.system.pojos.Mark;
import com.system.pojos.Ridgepole;
import com.system.pojos.Room;
import com.system.service.IRoomHealthService;
import com.system.utils.FormatUtils;
import com.system.utils.StringUtils;

@Service
public class IRoomHealthServiceImpl implements IRoomHealthService {
	@Autowired
	private HqlFenYeDAOImpl hqlFenYeDAOImpl;
	
	@Autowired
	private HealthDAO healthDAO;
	
	@Autowired
	private HealthstateDAO healthstateDAO;
	
	@Autowired
	private MarkDAO markDAO;
	
	@Autowired
	private RoomDAO roomDAO;
	
	@Autowired
	private RidgepoleDAO reRidgepoleDAO;
	
	@Autowired
	private IHealthDAO iHealthDAOImpl;
	
	@Autowired
	private IMarkDAO iMarkDAOImpl;
	
	
	
	@Override
	public String findAllService(String pageId,
			FenYeAllDataCallBack<HealthBean> fenye) {
			List<HealthBean> findHealthAllDao =
					hqlFenYeDAOImpl.findHealthAllDao(pageId,HealthBean.class);
			try {
				findHealthAllDao = FormatUtils.fomatHealthTime(findHealthAllDao);
			} catch (Exception e) {
		}
			fenye.allObjCount(hqlFenYeDAOImpl.getPageCount(), hqlFenYeDAOImpl.getAllCountObj(),hqlFenYeDAOImpl.getCurrentPageId(), findHealthAllDao);
			
			return fenye.getJumpUrl();
	}

	
	
	
	@Transactional
	@Override
	public String deleteById(String healthId, String markId,
			String healthStateId,
			FenYeAllDataCallBack<HealthBean> fenYeAllDataCallBack) {
			//检查卫生对象是否存在
			if(healthId!=null&&!"".equals(healthId)){
				Health findById = healthDAO.findById(Integer.parseInt(healthId));
				if(findById!=null){
					healthDAO.delete(findById);
				}
			}
			if(healthStateId!=null&&!"".equals(healthStateId)){
				Healthstate findById = healthstateDAO.findById(Integer.parseInt(healthStateId));
				if(findById!=null){
					healthstateDAO.delete(findById);
				}
			}
			if(markId!=null&&!"".equals(markId)){
				Mark findById = markDAO.findById(Integer.parseInt(markId));
				if(findById!=null){
					markDAO.delete(findById);
				}
			}
			return fenYeAllDataCallBack.getJumpUrl();
		
	}

	
	@Override
	public HealthBean findById(String healthId, String markId, String stateId,String roomId,String ridgId) {
			Health health = healthDAO.findById(Integer.parseInt(healthId));
			Mark mark = markDAO.findById(Integer.parseInt(markId));
			Healthstate healthstate = healthstateDAO.findById(Integer.parseInt(healthId));
			Room room = roomDAO.findById(Integer.parseInt(roomId));
			Ridgepole ridgepole = reRidgepoleDAO.findById(Integer.parseInt(ridgId));
			HealthBean haBean = new HealthBean();
			
			if(ridgepole!=null){
				haBean.setRidgId(ridgepole.getRidgId());
				haBean.setRidgNick(ridgepole.getRidgNick());
			}
			if(health!=null){
				haBean.setHealthId(health.getHealthId());
				haBean.setHealthDesc(health.getHealthDesc());
				haBean.setHealthTime(health.getHealthTime());
			}
			if(mark != null){
				haBean.setMarkDesc(mark.getMarkDesc());
				haBean.setMarkId(mark.getMarkId());
				haBean.setMarkNumber(mark.getMarkNumber());
				haBean.setMarkTime(mark.getMarkTime());
			}
			if(healthstate!=null){
				haBean.setState(healthstate.getState());
				haBean.setStateDesc(healthstate.getStateDesc());
				haBean.setStateId(healthstate.getStateId());
				haBean.setStateTime(healthstate.getStateTime());
			}
			if(room!=null){
				haBean.setRoomId(room.getRoomId());
				haBean.setRoomNick(room.getRoomNick());
			}
			return haBean;
	}

	
	//修改数据
	@Override
	@Transactional
	public void modify(HealthBean healthBean) {
		try {
			if(healthBean!=null){
				//更新卫生
				Health health = new Health();
				health.setHealthId(healthBean.getHealthId());
				health.setHealthDesc(healthBean.getHealthDesc());
				health.setHealthTime(new Date());
				System.out.println("=========="+health.getHealthId());
				iHealthDAOImpl.update(health);
				
				Mark mark  = new Mark();
				mark.setMarkTime(StringUtils.parseDate(healthBean.getFormatDate()));
				mark.setMarkId(healthBean.getMarkId());
				mark.setMarkNumber(healthBean.getMarkNumber());
				mark.setMarkDesc(healthBean.getMarkDesc());
				System.out.println("=========="+mark.getMarkId());
				iMarkDAOImpl.update(mark);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
