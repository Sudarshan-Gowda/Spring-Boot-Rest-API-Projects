package com.star.sud.app.shoppingcart.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SHOPPING_CART_ITEMS")
public class ShoppingCartItems implements Serializable {

	// Static Attributes
	/////////////////////
	private static final long serialVersionUID = -6381183293158878816L;

	// Attributes
	///////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SHPCART_ITEM_ID")
	private Long shapCartItemId;

	@OneToOne
	@JoinColumn(name = "PRODUCT_ID")
	private Product productId;

	@Column(name = "QUANTITY")
	private Integer quantity;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "STATUS")
	private Character status;

	// Properties
	/////////////////
	public Long getShapCartItemId() {
		return shapCartItemId;
	}

	public void setShapCartItemId(Long shapCartItemId) {
		this.shapCartItemId = shapCartItemId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {
		this.productId = productId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
