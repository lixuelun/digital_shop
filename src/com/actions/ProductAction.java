package com.actions;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domain.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.services.ProductService;

public class ProductAction extends ActionSupport{
	private String quantity;
	@Resource
	private ProductService productService;
	private Product product;

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//点击商品列表执行的方法
	public String execute(){
		HttpServletRequest request=ServletActionContext.getRequest();
		String name=product.getProName();
		try {
			name = new String(name.getBytes("ISO-8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		List<Product> list=productService.searchProductByName(name);
		for(Product t:list){
			ActionContext.getContext().getSession().put("id", t.getProId());
			ActionContext.getContext().getSession().put("img", t.getProImg());
			ActionContext.getContext().getSession().put("name", t.getProName());
			ActionContext.getContext().getSession().put("price", t.getProPrice());
		}
		String searchBox=(String) ActionContext.getContext().getSession().get("searchBox");
		request.setAttribute("searchBox", searchBox);
		request.setAttribute("list", list);
		return SUCCESS;
	}
	
	//点击加入购物车按钮执行的方法
	public String addShoppingCart(){
		//登陆完成把用户名存入session中
		
		String username=(String) ActionContext.getContext().getSession().get("username");
		HttpServletRequest request=ServletActionContext.getRequest();
		String img=(String) ActionContext.getContext().getSession().get("img");
		String name=(String) ActionContext.getContext().getSession().get("name");
		Double price=(Double) ActionContext.getContext().getSession().get("price");
		int number = Integer.parseInt(quantity);
		request.setAttribute("proname", name);
		if(productService.addShoppingCart(img,name,price,number,username))
			return "addSuccess";
		else
			return "addFalse";
	}

	

	

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
