package com.hibernate.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //this object has to be persisted into database
@Table(name="mobile_tbl")
public class MobileEntity {
	private int mid;
	private String name;
	private String model;
	private String color;
	private float price;
	private byte[] photo;

	@Id 
	//@GeneratedValue(strategy=GenerationType.AUTO)
	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	@Column(name="cname",length=100)
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(columnDefinition="longblob")
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "MobileEntity [mid=" + mid + ", name=" + name + ", model=" + model + ", color=" + color + ", price="
				+ price + ", photo=" + Arrays.toString(photo) + "]";
	}

}
