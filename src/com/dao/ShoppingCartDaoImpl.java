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
	public boolean  deleteShoppingCartBycart_id(Integer cart_id) {
		String hql = "delete from ShoppingCart where ad.cartId ='"+cart_id+"'";
		sessionFactory.getCurrentSession().createQuery(hql).executeUpdate();
		String hql1="from ShoppingCart as ad where ad.cartId'"+cart_id+"'";
		List<ShoppingCart> list=sessionFactory.getCurrentSession().createQuery(hql).list();
		if(list.size()!=0)
			return false;
		else 
			return true;		
	}	
}
