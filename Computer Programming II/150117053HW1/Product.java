//Muhammet Hasan Albayrak 150117053

import java.util.*;
public class Product {
	//Class file for product
 private String productName;
 private java.util.Calendar saleDate;
 private double price;
 
 //Constructor
    public Product(String sName, java.util.Calendar sDate, double price) {
    	this.productName = sName;
    	this.saleDate = sDate;
    	this.price = price;
    }

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public java.util.Calendar getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(java.util.Calendar saleDate) {
		this.saleDate = saleDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", saleDate=" + saleDate + ", price=" + price + "]";
	}
}
