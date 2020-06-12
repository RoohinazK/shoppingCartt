package com.mindtree.shooppingCartApplication.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cardId;

	@OneToMany
	@JoinTable(name = "product_cart", joinColumns = { @JoinColumn(name = "cartId") }, inverseJoinColumns = {
			@JoinColumn(name = "productId") })
	private List<Product> products;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getCardId() {
		return cardId;
	}

	public void setCardId(int cardId) {
		this.cardId = cardId;
	}

}

//	@OneToOne(cascade = CascadeType.ALL)
//	private User user;
//
//	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
//private List<Product> product;