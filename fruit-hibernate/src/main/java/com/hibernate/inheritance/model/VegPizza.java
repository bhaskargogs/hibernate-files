package com.hibernate.inheritance.model;

import java.util.Arrays;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="vegpizza_tbl")
@AttributeOverrides({
    @AttributeOverride(name="description", column=@Column(name="vdescription"))
})
//@DiscriminatorValue(value="V")    // for table per class hierarchy
public class VegPizza extends Pizza{

	private String toppings;
	private float price;
	private byte[] photo;

	public String getToppings() {
		return toppings;
	}

	public void setToppings(String toppings) {
		this.toppings = toppings;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "VegPizza [toppings=" + toppings + ", price=" + price + ", photo=" + Arrays.toString(photo) + "]";
	}

}
