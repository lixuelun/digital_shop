package com.domain;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private Integer proId;
	private String proName;
	private Double proPrice;
	private Integer proNum;
	private String proImg;
	private String proCategoryid;
	private String proContent;
	private String proDate;

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(Integer proId) {
		this.proId = proId;
	}

	/** full constructor */
	public Product(Integer proId, String proName, Double proPrice,
			Integer proNum, String proImg, String proCategoryid,
			String proContent, String proDate) {
		this.proId = proId;
		this.proName = proName;
		this.proPrice = proPrice;
		this.proNum = proNum;
		this.proImg = proImg;
		this.proCategoryid = proCategoryid;
		this.proContent = proContent;
		this.proDate = proDate;
	}

	// Property accessors

	public Integer getProId() {
		return this.proId;
	}

	public void setProId(Integer proId) {
		this.proId = proId;
	}

	public String getProName() {
		return this.proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public Double getProPrice() {
		return this.proPrice;
	}

	public void setProPrice(Double proPrice) {
		this.proPrice = proPrice;
	}

	public Integer getProNum() {
		return this.proNum;
	}

	public void setProNum(Integer proNum) {
		this.proNum = proNum;
	}

	public String getProImg() {
		return this.proImg;
	}

	public void setProImg(String proImg) {
		this.proImg = proImg;
	}

	public String getProCategoryid() {
		return this.proCategoryid;
	}

	public void setProCategoryid(String proCategoryid) {
		this.proCategoryid = proCategoryid;
	}

	public String getProContent() {
		return this.proContent;
	}

	public void setProContent(String proContent) {
		this.proContent = proContent;
	}

	public String getProDate() {
		return this.proDate;
	}

	public void setProDate(String proDate) {
		this.proDate = proDate;
	}

}