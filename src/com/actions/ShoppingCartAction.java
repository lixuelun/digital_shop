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
	private String name;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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
	public String execute(){ 						//查询购物车并输出
		String username=(String) ActionContext.getContext().getSession().get("username");
		List<ShoppingCart> list=ShoppingCartService.searchShoppingCartByUserName(username);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("list", list);
		return SUCCESS;
	}
	
	public String deleteShoppingCart(){				 //删除购物车
		HttpServletRequest request=ServletActionContext.getRequest();
		if(ShoppingCartService.deleteShoppingCartBycart_id(name)){
			 request.setAttribute("tip","删除成功");
			 return execute();
		}
		else{
			 request.setAttribute("tip","删除失败");
			 return execute();
		}
	}
	
	public String payShoppingCart(){                 //支付购物车
		String username=(String) ActionContext.getContext().getSession().get("username");
		HttpServletRequest request=ServletActionContext.getRequest();
		ShoppingCartService.payShoppingCart(username);
		if(ShoppingCartService.payShoppingCart(username)){
			request.setAttribute("tip","支付成功");
			return "paysuccess";
			}
		else{
			request.setAttribute("tip","支付失败");
			return "payfalse";
			}
		
	}
	
}
