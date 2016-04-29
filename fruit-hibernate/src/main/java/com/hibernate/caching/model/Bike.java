package com.hibernate.caching.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bike_tbl")
public class Bike {
	private int bid;
	private String name;
	private String model;
	private String vendor;
	private String wheels;
	private double price;

	public Bike() {

	}

	public Bike(String name, String model, String vendor, String wheels, double price) {
		super();
		this.name = name;
		this.model = model;
		this.vendor = vendor;
		this.wheels = wheels;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getWheels() {
		return wheels;
	}

	public void setWheels(String wheels) {
		this.wheels = wheels;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Bike [bid=" + bid + ", name=" + name + ", model=" + model + ", vendor=" + vendor + ", wheels=" + wheels
				+ ", price=" + price + "]";
	}

}
