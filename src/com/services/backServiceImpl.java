package com.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.backDao;
import com.domain.Back;


@Transactional
public class backServiceImpl implements backService{
	
	@Resource
	backDao bDao;
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	
	//此方法还没添加参数
	public List<Back> commitOfBack() {
		return bDao.commitOfBack();
	}

}
