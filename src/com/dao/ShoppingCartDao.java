package com.dao;

import java.util.List;

import com.domain.ShoppingCart;

public interface ShoppingCartDao {
	public List<ShoppingCart> searchShoppingCartByUserName(String username);

	public boolean deleteShoppingCartBycart_id(String name);

	public boolean payShoppingCart(String username);
}
