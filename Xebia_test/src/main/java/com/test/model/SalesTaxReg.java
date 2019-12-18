package com.test.model;

public class SalesTaxReg {
	private String quantity;
	private String productName;
	private Double price;

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SalesTaxReg [quantity=" + quantity + ", productName=" + productName + ", price=" + price + "]";
	}

}
