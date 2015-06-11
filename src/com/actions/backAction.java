package com.actions;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.domain.Back;
import com.opensymphony.xwork2.ActionSupport;
import com.services.backService;

public class backAction extends ActionSupport {
	private int backPrice;
	private String backReason;
	private String backContext;
	
	@Resource
	private backService bService;
	
	//点击提交按钮申请退款
	public String backProduct(){
		bService.commitOfBack(backPrice,backReason,backContext);
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


	public int getBackPrice() {
		return backPrice;
	}


	public void setBackPrice(int backPrice) {
		this.backPrice = backPrice;
	}


	public backService getbService() {
		return bService;
	}


	public void setbService(backService bService) {
		this.bService = bService;
	}
	
	
	
}
