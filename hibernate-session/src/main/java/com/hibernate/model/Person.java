package com.hibernate.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="person_tbl") //if you do not give the name then by default it is same as class name
public class Person {

	private int pid;
	private String name;
	private String email;
	private String mobile;
	private String gender;
    private Set<Address> addresses=new HashSet<Address>();  
	private Passport passport;
	private List<CreditCard> creditCards;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="person_address_tbl", 
	joinColumns={@JoinColumn(name="pid")}, 
	inverseJoinColumns={@JoinColumn(name="aid")})
	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	//mappedBy means this object is not responsible for relationship
	@OneToMany(cascade=CascadeType.ALL,mappedBy="person")
	public List<CreditCard> getCreditCards() {
		return creditCards;
	}

	public void setCreditCards(List<CreditCard> creditCards) {
		this.creditCards = creditCards;
	}

	//mappedBy means this object is not responsible for relationship
	@OneToOne(cascade=CascadeType.ALL,mappedBy="person")
	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Column(name="name",length=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="email",length=100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="mobile",length=12)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name="gender",length=6)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Person [pid=" + pid + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", gender="
				+ gender + ", addresses=" + addresses + ", passport=" + passport + ", creditCards=" + creditCards + "]";
	}


}
