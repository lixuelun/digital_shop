package com.domain;

/**
 * ShoppingCart entity. @author MyEclipse Persistence Tools
 */

public class ShoppingCart implements java.io.Serializable {

	// Fields

	private Integer cartId;
	private String img;
	private String name;
	private Double price;
	private Integer quantity;
	private String adminName;

	// Constructors

	/** default constructor */
	public ShoppingCart() {
	}

	/** minimal constructor */
	public ShoppingCart(Integer cartId) {
		this.cartId = cartId;
	}

	/** full constructor */
	public ShoppingCart(Integer cartId, String img, String name, Double price,
			Integer quantity, String adminName) {
		this.cartId = cartId;
		this.img = img;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.adminName = adminName;
	}

	// Property accessors

	public Integer getCartId() {
		return this.cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getAdminName() {
		return this.adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

}