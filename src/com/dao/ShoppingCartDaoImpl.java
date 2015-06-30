package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.domain.ShoppingCart;

public class ShoppingCartDaoImpl implements ShoppingCartDao{

	@Resource
	private SessionFactory sessionFactory;
	public List<ShoppingCart> searchShoppingCartByUserName(String username) {
		String hql="from ShoppingCart as ad where ad.adminName='"+username+"'";
		List<ShoppingCart> list=sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
		
	}
	public boolean  deleteShoppingCartBycart_id(String name) {
		String hql = "delete from ShoppingCart ad where ad.name ='"+name+"'";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		String hql2="from ShoppingCart as ad where ad.name ='"+name+"'";
		List<ShoppingCart> list=sessionFactory.getCurrentSession().createQuery(hql2).list();
		if(list.size()!=0)
			return false;
		else 
			return true;		
	}
	public boolean payShoppingCart(String username) {
		String hql = "delete from ShoppingCart ps where ps.adminName='"+username+"'";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		String pshql="from ShoppingCart as ad where ad.adminName='"+username+"'";
		List<ShoppingCart> list=sessionFactory.getCurrentSession().createQuery(pshql).list();
		if(list.size()==0)
			return true;
		else
			return false;
	}	
}
