package com.gl.HibernateMavenDemo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String prodname;
	private String pdiscription;
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "Store_Id")
	private Store store;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getProdname() {
		return prodname;
	}
	public void setProdname(String prodname) {
		this.prodname = prodname;
	}
	public String getPdiscription() {
		return pdiscription;
	}
	public void setPdiscription(String pdiscription) {
		this.pdiscription = pdiscription;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", prodname=" + prodname + ", pdiscription=" + pdiscription + ", price=" + price
				+ "]";
	}
	
	
	
	

}
