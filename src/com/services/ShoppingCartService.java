package com.services;

import java.util.List;

import com.domain.ShoppingCart;

public interface ShoppingCartService {
	public List<ShoppingCart> searchShoppingCartByUserName(String username);

	public boolean deleteShoppingCartBycart_id(String name);

	public boolean payShoppingCart(String username);
}
