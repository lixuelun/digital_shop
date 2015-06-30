package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.domain.Member;


public class LoginDaoImpl implements LoginDao{
	
	@Resource
	private SessionFactory sessionFactory;
	
	public boolean MemberLogin(String username, String password) {
		
		String hql="from Member as lg where lg.memName='"+username+"'and lg.memPass='"+password+"'";
		List<Member> list=sessionFactory.getCurrentSession().createQuery(hql).list();
		if(list.size()!=0)
			return true;
		else 
			return false;		
	}
	
}
