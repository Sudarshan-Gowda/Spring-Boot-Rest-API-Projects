package com.star.sud.app.shoppingcart.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.star.sud.app.util.DateUtil;

@JsonInclude(Include.NON_NULL)
public class ProductDto implements Serializable {

	// Static Attributes
	//////////////////////
	private static final long serialVersionUID = -5598115954202153239L;

	// Attributes
	//////////////
	private Long productId;

	private String productCode;

	private String productDesc;

	private Character status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtil.API_DATE_FORMAT)
	private Date createDate;

	// Properties
	////////////////
	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public Character getStatus() {
		return status;
	}

	public void setStatus(Character status) {
		this.status = status;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
