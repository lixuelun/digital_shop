package com.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDao;
import com.domain.Product;


@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Resource
	ProductDao productDao;
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Product> searchProductBySearchBox(String searchBox) {
		return productDao.searchProductBySearchBox(searchBox);
	}

}
