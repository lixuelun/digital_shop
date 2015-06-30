package com.actions;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domain.Member;
import com.domain.ShoppingCart;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.services.LoginService;

public class LoginAction extends ActionSupport{
	
	@Resource
	private LoginService loginService;
	private String username;
	private String password;
	
	
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String memlogin(){
		
		if(loginService.MemberLogin(username,password)){
			HttpServletRequest request=ServletActionContext.getRequest();
			request.setAttribute("tip", "µÇÂ½³É¹¦");
			ActionContext.getContext().getSession().put("username", username);
			return SUCCESS;
		}else{
			HttpServletRequest request=ServletActionContext.getRequest();
			request.setAttribute("tip", "µÇÂ½Ê§°Ü");
			return "false";
		}
		
	}
	
	public String quit(){
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().removeAttribute("username");
		request.setAttribute("tip", "ÍË³öµÇÂ½³É¹¦");
		return "quit";
		
	}
}
