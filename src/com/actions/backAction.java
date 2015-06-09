package com.actions;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domain.Back;
import com.opensymphony.xwork2.ActionSupport;
import com.services.backService;

public class backAction extends ActionSupport {
	private String backReason;
	private String backContext;
	
	@Resource
	private backService bService;
	
	//点击提交按钮申请退款
	public String backProduct(){
		List<Back> list=backService.commitOfBack();
		HttpServletRequest request=ServletActionContext.getRequest();
		request.setAttribute("list", list);
		return SUCCESS;
	}
	
	
	public String getBackReason() {
		return backReason;
	}
	public void setBackReason(String backReason) {
		this.backReason = backReason;
	}
	public String getBackContext() {
		return backContext;
	}
	public void setBackContext(String backContext) {
		this.backContext = backContext;
	}
	
}
