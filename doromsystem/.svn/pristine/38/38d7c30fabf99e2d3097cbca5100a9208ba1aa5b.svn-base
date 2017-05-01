package com.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.system.bean.ViolationBean;
import com.system.callback.FenYeAllDataCallBack;
import com.system.dao.ClasstDAO;
import com.system.dao.RidgepoleDAO;
import com.system.dao.RoomDAO;
import com.system.dao.StudentDAO;
import com.system.dao.ViolationDAO;
import com.system.dao.YarddeptDAO;
import com.system.daos.IViolationDAO;
import com.system.daos.impl.IViolationDAOImpl;
import com.system.hqldao.impl.HqlFenYeDAOImpl;
import com.system.pojos.Classt;
import com.system.pojos.Ridgepole;
import com.system.pojos.Room;
import com.system.pojos.Student;
import com.system.pojos.Violation;
import com.system.pojos.Yarddept;
import com.system.service.IViolationService;
import com.system.utils.Constant;
import com.system.utils.FormatUtils;
import com.system.utils.StringUtils;

@Service
public class IViolationServiceImpl implements IViolationService {
	@Autowired
	private HqlFenYeDAOImpl hqlFenYeDAOImpl;

	@Autowired
	private ViolationDAO violationDAO;
	
	@Autowired
	private IViolationDAO iViolationDAOImpl;

	/**
	 * 分页查询
	 */
	@Override
	public String findAllService(String pageId,
			FenYeAllDataCallBack<Violation> fenYeAllDataCallBack) {
		List<Violation> violations = hqlFenYeDAOImpl
				.findViolationAllDao(pageId);
				fenYeAllDataCallBack.allObjCount(hqlFenYeDAOImpl.getPageCount(),
				hqlFenYeDAOImpl.getAllCountObj(),
				hqlFenYeDAOImpl.getCurrentPageId(), violations);
		return fenYeAllDataCallBack.getJumpUrl();
	}

	
	/**
	 * 通过Id获取数据对象
	 */
	@Override
	public Violation findByIdServcie(String vioId) {
		Violation violation = iViolationDAOImpl.findByIdIViolation(vioId);
		return violation;
	}

	
	/**
	 * 更新数据
	 */
	@Transactional
	@Override
	public String update(ViolationBean violationBean,
			FenYeAllDataCallBack<Violation> fenYeAllDataCallBack){
			
			try {
				 //更新学生系部信息
				
				
				//更新宿舍信息
				Room room = new Room();
				room.setRoomId(violationBean.getRoomId());
				room.setRoomNick(violationBean.getRoom());
				
				//更新系部
				Yarddept yarddept = new Yarddept();
				yarddept.setYardId(violationBean.getYardId());
				yarddept.setYardNick(violationBean.getYard());
				
				//更新学校所在的班级
				Classt classt= new Classt();
				classt.setClassId(violationBean.getClastId());
				classt.setClassNick(violationBean.getClasst());
				classt.setYarddept(yarddept);
				
				
				//更新学生信息
				Student student  = new Student();
				student.setStudentId(violationBean.getStudentId());
				student.setStudentSex(violationBean.getSex());
				student.setStudentNick(violationBean.getNick());
				student.setStudentTel(violationBean.getTel());
				student.setRoom(room);
				student.setClasst(classt);
				
			
				
				//更新违规信息
				Violation violation = new Violation();
				violation.setViolationId(violationBean.getViolationId());
				violation.setViolationDesc(violationBean.getViodesc());
				violation.setViolationTime(FormatUtils.formatDate(violationBean.getViotime()));
				violation.setStudent(student);
				
				iViolationDAOImpl.update(violation);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return findAllService(Constant.defaultPageId+"",fenYeAllDataCallBack);
		
	}


	/**
	 * 删除数据
	 */
	@Transactional
	@Override
	public String delete(String findById,
			FenYeAllDataCallBack<Violation> fenYeAllDataCallBack) {
			Violation violation = violationDAO.findById(Integer.parseInt(findById));
			if(violation!=null){
				violationDAO.delete(violation);
			}
			return findAllService(Constant.defaultPageId+"",fenYeAllDataCallBack);
	}


	/**
	 * 通過學生的姓名去查詢數據
	 */
	@Override
	public List<Violation> findByNick(String findByNick) {
		List<Violation> violation = iViolationDAOImpl.findByNickQueryViolation(findByNick);
		return violation;
	}
	


	

}
