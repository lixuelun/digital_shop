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
	
	

	public void commitOfBack(int backPrice, String backReason,
			String backContext) {
		bDao.commitOfBack(backPrice,backReason,backContext);
		
	}

}
