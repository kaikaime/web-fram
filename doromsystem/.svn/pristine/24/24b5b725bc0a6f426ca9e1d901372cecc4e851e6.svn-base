package com.system.service;

import java.util.List;
import java.util.Map;

import com.system.bean.ViolationBean;
import com.system.callback.FenYeAllDataCallBack;
import com.system.pojos.Violation;

public interface IViolationService {

	String findAllService(String pageId,
			FenYeAllDataCallBack<Violation> fenYeAllDataCallBack);

	String update(ViolationBean violationBean,
			FenYeAllDataCallBack<Violation> fenYeAllDataCallBack);

	Violation findByIdServcie(String vioId);

	String delete(String findById,
			FenYeAllDataCallBack<Violation> fenYeAllDataCallBack);

	List<Violation> findByNick(String findByNick);

}
