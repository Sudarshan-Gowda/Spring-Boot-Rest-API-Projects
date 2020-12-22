package com.star.sud.app.shoppingcart.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.star.sud.app.util.DateUtil;

@JsonInclude(Include.NON_NULL)
public class ShoppingCartItemsDto implements Serializable {

	// Static Attributes
	/////////////////////
	private static final long serialVersionUID = -6381183293158878816L;

	// Attributes
	///////////////
	private Long shapCartItemId;

	private Long productId;

	private Integer quantity;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtil.API_DATE_FORMAT)
	private Date createDate;

	private Character status;

	// Properties
	/////////////////
	public Long getShapCartItemId() {
		return shapCartItemId;
	}

	public void setShapCartItemId(Long shapCartItemId) {
		this.shapCartItemId = shapCartItemId;
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
