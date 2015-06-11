package com.actions;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domain.ShoppingCart;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.services.ShoppingCartService;

public class ShoppingCartAction extends ActionSupport {
	
	@Resource
	private ShoppingCartService ShoppingCartService;
	private ShoppingCart shoppingCart;


	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public ShoppingCartService getShoppingCartService() {
		return ShoppingCartService; 
	}

	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		ShoppingCartService = shoppingCartService;
	}
	public String execute(){
		String username=(String) ActionContext.getContext().getSession().get("username");
		List<ShoppingCart> list=ShoppingCartService.searchShoppingCartByUserName(username);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("list", list);
		return SUCCESS;
	}
	
	public String deleteShoppingCart(){
		int cart_id=shoppingCart.getCartId();
		System.out.print(cart_id);
		HttpServletRequest request=ServletActionContext.getRequest();
		if(ShoppingCartService.deleteShoppingCartBycart_id(cart_id)){
			 request.setAttribute("tip","É¾³ý³É¹¦");
			 return execute();
		}
		else{
			 request.setAttribute("tip","É¾³ýÊ§°Ü");
			 return execute();
		}
	}
	
}
