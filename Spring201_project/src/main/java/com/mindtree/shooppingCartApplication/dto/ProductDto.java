package com.mindtree.shooppingCartApplication.dto;

public class ProductDto implements Comparable<ProductDto>{

	private int productID;

	private String productName;

	private float price;

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public int compareTo(ProductDto o) {
		// TODO Auto-generated method stub
		return (int) (this.getPrice() - o.getPrice());
	}
	
	
}
