package com.dao;

import java.util.List;

import com.domain.Product;

public interface ProductDao {
	//���������ť��ִ�еķ���
	public List<Product> searchProductBySearchBox(String searchBox);
	
	public void insertIntoTableWithProduct(Product product);

}
