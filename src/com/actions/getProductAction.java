package com.actions;


import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domain.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.services.ProductService;

public class getProductAction extends ActionSupport {
	
	private String category;
	@Resource
	private ProductService productService;
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	//点击搜索按钮会执行的方法
	public String getCategoryProduct(){

		List<Product> list=productService.searchProductByCategory(category);
		Product p = list.get(0);
		
//		System.out.println("sizeof list = "+list.size());
//		System.out.println(p.getProCategoryid());
//		System.out.println(p.getProName());
		
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("category", category);
		request.setAttribute("list", list);
		return SUCCESS;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}
