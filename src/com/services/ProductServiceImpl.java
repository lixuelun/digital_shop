package com.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ProductDao;
import com.domain.Member;
import com.domain.Product;


@Transactional
public class ProductServiceImpl implements ProductService{
	
	@Resource
	ProductDao productDao;
	
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Product> searchProductBySearchBox(String searchBox) {
		return productDao.searchProductBySearchBox(searchBox);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Product> searchProductByName(String name) {
		return productDao.searchProductByName(name);
	}

	public boolean addShoppingCart(String img, String name, double price, int quantity) {
		return productDao.addShoppingCart(img, name, price,quantity);
	}

	public List<Member> searchMemberByName(String name) {
		return productDao.searchMemberByName(name);
	}

	public boolean updateMemPass(String name, String newMemPass) {
		return productDao.updateMemPass(name, newMemPass);
	}

}
