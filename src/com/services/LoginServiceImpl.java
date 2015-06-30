package com.services;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.LoginDao;


@Transactional
public class LoginServiceImpl implements LoginService{
	
	@Resource
	LoginDao loginDao;
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public boolean MemberLogin(String username, String password) {
		// TODO Auto-generated method stub
		return loginDao.MemberLogin(username, password);
	}

}
