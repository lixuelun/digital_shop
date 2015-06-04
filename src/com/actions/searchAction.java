package com.actions;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domain.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.services.ProductService;

public class searchAction extends ActionSupport{
	private String search;
	@Resource
	private ProductService productService;
	
	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	//���������ť��ִ�еķ���
	public String searchProduct(){
		List<Product> list=productService.searchProductBySearchBox(search);
		HttpServletRequest request=ServletActionContext.getRequest();
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
