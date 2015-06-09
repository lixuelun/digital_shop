package com.domain;

/**
 * Back entity. @author MyEclipse Persistence Tools
 */

public class Back implements java.io.Serializable {

	// Fields

	private Integer backId;
	private String backReason;
	private String backContext;

	// Constructors

	/** default constructor */
	public Back() {
	}

	/** full constructor */
	public Back(Integer backId, String backReason, String backContext) {
		this.backId = backId;
		this.backReason = backReason;
		this.backContext = backContext;
	}

	// Property accessors

	public Integer getBackId() {
		return this.backId;
	}

	public void setBackId(Integer backId) {
		this.backId = backId;
	}

	public String getBackReason() {
		return this.backReason;
	}

	public void setBackReason(String backReason) {
		this.backReason = backReason;
	}

	public String getBackContext() {
		return this.backContext;
	}

	public void setBackContext(String backContext) {
		this.backContext = backContext;
	}

}