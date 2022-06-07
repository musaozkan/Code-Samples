//Musa Özkan 150121058
//A specified object class

import java.util.*;

public class Product {
	private String productName;
	private java.util.Calendar saleDate;
	private double price;
	
	public Product(String sName, java.util.Calendar sDate, double price) {
		setProductName(sName);
		setSaleDate(sDate);
		setPrice(price);
	}
	
	// Getters and Setters
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductName() {
		return productName;
	}
	public void setSaleDate(Calendar sDate) {
		this.saleDate = sDate;
	}
	public Calendar getSaleDate() {
		return saleDate;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	// Getters and Setters
	public String toString() {
		return ("Products Name is: " + productName + " Products Sale Date is: " + test.dateFormat(saleDate) + " Products Price is: " + price); 
	}
}
