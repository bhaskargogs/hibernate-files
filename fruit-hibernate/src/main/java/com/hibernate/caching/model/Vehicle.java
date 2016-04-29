package com.hibernate.caching.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "vehicle_tbl")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE) // used in second-level caching
public class Vehicle {
	private int vid;
	private String type;
	private String wheels;
	private List<Car> cars;

	public Vehicle() {
	
	}
	
	
	
	public Vehicle(String type, String wheels) {
		super();
		this.type = type;
		this.wheels = wheels;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWheels() {
		return wheels;
	}

	public void setWheels(String wheels) {
		this.wheels = wheels;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vehicle")
	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "Vehicle [vid=" + vid + ", type=" + type + ", wheels=" + wheels + ", cars=" + cars + "]";
	}

}
