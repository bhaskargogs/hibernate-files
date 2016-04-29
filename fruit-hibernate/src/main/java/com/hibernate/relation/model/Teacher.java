package com.hibernate.relation.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name = "teacher_tb")
public class Teacher {
	private int tid;
	private String name;
	private String cname;
	private String gender;
	private int age;

	private Mobile mobile;
	private List<Student> students;
	
	private Set<Address> addresses = new HashSet<Address>();
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="teacher_address_id",
	joinColumns={@JoinColumn(name="tid")},
	inverseJoinColumns={@JoinColumn(name="aid")})
	public Set<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

	@OneToOne(cascade=CascadeType.ALL,mappedBy="teacher")
	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
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

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Teacher [tid=" + tid + ", name=" + name + ", cname=" + cname + ", gender=" + gender + ", age=" + age
				+ ", mobile=" + mobile + ", students=" + students + ", addresses=" + addresses + "]";
	}

}
