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
	
	
	private String re_name;
	private String re_pass;
	private String re_adds;
	private String re_mail;
	private String re_tel;
	
	@Resource
	private ProductService productService;
	
	public String register(){
		HttpServletRequest request=ServletActionContext.getRequest();		
		if(productService.register(re_name,re_pass,re_adds,re_mail,re_tel)){
			request.setAttribute("tip", "注册成功");
			return "re_success";
		}else{
			request.setAttribute("tip", "注册失败");
			return "re_false";
		}	
	}
	
	public String getRe_name() {
		return re_name;
	}

	public void setRe_name(String re_name) {
		this.re_name = re_name;
	}

	public String getRe_pass() {
		return re_pass;
	}

	public void setRe_pass(String re_pass) {
		this.re_pass = re_pass;
	}

	public String getRe_adds() {
		return re_adds;
	}

	public void setRe_adds(String re_adds) {
		this.re_adds = re_adds;
	}

	public String getRe_mail() {
		return re_mail;
	}

	public void setRe_mail(String re_mail) {
		this.re_mail = re_mail;
	}

	public String getRe_tel() {
		return re_tel;
	}

	public void setRe_tel(String re_tel) {
		this.re_tel = re_tel;
	}


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
		//ActionContext.getContext().getSession().put("username", "member1");
		String name=(String)ActionContext.getContext().getSession().get("username");
		if(name==null)
			return INPUT;
		List<Member> list=productService.searchMemberByName(name);
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("list", list);
		return SUCCESS;		
	}
	
}
