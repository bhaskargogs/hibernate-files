package com.hibernate.model;

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
@Table(name="human_tbl")
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Human {
	
	private int pid;
	private String name;
	private String email;
	private String gender;
	private int age;
	private List<Laptop> laptops;
	
	public Human(){
		
	}
	
	public Human(String name, String email, String gender, int age) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}

	//mappedBy means this object is not responsible for relationship
	@OneToMany(cascade=CascadeType.ALL,mappedBy="human")
	public List<Laptop> getLaptops() {
		return laptops;
	}

	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Human [pid=" + pid + ", name=" + name + ", email=" + email + ", gender=" + gender + ", age=" + age
				+ ", laptops=" + laptops + "]";
	}

	
}
