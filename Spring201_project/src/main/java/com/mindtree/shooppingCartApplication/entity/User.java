package com.mindtree.shooppingCartApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column
	private String userName;
	
	@OneToOne
	private Cart cart;

	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(int userId, String userName, Cart cart) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.cart = cart;
	}
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}
}
