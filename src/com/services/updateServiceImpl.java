package com.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDao;
import com.domain.Product;

public class updateServiceImpl implements updateService {

	@Resource
	ProductDao productDao;
	
//	(propagation = Propagation.NOT_SUPPORTED)
	@Transactional
	public void insertIntoTableWithProduct(Product product){
		productDao.insertIntoTableWithProduct(product);
	}
}
