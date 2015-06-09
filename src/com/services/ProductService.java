package com.services;

import java.util.List;

import com.domain.Product;



public interface ProductService {
	//点击搜索按钮会执行的方法
	public List<Product> searchProductBySearchBox(String searchBox);
}
