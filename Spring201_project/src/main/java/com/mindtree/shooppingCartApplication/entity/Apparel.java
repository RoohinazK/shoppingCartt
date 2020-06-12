package com.mindtree.shooppingCartApplication.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("apparel")
public class Apparel extends Product {

//	@Id
//	@GeneratedValue(strategy =GenerationType.AUTO )
//	private int apparelId;

	@Column
	private String apprarelType;

	@Column
	private String apparelBrand;

	@Column
	private String apparelDesign;

	public Apparel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apparel(int productId, String productName, float price) {
		super(productId, productName, price);
		// TODO Auto-generated constructor stub
	}

	public Apparel(String apprarelType, String apparelBrand, String apparelDesign) {
		super();
		this.apprarelType = apprarelType;
		this.apparelBrand = apparelBrand;
		this.apparelDesign = apparelDesign;
	}

	public String getApprarelType() {
		return apprarelType;
	}

	public void setApprarelType(String apprarelType) {
		this.apprarelType = apprarelType;
	}

	public String getApparelBrand() {
		return apparelBrand;
	}

	public void setApparelBrand(String apparelBrand) {
		this.apparelBrand = apparelBrand;
	}

	public String getApparelDesign() {
		return apparelDesign;
	}

	public void setApparelDesign(String apparelDesign) {
		this.apparelDesign = apparelDesign;
	}

}
