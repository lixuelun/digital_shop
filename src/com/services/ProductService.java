package com.services;

import java.util.List;

import com.domain.Product;



public interface ProductService {
	//���������ť��ִ�еķ���
	public List<Product> searchProductBySearchBox(String searchBox);
}
