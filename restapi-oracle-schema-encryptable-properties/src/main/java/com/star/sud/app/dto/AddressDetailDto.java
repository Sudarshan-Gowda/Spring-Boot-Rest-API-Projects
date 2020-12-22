package com.star.sud.app.dto;

import java.io.Serializable;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class AddressDetailDto implements Serializable {

	// Static Attributes
	/////////////////////
	private static final long serialVersionUID = -5272964011424655924L;

	// Attributes
	///////////////////
	private Long addressId;

	private String addrType;

	@Size(max = 100, message = "addrLine1 identifier should not exceed length 100")
	private String addrLine1;

	@Size(max = 100, message = "addrLine2 identifier should not exceed length 100")
	private String addrLine2;

	@Size(max = 10, message = "postalCode identifier should not exceed length 10")
	private String postalCode;

	@Size(max = 20, message = "state identifier should not exceed length 20")
	private String state;

	@Size(max = 20, message = "country identifier should not exceed length 20")
	private String country;

	// Properties
	///////////////////
	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getAddrType() {
		return addrType;
	}

	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
