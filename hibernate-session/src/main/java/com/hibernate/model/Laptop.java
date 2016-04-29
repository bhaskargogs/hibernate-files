package com.hibernate.model;

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
@Table(name="laptop_tbl")
@Cache(usage=org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
public class Laptop {

	private int lid;
	private String name;
	private String model;
	private String ram;
	private String generation;
	private float price;
	private Human human;
	
	public Laptop(){
		
	}
	
	public Laptop(String name, String model, String ram, String generation, float price) {
		super();
		this.name = name;
		this.model = model;
		this.ram = ram;
		this.generation = generation;
		this.price = price;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="hlid",nullable=false,updatable=true)
	public Human getHuman() {
		return human;
	}

	public void setHuman(Human human) {
		this.human = human;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
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

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Laptop [lid=" + lid + ", name=" + name + ", model=" + model + ", ram=" + ram + ", generation="
				+ generation + ", price=" + price + ", human="+ "]";
	}



}
