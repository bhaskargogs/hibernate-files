package com.hibernate.inheritance.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="nonpizza_tbl")
@AttributeOverrides({
    @AttributeOverride(name="description", column=@Column(name="ndescription"))
})
//@DiscriminatorValue(value="N")  //for table per class hierarchy
public class NonVegPizza extends Pizza {

	private String toppings;
	private String meatType;
	private float price;

	public String getToppings() {
		return toppings;
	}

	public void setToppings(String toppings) {
		this.toppings = toppings;
	}

	@Column(length=20)
	public String getMeatType() {
		return meatType;
	}

	public void setMeatType(String meatType) {
		this.meatType = meatType;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "NonVegPizza [toppings=" + toppings + ", meatType=" + meatType + ", price=" + price + "]";
	}

}
