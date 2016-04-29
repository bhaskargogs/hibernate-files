package com.hibernate.caching.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;

@Entity
@Table(name = "car_tbl")
@Cache(usage=org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE) //second-level caching
public class Car {
	private int cid;
	private String name;
	private String model;
	private String vendor;
	private double price;
	private Vehicle vehicle;
	
	public Car() {

	}
	
	

	public Car(String name, String model, String vendor, double price) {
		super();
		this.name = name;
		this.model = model;
		this.vendor = vendor;
		this.price = price;
	}



	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vcid", nullable = false,updatable=true)
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Car [cid=" + cid + ", name=" + name + ", model=" + model + ", vendor=" + vendor + ", price=" + price
				+ ", vehicle=" + "]";
	}

}
