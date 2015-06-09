package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import com.domain.Product;

public class ProductDaoImpl implements ProductDao{
	
	@Resource
	private SessionFactory sessionFactory;

	public List<Product> searchProductBySearchBox(String searchBox) {
		
		String hql="from Product as pro where pro.proName='"+searchBox+"'";
		List<Product> list=sessionFactory.getCurrentSession().createQuery(hql).list();
		return list;
	}

}
