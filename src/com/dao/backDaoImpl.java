package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import com.domain.Back;

public class backDaoImpl implements backDao{
	
	@Resource
	private SessionFactory sessionFactory;

	

	public void commitOfBack(int backPrice, String backReason,
			String backContext) {
			Back back = new Back();
			back.setBackPrice(backPrice);
			back.setBackReason(backReason);
			back.setBackContext(backContext);
			sessionFactory.getCurrentSession().persist(back);
			
		
	}


}