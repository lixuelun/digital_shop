package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.domain.Product;

public class ProductDaoImpl implements ProductDao{
	
	@Resource
	private SessionFactory sessionFactory;

	public List<Product> searchProductBySearchBox(String searchBox) {
		
		String hql="from Product as pro where pro.proName like '%"+searchBox+"%'";
		List<Product> list=sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
	}
	
	public void insertIntoTableWithProduct(Product product){
		
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(product);	
	}
}
