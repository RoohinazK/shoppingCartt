package com.mindtree.shooppingCartApplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UserDto {

	private int userId;

	private String username;

	@JsonIgnoreProperties("userDto")
	private CartDto cartDto;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public CartDto getCartDto() {
		return cartDto;
	}

	public void setCartDto(CartDto cartDto) {
		this.cartDto = cartDto;
	}

}
