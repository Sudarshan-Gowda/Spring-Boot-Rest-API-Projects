package com.star.sud.app.shoppingcart.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ShoppingCartDto implements Serializable {

	// Static Attributes
	/////////////////////////
	private static final long serialVersionUID = -3200349891301529414L;

	// Attributes
	///////////////
	private Long shapCartId;

	private Date createDate;

	private Character status;

	private String userId;

	private Set<ShoppingCartItemsDto> shoppingCartItems;

	// Properties
	////////////////
	public Long getShapCartId() {
		return shapCartId;
	}

	public void setShapCartId(Long shapCartId) {
		this.shapCartId = shapCartId;
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

	public Set<ShoppingCartItemsDto> getShoppingCartItems() {
		return shoppingCartItems;
	}

	public void setShoppingCartItems(Set<ShoppingCartItemsDto> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
