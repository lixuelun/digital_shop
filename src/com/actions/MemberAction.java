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
		HttpServletRequest request=ServletActionContext.getRequest();		
		if(productService.updateMemPass(name,newMemPass)){
			request.setAttribute("tip", "修改密码成功");
			return execute();
		}else{
			request.setAttribute("tip", "修改密码失败");
			return execute();
		}		
	}
	
	public String updateMemAdds(){
		String name=(String)ActionContext.getContext().getSession().get("username");
		HttpServletRequest request=ServletActionContext.getRequest();		
		if(productService.updateMemAdds(name,newMemAdds)){
			request.setAttribute("tip", "修改地址成功");
			return execute();
		}else{
			request.setAttribute("tip", "修改地址失败");
			return execute();
		}		
	}
	
	public String updateMemTel(){
		String name=(String)ActionContext.getContext().getSession().get("username");
		HttpServletRequest request=ServletActionContext.getRequest();		
		if(productService.updateMemTel(name,newMemTel)){
			request.setAttribute("tip", "修改电话成功");
			return execute();
		}else{
			request.setAttribute("tip", "修改电话失败");
			return execute();
		}		
	}
	
	public String updateMemMail(){
		String name=(String)ActionContext.getContext().getSession().get("username");
		HttpServletRequest request=ServletActionContext.getRequest();		
		if(productService.updateMemMail(name,newMemMail)){
			request.setAttribute("tip", "修改e-mail成功");
			return execute();
		}else{
			request.setAttribute("tip", "修改e-mail失败");
			return execute();
		}		
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
