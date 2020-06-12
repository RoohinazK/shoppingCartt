package com.mindtree.shooppingCartApplication.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class CartDto {

	private int cartID;

	@JsonIgnoreProperties("cartDto")
	private List<ProductDto> productDto;

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public List<ProductDto> getProductDto() {
		return productDto;
	}

	public void setProductDto(List<ProductDto> productDto) {
		this.productDto = productDto;
	}

}
