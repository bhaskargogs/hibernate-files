package com.hibernate.relation.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mobile_tb")
public class Mobile {
	private int mobid;
	private String number;
	private String model;
	private String vendor;
	private float price;
	private Teacher teacher;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ms_id", nullable = false)
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getMobid() {
		return mobid;
	}

	public void setMobid(int mobid) {
		this.mobid = mobid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Mobile [mobid=" + mobid + ", number=" + number + ", model=" + model + ", vendor=" + vendor + ", price="
				+ price + ", teacher=" + teacher + "]";
	}

}
