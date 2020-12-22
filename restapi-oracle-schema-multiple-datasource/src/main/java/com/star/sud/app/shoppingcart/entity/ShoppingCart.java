package com.star.sud.app.shoppingcart.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.star.sud.app.constant.Constants;

@Entity
@Table(name = "SHOPPING_CART", schema = Constants.SCHEMA_ONLINE_APP)
public class ShoppingCart implements Serializable {

	// Static Attributes
	/////////////////////////
	private static final long serialVersionUID = -3200349891301529414L;

	// Attributes
	///////////////
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SHPCART_ID")
	private Long shapCartId;

	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "STATUS")
	private Character status;

	@OneToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@OneToMany(targetEntity = ShoppingCartItems.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "SHPCART_ID", referencedColumnName = "SHPCART_ID")
	private Set<ShoppingCartItems> shoppingCartItems;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<ShoppingCartItems> getShoppingCartItems() {
		return shoppingCartItems;
	}

	public void setShoppingCartItems(Set<ShoppingCartItems> shoppingCartItems) {
		this.shoppingCartItems = shoppingCartItems;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}