package com.star.sud.app.shoppingcart.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.star.sud.app.constant.Constants;

@Entity
@Table(name = "PRODUCT", schema = Constants.SCHEMA_ONLINE_APP)
public class Product implements Serializable {

	// Static Attributes
	//////////////////////
	private static final long serialVersionUID = -3614771366895738315L;

	// Attributes
	//////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Column(name = "PRODUCT_CODE")
	private String productCode;

	@Column(name = "PRODUCT_DESC")
	private String productDesc;

	@Column(name = "STATUS")
	private Character status;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	public Product() {
		super();
	}

	public Product(Long productId) {
		this.productId = productId;
	}

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