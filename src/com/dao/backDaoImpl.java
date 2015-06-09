package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import com.domain.Back;

public class backDaoImpl implements backDao{
	
	@Resource
	private SessionFactory sessionFactory;

	//public List<Back> commitOfBack() {
		
		//String hql="from Back as b where b.='"+searchBox+"'";
		//List<Back> list=sessionFactory.getCurrentSession().createQuery(hql).list();
		//return list;
	//}

}