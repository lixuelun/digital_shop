package com.actions;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domain.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.services.*;
public class updateAction extends ActionSupport {

	Product product;
	String productproName;
	
	public String getProductproName() {
		return productproName;
	}

	public void setProductproName(String productproName) {
		this.productproName = productproName;
	}

	@Resource
	private updateService updateService;
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	//点击提交按钮会执行的方法
	public String updateProduct(){
		

		System.out.println("test-------- price:"+product.getProPrice());
		System.out.println("test--------"+productproName);
		
		product.setProDate("2012-12-12");

		
//		updateService.insertIntoTableWithProduct(product);
		return SUCCESS;
	}

	public updateService getProductService() {
		return updateService;
	}

	public void updateService(updateService updateService) {
		this.updateService = updateService;
	}
}
