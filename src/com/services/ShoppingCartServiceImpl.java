package com.services;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.dao.ShoppingCartDao;
import com.domain.ShoppingCart;

@Transactional
public class ShoppingCartServiceImpl implements ShoppingCartService{
	@Resource
	ShoppingCartDao shoppingCartDao;
	public List<ShoppingCart> searchShoppingCartByUserName(String username) {
		// TODO Auto-generated method stub
		return shoppingCartDao.searchShoppingCartByUserName(username);
	}
	public boolean deleteShoppingCartBycart_id(Integer cart_id) {
		// TODO Auto-generated method stub
		return shoppingCartDao.deleteShoppingCartBycart_id(cart_id);
	}
	
}
