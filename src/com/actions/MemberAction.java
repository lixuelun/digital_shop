package com.actions;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domain.Member;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.services.ProductService;

public class MemberAction extends ActionSupport{
	private String newMemPass;
	private String newMemAdds;
	private String newMemMail;
	private String newMemTel;
	
	@Resource
	private ProductService productService;
	
	public String updateMemPass(){
		String name=(String)ActionContext.getContext().getSession().get("username");
		if(productService.updateMemPass(name,newMemPass))
			return SUCCESS;
		else 
			return "false";
	}
	
	public String getNewMemPass() {
		return newMemPass;
	}

	public void setNewMemPass(String newMemPass) {
		this.newMemPass = newMemPass;
	}

	public String getNewMemAdds() {
		return newMemAdds;
	}

	public void setNewMemAdds(String newMemAdds) {
		this.newMemAdds = newMemAdds;
	}

	public String getNewMemMail() {
		return newMemMail;
	}

	public void setNewMemMail(String newMemMail) {
		this.newMemMail = newMemMail;
	}

	public String getNewMemTel() {
		return newMemTel;
	}

	public void setNewMemTel(String newMemTel) {
		this.newMemTel = newMemTel;
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	
	
	public String execute(){
		//登陆完成把用户名存入session中
		ActionContext.getContext().getSession().put("username", "member1");
		String name=(String)ActionContext.getContext().getSession().get("username");
		List<Member> list=productService.searchMemberByName(name);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("list", list);
		return SUCCESS;		
	}
	
}
