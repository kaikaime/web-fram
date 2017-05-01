package com.system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.bean.VactionBean;
import com.system.callback.FenYeAllDataCallBack;
import com.system.dao.VactionDAO;
import com.system.daos.IVactionDAO;
import com.system.hqldao.impl.HqlFenYeDAOImpl;
import com.system.pojos.Classt;
import com.system.pojos.Ridgepole;
import com.system.pojos.Room;
import com.system.pojos.Student;
import com.system.pojos.Vaction;
import com.system.pojos.Yarddept;
import com.system.service.IVactionService;
import com.system.utils.Constant;
import com.system.utils.FormatUtils;
import com.system.utils.StringUtils;

import java.util.*;

@Service
public class IVactionServiceImpl implements IVactionService{
	
	@Autowired
	private HqlFenYeDAOImpl hqlFenYeDAOImpl;
	
	@Autowired
	private IVactionDAO iVactionDAOImpl;
	
	@Autowired
	private VactionDAO vactionDAO;
	
	
	@Override
	public String findAllService(String pageId,
			FenYeAllDataCallBack<Vaction> fenYeAllDataCallBack) {
			List<Vaction> list = hqlFenYeDAOImpl.findVactionAllDao(pageId);
			fenYeAllDataCallBack.allObjCount(hqlFenYeDAOImpl.getPageCount(), hqlFenYeDAOImpl.getAllCountObj(),
					hqlFenYeDAOImpl.getCurrentPageId(), list);
			return fenYeAllDataCallBack.getJumpUrl();
	}


	@Override
	public Vaction findById(String findById) {
		return iVactionDAOImpl.findById(Integer.parseInt(findById));
	}


	@Transactional
	@Override
	public String update(VactionBean vactionBean,
			FenYeAllDataCallBack<Vaction> fenYeAllDataCallBack) {
			int defaultPageId = Constant.defaultPageId;
			try{
				
				Room room = new Room();
				room.setRoomId(vactionBean.getVactionsId()[4]);
				room.setRoomNick(vactionBean.getRoomNick());
				
				Yarddept yarddept = new Yarddept();
				yarddept.setYardId(vactionBean.getVactionsId()[3]);
				yarddept.setYardNick(vactionBean.getYardNick());
				
				Classt classt = new Classt();
				classt.setClassId(vactionBean.getVactionsId()[2]);
				classt.setClassNick(vactionBean.getClassNick());
				classt.setYarddept(yarddept);
				
				Student student =new Student();
				student.setStudentId(vactionBean.getVactionsId()[1]);
				student.setStudentTel(vactionBean.getStudentTel());
				student.setStudentNick(vactionBean.getStudentNick());
				student.setRoom(room);
				student.setClasst(classt);
				
				
				Vaction vaction = new Vaction();
				vaction.setVactionId(vactionBean.getVactionsId()[0]);
				vaction.setVactionDesc(vactionBean.getVactionDesc());
				vaction.setStartTime(FormatUtils.formatDate(vactionBean.getStartTime()));
				vaction.setEndTime(FormatUtils.formatDate(vactionBean.getEndTime()));
				vaction.setStudent(student);
				iVactionDAOImpl.update(vaction);
			}catch(Exception exception){
				exception.printStackTrace();
			}
			
		return findAllService(defaultPageId+"",fenYeAllDataCallBack);
	}


	@Transactional
	@Override
	public String delete(String findById,
			FenYeAllDataCallBack<Vaction> fenYeAllDataCallBack) {
		int defaultPageId = Constant.defaultPageId;
		Vaction vaction = vactionDAO.findById(Integer.parseInt(findById));
		if(vaction!=null){
			vactionDAO.delete(vaction);
		}
		return findAllService(defaultPageId+"",fenYeAllDataCallBack);
	}

}
